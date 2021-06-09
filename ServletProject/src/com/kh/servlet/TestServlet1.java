package com.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet() 메소드 : get방식으로 전달되는 요청을 처리하고 응답하는 메소드
	
		
		// post 방식으로 데이터 전달 시 한글이 깨지는 이유!!(빠밤)
		// -> post 방식 전달 시 데이터의 인코딩이 ISO-8859-1 형식으로 지정되어 있어
		// UTF-8로 지정된 환경에서 깨지는 현상이 발생함.
		//  --> 전달된 데이터의 문자 인코딩을 UTF-8로 바꾸면 문제가 해결됨!
		request.setCharacterEncoding("UTF-8"); // POST 방식 첫 줄 필수!!!
		
		
		// 클라이언트 요청에 담겨져 넘어온 값을 파라미터(parameter) 라고 함.
		// 파라미터는 무조건 String 자료형이다!!!
		
		// 파라미터를 얻어와 String 변수에 저장
		// request.getParameter("name속성값") : name 속성값을 가지는 input태그  
//											   value를 얻어와 문자열 형태로 반환
		
		// request.getParameterValues("name속성값");
		//  : 같은 name 속성값을 가지는 input태그의 모든 value를 순서대로 얻어와
		//    String[] 형태로 반환
		
		String inputName = request.getParameter("inputName");
		
		String gender = request.getParameter("gender");
		// radio 타입은 버튼은 여러 개지만 선택되는 값은 하나! 
		
		String[] foodArr = request.getParameterValues("food");
		
		// 얻어온 파라미터 확인
		System.out.println("inputName : " + inputName);
		System.out.println("gender : " + gender);
		System.out.println("food : " + Arrays.toString(foodArr));
		
		
		// 응답화면을 출력하기 위한 준비
		
		// 1) 응답 화면(HTML문서)의 형식 지정
		response.setContentType("text/html; charset=UTF-8");
		
		// 2) 응답을 위한 데이터 전달 통로(스트림) 준비
		PrintWriter out = response.getWriter();
		
		// 3) 응답 화면을 만들기 위한 HTML코드를 스트림을 이용해 출력
		String pr1 = inputName + "(" + gender + ")"; // 홍길동(남자)
		String pr2 = String.join(", ", foodArr);
				// 한식, 중식, 일식
		
		
		out.println("<!DOCTYPE html>" + 
				"<html lang=\"ko\">" + 
				"<head>" + 
				"    <meta charset=\"UTF-8\">" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" + 
				"    <title>TestServlet1 응답 화면</title>" + 
				"" + 
				"    <style>" + 
				"        #span1{ color : blue; }" + 
				"        #span2{ color : red; }" + 
				"    </style>" + 
				"</head>" + 
				"<body>" + 
				"    <h3>" + 
				"        <span id=\"span1\">" + pr1 + "</span>님의 " + 
				"        선호하는 음식 스타일은 " + 
				"        <span id=\"span2\">" + pr2 + "</span>입니다." + 
				"    </h3>" + 
				"</body>" + 
				"</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doPost() 메소드 : post방식으로 전달되는 요청을 처리하고 응답하는 메소드
		doGet(request, response);
		// get, post 전달방식의 요청을 모두 하나의 메소드(doGet())에서 처리한다는 의미
		// == get, post 관계 없이 처리 방법이 같음
	}

	
	
}
