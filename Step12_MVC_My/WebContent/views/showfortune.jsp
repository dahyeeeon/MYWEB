<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/showfortune.jsp</title>
</head>
<body>
<%
	//request 에 담긴 데이터 읽어오기
	String fortuneToday=
		(String)request.getAttribute("fortuneToday");
%>
<h3>오늘의 운세 페이지</h3>
<p> 오늘의 운세 : <strong><%=fortuneToday %></strong></p>
</body>
</html>













