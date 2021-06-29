package edu.kh.semi.board.model.service;

import static edu.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import edu.kh.semi.board.model.dao.SelectBoardDAO;
import edu.kh.semi.board.model.vo.Board;
import edu.kh.semi.board.model.vo.Pagination;

public class SelectBoardService {
	
	private SelectBoardDAO dao = new SelectBoardDAO();

	/** 페이징 처리 객체 생성용 Service
	 * @param cp
	 * @param boardType
	 * @return pagination
	 * @throws Exception
	 */
	public Pagination getPagination(int cp, int boardType) throws Exception {
		
		Connection conn = getConnection();
		
		// DB에서 전체 게시글 수 + 게시판 이름을 얻어옴
		Map<String, Object> map = dao.getListCount(conn, cp, boardType);
		
		close(conn);
		
		int listCount = (int)map.get("listCount");
		String boardName = (String)map.get("boardName");
		
		return new Pagination(cp, listCount, boardType, boardName);
	}

	
	
	/** 게시글 목록 조회 Service
	 * @param pagination
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Pagination pagination) throws Exception{
		Connection conn = getConnection();
		
		List<Board> boardList = dao.selectBoardList(conn, pagination);
		
		close(conn);
		
		return boardList;
	}



	/** 게시글 상세 조회
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(int boardNo) throws Exception{
		Connection conn = getConnection();
		
		Board board = dao.selectBoard(conn, boardNo);
		
		// 게시글이 정상 조회 된 경우
		if(board.getBoardTitle() != null) {
			
			int result = dao.increaseReadCount(conn, boardNo);
			
			if( result > 0 ) {
				commit(conn);
				
				// DB에서 조회수를 증가하기 전에 얻어왔던 값을 1 증가 시킴
				board.setReadCount( board.getReadCount() + 1  );
			}
			
			else				rollback(conn);
		}
		
		
		close(conn);
		
		return board;
	}

	
	
	
	
	
}
