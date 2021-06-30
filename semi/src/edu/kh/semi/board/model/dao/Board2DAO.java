package edu.kh.semi.board.model.dao;

import static edu.kh.semi.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import edu.kh.semi.board.model.vo.Attachment;
import edu.kh.semi.board.model.vo.Board;
import edu.kh.semi.board.model.vo.Category;
import edu.kh.semi.board.model.vo.Pagination;

public class Board2DAO {

	// 자주 사용하는 JDBC 객체 참조 변수 선언
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 외부 XML 파일에 작성된 SQL 구문을 읽어와 저장할 Properties객체 참조 변수 선언
	private Properties prop = null;
	
	
	// 기본 생성자를 이용한 DAO 객체 생성 시 외부 XML파일을 읽어와 prop에 저장
	public Board2DAO() {
		// board2-query.xml 파일의 경로 얻어오기
		String filePath 
			= Board2DAO.class.getResource("/edu/kh/semi/sql/board/board2-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			
			// filePath 변수에 저장된 경로로 부터 XML 파일을 읽어와 prop에 저장
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	/** 카테고리 목록 조회 DAO
	 * @param conn
	 * @return category
	 * @throws Exception
	 */
	public List<Category> selectCategoryList(Connection conn) throws Exception {
		
		List<Category> category = new ArrayList<Category>();
		
		String sql = prop.getProperty("selectCategoryList");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Category ca = new Category();
				ca.setCategoryCode(rs.getInt(1));
				ca.setCategoryName(rs.getString(2));
				
				category.add(ca);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		return category;
	}


	/** 다음 게시글 번호 조회 DAO
	 * @param conn
	 * @return boardNo
	 * @throws Exception
	 */
	public int nextBoardNo(Connection conn) throws Exception{
		
		int boardNo = 0;
		
		String sql = prop.getProperty("nextBoardNo");
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				boardNo = rs.getInt(1);
			}
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		return boardNo;
	}


	/** 게시글 삽입 DAO
	 * @param conn
	 * @param board
	 * @param boardType
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Connection conn, Board board, int boardType) throws Exception {
	
		int result = 0;
		
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, board.getBoardNo());
			pstmt.setString(2, board.getBoardTitle());
			pstmt.setString(3, board.getBoardContent());
			pstmt.setInt(4, board.getMemberNo());
			pstmt.setInt(5, board.getCategoryCode());
			pstmt.setInt(6, boardType);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 첨부파일(이미지) 정보 삽입 DAO
	 * @param conn
	 * @param at
	 * @return result
	 * @throws Exception
	 */
	public int insertAttachment(Connection conn, Attachment at) throws Exception {
		int result = 0;
		
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, at.getFilePath());
			pstmt.setString(2, at.getFileName());
			pstmt.setInt(3, at.getFileLevel());
			pstmt.setInt(4, at.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	
	
	
	
}
