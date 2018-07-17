<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/info.jsp</title>
</head>
<body>

<h3>회원 정보 입니다.</h3>
<p>번호: <strong>${requestScope.dto.getNum() }</strong></p>
<p>번호: <strong>${dto.num }</strong></p>
<p>이름: <strong>${dto.name }</strong></p>
<p>주소: <strong>${dto.addr }</strong></p>
</body>
</html>











