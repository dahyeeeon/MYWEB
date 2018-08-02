package test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	//필드
	private String encoding;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, 
			FilterChain chain)
			throws IOException, ServletException {
		//1.요청을 가로채서 해야할 작업 작성
		if(req.getCharacterEncoding()==null) {
			req.setCharacterEncoding("utf-8");
		}
		//2.다음 작업 수행하기
		chain.doFilter(req, res);
		
	}
	//필터가 최초 동작될때 호출되는 메소드(객체 생성직후) 
	@Override
	public void init(FilterConfig config) throws ServletException {
		/*  아래와 같은 web.xml 문서의 내용중에서 utf-8 문자열
		 *  읽어내기 
		 * 	<init-param>
				<param-name>encoding</param-name>
				<param-value>utf-8</param-value>
			</init-param>
		 */
		//읽어온 문자열을 맴버필드에 저장한다. 
		encoding=config.getInitParameter("encodig");
	}

}



