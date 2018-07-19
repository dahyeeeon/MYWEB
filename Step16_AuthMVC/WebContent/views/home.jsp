<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/home.jsp</title>
</head>
<body>
<%
	List<String> msgs=(List<String>)request.getAttribute("msgs");
%>
<h3>home 페이지 입니다</h3>
<ul>
	<li><a href="member/list.do">회원 목록 보기</a></li>
</ul>

<h3>공지 사항 입니다.</h3>
<ul>
	<%for(String tmp:msgs){%>
		<li><%=tmp %></li>
	<%} %>
</ul>
</body>
</html>





