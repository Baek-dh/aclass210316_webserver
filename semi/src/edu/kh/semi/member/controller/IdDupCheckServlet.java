package edu.kh.semi.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.semi.member.model.service.MemberService;

@WebServlet("/member/idDupCheck")
public class IdDupCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 아이디 중복 검사 팝업창으로 요청 위임
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view 
			= request.getRequestDispatcher("/WEB-INF/views/member/idDupCheck.jsp");	
				
		view.forward(request, response);
		
	}
	
	// DB에 같은 아이디가 있는지 중복 검사 후 결과 반환
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// POST 방식 전달됨 -> 문자 인코딩을 UTF-8로 변환
		// request.setCharacterEncoding("UTF-8");
		// -> 필터가 적용되면 필요없음
		
		String id = request.getParameter("id");
		
		// ajax를 이용하여 비동기로 중복 검사
		try {
			// DB에서 아이디 중복 검사 수행 후 결과를 반환 받아 저장
			int result = new MemberService().idDupCheck(id);
			
			// ajax는 화면 전체가 아닌 
			// 화면 일부 갱신에 사용되는 데이터만 응답으로 내보낸다.
			
			// 응답을 받을 클라이언트와의 연결 스트림
			PrintWriter out = response.getWriter();
			out.print(result);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		// 팝업창으로 중복 검사
		/*try {
			
			// DB에서 아이디 중복 검사 수행 후 결과를 반환 받아 저장
			int result = new MemberService().idDupCheck(id);
			
			//System.out.println(result);
			
			
			// redirect 시 데이터가 유지될 수 있도록 Session 사용
			HttpSession session = request.getSession();
			
			session.setAttribute("result", result);
			session.setAttribute("id", id);
			
			
			// get방식으로 /member/idDupCheck 주소를 재요청
			response.sendRedirect("idDupCheck");
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("errorMsg", "아이디 중복 검사 과정에서 문제가 발생했습니다.");
			
			RequestDispatcher view 
				= request.getRequestDispatcher("/WEB-INF/views/common/error.jsp");
			
			view.forward(request, response);
		}
		*/
		
		
		
	}

	
	
	
	
}
