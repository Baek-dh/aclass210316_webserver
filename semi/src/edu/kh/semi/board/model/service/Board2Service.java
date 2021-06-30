package edu.kh.semi.board.model.service;

import static edu.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import edu.kh.semi.board.model.dao.Board2DAO;
import edu.kh.semi.board.model.dao.SelectBoardDAO;
import edu.kh.semi.board.model.vo.Attachment;
import edu.kh.semi.board.model.vo.Board;
import edu.kh.semi.board.model.vo.Category;
import edu.kh.semi.board.model.vo.Pagination;

public class Board2Service {
	
	private Board2DAO dao = new Board2DAO();

	/** 카테고리 목록 조회 Service
	 * @return category
	 * @throws Exception
	 */
	public List<Category> selectCategoryList() throws Exception{
		
		Connection conn = getConnection();
		
		List<Category> category = dao.selectCategoryList(conn);
		
		close(conn);
		
		return category;
	}

	/** 게시글 삽입 Service
	 * @param board
	 * @param atList
	 * @param boardType
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Board board, List<Attachment> atList, int boardType) throws Exception {
		
		Connection conn = getConnection();
		
		// 1. 다음 게시글 번호 얻어오기
		// 왜? 동시 다발적인 INSERT 발생 시 시퀀스.NEXTVAL가 연속으로 이루어져
		// 이후 시퀀스.CURRVAL가 호출될 때 원하는 값을 못얻어 오는 경우가 생기기 때문에...
		int boardNo = dao.nextBoardNo(conn);
		
		int result = 0;
		// 2. 얻어온 boardNo가 존재할 경우 board 객체 추가 후 board를 insert
		if(boardNo > 0) {
			board.setBoardNo(boardNo);
			
			
			// 2.5 > 게시글 내용의 줄바꿈을 <br> 태그로 변환하는 작업 필요 
			//     + 크로스 사이트 스크립팅 방지 처리
			// textarea의 개행문자 : \r\n
			// div의 개행문자 : <br>
			String boardContent = board.getBoardContent(); // <script> \r\n
			boardContent = replaceParameter(boardContent); // &lt;script&gt;
			boardContent = boardContent.replaceAll("\r\n", "<br>"); // &lt;script&gt; <br>
			board.setBoardContent(boardContent);
			
			result = dao.insertBoard(conn, board, boardType);
			
			// 3. 게시글 부분 삽입 성공 시 파일 정보 삽입
			if(result > 0) {
				
				// atList에서 하나씩 꺼내서 한 행씩 insert
				for(Attachment at : atList) {
					at.setBoardNo(boardNo); // 게시글 번호 세팅
					
					result = dao.insertAttachment(conn, at);
					
					if(result == 0) { // insert 실패 시 바로 rollback 후 남은 구문은 수행하지 않음.
						rollback(conn);
						break;
					}
				}
				
				if(result > 0) {
					commit(conn);
					// 게시글 삽입 성공 -(다음화면)->   작성한 글 (상세조회 -> 게시글 번호 필요!)  
					result = boardNo; 
					// result에 boardNo를 담아 상세조회로 이동할 때 사용하게 함.
				}else {
					rollback(conn); // << -- 여기도 추가해야됩니다!
				}
				
				
			}else {
				rollback(conn);
			}
		}
		
		close(conn);
		
		return result;
		
	}

	
	
	
	
	
	// 크로스 사이트 스크립트 방지 메소드
	private String replaceParameter(String param) {
		String result = param;
		if(param != null) {
			result = result.replaceAll("&", "&amp;");
			result = result.replaceAll("<", "&lt;");
			result = result.replaceAll(">", "&gt;");
			result = result.replaceAll("\"", "&quot;");
		}
		
		return result;
	}
	
}
