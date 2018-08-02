<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<thead>
		<tbody>
		<tr>
		<th>아이디</th>
		<td>${dto.id }</td>
		</tr>
		<tr>
		<th>이메일</th>
		<td>${dto.email }</td>
		</tr>
		<tr>
		<th>가입일</th>
		<td>${dto.regdate }</td>
		</tr>
		</tbody>
	</thead>
</table>
<a href="updateform.do">회원정보 수정</a>
<a href="javascript:deleteConfirm()">회원 탈퇴</a>
<script>
	function deleteConfirm(){
		var isDelete=confirm("회원 탈퇴하시겠습니까?");
		if(isDelete){
			location.href="delete.do";
		}
	}

</script>
</body>
</html>