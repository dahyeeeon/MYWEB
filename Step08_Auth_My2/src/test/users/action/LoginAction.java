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
		//폼 전송되는 파라미터 추출
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		//MemberDto 객체에 정보를 담고
		UsersDto dto=new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		//MemberDao 객체를 이용해서 db에 저장
		boolean isLoginSuccess=UsersDao.getInstance().isValid(dto);

		
		if(isLoginSuccess) {
			//세션으로 로그인 처리할때는 getSession으로
			request.getSession().setAttribute("id", id);
		}
		
		String url=request.getParameter("url");
		request.setAttribute("isLoginSuccess", isLoginSuccess);
		request.setAttribute("url", url);
		
		return new ActionForward("/views/users/login.jsp");
	}

}
