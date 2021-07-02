package edu.kh.semi.board.model.dao;

import static edu.kh.semi.common.JDBCTemplate.*;

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
import edu.kh.semi.board.model.vo.Reply;
import edu.kh.semi.member.model.dao.MemberDAO;

public class ReplyDAO {

	// 자주 사용하는 JDBC 객체 참조 변수 선언
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 외부 XML 파일에 작성된 SQL 구문을 읽어와 저장할 Properties객체 참조 변수 선언
	private Properties prop = null;
	
	
	// 기본 생성자를 이용한 DAO 객체 생성 시 외부 XML파일을 읽어와 prop에 저장
	public ReplyDAO() {
		// selectBoard-query.xml 파일의 경로 얻어오기
		String filePath 
			= ReplyDAO.class.getResource("/edu/kh/semi/sql/board/reply-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			
			// filePath 변수에 저장된 경로로 부터 XML 파일을 읽어와 prop에 저장
			prop.loadFromXML(new FileInputStream(filePath));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	/** 댓글 목록 조회 DAO
	 * @param conn
	 * @param boardNo
	 * @return list
	 * @throws Exception
	 */
	public List<Reply> selectList(Connection conn, int boardNo) throws Exception{
		
		List<Reply> list = new ArrayList<Reply>();
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Reply reply = new Reply();
				
				reply.setReplyNo(rs.getInt("REPLY_NO"));
				reply.setReplyContent(rs.getString("REPLY_CONTENT"));
				reply.setCreateDate(rs.getTimestamp("CREATE_DT"));
				reply.setMemberNo(rs.getInt("MEMBER_NO"));
				reply.setMemberName(rs.getString("MEMBER_NM"));
				reply.setBoardNo(rs.getInt("BOARD_NO"));
				
				list.add(reply);
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		
		return list;
	}


	/** 댓글 삽입 DAO
	 * @param conn
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Connection conn, Reply reply) throws Exception{
		
		int result = 0;

		String sql = prop.getProperty("insertReply");
		
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getMemberNo());
			pstmt.setInt(3, reply.getBoardNo());
			
			result = pstmt.executeUpdate();
					
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 댓글 수정 DAO
	 * @param conn
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int updateReply(Connection conn, Reply reply) throws Exception {
		int result = 0;

		String sql = prop.getProperty("updateReply");
		
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getReplyNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 댓글 삭제
	 * @param conn
	 * @param replyNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteReply(Connection conn, int replyNo) throws Exception{
		int result = 0;

		String sql = prop.getProperty("deleteReply");
		
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}