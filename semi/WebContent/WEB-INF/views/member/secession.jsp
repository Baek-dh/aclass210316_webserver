<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
</head>
<style>
#content-main {
	height: 830px;
}
</style>
<body>
	<div class="container" id="content-main">
		<jsp:include page="../common/header.jsp"></jsp:include>

		<div class="row my-5">
			<jsp:include page="sideMenu.jsp"></jsp:include>

			<div class="col-sm-offset-2 col-sm-8">
				<h3>회원 탈퇴</h3>
				<div class="bg-white rounded shadow-sm container p-3">
					<form method="POST" action="secession" onsubmit="return secessionValidate();" 
						class="form-horizontal" role="form">
						<!-- 아이디 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>아이디</h6>
							</div>
							<div class="col-md-6">
								<h5 id="id">${loginMember.memberId }</h5>
							</div>
						</div>

						<!-- 비밀번호 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>비밀번호</h6>
							</div>
							<div class="col-md-6">
								<input type="password" class="form-control" id="currentPwd"
									name="currentPwd">
							</div>
						</div>

						<hr>
						<div class="panel panel-default">

							<div class="panel-body">
								<div class="form-group pull-left">
									<label class="control-label"> 회원 탈퇴 약관 </label>
									<div class="col-xs-12">
										<textarea class="form-control" readonly rows="10" cols="100">
제1조
이 약관은 샘플 약관입니다.

① 약관 내용 1

② 약관 내용 2

③ 약관 내용 3

④ 약관 내용 4


제2조
이 약관은 샘플 약관입니다.

① 약관 내용 1

② 약관 내용 2

③ 약관 내용 3

④ 약관 내용 4
</textarea>
									</div>
									<div class="checkbox pull-right">
										<div class="custom-checkbox">
											<div class="form-check">
												<input type="checkbox" name="agree" id="agree"
													class="form-check-input custom-control-input"> <br>
												<label class="form-check-label custom-control-label"
													for="agree">위 약관에 동의합니다.</label>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<hr class="mb-4">
						<button class="btn btn-primary btn-lg btn-block" id="btn"
							type="submit">탈퇴</button>
					</form>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="../common/footer.jsp"></jsp:include>

	<script>
		// 약관 동의가 체크 되었을 때에만 탈퇴 진행
		function secessionValidate(){
			// script, filter, wrapper, servlet, service, dao, sql
			// 응답화면 제어
			
			// 방법 1) 체크된 체크박스를 선택하는 :checked 선택자 사용 방법
			// $("#agree:checked") -> 아이디가 agree인 요소 중 check된 요소만을 선택
			// 체크된 요소가 있으면 length == 1, 없으면 0
			if( $("#agree:checked").length == 0){
				swal({"icon" : "info", "title" : "약관 동의를 체크해주세요."})
				return false;
			}
			
			
			// 방법 2) jQuery 의 .prop("checked") 메소드를 이용
			// $("#agree").prop("checked") 
			// -> 아이디가 agree인 요소에 체크가 되어있으면 true, 아니면 false
			if( !$("#agree").prop("checked") ){
				swal({"icon" : "info", "title" : "약관 동의를 체크해주세요."})
				return false;
			}
			
			
		}
	</script>
	
	
	
	

</body>
</html>
