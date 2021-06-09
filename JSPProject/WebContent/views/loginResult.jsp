<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% // 스크립틀릿 : jsp에서 java코드 작성이 가능한 영역
	String result = (String)request.getAttribute("result");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과 화면</title>
</head>
<body>
	<!-- 표현식 : java 코드를 html 화면에 출력하는 것 -->
	<h1> <%= result %>  </h1>
</body>
</html>




