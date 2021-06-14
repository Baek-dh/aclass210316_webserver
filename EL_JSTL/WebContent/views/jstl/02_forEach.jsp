<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>02_forEach</title>
</head>
<body>
	<h1>&lt;c:forEach> 태그 </h1>
	- Java의 for문에 해당하는 기능을 제공하는 태그
	- forEach는 여러가지 속성이 사용됨
	
	<pre>
	var : 현재 반복 횟수에 해당하는 변수의 이름
	begin : 반복이 시작할 요소 번호 (0 … n)
	end : 반복이 끝나는 요소 번호
	step : 반복 시 증가할 수
	items : 반복할 객체 명 (Collection 객체)
	varStatus : 현재 반복에 해당하는 객체의 요소
	</pre>
	
	<hr>
	
	<h3> 기본 사용법 </h3>
	<c:forEach var="i" begin="1" end="6" step="1">
		
		<h${i}> ${i}번째 반복 중입니다. </h${i}>
	
	</c:forEach>
	
	<hr>
	<h3> forEach 역순으로 반복하기</h3>
	<span style="color:red"> 
		step 속성은 0보다 작거나 같을 수 없다!!!
	</span>
	<br>
	
	<c:forEach var="i" begin="1" end="6" step="1">
		<h${7-i}> 역순 반복중 (${7-i}) </h${7-i}>
	</c:forEach>
	
	<hr>
	
	<h3>forEach를 이용한 배열 반복 접근</h3>
	
	<h4>사용 가능한 언어/기술 선택</h4>
	<form action="forEachEnd.jsp">
		<input type="checkbox" name="lang" value="Java">  Java <br>
		<input type="checkbox" name="lang" value="Oracle SQL">  Oracle SQL <br>
		<input type="checkbox" name="lang" value="JDBC">  JDBC <br>
		<input type="checkbox" name="lang" value="HTML5">  HTML5  <br>
		<input type="checkbox" name="lang" value="CSS3"> CSS3  <br>
		<input type="checkbox" name="lang" value="Javascript">  Javascript  <br>
		<input type="checkbox" name="lang" value="jQuery">  jQuery <br>
		<input type="checkbox" name="lang" value="Servlet">  Serlvet <br>
		<input type="checkbox" name="lang" value="JSP">  JSP <br><br>
		<button>제출하기</button>
	</form>






</body>
</html>