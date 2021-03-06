package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class UsersUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		 //1.파라미터로 전달되는 회원정보 추출
	    String id=(String)request.getParameter("id");
	    String pwd=(String)request.getParameter("pwd");
	    String email=(String)request.getParameter("email");

	    //2.db에 수정반영
	    UsersDto dto=new UsersDto();
	    dto.setId(id);
	    dto.setPwd(pwd);
	    dto.setEmail(email);
	    boolean isSuccess=UsersDao.getInstance().update(dto);
	    request.setAttribute("isSuccess", isSuccess);
		return new ActionForward("/views/users/private/update.jsp");
	}

}
