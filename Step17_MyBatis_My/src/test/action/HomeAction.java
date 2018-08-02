package test.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

/*
 *  /home.do 요청을 처리할 액션
 */
public class HomeAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//공지사항을 Dao 를 이용해서 읽어온다.
		List<String> msgs=new ArrayList<>();
		msgs.add("날씨가 많이 더워요");
		msgs.add("야외 활동을 자제해 주세요");
		msgs.add("어쩌구...");
		msgs.add("저쩌구...");
		
		//모델을 request 에 담는다.
		request.setAttribute("msgs", msgs);
		
		// view 페이지로 forward 이동
		return new ActionForward("/views/home.jsp");
	}

}









