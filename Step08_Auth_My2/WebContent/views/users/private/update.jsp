<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update.jsp</title>
</head>
<body>
<c:choose>
	<c:when test="${isSuccess }">
	<p>${id }회원님 정보를 수정했습니다,.</p>
	<a href="info.do">확인</a>
	</c:when>
	<c:otherwise>
	<p>회원정보 수정 실패!</p>
	<a href="updateform.do">다시 작성하기</a>
	</c:otherwise>
</c:choose>

</body>
</html>