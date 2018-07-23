package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class LoginFormAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//로그인후 이동할 url 정보를 읽어온다. 
		String url=request.getParameter("url");
		if(url==null){//만일 전달되지 않았으면
			//인덱스 페이지로 이동 되도록 한다. 
			url=request.getContextPath()+"/";
		}
		
		request.setAttribute("url", url);
		
		//view 페이지로 forward 이동
		return new ActionForward("/views/users/loginform.jsp");
	}

}










