<%@page import="edu.kh.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	Member loginMember = (Member)request.getAttribute("loginMember");
%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>로그인 결과 화면</title>
</head>
<body>
	
	<% if(loginMember != null){ %>
		<h1>로그인 성공</h1>

		<ul>
			<li> 입력한 아이디 : ${param.memberId }</li>
			<li> 입력한 비밀번호 : ${param.memberPw }</li>
		</ul>
		
		<ul>
			<li> 회원 번호 : ${loginMember.memNo }</li>
			<li> 아이디 : ${loginMember.memId }</li>
			<li> 이름 : ${loginMember.memNm }</li>
			<li> 전화번호 : ${loginMember.memPhone }</li>
			<li> 성별 : ${loginMember.memGender }</li>
			<li> 전화번호 : ${loginMember.joinDate }</li>
		</ul>


	<% } else {%>
		<h1>아이디 또는 비밀번호가 일치하지 않습니다.</h1>
	
	<% } %>
	
	
</body>
</html>