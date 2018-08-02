package test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {
	//추상메소드
	//request에 받은걸 Action에 넣어줌
	public abstract ActionForward execute
	(HttpServletRequest request, HttpServletResponse response);
}
