package test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * 중간에 요청을 가로채서 특정(검증 등) 동작을 하기 위한 클랫
 * 
 * 1. Filter 인터페이스를 구현한다.
 * 2. Filter의 동작을 맵핑한다.
 * 
 * webfilter에 필터링할 경로 적고
 * dofilter메소드에 쓴다
 * 
 * 
 * */


@WebFilter({"/users/private/*"})
public class LoginFilter implements Filter{ //1.

   @Override
   public void destroy() {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
         
         throws IOException, ServletException {
      System.out.println("doFilter() ...");
      
      //원래 type으로 casting
      HttpServletRequest request=(HttpServletRequest)req;
      HttpServletResponse response=(HttpServletResponse)res;
      
      //context path
      String cPath=request.getContextPath();
      String url=request.getRequestURI();
      
      //세션 객체 얻어와서
      HttpSession session = request.getSession();
      
      //id가 저장되어 있는지 읽어와 본다.
      String id=(String)session.getAttribute("id");
      
      if(id==null) {//로그인 하지 않았으면
         //로그인 페이지로 이동하라고 리다이렉트 응답을 준다
         response.sendRedirect(cPath+"/users/loginform.jsp?url="+url);
         
      }else {
    	   //요청 흐름 계속 진행 시키기
          chain.doFilter(req, res);
      }
      
   
      
   }

   @Override
   public void init(FilterConfig arg0) throws ServletException {
      // TODO Auto-generated method stub
      
   }
   
}
