package test.cafe.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
/*
 *  카페 새글 작성 폼 요청 처리 
 */
public class CafeInsertformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		return new ActionForward("/views/cafe/insertform.jsp");
	}

}









