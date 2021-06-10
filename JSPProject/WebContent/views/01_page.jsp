<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage="errorPage.jsp" %>
<%-- errorPage : 해당 JSP 내부에서 에러가 발생하면 보여질 페이지를 지정--%>    
    
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>page 지시자(import, error)</title>
</head>
<body>
	<%@ include file="header.jsp" %>


	<!-- HTML 주석 : HTML코드 주석, 화면에는 안보이지만 개발자 도구에서 보임 -->
	<!-- <p>html내용</p> -->

	
	<%-- JSP 주석  : JSP내 HTML, java코드 주석
				   화면, 개발자도구 모두 안보임--%>
	<%-- <% String str = "스크립틀릿"; %> --%>
	<%-- <h1>점심 뭐먹지</h1> --%>
	
	
	<% // Scriptlet(스크립틀릿) : JSP 내부에 Java 코드 작성 부분
		List<String> list = new ArrayList<String>();
	
		list.add("짬뽕");
		list.add("짜장");
		list.add("볶음밥");
	%>
	
	<% for(String s : list) { %>
		<%-- Expression(표현식) : Java코드를 HTML로 출력해서 화면에 표현 --%>
		<h3> <%= s %> </h3>
	<% } %>
	
	
	<%-- 강제 에러 발생 --%>
	<%-- <% list.add(10, "탕수육"); %> --%>
	
	
	<h3>잘못된 주소/경로로 접근했을 때 나타나는 에러페이지 지정하기</h3>
	
	<a href="abc.jsp">존재하지 않는 주소로 이동</a>
	<!-- 
		HTTP 상태 코드
		200 : HTTP 응답 성공  (서버와의 요청 응답이 정상적으로 수행됨)
		
		400 Bad Request : 잘못된 요청으로 서버가 인지하지 못함
		403 Forbidden : 서버가 사용자 요청을 거부
		404 Not Found : 요청한 페이지를 찾을 수 없음
		500 Internal Server Error: 서버쪽(Java, DB)에서 오류 발생
	 -->
	
	
	
	
	<%@ include file="footer.jsp" %>

</body>
</html>