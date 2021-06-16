package edu.kh.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.semi.member.model.service.MemberService;
import edu.kh.semi.member.model.vo.Member;

// 로그인 요청 주소 : /semi/member/login
@WebServlet("/member/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. POST 방식 전송 값은 한글이 깨짐 -> 문자 인코딩 변경
		request.setCharacterEncoding("UTF-8");
		
		// 2. 로그인 요청 시 전달 받은 파라미터를 변수에 저장
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		// ** 로그인이란?
		// 아이디와 비밀번호가 일치하는 정보를 DB에서 조회하여 Session에 추가하는 기능
		
		// JAVA <-> DB (JDBC), 서로 다른 프로그램 연결 시 입출력간 오류 발생 확률이 있음.
		// -> 예외 처리
		try {
			
			// 로그인 Service를 위한 MemberService 객체 생성
			MemberService service = new MemberService();
			
			// 로그인 요청을 처리할 수 있는 서비스 메소드를 호출하고 로그인 결과를 반환 받음.
			Member loginMember = service.login(memberId, memberPw);
			
			
			// 세션을 얻어와 변수에 저장
			HttpSession session = request.getSession();
			
			// 서비스 수행 결과에 따른 View 연결 처리
			if(loginMember != null) { // 로그인 성공
				
				// page : 현재 페이지
				// request : 요청받은 Servlet + 요청 위임된 JSP
				// session : 한 브라우저
				// application : 웹앱 전쳉
				
				// session에 로그인 정보 추가
				session.setAttribute("loginMember", loginMember);
				
			}else { // 로그인 실패
				
			}
			
			
			// ****** forward와 redirect ******
			// 1) forward 방식
			//   - 요청을 위임할 때 사용 
			//     -> 하나의 요청이 유지되고 있음. 
			//     -> 위임된 JSP에서도 똑같은 request, response를 사용할 수 있다.
			//   + 특정 경로의 jsp로 화면이 바뀐 것 처럼 보이지만
			//     주소창에 있는 주소는 Servlet 요청 주소를 유지하고 있다.
			//     (forward를 하면 요청 주소가 유지된다!!!)
			
			// 2) redirect 방식
			// - 재요청 뜻함
			//   -> 기존 요청을 폐기하고, 새로운 Servlet 주소를 요청하는 것
			//   -> 기존에 활용되던 request, response를 없애고 새로 생성함
			//   -> 새로운 요청을 하는 것이기 때문에 주소창의 요청 주소가 바뀐다!!
			
			// 로그인을 성공하든, 실패하든 메인페이지로 이동하기
			response.sendRedirect( request.getContextPath()  );
			// request.getContextPath() : 프로젝트 최상위 주소 (/)
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
