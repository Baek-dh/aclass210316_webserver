<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>JSP Action Tag Include(동적 include)</title>
</head>
<body>
	<h3>JSP Action Tag란?</h3>
	<pre>
		JSP Action Tag는 XML 기술을 이용하여
		기존의 JSP 문법을 확장하는 메커니즘을 제공하는 태그로써,
		JSP 자체에 내장되어있음. (JSTL 아님)
		
		웹 브라우저에서 해석되어 실행되는 것이 아닌
		웹 컨테이너에 실행되고 결과만 브라우저로 출력함.
		(== JSP Action Tag는 Java코드로 변환된다.)
	</pre>

	<%-- 
		JSP Action Tag include (동적 include)
		<jsp:include page="jsp 경로">
	 --%>

	<pre>
		JSP Action Tag include는
		부모 JSP 파일이 화면에 출력되는 시점에 삽입되어짐.
		
		장점 : 서로 다른 페이지로 인식 되기 때문에 변수명 중복이 발생하지 않는다.
			  컴파일 단계 이전에 합쳐지는 과정이 없기 때문에 컴파일 속도가 향상됨.
			  
		단점 : 화면 출력 시점에 삽입되기 때문에 클라이언트 측 화면 로딩이 지연됨.		
	</pre>
	
	
	<jsp:include page="ex2.jsp"></jsp:include>

	<% String name = "이순신"; // 변수명 중복 에러 X%>
	
	<h1><%= name %></h1>	
	





</body>
</html>


