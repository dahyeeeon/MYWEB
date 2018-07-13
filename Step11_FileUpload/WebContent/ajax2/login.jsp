 <%@page import="test.users.dao.UsersDao"%>
<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// ajax 요청 파라미터 추출 
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	//유효한 정보인지 확인
	UsersDto dto=new UsersDto();
	dto.setId(id);
	dto.setPwd(pwd);
	
	boolean isLoginSuccess=UsersDao.getInstance().isValid(dto);
	if(isLoginSuccess){
		//로그인 처리 하기 
		session.setAttribute("id", id);
	}
%>
{"isSuccess":<%=isLoginSuccess %>}













