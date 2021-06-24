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

@WebServlet("/member/secession")

public class SecessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 회원 탈퇴 화면으로 요청 위임
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// secession.jsp로 요청 위임 한 줄로 작성
		request.getRequestDispatcher("/WEB-INF/views/member/secession.jsp").forward(request, response);

	}

	// 회원 탈퇴 서비스 수행
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String currentPwd = request.getParameter("currentPwd");

		HttpSession session = request.getSession();
		int memberNo = ((Member) session.getAttribute("loginMember")).getMemberNo();

		try {
			int result = new MemberService().secession(currentPwd, memberNo);

			
			// 탈퇴 성공 시 -> 메인 페이지로 이동
			// 실패 시 -> 회원 탈퇴 페이지로 이동
			String path = null;
			String icon = null;
			String title = null;
			String text = null;

			if (result > 0) { // 성공
				icon = "success";
				title = "회원 탈퇴 성공";
				text = "이용해 주셔서 감사합니다.";

				path = request.getContextPath(); // 메인 페이지 요청 주소
				session.invalidate(); // 세션 무효화 (로그아웃 시키기)
				
			} else { // 실패
				icon = "error";
				title = "회원 탈퇴 실패";
				text = "비밀번호가 일치하지 않습니다.";
				
				path = "secession"; // 회원 탈퇴 페이지 요청 주소
			}

			// - 탈퇴 성공 시 이전에 얻어온 세션이 무효화 되기 때문에
			// 		새롭게 세션을 얻어옴
			// - 탈퇴 실패 시 이전 세션을 그대로 얻어옴
			session = request.getSession();
			
			session.setAttribute("icon", icon);
			session.setAttribute("title", title);
			session.setAttribute("text", text);

			response.sendRedirect(path);

		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("errorMsg", "회원 탈퇴 과정에서 오류 발생");
			
			RequestDispatcher view 
				= request.getRequestDispatcher("/WEB-INF/views/common/error.jsp");
			
			view.forward(request, response);
		}

	}

}
