package edu.kh.semi.member.model.dao;

import static edu.kh.semi.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import edu.kh.semi.member.model.vo.Member;

// DAO(Data Access Object) : DB 연결 객체
public class MemberDAO {
	
	// 자주 사용하는 JDBC 객체 참조 변수 선언
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 외부 XML 파일에 작성된 SQL 구문을 읽어와 저장할 Properties객체 참조 변수 선언
	private Properties prop = null;
	
	
	// 기본 생성자를 이용한 DAO 객체 생성 시 외부 XML파일을 읽어와 prop에 저장
	public MemberDAO() {
		// member-query.xml 파일의 경로 얻어오기
		String filePath 
			= MemberDAO.class.getResource("/edu/kh/semi/sql/member/member-query.xml").getPath();                    
		
		try {
			prop = new Properties();
			
			// filePath 변수에 저장된 경로로 부터 XML 파일을 읽어와 prop에 저장
			prop.loadFromXML(new FileInputStream(filePath));
			
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

		// 로그인된 회원 정보가 담긴 객체를 참조할 변수 (결과 저장용 변수) 선언
		Member loginMember = null;
		
		// prop에서 알맞은 SQL 구문 꺼내오기
		String sql = prop.getProperty("login");
		
		try {
			
			// DB로 SQL을 전달하고 수행 후 결과를 반환 받을 객체를 Connection에 세팅
			pstmt = conn.prepareStatement(sql);
			
			// 위치홀더에 알맞은 값 채우기
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			
			// SQL 구문 수행 후 조회 결과인 ResultSet을 rs 변수에 저장
			rs = pstmt.executeQuery();
			
			// 조회 결과가 있는지 확인 후 있으면 Member 객체를 생성하여 조회된 값을 저장
			// -> 로그인 결과는 없거나 1행만 있음 -> if문으로 검사
			if(rs.next()) {
				// rs.next() : 다음 행에 조회 결과가 있을 경우 다음 행으로 이동
				loginMember 
				= new Member(rs.getInt("MEMBER_NO"), 
							rs.getString("MEMBER_ID"), 
							rs.getString("MEMBER_NM"), 
							rs.getString("MEMBER_PHONE"), 
							rs.getString("MEMBER_EMAIL"), 
							rs.getString("MEMBER_ADDR"), 
							rs.getDate("ENROLL_DATE"), 
							rs.getString("MEMBER_GRADE"));
			}
			
			
		}finally {
			
			// 사용한 JDBC 객체 생성 역순으로 반환
			close(rs);
			close(pstmt);
		}
		
		// 조회 결과 반환 (조회 성공 시 Member, 실패 시 null 이 반환됨)
		return loginMember;
	}


	/** 회원 가입 DAO
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception {
		
		// 1) 결과 반환용 변수 선언
		int result = 0;
		
		// 2) SQL구문을 Properties에서 얻어오기
		String sql = prop.getProperty("signUp");
		
		try {
			// 3) PreparedStatement 객체를 생성해서 SQL 세팅
			pstmt = conn.prepareStatement(sql);
			
			// 4) 위치홀더에 알맞은 값 대입
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberPhone());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getMemberAddress());
			
			// 5) SQL 수행 후 결과 반환 받기
			result = pstmt.executeUpdate();
		
		}finally {
			// 6) 사용한 JDBC 자원 반환하기
			close(pstmt);
		}
		
		// 7) 결과를 Service로 반환하기
		return result;
	}
	
	
	
}





