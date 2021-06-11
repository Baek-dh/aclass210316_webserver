package com.kh.eljstl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.eljstl.model.vo.Person;

//     /EL_JSTL/el1.do 주소로의 요청을 받아 들이는 servlet
@WebServlet("/el1.do")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get방식으로 전달 받았기 때문에 문자 인코딩 변경 처리 X
		
		// 전달 받은 파라미터를 얻어와 변수에 저장
		String inputName = request.getParameter("inputName");
		String inputAddr = request.getParameter("inputAddr");
		
		//String inputAge = request.getParameter("inputAge");
		int inputAge = Integer.parseInt( request.getParameter("inputAge")  );
		// Integer.parseInt("숫자만 작성된 String") : String -> int 변환
		
		
		Person p1 = new Person(inputName, inputAge, inputAddr);
		int nextAge = inputAge + 1; // 다음 해 나이
		
		
		// * x 100
		// servlet/JSP 내장 객체의 범위(scope)
		// 1. page : 현재 페이지
		// 2. request : 요청을 받은 Servlet + 요청을 위임한 JSP
		// 3. session : 하나의 브라우저당 1개씩 생성. 같은 브라우저 내에서 객체 공유
		// 4. application : 하나의 웹 애플리케이션당 1개씩 생성. 
		//				 	웹 애플리케이션이 종료(서버 다운)되기 전까지 모든 페이지에서 공유
		
		
		// request scope
		request.setAttribute("p1", p1);
		request.setAttribute("nextAge", nextAge);
		
		
		// session scope
		HttpSession session = request.getSession();
		// 요청한 클라이언트의 브라우저 정보를 이용해 session이 만들어진다
		
		// session의 속성으로 값을 등록 
		// == 클라이언트 브라우저 종료되기 전까지 유지됨
		session.setAttribute("academy", "KH정보교육원");
		
		
		// request, session, application 객체의 속성이 중복되는 경우
		
		request.setAttribute("check", "request 범위 입니다.");
		session.setAttribute("check", "session 범위 입니다.");
		
		// application 객체 얻어오기
		ServletContext application = request.getServletContext();
		application.setAttribute("check", "application 범위 입니다.");
		
		
		
		// 요청 위임
		RequestDispatcher view = request.getRequestDispatcher("/views/el/01_el_result.jsp");
		view.forward(request, response);
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
