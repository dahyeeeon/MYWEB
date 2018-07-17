package test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class TestAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		/*
		 *  /test.do?num=1&name=gura
		 *  
		 *  와 같이 요청 파라미터가 전달되었는데 
		 *  view 페이지로 forward 이동해서도 파라미터를 추출할수 있다.
		 */
		
		return new ActionForward("/views/test.jsp");
	}

}










