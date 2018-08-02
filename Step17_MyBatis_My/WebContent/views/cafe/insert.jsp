<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/cafe/insert.jsp</title>
</head>
<body>
<h3>카페 새글 저장 결과</h3>
<c:choose>
	<c:when test="${isSuccess }">
		<p>${id } 님 새글을 저장했습니다.</p>
		<a href="../list.do">글 목록 보기</a>
	</c:when>
	<c:otherwise>
		<p>글저장 실패!</p>
		<a href="insertform.do">글 다시 쓰기</a>
	</c:otherwise>
</c:choose>
</body>
</html>