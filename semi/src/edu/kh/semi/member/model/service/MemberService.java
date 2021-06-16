package edu.kh.semi.member.model.service;

import static edu.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.semi.member.model.dao.MemberDAO;
import edu.kh.semi.member.model.vo.Member;


// Service : 비즈니스 로직 처리(데이터 가공, 트랜잭션 처리)
public class MemberService {
	
	private MemberDAO dao = new MemberDAO();

	
	/** 로그인 Service
	 * @param memberId
	 * @param memberPw
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(String memberId, String memberPw) throws Exception {
		
		// DB 연결 정보를 담고있는 Connection을 얻어옴.
		Connection conn = getConnection();
		
		// 얻어온 Connection과 매개변수를 DAO의 알맞은 메소드로 전달하여 결과를 반환 받음.
		Member loginMember = dao.login(conn, memberId, memberPw);
		
		// 커넥션 반환
		close(conn);
		
		// 서비스 수행 결과 반환
		return loginMember;
	}
	

	
	
	
}
