<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="test.member.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	List<MemberDto> list=new ArrayList<>();
	list.add(new MemberDto(1, "김구라", "노량진"));
	list.add(new MemberDto(2, "김구라2", "노량진2"));
	list.add(new MemberDto(3, "김구라3", "노량진3"));
	// 컨트롤러에서 Model 을 request 에 담았다고 가정 
	request.setAttribute("list", list);
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test05.jsp</title>
</head>
<body>
<h3>회원 목록입니다.</h3>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="tmp" items="${list }">
		<tr>
			<td>${tmp.num }</td>
			<td>${tmp.name }</td>
			<td>${tmp.addr }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>













