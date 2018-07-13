
<%@page import="board_dao.BoardDao"%>
<%@page import="board_dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 폼전송되는 수정할 글 정보를 읽어온다.
	request.setCharacterEncoding("utf-8");
	int num=Integer.parseInt(request.getParameter("num"));
	String writer=request.getParameter("writer");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	//2. BoardDao 객체를 이용해서 수정 반영한다.
	BoardDto dto=new BoardDto();
	dto.setNum(num);
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	boolean isSuccess=BoardDao.getInstance().update(dto);
	//3. 응답하기 
%>

<%if(isSuccess){ %>
	<p><strong><%=num %></strong> 번 글 정보를 수정했습니다.</p>
<%}else{ %>
	<p>글 수정 실패!</p>
<%} %>
<a href="../list.jsp">글 목록 보기</a>













