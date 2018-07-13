
<%@page import="user.dto.UsersDto"%>
<%@page import="java.util.List"%>
<%@page import="board_dto.BoardDto"%>
<%@page import="board_dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	//글 목록 불러오기
	List<BoardDto> list=BoardDao.getInstance().getList();
String id=(String)session.getAttribute("id");
%>
<%
if(id==null){	%>
	<script>
	alert("회원전용입니다. 로그인해주세요");
	location.href="index.jsp?nav=users/login_form.jsp";
	</script>

<% }	else{%>
<div class="container">
	<h3>게시글 목록</h3>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
			
			</tr>
		</thead>
		<tbody>
		<%for(BoardDto tmp:list){ %>
			<tr>
				<td><%=tmp.getNum() %></td>
				<td><a href="index.jsp?nav=community/detail.jsp?num=<%=tmp.getNum() %>"><%=tmp.getTitle() %></a></td>
				<td><%=tmp.getWriter() %></td>
				<td><%=tmp.getRegdate() %></td>
				
			</tr>
		

		<%} %>
		</tbody>
	</table>

		<div><a href="index.jsp?nav=community/insertform.jsp">글쓰기</a></div>
</div>

<%}%>