<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.kh.eljstl.model.vo.Person"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>EL 특징 + 나머지</title>
</head>
<body>

	<h1>EL은 NullPointerException을 발생시키지 않는다!!</h1>
	
	<h3>값이 null인 경우 EL은 빈칸으로 화면에 출력함 </h3>
	
	<!-- request 속성 중 ppp를 얻어와 Person으로 다운캐스팅 후 name을 얻어옴 -->
	<%-- <%= ( (Person)request.getAttribute("ppp") ).getName()  %> --%>
	
	EL : ${ ppp.name }
	
	<hr>
	
	
	<h2>객체가 null이거나 비어있는지 확인하는 방법  :  empty </h2>
	
	<%
		List<String> list = new ArrayList<String>();
	%>

	list는 비어있는가? ${empty list}  <br>

	ppp는 null인가? ${empty ppp}


	<hr>
	
	<h3>EL은 HTML에 출력하기 위한 표현 언어 이지만, 간단한 연산도 가능하다</h3>
	
	10 + 3  <br>
	
	${ 10 + 3 } <br>
	${ 10 - 3 } <br>
	${ 10 * 3 } <br>
	${ 10 / 3 } <br>
	${ 10 % 3 } <br>
	
	${ true && true } <br>
	${ true && false }  <br>
	${ true and false }  <br>



</body>
</html>



