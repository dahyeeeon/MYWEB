package test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.member.dto.MemberDto;

public class InfoAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 회원정보 얻어오기
		MemberDto dto=new MemberDto(1, "김구라", "노량진");
		//2. request 에 담기
		request.setAttribute("dto", dto);
		//3. view 페이지로 forward 이동
		return new ActionForward("/views/info.jsp");
	}
	
}










