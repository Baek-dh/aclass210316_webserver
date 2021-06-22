package edu.kh.semi.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import edu.kh.semi.wrapper.EncryptWrapper;

@WebFilter(filterName = "encryptFilter", urlPatterns = {"/member/login", "/member/signUp", "/member/changePwd"  })
public class EncryptFilter implements Filter {

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		// 1. HttpServletRequest로 다운캐스팅
		HttpServletRequest req = (HttpServletRequest)request;

		//System.out.println( req.getMethod() );
		
		// 2. 비밀번호를 입력하는 POST 방식 요청에서만 암호화를 적용
		if( req.getMethod().equals("POST")  ) {
			
			// 4. Wrapper를 이용하여 요청데이터(request)를 변경함 
			// --> 암호화 진행을 위한 EncryptWrapper 클래스 생성
			
			// 5. EncryptWrapper 객체를 생성
			EncryptWrapper encWrapper = new EncryptWrapper(req);
			
			// 6. request 대신 encWrapper를 다음 필터나 servlet/request로 넘김
			chain.doFilter(encWrapper, response);
			
		}else {
			// 3. POST 방식이 아닐때 -> 요청을 다음 필터나 servlet/jsp로 넘김
			chain.doFilter(request, response);
			
		}
		
		
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
