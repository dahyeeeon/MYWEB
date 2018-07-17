package test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.member.dto.MemberDto;

@WebServlet("/showmember")
public class ShowMember extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//1. 회원 정보를 얻어오는 로직 수행
		MemberDto dto=new MemberDto(1, "김구라", "노량진");
		//2. Model 을 request 담기
		request.setAttribute("dto", dto);
		//3. view 페이지로 forward 이동
		RequestDispatcher rd=
				request.getRequestDispatcher("/views/showmember.jsp");
		rd.forward(request, response);
		
	}
}



















