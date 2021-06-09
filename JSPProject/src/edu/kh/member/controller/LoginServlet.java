package edu.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.member.model.service.MemberService;
import edu.kh.member.model.vo.Member;

// Controller : MVC Model2 패턴 중 C에 해당하는 부분으로
// 요청에 따른 Service를 선택하고, 응답 화면을 제어하는 클래스

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// POST 전달 방식 -> 문자 인코딩 변경
		request.setCharacterEncoding("UTF-8");
		
		// 전달 받은 파라미터 변수에 저장
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		System.out.println("memberId : " + memberId);
		System.out.println("memberPw : " + memberPw);
			
		
		// Service를 호출하여 아이디, 비밀번호가 일치하는 정보를 DB에서 조회해오기
		MemberService service = new MemberService();
		
		try {
			Member loginMember = service.login(memberId, memberPw);
			
			System.out.println(loginMember);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
