package edu.kh.member.model.service;

import static edu.kh.member.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.member.model.dao.MemberDAO;
import edu.kh.member.model.vo.Member;


// Service : 데이터 가공 + 트랜잭션 처리
public class MemberService {

	private MemberDAO dao = new MemberDAO();

	// alt + shift + j
	/** 로그인 Service   
	 * @param memberId
	 * @param memberPw
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(String memberId, String memberPw) throws Exception {
		
		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn, memberId, memberPw);
		
		close(conn);
		
		return loginMember;
	}
	
	
	
	
	
	
	
}
