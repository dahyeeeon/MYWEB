package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class LoginformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String url=request.getParameter("url");
		if(url==null){
			url=request.getContextPath()+"/";
		}
		request.setAttribute("url", url);
	
		ActionForward af=new ActionForward("/views/users/loginform.jsp");

		return af;
	}

}
