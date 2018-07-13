<%@page import="user.dao.UsersDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//1.파라미터로 전달되는 아이디 읽어오기
	String inputId=request.getParameter("inputId");
	//2.db에서 사용 가능한 아이디인지 확인한다.
	boolean canUse=UsersDao.getInstance().canUseId(inputId);
	//3.가능한지 여부를 적당한 문자열 형식으로 응답한다.
	//html,json,xml,자기만의 형식 등으로. 가급적 json형식으로 응답이 좋다

%>

{"canUse":<%=canUse %>}