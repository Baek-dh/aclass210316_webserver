package edu.kh.semi.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/* 필터(filter) 
 * HttpServletRequest, HttpServletResponse 객체가
 * Servlet 또는 JSP에 도달하기 전에 전/후 처리를 하는 클래스
 * 
 * 필터는 FilterChain을 통해 여러 필터를 연쇄적으로 연결하여 사용할 수 있다.
 * 
 * 필터 생명주기 
 * init() -> doFilter() -> destroy()
 * */


// @WebFilter : servlet 3.0 이상 버전부터 사용 가능한 어노테이션
// 필터링 하려는 url 패턴과 필터의 이름을 지정할 수 있다.
// 필터에 이름이 지정되어 있을 경우 FilterChain 시 다음 수행할 필터를 선택할 수 있다.

// filterName : 필터 이름 지정  (필수 아님)
// urlPatterns : 필터가 적용될 요청, 응답 주소 패턴을 작성 (필수!!!)
//   /* : 모든 주소

@WebFilter(filterName = "encoding", urlPatterns = "/*")
public class EncodingFilter implements Filter {

	public void destroy() {
		// 필터 내용이 변경되어 이전 필터 내용이 필요 없어질 경우 수행
		//System.out.println("인코딩 필터 파괴");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 필터링 내용을 작성하는 메소드
		
		// ServletRequest 는 HttpServletRequest의 부모
		// ServletResponse 는 HttpServletResponse의 부모
		// -> 다형성을 이용해서 모든 종류의 요청, 응답 객체를 받겠다는 의미
		
		// 1. 요청 데이터의 문자 인코딩을 UTF-8로 변경
		request.setCharacterEncoding("UTF-8");
	
		// 2. 응답 데이터의 문자 인코딩을 UTF-8로 변경
		response.setCharacterEncoding("UTF-8");
		
		//System.out.println("필터링 완료");
		
		// 3. 연결된 필터가 있으면 다음 필터로 전달
		//    없으면 Servlet 또는 JSP로 전달
		chain.doFilter(request, response);
		
		/* Filter.doFilter(request, response, chain)
		 * -> 실제 필터링 처리를 하는 메소드
		 * 
		 * FilterChain.doFilter(request, response)
		 * -> 다음 필터 호출 또는 마지막 필터일 경우 servlet,jsp 호출
		 * 
		 * */
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		// 서버 실행 시 필터 객체가 생성될 때의 동작을 지정
		//System.out.println("인코딩 필터 초기화");
	}

}
