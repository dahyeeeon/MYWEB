
<%@page import="board_dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//1. 파라미터로 전달되는 삭제할 글번호를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
	//2. BoardDao 를 이용해서 해당글을 삭제한다.
	boolean isSuccess=BoardDao.getInstance().delete(num);
	//3. 응답하기 
%>

<%if(isSuccess){%>
	<script>
		alert("<%=num%>번 글을 삭제 했습니다.");
		location.href="list.jsp";
	</script>
<%}else{ %>
	<script>
		alert("삭제 실패!");
		location.href="list.jsp";
	</script>
<%}%>


















