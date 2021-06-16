<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 배포된 웹 애플리케이션의 최상위 주소를 간단히 얻어올 수 있도록 
     application 범위로 변수를 하나 생성 --%>
<c:set var="contextPath" scope="application"
	   value="${pageContext.servletContext.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Semi Project</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

<!-- Bootstrap core JS -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
 

<style>
body {
	padding-top: 56px;
}
</style>

</head>

<body>


	<!-- Navigation으로 된 header -->
	<div class="header navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
		
			<!-- 메인페이지 이동 로고 -->
			<a class="navbar-brand" href="${contextPath}">Semi Project</a>
			
			
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="#">Notice</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Board</a></li>

					<%-- 로그인 버튼 --%>
					<%-- Modal 동작 버튼은 data-toggle="modal" 속성과 href 속성값으로 보여질 Modal 영역 id를 작성하면된다. --%>
					<li class="nav-item active"><a class="nav-link" data-toggle="modal" href="#modal-container-1">Login</a></li>

				</ul>
			</div>
		</div>
	</div>


	<%-- Modal창에 해당하는 html 코드는 페이지 마지막에 작성하는게 좋다 --%>
	<div class="modal fade" id="modal-container-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">

			<div class="modal-content">

				<div class="modal-header">
					<h5 class="modal-title" id="myModalLabel">로그인 모달창</h5>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
				</div>

				<div class="modal-body">
					<form class="form-signin" method="POST" action="${contextPath}/member/login" onsubmit="return loginValidate();">

						<input type="text" class="form-control" id="memberId" name="memberId" placeholder="아이디" value="">
						<br>
						<input type="password" class="form-control" id="memberPw" name="memberPw" placeholder="비밀번호">
						<br>

						<div class="checkbox mb-3">
							<label> 
								<input type="checkbox" name="save" id="save"> 아이디 저장
							</label>
						</div>

						<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
						
						
						<a class="btn btn-lg btn-secondary btn-block" href="#">회원가입</a>
					</form>
				</div>
				
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>


</body>

</html>
