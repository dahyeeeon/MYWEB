package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeDeleteAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1.파라미터로 전달되는 글번호
		int num=Integer.parseInt(request.getParameter("num"));
		//2.CafeDao를 이용해서 글 삭제
		boolean isSuccess=CafeDao.getInstance().delete(num);
		//3.결과를 request에
		request.setAttribute("isSuccess", isSuccess);
		//4. forward 이동
		return new ActionForward("/views/cafe/delete.jsp");
		
	}

}
