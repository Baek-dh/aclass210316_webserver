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

	
	
	
}
