package edu.kh.semi.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper{


	// HttpServletRequestWraaper
	// -> 사용자 요청을 감싸서 요청데이터 가공을 하는 객체
	// -> Wrapper로 지정된 클래스에서 상속을 받아야 한다.
	
	// HttpServletRequestWrapper를 상속 받으면 반드시 매개변수있는 생성자를 만들어야 한다.
	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	
	// 파라미터로 전달 받은 값 중 비밀번호를 얻어와 암호화를 진행
	// request.getParamter() 오버라이딩
	
	@Override
	public String getParameter(String key) {
		
		// 매개변수 key == input 태그의 name 속성값 
		
		String value = null; // 
		
		switch(key) {
		case "memberPw" :
		case "pwd1" :
		case "currentPwd" :  
		case "newPwd1" :
			// 비밀번호는 암호화
			value = getSha512(  super.getParameter(key)   ); break;
			
		default : 
			// 비밀번호가 아니면 그대로 반환
			value = super.getParameter(key);
		}
		
		return value;
	}


	
	/** SHA-512 해쉬 함수를 이용하여 문자열 암호화를 진행하는 메소드
	 * @param pwd
	 * @return encPwd
	 */
	private String getSha512(String pwd) {
		
		// 1. 암호화된 비밀번호를 저장할 변수 선언
		String encPwd = null;
		
		// 2. 해쉬 함수를 수행하는 객체를 저장할 변수 선언
		// 해쉬 함수 : 특정 값을  여러 단계의 연산을 거쳐 일정 길이의 무작위 값을 얻어내는 함수
		MessageDigest md = null;
		
		try {
			// 3. SHA-512 방식의 해쉬함수를 수행할 수 있는 객체를 얻어옴
			md = MessageDigest.getInstance("SHA-512");
			
			// 4. md를 이용해 문자열 암호를 하기 위해 byte 배열로 변환
			byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
			
			
			// 5. md 객체에 바이트로 변환된 비밀번호를 전달하여 암호화를 수행
			md.update(bytes);
			
			// 6. md 객체에서 암호화된 내용을 꺼내옴
			//  Base64 : 바이트 코드를 문자열로 바꾸는 라이브러리
			encPwd = Base64.getEncoder().encodeToString(md.digest());
			// md.digest() : 암호화된 코드를 꺼내옴
			
			System.out.println("암호화 전 : " + pwd);
			System.out.println("암호화 후 : " + encPwd);
			
		}catch (NoSuchAlgorithmException e) {
			// SHA-512 해쉬함수가 없는 경우 발생
			e.printStackTrace();
		}
		
		return encPwd;
	}
	
	
	
	
	
	
	
	
	
}
