package test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class PersonAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String personToday="삼계탕";
		request.setAttribute("personToday", personToday);
		
		return new ActionForward("/views/person.jsp");
	}
	
}







