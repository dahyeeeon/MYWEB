package test.users.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
/*	
 * 	UserActionFactory 클래스에 명시할 
 * 	command : /users/signup_form 
 * 
 *  회원 가입 폼을 출력해주는 액션
 */
public class SignupFormAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//지금은 비즈니스 로직을 수행할게 없음
		
		//view 페이지로 forward 이동 
		return new ActionForward("/views/users/signup_form.jsp");
	}
	
}










