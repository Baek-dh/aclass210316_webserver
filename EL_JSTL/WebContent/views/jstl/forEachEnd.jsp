<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
 
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>forEach 결과화면</title>
</head>
<body>

	${param.lang } <br>
	<!-- 같은 name속성으로 존재하는 파라미터가 다수일 경우
		param.name속성값  구문은 첫 번째 값만 얻어옴. -->
		
	${paramValues.lang }   <br>
	<!-- 
		paramValues.name속성값
		파라미터 중 같은 name 속성값을 가지는 파라미터를 
		하나의 String 배열로 반환
	 -->

	${paramValues.lang[0] } <br>
	${paramValues.lang[1] } <br>
	${paramValues.lang[2] } <br>


	<hr>
	
	<h3>varStatus 속성</h3>
	
	varStatus는 다음과 같은 속성을 가지고 있음
	
	<pre>
	current : 현재 반복 횟수 또는 현재 반복 접근한 값
	index : 반복 라운드의 제로 기반(zero-based) 인덱스 (0 … n)
	count : 반복 라운드의 1 기반(one-based) 인덱스 (1 … n) 
	first : 현재 라운드가 반복을 통한 첫 번째임을 의미 
	last  :현재 라운드가 반복을 통한 마지막 번째임을 의미 
	</pre>	
	
	<c:forEach items="${paramValues.lang}" var="item" varStatus="vs">

		현재 값 : ${vs.current }  <br>
		현재 인덱스 : ${vs.index } <br>
		현재 인덱스 값 : ${paramValues.lang[vs.index] } <br>
		현재 반복 횟수 : ${vs.count } <br>
		첫 번째 바퀴인가? : ${vs.first } <br>
		마지막 바퀴인가? : ${vs.last } <br>
		<hr>

	</c:forEach>








</body>
</html>