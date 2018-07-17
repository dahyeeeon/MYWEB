package test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// /showfortune 요청을 처리할 서블릿
@WebServlet("/showfortune")
public class ShowFortune extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//1. 오늘의 운세를 얻어오는 비즈니스 로직 수행
		String fortuneToday="밖에 나가면 졸라 더워요!";
		//2. 로직 수행결과로 얻어진 데이터(Model) 을 request 에 담기 
		request.setAttribute("fortuneToday", fortuneToday);
		//3. view 페이지로 (jsp 페이지로) forward 이동
		RequestDispatcher rd=
			request.getRequestDispatcher("/views/showfortune.jsp");
		rd.forward(request, response);
	}
}

















