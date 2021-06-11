<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>내장객체 범위 테스트</title>
</head>
<body>
	request : ${ nextAge }    <br>
	session : ${ sessionScope.academy }  <br>
	application : ${applicationScope.check }

</body>
</html>



