package test.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dao.MemberDao;
import test.member.dto.MemberDto;
/*
 *  폼전송되는 수정할 회원의 정보를 DB 에 반영하는 액션 
 */
public class MemberUpdateAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// post 방식 폼 전송되는 파라미터 추출
		int num=Integer.parseInt(request.getParameter("num"));
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		// MemberDto 객체에 담아서
		MemberDto dto=new MemberDto(num, name, addr);
		// DB 에 반영
		boolean isSuccess=MemberDao.getInstance().update(dto);
		if(isSuccess) {
			request.setAttribute("msg", num+" 번 회원정보 수정됨");
		}else {
			request.setAttribute("msg", "수정 실패!");
		}
		request.setAttribute("url", "/member/list.do");
		return new ActionForward("/views/member/alert.jsp");
	}

}










