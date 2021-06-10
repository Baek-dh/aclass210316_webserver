<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"  %>
   
<%-- isErrorPage="true"  : 현재 페이지는 에러 처리 페이지임을 알림
							true로 작성된 경우 exception객체 사용 가능
 --%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>에러페이지</title>
</head>
<body>
	<h1>에러 발생!!!</h1>
	<h4>발생한 에러 : <%= exception.getClass().getName() %></h4>
	<%=exception %>

</body>
</html>


