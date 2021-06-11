<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.kh.eljstl.model.vo.Person"%>
    
<% 
	Person p11 = (Person)request.getAttribute("p1");
	int nextAge1 = (int)request.getAttribute("nextAge");
%> 
 
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>EL 예제 결과 페이지</title>
</head>
<body>

	<h3>표현식으로 출력하기</h3>
	p11 : <%= p11 %> <br>
	nextAge1 : <%= nextAge1 %>
	
	<h3>EL로 출력하기</h3>
	<pre>
		스크립틀릿에서 request.getAttribute()로 값을 얻어와 
		변수에 저장 후 표현식으로 출력하는 번거로운 과정 없이
		
		EL을 이용하면 바로 request에 담긴 속성 중 특정 속성 값을 얻어오는게 가능하다
	</pre>
	
	<!-- ${ p1 } : request에 세팅된 속성 중 p1의 값을 출력  -->
	p1 : ${ p1 } <br>
	nextAge : ${ nextAge }
	
	<hr>
	
	<h3>요청 시 전달받은 파라미터 출력하기</h3>
	
	<%
		// 스크립틀릿으로 jsp에서 요청 위임받은 request를 통해 파라미터 얻어오기
		String name = request.getParameter("inputName");
		String age = request.getParameter("inputAge");
		String addr = request.getParameter("inputAddr");
	%>
	<h4>표현식으로  파라미터 출력</h4>
	이름 : <%= name %> <br>
	나이 : <%= age %> <br>
	주소 : <%= addr %> <br>
	
	<h4>EL로 파라미터 출력</h4>
	이름 : ${ param.inputName }  <br>
	<%-- ${ param.inputName } : 
		request에 있는 전달 받은 파라미터 중 inputName의 값을 출력
		--%>
	
	나이 : ${ param.inputAge }  <br>
	주소 : ${ param.inputAddr } <br>
	
	<!-- 
		파라미터(Parameter) : 클라이언트가 요청할 때 전달한 값
		속성 (Attribute) : Servlet에서 가공을 통해 request에 추가한 값
	 -->

	<hr>
	
	<h3> EL을 이용하여 객체 내부 속성값 출력하기 </h3>
	p11에 대입된 이름 : <%= p11.getName()  %>  <br>
	
	p1에 대입된 이름(EL) : ${ p1.name }
	<pre>
		EL을 이용해서 객체 내부 속성값(필드)을 출력하기 위해서는
		\${ 객체명.필드명 } 으로 작성해야 하며
		반드시 객체 내부에 getter가 작성되어 있어야 한다.
	</pre>
	
	
	<hr>
	<h3>session 확인하기</h3>
	
	<pre>
	EL을 이용하여 page, request, session, application 내장객체의 속성을 출력할 때
	
	pageScope, requestScope, sessionScope, applicationScope
	위 단어들을 속성명 앞에 붙여서 객체별 속성을 출력하거나
	
	별도로 작성하지 않는 경우
	page > request > session > application 순서로
	속성명이 일치하는 값을 찾아 출력한다.
	</pre>

	학원 이름 : ${ sessionScope.academy } <br>
	학원 이름 : ${ academy } <br>
	
	<!-- request 범위에 존재하는 nextAge 속성을 출력하는 구문-->
	nextAge : ${ requestScope.nextAge }  <br> 
	
	<h4>내장 객체 범위 테스트</h4>
	
	<%
		// page scope에 속성 추가하기
		pageContext.setAttribute("check", "page 범위 입니다.");
	%>
	
	${check } <br>
	
	request에 있는 check 속성 출력 : ${requestScope.check }  <br>
	session에 있는 check 속성 출력 : ${sessionScope.check }  <br>
	application에 있는 check 속성 출력 :  ${applicationScope.check }   <br>
	
	
	
	<a href="/EL_JSTL/views/el/scope_test.jsp">내장객체 범위 테스트 페이지</a>





</body>
</html>




