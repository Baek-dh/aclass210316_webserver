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


	
	
	
	
}
