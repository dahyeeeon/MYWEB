<%@page import="board_dao.BoardDao"%>
<%@page import="board_dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 폼 전송되는 내용을 추출해서
	request.setCharacterEncoding("utf-8");
	String writer=request.getParameter("writer");
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	//2. DB 에 저장하고
	BoardDto dto=new BoardDto();
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	//BoardDao 객체의 참조값 얻어와서 DB 에 저장하기 
	BoardDao dao=BoardDao.getInstance();
	boolean isSuccess=dao.insert(dto);

	//3. 응답하기
%>

<%if(isSuccess){ %>
	<p><strong><%=writer %></strong> 님의 글이 저장 되었습니다.</p>
	<a href="index.jsp?nav=community/list.jsp">글 목록 보기</a>
<%}else{ %>
	<p>글정보 저장 실패!</p>
	<a href="index.jsp?nav=community/insertform.jsp">새글 작성폼</a>
<%} %>
