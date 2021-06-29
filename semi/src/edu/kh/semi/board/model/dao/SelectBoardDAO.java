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
import edu.kh.semi.board.model.vo.Pagination;

public class SelectBoardDAO {

	// 자주 사용하는 JDBC 객체 참조 변수 선언
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 외부 XML 파일에 작성된 SQL 구문을 읽어와 저장할 Properties객체 참조 변수 선언
	private Properties prop = null;
	
	
	// 기본 생성자를 이용한 DAO 객체 생성 시 외부 XML파일을 읽어와 prop에 저장
	public SelectBoardDAO() {
		// selectBoard-query.xml 파일의 경로 얻어오기
		String filePath 
			= SelectBoardDAO.class.getResource("/edu/kh/semi/sql/board/selectBoard-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			
			// filePath 변수에 저장된 경로로 부터 XML 파일을 읽어와 prop에 저장
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	/** 전체 게시글 수 + 게시판 이름 조회 DAO
	 * @param conn
	 * @param cp
	 * @param boardType
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> getListCount(Connection conn, int cp, int boardType)
				throws Exception{
	
		Map<String, Object> map = new  HashMap<String, Object>();
		
		String sql = prop.getProperty("getListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardType);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				map.put( "listCount",  rs.getInt(1) );			
				map.put( "boardName",  rs.getString(2) );	
			}

		}finally {
			close(rs);
			close(pstmt);
		}
		
		return map;
	}


	/** 게시글 목록 조회 DAO
	 * @param conn
	 * @param pagination
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Connection conn, Pagination pagination) throws Exception{
	
		List<Board> boardList = new ArrayList<Board>();
				
		String sql = prop.getProperty("selectBoardList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pagination.getBoardType());
			
			// 조회할 범위를 지정할 변수 선언
			int startRow = (pagination.getCurrentPage() - 1) * pagination.getLimit() + 1;
			int endRow = startRow + pagination.getLimit() - 1;
			
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 조회된 한 행의 정보를 board에 set
				Board board = new Board();
				
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setCategoryName(rs.getString("CATEGORY_NM"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberName(rs.getString("MEMBER_NM"));
				board.setReadCount(rs.getInt("READ_COUNT"));
				board.setCreateDate(rs.getTimestamp("CREATE_DT"));
				
				// 1) board의 filePath, fileName에 set할 수 있는 List 객체부터 생성
				List<String> filePath = new ArrayList<String>();
				List<String> fileName = new ArrayList<String>();
				
				// 2) 생성된 리스트에 DB 조회 결과를 추가
				filePath.add( rs.getString("FILE_PATH") );
				fileName.add( rs.getString("FILE_NM") );
				
				// 3) 리스트를 board에 set
				board.setFilePath(filePath);
				board.setFileName(fileName);
				
				
				// set 완료된 board를 boardList에 추가
				boardList.add(board);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return boardList;
	}


	/** 게시글 상세 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoard(Connection conn, int boardNo) throws Exception{
		Board board = null;
		
		String sql = prop.getProperty("selectBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			board = new Board();
			
			// board에 필드 중 atList에 값을 저장할 수 있도록 List 객체 하나를 생성하여 세팅
			board.setAtList(new ArrayList<Attachment>());
			
			
			boolean flag = true; // 아래 반복문 첫 반복을 하고 있을 때 true, 아닐 때 false를 나타내는 신호
			
			while(rs.next()) {
				if(flag) {
					board.setBoardNo(rs.getInt("BOARD_NO"));
					board.setCategoryName(rs.getString("CATEGORY_NM"));
					board.setBoardTitle(rs.getString("BOARD_TITLE"));
					board.setMemberName(rs.getString("MEMBER_NM"));
					board.setReadCount(rs.getInt("READ_COUNT"));
					board.setCreateDate(rs.getTimestamp("CREATE_DT"));
					
					board.setBoardContent(rs.getString("BOARD_CONTENT"));
					board.setMemberNo(rs.getInt("MEMBER_NO"));
					board.setModifyDate(rs.getTimestamp("MODIFY_DT"));
					flag = false;
				}
				
				// 조회된 파일 관련 정보를 저장할 객체 선언(경로, 이름, 레벨)
				Attachment at = new Attachment();
				at.setFilePath( rs.getString("FILE_PATH") );
				at.setFileName( rs.getString("FILE_NM") );
				at.setFileLevel( rs.getInt("FILE_LEVEL") );
				
				// 값 세팅이 완료된 Attachment 객체를
				// board의 atList에 추가
				board.getAtList().add(at);
			}
			
		}finally {
			
			close(rs);
			close(pstmt);
		}
		
		return board;
	}


	/** 게시글 조회수 증가 DAO
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int increaseReadCount(Connection conn, int boardNo) throws Exception{
		
		int result = 0;
		
		String sql = prop.getProperty("increaseReadCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	
	
	
	
	
}
