package com.kh.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet 어노테이션
// 기존에 web.xml에 작성했던 url 패턴에 따른 servlet 연결 구문을 간소화 하는 설정
@WebServlet("/example.do")
public class Example extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// POST 방식으로 전달된 데이터의 문자 인코딩을 변경
		request.setCharacterEncoding("UTF-8");
		
		// 요청 시 전달된 데이터(== 파라미터)를 별도 변수에 저장
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		System.out.println("userId : " + userId);
		System.out.println("userPw : " + userPw);
		
		// id가 user01, pw가 pass01인 경우에는 "로그인 성공"
		// 아닐경우 "아이디 또는 비밀번호가 일치하지 않습니다"
		// 응답 화면으로 출력하기
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	
}
