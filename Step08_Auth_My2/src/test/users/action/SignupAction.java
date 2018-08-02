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
		//폼 전송되는 파라미터 추출
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String email=request.getParameter("email");
		
		//MemberDto 객체에 정보를 담고
		UsersDto dto=new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);
		//MemberDao 객체를 이용해서 db에 저장
		boolean isSuccess=UsersDao.getInstance().insert(dto);
		
		request.setAttribute("isSuccess", isSuccess);
		request.setAttribute("id", id);
		
		return new ActionForward("/views/users/signup.jsp");
		
	}

}
