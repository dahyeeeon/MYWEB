package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeDelete2Action extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num=Integer.parseInt(request.getParameter("num"));
		
		boolean isSuccess=CafeCommentDao.getInstance().delete(num);
		//3.결과를 request에
		request.setAttribute("isSuccess", isSuccess);
		//4. forward 이동
		return new ActionForward("/views/cafe/delete.jsp");
	}

}
