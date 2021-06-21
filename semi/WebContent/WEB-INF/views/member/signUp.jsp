<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	/* number 태그 화살표 제거 */
	input[type="number"]::-webkit-outer-spin-button, input[type="number"]::-webkit-inner-spin-button
		{
		-webkit-appearance: none;
		margin: 0;
	}
</style>

</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container">
		<!-- 
			상대경로에서 사용하는 기호
			(빈칸) : 현재 폴더
			/     : 하위 폴더
			../   : 상위 폴더
		 -->

		<div class="py-5 text-center">
			<h2>회원 가입</h2>
		</div>

		<div class="row">
			<div class="col-md-6 offset-md-3">

				<form method="POST" action="signUp" class="needs-validation" name="signUpForm" onsubmit="return validate();">
					<%-- action="${contextPath}/member/signUp" --%>

					<!-- 아이디 -->
					<div class="row mb-5 form-row">
						<div class="col-md-3">
							<label for="id">* 아이디</label>
						</div>
						<div class="col-md-6">
							<input type="text" class="form-control" name="id" id="id" maxlength="12" placeholder="아이디를 입력하세요" autocomplete="off" required>
							<!-- required : 필수 입력 항목으로 지정 -->
							<!-- autocomplete="off" : input 태그 자동완성 기능을 끔 -->

							<!-- 팝업창 중복체크 여부 판단을 위한 hidden 타입 요소 -->
							<input type="hidden" name="idDup" id="idDup" value="false">
						</div>

						<!-- ajax 중복검사 시 필요없음 -->
						<div class="col-md-3">
			                <button type="button" class="btn btn-primary" id="idDupCheck">중복검사</button>
			            </div>

						<div class="col-md-6 offset-md-3">
							<span id="checkId">&nbsp;</span>
						</div>
					</div>


					<!-- 비밀번호 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="pwd1">* 비밀번호</label>
						</div>
						<div class="col-md-6">
							<input type="password" class="form-control" id="pwd1" name="pwd1" maxlength="20" placeholder="비밀번호를 입력하세요" required>
						</div>

						<div class="col-md-6 offset-md-3">
							<span id="checkPwd1">&nbsp;</span>
						</div>
					</div>

					<!-- 비밀번호 확인 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="pwd2">* 비밀번호 확인</label>
						</div>
						<div class="col-md-6">
							<input type="password" class="form-control" id="pwd2" maxlength="20" placeholder="비밀번호 확인" required>
						</div>

						<div class="col-md-6 offset-md-3">
							<span id="checkPwd2">&nbsp;</span>
						</div>
					</div>
					<br>

					<!-- 이름 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="name">* 이름</label>
						</div>
						<div class="col-md-6">
							<input type="text" class="form-control" id="name" name="name" required>
						</div>

						<div class="col-md-6 offset-md-3">
							<span id="checkName">&nbsp;</span>
						</div>
					</div>

					<!-- 전화번호 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="phone1">* 전화번호</label>
						</div>
						<!-- 전화번호1 -->
						<div class="col-md-3">
							<select class="custom-select" id="phone1" name="phone" required>
								<option>010</option>
								<option>011</option>
								<option>016</option>
								<option>017</option>
								<option>019</option>
							</select>
						</div>

						<!-- number타입의 input태그에는 maxlength를 설정할 수 없음 -->
						<!-- 전화번호2 -->
						<div class="col-md-3">
							<input type="number" class="form-control phone" id="phone2" name="phone" required>
						</div>

						<!-- 전화번호3 -->
						<div class="col-md-3">
							<input type="number" class="form-control phone" id="phone3" name="phone" required>
						</div>

						<div class="col-md-6 offset-md-3">
							<span id="checkPhone">&nbsp;</span>
						</div>
					</div>

					<!-- 이메일 -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="email">* Email</label>
						</div>
						<div class="col-md-6">
							<input type="email" class="form-control" id="email" name="email" autocomplete="off" required>
						</div>

						<div class="col-md-6 offset-md-3">
							<span id="checkEmail">&nbsp;</span>
						</div>
					</div>
					<br>

					<!-- 주소 -->
					<!-- 오픈소스 도로명 주소 API -->
					<!-- https://www.poesis.org/postcodify/ -->
					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="postcodify_search_button">우편번호</label>
						</div>
						<div class="col-md-3">
							<input type="text" name="address" class="form-control postcodify_postcode5">
						</div>
						<div class="col-md-3">
							<button type="button" class="btn btn-primary" id="postcodify_search_button">검색</button>
						</div>
					</div>

					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="address1">도로명 주소</label>
						</div>
						<div class="col-md-9">
							<input type="text" class="form-control postcodify_address" name="address" id="address1">
						</div>
					</div>

					<div class="row mb-3 form-row">
						<div class="col-md-3">
							<label for="address2">상세주소</label>
						</div>
						<div class="col-md-9">
							<input type="text" class="form-control postcodify_details" name="address" id="address2">
						</div>
					</div>


					<hr class="mb-4">
					<button class="btn btn-primary btn-lg btn-block" type="submit">가입하기</button>
				</form>
			</div>
		</div>
		<br>
		<br>

		<!-- 오픈소스 도로명 주소 검색 API -->
		<!-- https://www.poesis.org/postcodify/ -->
		<!-- postcodify 라이브러리를 CDN 방식으로 추가. -->
		<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
		<script>
			// 검색 단추를 누르면 팝업 레이어가 열리도록 설정한다.
			$(function () {
				$("#postcodify_search_button").postcodifyPopUp();
			});
		</script>
		
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	
	
	<script src="${contextPath}/resources/js/member.js"></script>
	
	
	<script>
		// 아이디 중복 검사용 팝업창 오픈
		$("#idDupCheck").on("click", function(){
			// window.open("주소/경로", "창 이름", "스타일 설정");
			window.open("idDupCheck", "idDupForm", "width=450, height=250");
			// 절대 경로 : ${contextPath}/member/idDupCheck
			// 상대 경로 : idDupCheck
		});
		
	</script>
	
	
</body>
</html>







