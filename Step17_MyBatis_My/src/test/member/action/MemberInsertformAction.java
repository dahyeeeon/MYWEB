package test.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

/*
 *  회원 추가 폼을 출력해주는 액션
 */
public class MemberInsertformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//수행할 비즈니스 로직은 없음...
		
		// /views/member/insertform.jsp 페이지로 forward 이동하도록 
		ActionForward af=
				new ActionForward("/views/member/insertform.jsp");
		return af;
	}

}








