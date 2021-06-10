<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>include 테스트</title>
</head>
<body>

	<%@ include file="header.jsp" %>

	<hr>
	<pre>
		include 지시자는 외부 페이지를 현재 페이지에 포함시키는 역할을 함.
	</pre>
	<hr>

	<%@ include file="footer.jsp" %>


</body>
</html>







