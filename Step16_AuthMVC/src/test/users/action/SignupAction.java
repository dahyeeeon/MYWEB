package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class SignupAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		
		UsersDto dto=new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);
		
		boolean isSuccess=UsersDao.getInstance().insert(dto);
		//회원가입 결과를 request 에 담고 
		request.setAttribute("isSuccess", isSuccess);
		//아이디도 담고
		request.setAttribute("id", id);
		//view 페이지로 forward 이동
		return new ActionForward("/views/users/signup.jsp");
	}

}











