package edu.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.member.model.service.MemberService;
import edu.kh.member.model.vo.Member;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");

		MemberService service = new MemberService();

		try {
			Member loginMember = service.login(memberId, memberPw);

			RequestDispatcher view = request.getRequestDispatcher("/views/loginResult.jsp");
			
			request.setAttribute("loginMember", loginMember);
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
