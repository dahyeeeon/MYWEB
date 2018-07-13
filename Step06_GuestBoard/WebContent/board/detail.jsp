<%@page import="test.board.dao.BoardDao"%>
<%@page import="test.board.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/board/detail.jsp</title>
</head>
<body>
<%
	// /board/detail.jsp?num=x
	
	//자세히 보여줘야 될 글 번호를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
    BoardDto dto=BoardDao.getInstance().getData(num);
%>
<h3>글 자세히 보기 페이지</h3>
<table>
	<tr>
		<th>글번호</th>
		<td><%=dto.getNum() %></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%=dto.getWriter() %></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><%=dto.getTitle() %></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea cols="30" rows="5"><%=dto.getContent() %></textarea></td>
	</tr>
	<tr>
		<th>등록일</th>
		<td><%=dto.getRegdate() %></td>
	</tr>
</table>


<a href="updateform.jsp?num=<%=dto.getNum() %>">수정</a>
<a href="javascript:deleteCheck()">삭제</a>
<script>
	function deleteCheck(){
		var isDelete=confirm("글을 삭제 하시겠습니까?");
		if(isDelete){
			location.href="delete.jsp?num=<%=dto.getNum() %>";
		}
	}
</script>
</body>
</html>










