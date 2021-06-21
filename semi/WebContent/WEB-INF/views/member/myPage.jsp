<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%-- fn 태그 : JSTL에서 문자열과 관련된 메소드를 제공하는 태그
	(주의) 이름은 태그인데 사용은 EL식 내부에서만 사용할 수 있다!!
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내정보</title>
<style>
	input[type="number"]::-webkit-outer-spin-button, 
	input[type="number"]::-webkit-inner-spin-button
		{
		-webkit-appearance: none;
		margin: 0;
	}
</style>
</head>
<body>
	<div class="container">
		<jsp:include page="../common/header.jsp"></jsp:include>
		
		<%-- 
			${fn:split(문자열, 구분자)}  :    
				문자열을 지정한 구분자로 나누어 배열로 반환
		--%>
		<c:set var="phone"  
			   value="${fn:split( loginMember.memberPhone, '-' ) }"/>
		
		
		<c:set var="addr" 
			   value="${fn:split( loginMember.memberAddress, ',' ) }"/>


		<div class="row my-5">
			<jsp:include page="sideMenu.jsp"></jsp:include>		
				
			<div class="col-sm-8">
				<h3>My Page</h3>
				<hr>
				<div class="bg-white rounded shadow-sm container p-3">
					<form method="POST" action="update" onsubmit="return memberUpdateValidate();" class="form-horizontal" role="form">
						<!-- 아이디 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>아이디</h6>
							</div>
							<div class="col-md-6">
								<h5 id="id"> ${loginMember.memberId} </h5>
							</div>
						</div>
	
						<!-- 이름 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<h6>이름</h6>
							</div>
							<div class="col-md-6">
								<h5 id="name"> ${loginMember.memberName } </h5>
							</div>
						</div>
	
						<!-- 전화번호 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<label for="phone1">전화번호</label>
							</div>
							<!-- 전화번호1 -->
							<div class="col-md-3">
								<select class="custom-select" id="phone1" name="phone">
									<option>010</option>
									<option>011</option>
									<option>016</option>
									<option>017</option>
									<option>019</option>
								</select>
							</div>
							
	
							<!-- 전화번호2 -->
							<div class="col-md-3">
								<input type="number" class="form-control phone" id="phone2" name="phone" value="${phone[1]}">
							</div>
	
							<!-- 전화번호3 -->
							<div class="col-md-3">
								<input type="number" class="form-control phone" id="phone3" name="phone" value="${phone[2]}">
							</div>
						</div>
	
						<!-- 이메일 -->
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<label for="memberEmail">Email</label>
							</div>
							<div class="col-md-6">
								<input type="email" class="form-control" id="email" name="email" value="${loginMember.memberEmail }">
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
								<input type="text" name="address" class="form-control postcodify_postcode5" value="${addr[0]}">
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
								<input type="text" class="form-control postcodify_address" name="address" id="address1"  value="${addr[1]}">
							</div>
						</div>
	
						<div class="row mb-3 form-row">
							<div class="col-md-3">
								<label for="address2">상세주소</label>
							</div>
							<div class="col-md-9">
								<input type="text" class="form-control postcodify_details" name="address" id="address2"  value="${addr[2]}">
							</div>
						</div>
	
						<hr class="mb-4">
						<button class="btn btn-primary btn-lg btn-block" type="submit">수정</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<br><br>
	
	<jsp:include page="../common/footer.jsp"></jsp:include>
		
		
		
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
	
	
	
	<script>
	
		//  (function(){  })()
		// 즉시 실행 함수 : 함수가 정의 되자 마자 실행되는 함수.
		// 변수명 중복 해결 + 속도적 측면에서 우위를 가짐.
		
		// 전화번호 첫 번째 자리 지정하기
		(function(){
			// 전화번호 앞자리가 적힌 option 요소를 배열로 얻어옴
			// each( function(index, item){ }  : 배열을 반복 접근하는 jQuery 메소드
			// index : 현재 접근한 인덱스 번호
			// item : 현재 접근한 요소
			$("#phone1 > option").each( function(index, item){ 
				//console.log( $(item).text()  );
				
				// 요소에 작성된 내용이 phone[0]의 값과 같다면
				if( $(item).text() == "${phone[0]}"){
					
					// 현재 요소에 seleted 속성을 추가
					$(item).prop("selected", true);
				}
				
			});
			//console.log("${phone[0]}");
		})();
	
	
		// 회원 정보 수정 시 유효성 검사
		function memberUpdateValidate(){
		    const regExp1 = /^[0-9]{3,4}$/; // 숫자 3~4글자
		    const regExp2 = /^[0-9]{4}$/; // 숫자 4글자

		    const ph2 = $("#phone2").val();
		    const ph3 = $("#phone3").val();

		    if( !regExp1.test(ph2)  || !regExp2.test(ph3)  ){
		    	swal({ "icon"  : "warning",
		    		   "title" : "전화번호가 유효하지 않습니다."  ,
		    		   "text"  : "중간 자리는 3~4, 마지막 자리는 4글자로 작성해주세요." });
		    	
		    	return false;
		    }
		    
		    
		    
		    // 이메일 유효성 검사
		    const regExp = /^[\w]{4,}@[\w]+(\.[\w]+){1,3}$/;

		    const inputEmail = $("#email").val().trim();

		    if( !regExp.test(inputEmail) ){
		    	swal({ "icon"  : "warning",
		    		   "title" : "이메일이 유효하지 않습니다."  ,
		    		   "text"  : "아이디 4글자 이상의 이메일 형식으로 작성해주세요." });
		    	
		    	return false;
		    }
		    
		}
			
	</script>
	
	
</body>
</html>




