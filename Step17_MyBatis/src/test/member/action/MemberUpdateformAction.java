package test.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dao.MemberDao;
import test.member.dto.MemberDto;
/*
 * 수정할 회원의 정보를 form 에 출력해주는 액션 
 */
public class MemberUpdateformAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// get 방식 파라미터로 전달되는 수정할 회원의 번호
		int num=Integer.parseInt(request.getParameter("num"));
		// 수정할 회원의 정보 
		MemberDto dto=MemberDao.getInstance().getData(num);
		// request 에 담기
		request.setAttribute("dto", dto);
		// view 페이지로 forward 이동
		return new ActionForward("/views/member/updateform.jsp");
	}
	
}



















