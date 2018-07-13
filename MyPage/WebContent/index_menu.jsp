<%@page import="user.dao.UsersDao"%>
<%@page import="user.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id=(String)session.getAttribute("id");
	
%>

<nav class="navbar">
      <a class="navbar-brand" href="index.jsp">Portfolio</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
      
        <li><a href="index.jsp?nav=community/list.jsp">커뮤니티</a></li>
        <li><a href="index.jsp?nav=gallery/list.jsp"><span class="glyphicon glyphicon-picture"></span>갤러리</a></li>
        <li><a href="FileUpload/list.jsp">자료실</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <% if(id!=null){ %>
  
       <li><a href="index.jsp?nav=users/logout.jsp"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
		<%}else{ %>
		 <li><a href="index.jsp?nav=users/login_form.jsp"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
		<%} %>
        <li><a href="index.jsp?nav=users/joinus_form.jsp">회원가입</a></li>
        <li><a href="index.jsp?nav=users/userbye.jsp">회원탈퇴</a></li> 
      </ul>
</nav>