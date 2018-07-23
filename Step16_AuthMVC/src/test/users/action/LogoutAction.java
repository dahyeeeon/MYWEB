package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class LogoutAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		//세션에서 로그인 정보 제거
		request.getSession().invalidate();
		
		return new ActionForward("/views/users/logout.jsp");
	}

}









