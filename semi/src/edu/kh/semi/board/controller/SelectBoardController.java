package edu.kh.semi.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.semi.board.model.service.ReplyService;
import edu.kh.semi.board.model.service.SelectBoardService;
import edu.kh.semi.board.model.vo.Board;
import edu.kh.semi.board.model.vo.Pagination;
import edu.kh.semi.board.model.vo.Reply;

// MVC (Model View Controller)

// Model : 비즈니스 로직 처리
// - Service : 데이터 가공, 트랜잭션 처리
// - DAO : DB 연결, SQL 수행
// - VO : 데이터 저장(DB 조회 결과, 다수 파라미터 저장)

// View : 클라이언트에게 보여지는 부분
//        클라이언트의 요청을 받고, 응답(요청 처리 결과)을 보여주는 화면

// Controller : 클라이언트의 요청을 받아서 알맞은 비즈니스 로직으로 처리한 후
//              응답화면을 연결하는 제어 역할


@WebServlet("/board/*") //   /board로 시작하는 요청을 모두 받음
public class SelectBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Front Controller 패턴   (디자인 패턴)
	// - 클라이언트의 요청을 한 곳으로 집중시켜
	//   개발 및 유지보수의 효율성을 증가시킨 패턴
	
	// - 요청에 따른 Servlet을 각각 생성하는 것이 아닌, 하나의 Servlet으로 여러 요청을 받음.
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI(); // 요청 주소  			ex) /semi/board/list
		String contextPath = request.getContextPath(); // 최상위 주소  	ex) /semi 
		String command = uri.substring( (contextPath + "/board/").length() ); // list
		// uri에서 contextPath + "/board/" 만큼을 앞에서 부터 잘라낸 후 나머지를 command 저장
		
		
		String path = null; // 응답화면 주소 또는 경로
		RequestDispatcher view = null; // 요청 위임 객체 저장 참조 변수
		
		// sweetalert용 변수
		String icon = null;
		String title = null;
		String text = null;
		
		try {
			
			SelectBoardService service = new SelectBoardService();
			
			// 현재 페이지 저장
			// 삼항 연산자를 이용해서 cp가 없으면 1, 있으면 int형태로 파싱한 cp값 을 저장
			int cp =  request.getParameter("cp") == null  ?  1 : Integer.parseInt(request.getParameter("cp"))  ;
			
			
			// 게시글 목록 조회 Controller
			if( command.equals("list") ) {
				
				// 쿼리스트링에 있는 type을 얻어와 int로 파싱 후 저장
				int boardType = Integer.parseInt(request.getParameter("type"));
				
				// 페이징 처리를 위한 여러 정보를 담고있는 객체 Pagination 생성
				Pagination pagination = service.getPagination(cp, boardType);
				
				//System.out.println(pagination);
				
				// pagination을 이용하여 게시글 목록에 보여져야할 내용을 DB에서 조회
				List<Board> boardList = service.selectBoardList(pagination);
				
				
				// pagination, boardList를 request에 속성으로 추가한 후 boardList.jsp로 forward
				
				request.setAttribute("pagination", pagination);
				request.setAttribute("boardList", boardList);
				
				path = "/WEB-INF/views/board/boardList.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
				
				
			}
			
			// 게시글 상세 조회 Controller
			else if( command.equals("view") ) {
				
				int boardNo = Integer.parseInt(request.getParameter("no")); 
				
				Board board = service.selectBoard(boardNo);
				
				// 해당 게시글 댓글 목록 조회
				List<Reply> rList = new ReplyService().selectList(boardNo);

				//System.out.println(board);
				
				request.setAttribute("board", board);
				request.setAttribute("rList", rList);
				
				
				path = "/WEB-INF/views/board/boardView.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
				
			}
			
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
