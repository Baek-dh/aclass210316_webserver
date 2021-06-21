package edu.kh.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.semi.member.model.vo.Member;

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. POST 방식 인코딩 변경
		request.setCharacterEncoding("UTF-8");
		
		// 2. Session에서 로그인된 회원 정보 얻어오기
		HttpSession session = request.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		int memberNo = loginMember.getMemberNo(); // 회원 번호
		
		// 3. 파라미터로 전달 받은 수정된 회원정보를 변수에 저장
		// (DB에 저장하기위해 알맞은 형태로 변환 ,   회원가입 Servlet 참고)
		
		try {
			// 4. 회원정보 수정 서비스를 호출 후 결과 반환 받기
			// int result = ;
			
			// 5. 수정 결과에 따라서 화면에 sweetalert로 
			// 수정 성공/실패 메세지 출력하도록  session에 속성 세팅
			
			// 6. 로그인된 회원 정보를 최신 버전으로 업데이트
			
			// 7. 마이페이지로 재요청
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
