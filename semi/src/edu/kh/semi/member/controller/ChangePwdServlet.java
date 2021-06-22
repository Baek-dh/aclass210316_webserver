package edu.kh.semi.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.semi.member.model.service.MemberService;
import edu.kh.semi.member.model.vo.Member;

@WebServlet("/member/changePwd")
public class ChangePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 비밀번호 변경 화면으로 요청 위임
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//request.getRequestDispatcher("/WEB-INF/views/member/changePwd.jsp").forward(request, response);
		
		RequestDispatcher view
			= request.getRequestDispatcher("/WEB-INF/views/member/changePwd.jsp");
		
		view.forward(request, response);
	
	}

	
	// DB에 저장된 비밀번호를 변경하고 결과에 따른 화면 제어
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 인코딩 필터가 있으니까 post 문자 인코딩 변경은 신경쓰지 않아도 된다
		
		// 파라미터로 전달 받은 암호화된 비밀번호를 변수에 저장
		String currentPwd = request.getParameter("currentPwd");
		String newPwd1 = request.getParameter("newPwd1");
		
		// session에서 회원 번호 얻어오기
		HttpSession session = request.getSession();
		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		
		try {
			int result = new MemberService().changePwd(currentPwd, newPwd1, memberNo);
			
			// 1) 비밀번호 변경 결과에 따라 sweetalert로 내보낼 메세지 제어
			String icon = null;
			String title = null;
			String text = null;
			
			
			if(result > 0) {  
				icon = "success";
				title = "비밀번호 변경 성공";
				text = "비밀번호가 변경 되었습니다.";
				
			}else { 
				icon = "error";
				title = "비밀번호 변경 실패 실패";
				text = "비밀번호가 변경 중 문제가 발생했습니다.";
			}
			
			
			// 2) 메세지들을 Session에 추가
			session.setAttribute("icon", icon);
			session.setAttribute("title", title);
			session.setAttribute("text", text);
			
			// 3) 마이페이지 재요청
			response.sendRedirect("myPage");
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("errorMsg", "비밀 번호 변경 과정에서 오류 발생");
			
			RequestDispatcher view 
				= request.getRequestDispatcher("/WEB-INF/views/common/error.jsp");
			
			view.forward(request, response);
		}
		
		
		
		
	}

	
	
	
}
