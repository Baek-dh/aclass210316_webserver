package edu.kh.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
		String save = request.getParameter("save");
		
		// checkbox를 체크했을 때/안했을 때 넘어오는 값 확인
		//System.out.println("save : " + save);
		// 결과 : 체크하면 "on", 안하면 null
		
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
				
				// 일정 시간 후 세션 만료
				// 30분 후 세션 만료
				session.setMaxInactiveInterval(1800); // 초 단위로 작성
				
				
				// ****************************** //
				// javax.servlet.http.Cookie 를 이용한 아이디 저장
				
				/* Cookie란?
				 * 
				 * 파일의 형태로 브라우저에서 관리하는 자원.
				 * 
				 * Session의 저장된 정보는 Server에서 관리함.
				 * Cookie의 저장된 정보는 Client에서 관리함.
				 * 
				 * Cookie의 생성은 Server쪽에서 수행해 
				 * 응답(response)에 담아서 Client로 전달함
				 * */
				
				
				// 1) Cookie 객체 생성
				Cookie cookie = new Cookie("saveId", memberId);
				
				// 2) 아이디 저장이 체크된 경우
				if(save != null) {
					// 쿠키는 반드시 만료 기간을 설정해야 한다.
					cookie.setMaxAge(60 * 60 * 24 * 7); // 초 단위
					// 일주일
					
				} else {
					// 3) 아이디 저장이 체크되지 않은 경우
					// -> 아이디가 저장된 쿠키 제거
					cookie.setMaxAge(0); // 만료 기간 0초 == 쿠키 제거
				}
				
				
				
				
			}else { // 로그인 실패
				
				session.setAttribute("icon", "error"); // success, warning, error, info
				session.setAttribute("title", "로그인 실패");
				session.setAttribute("text", "아이디 또는 비밀번호가 일치하지 않습니다.");
				// session에 로그인 실패 메세지를 담는 이유
				// -> redirect 시 request는 폐기 되기 때문에
				//    request보다 범위가 넓은 session에 담아서 내용을 유지하기 위함
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
