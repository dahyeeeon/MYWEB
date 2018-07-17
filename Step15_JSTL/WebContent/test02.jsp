<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test02.jsp</title>
</head>
<body>
<h3>JSTL if 문</h3>
<c:if test="true">
	<p>출력이 되요</p>
</c:if>
<c:if test="false">
	<p>출력이 안되요</p>
</c:if>
<c:if test="${10 gt 2 }">
	<p>10 은 2 보다 커요</p>
</c:if>
<c:if test="${10 lt 2 }">
	<p>10 은 2 보다 작아요</p>
</c:if>
<% request.setAttribute("num", 10); %>
<c:if test="${num gt 2}">
	<p>${num } 은 2 보다 커요</p>
</c:if>
<% session.setAttribute("id", "gura"); %>
<c:if test="${not empty id }">
	<p>${id } 님 로그인중...</p>
</c:if>

<c:choose>
	<c:when test="${not empty id }">
		<p>${id } 님 로그인중...</p>
	</c:when>
	<c:otherwise>
		<a href="loginform.jsp">로그인 하러 가기</a>
	</c:otherwise>
</c:choose>
</body>
</html>










