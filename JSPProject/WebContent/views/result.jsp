<%@page import="edu.kh.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Member loginMember = (Member)request.getAttribute("loginMember");
	// request.getAttribute("key값") : Object 형태로 key에 일치하는 value 반환
	// -> 알맞은 형태로 다운 캐스팅 후 사용
%>    
    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원 로그인 결과(JDBC)</title>
</head>
<body>
	<!-- 로그인 성공 시 회원 정보를 화면에 출력
		실패 시 "로그인 실패" 구문을 출력하고 이전 페이지로 돌아가는 버튼을 추가
		
		로그인 성공/실패 확인 방법 : loginMemebr 가 null인지, null이 아닌지 확인
	  -->
	  
	<% if(loginMember != null){ %>

		<ul>
			<li>회원 번호 : <%= loginMember.getMemNo() %>  </li>
			<li>아이디 : <%= loginMember.getMemId() %>  </li>
			<li>이름 : <%= loginMember.getMemNm() %>  </li>
			<li>성별 : <%= loginMember.getMemGender() %>  </li>
			<li>전화번호 : <%= loginMember.getMemPhone() %>  </li>
			<li>가입일 : <%= loginMember.getJoinDate() %>  </li>
		</ul>
	
	<% } else { %>
	
		<h3 style="color:red;">로그인 실패</h3>
		<button type="button" onclick="history.back();">이전 페이지로 이동</button>

	<% } %>
</body>
</html>






