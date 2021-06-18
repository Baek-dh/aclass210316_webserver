<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 
	WebContent 폴더 : 프로젝트의 웹 배포 시 최상위 폴더(ContextPath, root, contextRoot)
					보통 주소상에서 프로젝트명으로 나타남
					http://localhost:8080/semi/ 이 주소에서
					/semi를 나타냄.
					
					WebContent 하위에 존재하는 폴더/파일은 주소를 이용한 직접 요청이 가능하지만
					WEB-INF 폴더는 직접 요청이 불가능하다.

	WEB-INF 폴더 : 외부(클라이언트)로 부터 직접적인 파일 접근 요청을 차단하는 폴더
				(파일 보호 -> 보안성 상승)
				Servlet을 이용한 간접 접근만 가능함.
 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <style>
      .bg-image-full {
        background: no-repeat center center scroll;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        background-size: cover;
        -o-background-size: cover;
      }

      div.bg-image-full{
        height: 300px;
        text-align: center;
      }

      @font-face { font-family: 'GmarketSansBold'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansBold.woff') format('woff'); font-weight: normal; font-style: normal; }
      div.bg-image-full>h1{
        color : white;
        position: relative;
        top : 75px;
        font-size: 3em;
        font-family: 'GmarketSansBold';
        text-shadow: -2px 0 black, 0 2px black, 2px 0 black, 0 -2px black;
      }
  </style>
</head>
<body>
	
	<!-- header.jsp 동적 include -->
	<jsp:include page="common/header.jsp" />
	
	<!-- 메인 화면 이미지 -->
	<div class="py-5 bg-image-full" style="background-image: url('https://iei.or.kr/resources/images/intro/intro_bg.jpg');">
	    <h1>Servlet/JSP를 이용한<br>Semi Project</h1>
	</div>
	
	<!-- 내용 작성 부분 -->
	<div class="py-5">
	  <div class="container">
	  
	    <h1> ${ sessionScope.loginMember.memberName }  </h1>
	    
	    <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
	    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid, suscipit, rerum quos facilis repellat architecto commodi officia atque nemo facere eum non illo voluptatem quae delectus odit vel itaque amet.</p>
	  </div>
	</div>
	
	<div class="py-5">
	  <div class="container">
	    <h1>Section Heading</h1>
	    <p class="lead">Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
	    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquid, suscipit, rerum quos facilis repellat architecto commodi officia atque nemo facere eum non illo voluptatem quae delectus odit vel itaque amet.</p>
	  </div>
	</div>
	
	
	<!-- footer.jsp 동적 include -->
	<jsp:include page="common/footer.jsp"></jsp:include>
	
</body>
</html>



