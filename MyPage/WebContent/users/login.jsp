<%@page import="user.dao.UsersDao"%>
<%@page import="user.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //폼전송되는 아이디 비밀번호를 읽어와서
    request.setCharacterEncoding("utf-8");
    String id=request.getParameter("id");
    String pwd=request.getParameter("pwd");
    //db의 정보와 일치 하는지 확인
    UsersDto dto=new UsersDto();
    dto.setId(id);
    dto.setPwd(pwd);

    //로그인 성공여부
    boolean isLoginSuccess=UsersDao.getInstance().isValid(dto);

    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<%if(isLoginSuccess){ 
session.setAttribute("id",id);%>
<script>
alert("<%=id%>님 로그인 되었습니다!");
location.href="index.jsp";
</script>
<%}else{ %>
<p>아이디 혹은 비밀번호가 틀려요</p>
<a href="index.jsp?nav=users/login_form.jsp">확인</a>
<%} %>
</body>
</html>