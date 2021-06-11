package edu.kh.member.model.dao;

import static edu.kh.member.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.member.model.vo.Member;

public class MemberDAO {
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Properties prop = null; 
	
	public MemberDAO() {
		
		try {
			prop = new Properties();
			
			String filePath 
			= MemberDAO.class.getResource("/edu/kh/member/sql/member-query.xml").getPath();     
		
			
			prop.loadFromXML( new FileInputStream( filePath ) );
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/** 로그인 DAO
	 * @param conn
	 * @param memberId
	 * @param memberPw
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Connection conn, String memberId, String memberPw) throws Exception {
		Member loginMember = null;
		
		try {
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				int memNo = rs.getInt("MEM_NO");
				String id = rs.getString("MEM_ID");
				String memNm = rs.getString("MEM_NM");
				String memPhone = rs.getString("MEM_PHONE");
				char memGender = rs.getString("MEM_GENDER").charAt(0);
				Date joinDate = rs.getDate("JOIN_DATE");
			
				loginMember = new Member(id, memNm, memPhone, 
										memGender, joinDate);
				
				loginMember.setMemNo(memNo);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return loginMember;
	}
}
