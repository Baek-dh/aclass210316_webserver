<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>요청된 주소를 찾을 수 없습니다.</title>
</head>
<body>
	<h1>404 Not Found</h1>
	<h3>요청한 주소가 잘못 되었거나 존재하지 않습니다.</h3>
	<button type="button" onclick="history.back();">이전 페이지로 이동</button>
	<button type="button" 
		onclick="location.href='<%= request.getContextPath() %>';">메인 페이지로 이동</button>
		
	<!--  request.getContextPath() : 현재 주소 중 제일 앞에 작성된 경로
			(비슷한 말로 rootContext가 있음)
	 -->
	
</body>
</html>



