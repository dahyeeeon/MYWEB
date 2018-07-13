<%@page import="user.dao.UsersDao"%>
<%@page import="user.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//폼 전송되는 회원 정보를 추출해서
	request.setCharacterEncoding("utf-8");
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	//DB 에 저장하고
	UsersDto dto=new UsersDto();
	dto.setId(id);
	dto.setPwd(pwd);
	dto.setName(name);
	dto.setPhone(phone);
	boolean isSuccess=UsersDao.getInstance().insert(dto);
	//응답하기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/users/signup.jsp</title>
</head>
<body>
<h3>회원 가입 요청 결과 페이지</h3>
<%if(isSuccess){%>
	<p> <strong><%=name %></strong> 회원님 가입되었습니다.</p>
	<a href="index.jsp?nav=users/login_form.jsp">로그인 하기</a>
<%}else{ %>
	<p> 가입 실패! </p>
	<a href="index.jsp?nav=users/joinus_form.jsp">다시 가입하러 가기</a>
<%} %>
</body>
</html>