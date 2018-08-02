package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;

public class UsersDeleteAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1.세션에서 아이디를 읽어와서
		String id=(String)request.getSession().getAttribute("id");
		//2.db에서 삭제하고
		UsersDao.getInstance().delete(id);
		//3.로그아웃 처리하고
		request.getSession().invalidate();
		//id전달하려면
		request.setAttribute("id", id);
		return new ActionForward("/views/users/private/delete.jsp");
	}

}
