package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeCommentDao;
import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeCommentDto;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeUpdateCommentFormAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		int num=Integer.parseInt(request.getParameter("num")); 
		CafeCommentDto dto=new CafeCommentDto();
		dto.setNum(num);
		//2.수정할 글정보 얻어오기
		CafeCommentDto resultDto=CafeCommentDao.getInstance().getData(dto);
		//3.request에 담고 view페이지 보여주기
		request.setAttribute("dto", resultDto);
		return new ActionForward("/views/cafe/updatecommentform.jsp");
	}

}
