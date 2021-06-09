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
	
	private Properties prop = null; // 외부에서 읽어온 xml 파일을 저장한 객체를 참조할 변수 선언.
	
	public MemberDAO() {
		// DAO 클래스에서 사용되는 SQL 구문은 수정 될 가능성이 많으므로
		// 별도의 XML 파일에 따로 작성하여 컴파일을 추가적으로 하지 않아도 되는 형태로 코드 작성.
	
		// 기본 생성자에 코드를 작성하는 이유!
		// -> 외부 XML 파일을 읽어 온다 --> IOException 발생 가능성이 있음
		// --> 예외처리 필요 --> 예외처리는 메소드에만 작성 가능
		// --> 생성자도 메소드이기 때문에 생성자를 사용
		
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
	 * @param memId
	 * @param memPw
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Connection conn, String memId, String memPw) throws Exception {
		// ** 결과 저장용 변수 만들기 + return 구문 작성
		Member loginMember = null;
		
		try {
			// 1. SQL 구문 얻어오기
			String sql = prop.getProperty("login");
			
			// 2. Connection에 PreparedStatement 생성 + sql 배치
			pstmt = conn.prepareStatement(sql);
			
			// 3. 위치 홀더에 알맞은 값 세팅
			pstmt.setString(1, memId);
			pstmt.setString(2, memPw);
			
			// 4. sql 수행 후 결과를 rs로 반환 받기
			rs = pstmt.executeQuery();
			
			// 5. 조회 결과가 있으면 조회 결과를 Member객체에 저장
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
			
			// 중간 확인 
			//System.out.println(loginMember);
			
		}finally {
			// 6. 사용한 JDBC 객체 자원 반환
			close(rs);
			close(pstmt);
		}
		
		return loginMember;
	}
}
