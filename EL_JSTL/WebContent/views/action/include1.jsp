<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Scripting Include (정적 include)</title>
</head>
<body>

	<%-- 스크립팅 방식의 include
		<%@ include file="jsp경로"%>
	 --%>
	 
	<pre>
		스크립팅 방식의 include는 
		부모 JSP 파일이 컴파일 되기 전에 삽입되어 같이 컴파일이 이루어짐.
	</pre>
	

	<%@ include file="ex1.jsp" %>
	
	
	<%-- <% String year = "2021"; %> --%>
	<!-- Duplicate local variable year
		변수명 중복 에러 발생
		
		정적 include
		장점 : 컴파일 단계에서 하나로 합쳐지기 때문에
		     추후 해당 페이지 호출 시  속도적 우위가 있음.
		     
     	단점 : 부모, 자식 페이지간 변수명 중복이 발생하기 때문에
     	      여러 변수명을 지정하게 되서 코드 간결화, 유지보수성이 나빠짐.
	 -->





</body>
</html>



