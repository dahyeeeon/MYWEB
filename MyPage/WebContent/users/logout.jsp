<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%
//세션에 저장된 모든 정보 삭제하기
	session.invalidate();

	String cPath=request.getContextPath(); //최상위 경로 담는다
%>
<script>
alert("로그아웃 되었습니다.");
location.href="<%=cPath%>/";

</script>
</body>
</html>