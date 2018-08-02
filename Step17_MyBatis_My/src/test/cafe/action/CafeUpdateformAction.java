package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.cafe.dao.CafeDao;
import test.cafe.dto.CafeDto;
import test.controller.Action;
import test.controller.ActionForward;

public class CafeUpdateformAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1.수정할 글번호 읽어오기
		int num=Integer.parseInt(request.getParameter("num")); 
		CafeDto dto=new CafeDto();
		dto.setNum(num);
		//2.수정할 글정보 얻어오기
		CafeDto resultDto=CafeDao.getInstance().getData(dto);
		//3.request에 담고 view페이지 보여주기
		request.setAttribute("dto", resultDto);
		return new ActionForward("/views/cafe/updateform.jsp");
	}

}
