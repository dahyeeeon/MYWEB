package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class LoginAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//파라미터로 전달되는 아이디 비밀번호를 읽어와서 
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		// DB 의 정보와 일치 하는지 확인해서 
		UsersDto dto=new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		//로그인 성공여부 
		boolean isLoginSuccess=UsersDao.getInstance().isValid(dto);
		//로그인 성공후 월래 가야할곳의 정보 
		String url=request.getParameter("url");
		
		if(isLoginSuccess) {
			//세션 객체를 이용해서 로그인 처리 하기 
			request.getSession().setAttribute("id", id);
		}
		
		//Model 을 request 에 담기
		request.setAttribute("isLoginSuccess", isLoginSuccess);
		request.setAttribute("url", url);
		
		return new ActionForward("/views/users/login.jsp");
	}

}










