package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.users.dao.UsersDao;
/*
 *  UserActionFactory 에 명시할
 *  command : /users/checkid
 *  
 *  사용할수 있는 아이디 인지 여부를 json 으로 응답하는 액션 
 */
public class CheckIdAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// ajax 요청 파라미터로 전달되는 문자열 읽어오기 
		String inputId=request.getParameter("inputId");
		// 사용 가능한지 여부를 Dao 를 이용해서 리턴 받는다. 
		boolean canUse=UsersDao.getInstance().canUseId(inputId);
		// Model 을 request 에 담기
		request.setAttribute("canUse", canUse);
		// view 페이지로 forward 이동
		return new ActionForward("/views/users/checkid.jsp");
	}

}










