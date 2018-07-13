<%@page import="user.dao.UsersDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<%
	String id=(String)session.getAttribute("id");
%>
    
<% if(id!=null){ %>
<p><strong><%=id %></strong>님 회원 탈퇴 하시겠습니까?</p>
<a href="javascript:deleteConfirm(<%=id%>)">삭제</a></td>
<script>

	function deleteConfirm(num){
		var isDelete=confirm("정말 삭제하시겠습니까?");
		if(isDelete){
			<%
	
			UsersDao.getInstance().delete(id);
	
		%>
		alert("삭제되었습니다");
		location.href="index.jsp?nav=users/logout.jsp";
		}
	}
</script>
<%}else{ %>
<script>
alert("로그인 해주세요.");
location.href="index.jsp?nav=users/login_form.jsp";
</script>
<%} %>

