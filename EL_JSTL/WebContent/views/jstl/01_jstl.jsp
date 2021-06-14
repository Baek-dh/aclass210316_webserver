<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>01_JSTL 기초</title>
</head>
<body>

	<h1>JSTL이란?</h1>
	<pre>
		Jsp Standard Tag Library의 약자로
		JSP에서 사용하는 커스텀 태그이다.
		
		JSP에서 공통적으로 사용하는 코드를 
		사용하기 쉽게 태그화하여 표준으로 제공함.
		(변수 선언, if, for, parsing 등등)
	</pre>

	<h3>라이브러리 등록 방법</h3>
	1) https://tomcat.apache.org/download-taglibs.cgi 접속<br>
	2) Standard-1.2.5 -> jar files -> 3개(compat 빼고) 다운로드<br>
	3) WebContent/WEB-INF/lib 에 추가<br>
	
	<hr>
	
	<h2>JSTL 선언 방법</h2>
	<pre>
		JSTL을 사용 하고자하는 JSP 페이지가 있을 경우
		JSP 상단에 JSTL 라이브러리를 추가하는 taglib 지시자를 추가해야함.
	
		&lt;%@ taglib prefix="사용하고자 하는 접두사" uri="tld 파일상의 uri"  %> 
		
		prefix : 접두사. 다른 태그와 구별할 수 있는 namespace를 제공함.
		uri : 실제 웹상주소가 아니라, 태그라이브러리를 나타내는 식별자임. 
			tld파일상의 uri값을 가리키며,
			이 지시자를 통해 작성한 태그이름과 매칭되는 자바코드를 찾음. <br>

		* tld(Tag Library Descriptor) 파일 : 커스텀 태그 정보를 갖고 있는 라이브러리 파일.
		* uri : (Uniform Resource Identifier) : 자원을 나타내는 유일한 주소
	</pre>
	
	
	<hr>
	
	
	<h3>JSTL Core Library</h3>
	<pre>
		변수 선언, url 저장, 조건문, 반복문 등과 같이
		기본적인 문법 + 로직 관련 문법을 제공하는 태그
	</pre>
	
	<h4> 1. 변수 선언  -   &lt;c:set>      </h4>
	<pre>
		- 변수를 선언하고 초기값을 대입하는 기능을 가진 태그
		- 초기값을 무조건 작성해야 한다.
		- c:set 태그를 이용하여 선언된 변수는
		   EL식 안에서 사용할 수 있다. (스크립틀릿은 안됨)
		   
		- 특징 1 : 별도의 변수 타입을 선언하지 않는다.
		- 특징 2 : 변수 선언 시 scope를 지정할 수 있다.
				(page, request, session, application)
	</pre>
	
	<c:set var="num1" value="100" /> 
	<c:set var="num2" value="200" /> 
	
	num1 = ${num1} <br>
	num2 = ${num2} <br>
	
	<!-- EL을 이용해서 연산을 하는 경우 하나의 EL식 내부에 작성한다. -->
	num1 + num2 = ${num1 + num2} <br>
	
	
	result = num1 * num2; <br>
	<!-- EL, JSTL 혼합 시 EL이 먼저 해석된다 -->
	<c:set var="result" value="${num1 * num2}" />
	<!-- c:set 선언 시 scope를 지정하지 않으면 page scope다. -->
	
	
	result :  ${result}    <br>
	
	<!-- 변수명, scope가 같으면 덮어쓰기됨 -->
	<c:set var="result" value="${num2 / num1}" scope="session" />
	
	result : ${result } <br>
	session에 있는 result : ${sessionScope.result } <br>
	
	<hr>
	
	<h4> 2. 변수의 삭제 - &lt;c:remove> </h4>
	<pre>
		지정한 변수를 특정 또는 모든 scope에서 삭제하는 태그	
	</pre>
	
	1) session scope에 있는 result를 삭제 <br>
	<c:remove var="result" scope="session" />
	삭제 결과 (session) : ${sessionScope.result}  <br>
	삭제 결과 (page) :    ${result}  <br><br>
	
	2) 모든 scope에 있는 result 삭제<br>
	<c:set var="result" value="10" scope="request"/>
	<c:set var="result" value="100" scope="application"/>
	
	page scope : ${pageScope.result }<br>
	request scope : ${requestScope.result }<br>
	application scope : ${applicationScope.result }<br>
	
	<h5>모든 scope에서 result 삭제 후</h5>
	<c:remove var="result"/>
	page scope : ${pageScope.result }<br>
	request scope : ${requestScope.result }<br>
	application scope : ${applicationScope.result }<br>
	

	<hr>
	
	<h4>3. 조건문 - &lt;c:if> </h4>
	<pre>
		if문에 사용할 조건을 test라는 속성의 값으로 EL식 형태로 작성함.
		별도의 else 구문이 존재하지 않음.
	</pre>
	
	<c:set var="n1" value="10"/>
	<c:set var="n2" value="1"/>
	
	<c:if test="${n1 > n2 }">
		${n1}은 ${n2}보다 크다.
	</c:if>
	
	<!-- else가 별도로 없기 때문에 if로 else 조건을 작성 -->
	<c:if test="${n1 <= n2 }">
		${n1}은 ${n2}보다 작거나 같다.
	</c:if>
	
	
	<hr>
	
	<h4> 4. 조건문 - &lt;c:choose>  </h4>
	<pre>
		-if else-if else와 비슷한 구문
		- c:when 태그  == if,  else-if와 같은 태그
		- c:otherwise 태그 == else와 같은 태그
	</pre>
	
	<c:choose>
		<%-- 파라미터로 넘겨져온 값이 10보다 큰 경우 --%>
		<c:when test="${param.test > 10}">
			${param.test}는 10보다 크다.
		</c:when>
		
		<c:when test="${param.test > 0}">
			${param.test}는 10보다 작거나 같고, 0보다 크다.
		</c:when>
		
		<c:otherwise>
			${param.test}는 0보다 작거나 같다.
		</c:otherwise>
	
	</c:choose>
	
	<!-- 주소창에 
		http://localhost:8080/EL_JSTL/views/jstl/01_jstl.jsp?test=-3
		위와 같은 주소 작성 시 
		마지막 ? 뒤에 작성되는 값이 GET 방식 요청으로 전달되는 파라미터이다.
		이러한 파라미터가 작성된 문자열을 "쿼리스트링(QueryString)"이라고 한다.
	 -->
	
	







</body>
</html>