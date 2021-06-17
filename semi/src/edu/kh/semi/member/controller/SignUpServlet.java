package edu.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.semi.member.model.vo.Member;

// 회원가입 요청 주소 : /semi/member/signUp
@WebServlet("/member/signUp")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// get방식 요청을 받아서 처리하는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 화면을 응답해주는 메소드
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/signUp.jsp");
		view.forward(request, response);
		
		
	}

	
	// post 방식 요청을 처리하는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 페이지에서 가입하기 버튼을 눌렀을 때 요청을 받고 응답하는 메소드
		
		// 1. POST 방식으로 전달된 요청의 문자 인코딩 변경
		request.setCharacterEncoding("UTF-8");
		
		// 2. 전달 받은 파라미터를 모두 변수에 저장
		String memberId = request.getParameter("id");
		String memberPw = request.getParameter("pwd1");
		String memberName = request.getParameter("name");
		String memberEmail = request.getParameter("email");
		
		// * 같은 name 속성으로 전달된 파라미터를 얻어오는 방법
		// String[] 배열명 = request.getParameterValues("name속성값");
		
		String[] phone = request.getParameterValues("phone");
		
		// DB 저장을 위해 구분자 '-'를 이용하여 하나의 문자열로 합침
		String memberPhone = String.join("-", phone);
		
		
		
		String[] address = request.getParameterValues("address");
		// 주소는 필수 입력 사항이 아니기 때문에 파라미터가 없을 수 있다 == null
		// -> String.join() 수행 시 NullPointerException가 발생할 수 있다
		
		String memberAddress = null;
		if(address != null) {
			memberAddress = String.join(",", address);
		}
		
		
		// 중간확인
		System.out.println(memberId);
		System.out.println(memberPw);
		System.out.println(memberName);
		System.out.println(memberEmail);
		System.out.println(memberPhone);
		System.out.println(memberAddress);
		
		
		// 파라미터를 하나의 Member객체에 담기
		Member member = new Member(memberId, memberPw, memberName, memberPhone, memberEmail, memberAddress);
		
		// @@@@ 2021년 6월 17일 (목) 숙제
		// 입력받은 회원 정보를 DB의 MEMBER 테이블에 INSERT하고 결과를 Servlet까지 반환하기
		
	}
	
	
	
	
	
	

}
