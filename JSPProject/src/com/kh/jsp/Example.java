package com.kh.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		
		String result = null;
		if(userId.equals("user01") && userPw.equals("pass01")  ) {
			result =  "로그인 성공";
		}else {
			result = "아이디 또는 비밀번호가 일치하지 않습니다";
		}
		
		/*
		// 응답화면 출력하기
		
		// 1) 응답 문서 타입 설정
		response.setContentType("text/html; charset=UTF-8");
		
		// 2) 스트림 얻어오기
		PrintWriter out = response.getWriter();
		
		// 3) 스트림 통해서 출력하기
		out.println("<!DOCTYPE html>" + 
				"<html lang=\"ko\">" + 
				"<head>" + 
				"    <meta charset=\"UTF-8\">" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" + 
				"    <title>로그인 결과 화면</title>" + 
				"</head>" + 
				"<body>" + 
				"    <h1>" + result + "</h1>" + 
				"</body>" + 
				"</html>");
		*/
		
		// servlet에서 응답 화면을 만들기위해 작성한 HTML 코드 부분을
		// JSP로 위임하기 
		
		// 1. 요청 위임 객체 생성 (RequestDispatcher)
		
		// Dispatcher : 필요한 정보를 제공하는자, 발송자
		// RequestDispatcher : 요청 정보를 발송하는 객체 (== 요청 위임 객체)
		RequestDispatcher view = 
				request.getRequestDispatcher("views/loginResult.jsp");
		// views/loginResult.jsp 파일로 요청을 위임하는 객체 생성
		
		
		// userId, userPw와 같은 요청 관련 데이터는 요청 위임 객체 생성 시 자동으로 전달되지만
		// result와 같은 요청과 관계없는 데이터(가공된 데이터)는 전달되지 않는다!
		// --> result를 request 객체에 담으면 JSP로 같이 전달 가능
		
		// request.setAttribute("key", value) 
		// 요청 정보를 담고있는 HttpServletRequest 객체에 새로운 정보를 key, value 형태로 추가
		request.setAttribute("result", result);
		
		
		// 요청 위임 객체에 작성된 jsp 파일로 request, response를 전달하여
		// 기존 Servlet이 만들어야 했던 HTML 응답화면을 대신 만들어줌
		// forward : 앞으로, 밖으로; 전송(전달)하다
		view.forward(request, response);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	
}
