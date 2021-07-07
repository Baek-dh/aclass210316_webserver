<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- fmt 태그 : 문자열, 날짜, 숫자의 형식(모양)을 지정하는 태그 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
<style>
	#board-area{ min-height: 700px;  margin-bottom: 100px;}
	#board-content{ padding-bottom:150px;}

	.boardImgArea{
		height: 300px;
	}

	.boardImg{
		width : 100%;
		height: 100%;
		border : 1px solid #ced4da;
		position : relative;
		
	}
	
	.replyWrite > table{
		width: 90%;
		align: center;
	}
	
	#replyContentArea{ width: 90%; }
	
	#replyContentArea > textarea{
	    resize: none;
    	width: 100%;
	}
	
	#replyBtnArea{
	    width: 100px;
	    text-align: center;
	}
	
	.rWriter{ margin-right: 30px;}
	.rDate{
		font-size: 0.7em;
		color : gray;
	}
	
	#replyListArea{
		list-style-type: none;
	}
	
	.board-dateArea{
		font-size: 14px;
	}
	
	
	.boardImg {
		width: 200px;
		height: 200px;
		
	}
	.thubnail{
		width: 300px;
		height: 300px;
	}
	
	.boardImg > img{
		max-width : 100%;
		max-height : 100%;
		position: absolute;
		top: 0;
		bottom : 0;
		left : 0;
		right : 0;
		margin : auto;
	}
</style>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div class="container  my-5">

		<div>

			<div id="board-area">

				<!-- Category -->
				<h6 class="mt-4">카테고리 : [ ${board.categoryName } ]</h6>
				
				<!-- Title -->
				<h3 class="mt-4"> ${board.boardTitle } </h3>

				<!-- Writer -->
				<p class="lead">
					작성자 : ${board.memberName }
				</p>

				<hr>

				<!-- Date -->
				<p>
					<span class="board-dateArea">
						작성일  : <fmt:formatDate value="${board.createDate }" pattern="yyyy년 MM월 dd일 HH:mm:ss"/>                     
						<br>
						마지막 수정일  : <fmt:formatDate value="${board.modifyDate }" pattern="yyyy년 MM월 dd일 HH:mm:ss"/>
					</span>
			 		<span class="float-right">조회수 ${board.readCount }</span>
				</p>

				<hr>
				
					<!-- 이미지 출력 -->
					<c:forEach items="${board.atList}" var="at">
						<c:choose>
							<c:when test="${at.fileLevel == 0 && !empty at.fileName}">
								<c:set var="img0" value="${contextPath}/${at.filePath}${at.fileName}"/>
							</c:when>
							<c:when test="${at.fileLevel == 1 && !empty at.fileName}">
								<c:set var="img1" value="${contextPath}/${at.filePath}${at.fileName}"/>
							</c:when>
							<c:when test="${at.fileLevel == 2 && !empty at.fileName}">
								<c:set var="img2" value="${contextPath}/${at.filePath}${at.fileName}"/>
							</c:when>
							<c:when test="${at.fileLevel == 3 && !empty at.fileName}">
								<c:set var="img3" value="${contextPath}/${at.filePath}${at.fileName}"/>
							</c:when>
						</c:choose>
					</c:forEach>
					
					
					<div class="form-inline mb-2">
						<label class="input-group-addon mr-3 insert-label">썸네일</label>
						<div class="boardImg thubnail" id="titleImgArea">
							
							<!-- img0 변수가 만들어진 경우 -->
							<c:if test="${!empty img0 }"> 
								<img id="titleImg" src="${img0}">
							</c:if>
								
						</div>
					</div>
	
					<div class="form-inline mb-2">
						<label class="input-group-addon mr-3 insert-label">업로드<br>이미지</label>
						<div class="mr-2 boardImg" id="contentImgArea1">
							<c:if test="${!empty img1 }"> 
								<img id="contentImg1" src="${img1}">
							</c:if>
						</div>
	
						<div class="mr-2 boardImg" id="contentImgArea2">
							<c:if test="${!empty img2 }"> 
								<img id="contentImg2" src="${img2}">
							</c:if>
						</div>
	
						<div class="mr-2 boardImg" id="contentImgArea3">
							<c:if test="${!empty img3 }"> 
								<img id="contentImg3" src="${img3}">
							</c:if>
						</div>
					</div>
				
				
				<hr>				

				<!-- Content -->
				<div id="board-content">${board.boardContent }</div>
				

				<hr>
				 
				
				<div>
					
					<%-- 로그인된 회원과 해당 글 작성자가 같은 경우에만 버튼 노출--%>
					<c:if test="${loginMember.memberNo == board.memberNo }">
						<button id="deleteBtn" class="btn btn-primary float-right mr-2">삭제</button> 
						<button id="updateBtn" class="btn btn-primary float-right mr-2" onclick="fnRequest('updateForm');">수정</button> 
					</c:if>
					
					
					<%-- 검색 상태 유지를 위한 쿼리스트링용 변수 선언 --%>
					<c:if test="${!empty param.sk && !empty param.sv }">
						<%-- 검색은  게시글 목록 조회에 단순히 sk, sv 파라미터를 추가한 것
								-> 목록 조회 결과 화면을 만들기 위해 boardList.jsp로 요청 위임 되기 때문에
									 request객체가 유지되고, 파라미터도 유지된다.
						--%>
						
						<c:set var="searchStr" 
							value="&sk=${param.sk}&sv=${param.sv}"  />
					</c:if>
					
					
					<a href="list?type=${param.type}&cp=${param.cp}${searchStr}" class="btn btn-primary float-right mr-2">목록으로</a>
				</div>
				
				<%-- 댓글 영역 --%>
				<jsp:include page="reply.jsp"></jsp:include>
				
			</div>



		</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	
	
	<form action="#" method="POST" name="requestForm">
		<input type="hidden" name="boardNo" value="${board.boardNo}">
		<input type="hidden" name="cp" value="${param.cp}">
		<input type="hidden" name="type" value="${param.type}">
	</form>
	
	
	<script>
		function fnRequest(addr){
			
			// 현재 문서 내부에 name속성 값이 requestForm인 요소의 action 속성 값을 변경
			document.requestForm.action = "../board2/" + addr;
			
			// 현재 문서 내부에 name속성 값이 requestForm인 요소를 제출해라
			document.requestForm.submit();
			
		}
		
	</script>
	
	
	
</body>
</html>
