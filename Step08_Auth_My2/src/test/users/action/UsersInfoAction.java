package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
import test.users.dto.UsersDto;

public class UsersInfoAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		 //세션에서 로그인된 아이디를 읽어와서
		String id=(String)request.getSession().getAttribute("id");
		
		 //개인정보를 불러온다.
		    UsersDto dto=UsersDao.getInstance().getData(id);
		    //request에 담고
		    request.setAttribute("dto", dto);
		 //view페이지로  forward
		return new ActionForward("/views/users/private/info.jsp");
	}

}
