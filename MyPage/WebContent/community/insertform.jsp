<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
	String id=(String)session.getAttribute("id");

%>    

<%if(id==null){	%>
	<script>
	location.href('회원전용 게시판입니다. 로그인해주세요.')
	</script>

<% }	else{%>
<div class="text-center">
<h3>새 글을 작성하시겠습니까?</h3>
<form action="index.jsp?nav=community/insert.jsp" method="post">

	<label for="writer">작성자</label>
	<input type="text" name="writer" id="writer" value="<%=id%>" disabled/><br/>
	<input type="hidden" name="writer" id="writer" value="<%=id%>"/><br/>
	<label for="title">제 목</label>
	<input type="text" name="title" id="title"/><br />
	<label for="content">내용</label><br />
	<textarea name="content" id="content" cols="25" rows="10"></textarea>
	<br/>
	<button type="submit">작성 완료</button>
	<button type="reset">취소</button>
</form>
</div>
<%}%>