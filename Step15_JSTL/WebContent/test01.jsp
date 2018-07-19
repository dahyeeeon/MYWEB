<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	//컨트롤러에서 request 에 담은 데이터라고 가정 
	List<String> msgs=new ArrayList<>();
	msgs.add("하나");
	msgs.add("두울");
	msgs.add("세엣");
	msgs.add("...");
	
	request.setAttribute("msgs", msgs);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test01.jsp</title>
</head>
<body>
<h3>반복문 forEach</h3>
<c:forEach var="i" begin="0" end="9" step="1">
	
	<strong>${i }</strong> &nbsp;

</c:forEach>

<h3>request 에 담긴 내용을 반복문 돌면서 출력</h3>
<ul>
	<c:forEach var="tmp" items="${msgs }">
		<li>${tmp }</li>
	</c:forEach>
</ul>
</body>
</html>
























