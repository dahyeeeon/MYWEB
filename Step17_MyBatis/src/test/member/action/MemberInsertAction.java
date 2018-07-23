package test.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dao.MemberDao;
import test.member.dto.MemberDto;
/*
 *  폼전송되는 파라미터를 추출해서 DB 에 저장하는 Action 
 */
public class MemberInsertAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//폼전송되는 파라미터 추출
		String name=request.getParameter("name");
		String addr=request.getParameter("addr");
		//MemberDto 객체에 정보를 담고 
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		//MemberDao 객체를 이용해서 DB 에 저장 
		boolean isSuccess=MemberDao.getInstance().insert(dto);
		
		if(isSuccess) {//성공
			request.setAttribute("msg", "저장 했습니다.");
			request.setAttribute("url", "/member/list.do");
		}else {//실패
			request.setAttribute("msg", "실패 했습니다.");
			request.setAttribute("url", "/member/insertform.do");
		}
		ActionForward af=
				new ActionForward("/views/member/alert.jsp");
		return af;
	}

}











