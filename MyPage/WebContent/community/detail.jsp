<%@page import="board_dao.BoardDao"%>
<%@page import="board_dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// /board/detail.jsp?num=x
	
	//자세히 보여줘야 될 글 번호를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));
    BoardDto dto=BoardDao.getInstance().getData(num);
    String id=(String)session.getAttribute("id");
%>

<h3>글 자세히 보기 페이지</h3>
<table>
	<tr>
		<th>글번호</th>
		<td><%=dto.getNum() %></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%=id %></td>
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

<%if(id.equals(dto.getWriter())){ %>
		<a href="index.jsp?nav=community/updateform.jsp?num=<%=dto.getNum() %>">수정</a>
		<a href="javascript:deleteCheck()">삭제</a>
		
<%}%>

<script>
	function deleteCheck(){
		var isDelete=confirm("글을 삭제 하시겠습니까?");
		if(isDelete){
			location.href="index.jsp?nav=community/delete.jsp?num=<%=dto.getNum() %>";
		}
	}
</script>

