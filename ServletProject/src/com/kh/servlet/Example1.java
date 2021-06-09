package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Example1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, 
						HttpServletResponse response) throws ServletException, IOException {
		
		String inputName = request.getParameter("inputName");
		String inputAge = request.getParameter("inputAge");
		
		System.out.println("입력 받은 이름 : " + inputName);
		System.out.println("입력 받은 나이 : " + inputAge);
		
		
		// --------------------------------------------------------
		// 응답(Response) 화면 출력 준비
		
		// 응답할 문서의 형식 지정
		response.setContentType("text/html; charset=UTF-8");
		
		// 외부로 문자열을 출력하기 위한 스트림 준비
		// HttpServletResponse에 있는 응답용 스트림을 얻어옴
		PrintWriter out = response.getWriter();
		
		/*out.println("<!DOCTYPE html>");
		out.println("<html lang='ko'>");
		out.println("</html>");*/
		
		// 응답 화면 출력하기
		out.println("<!DOCTYPE html>" + 
				"<html lang=\"ko\">" + 
				"<head>" + 
				"    <meta charset=\"UTF-8\">" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" + 
				"    <title>Example1 응답 화면</title>" + 
				"</head>" + 
				"<body>" + 
				"    <h1>" + inputName + "님 환영합니다.</h1>" + 
				"    <h3>올해 " + inputAge + "세 이시군요.</h3>" + 
				"</body>" + 
				"</html>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	
}
