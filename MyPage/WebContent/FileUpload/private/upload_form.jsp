<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*[파일 업로드 폼 작성법]
			1.method="post"
			2.enctype="multipart/form-data" -파라미터로 추출할 수 없지만 cos.jar가 도와줌
			3.<input type="file"/>
	
	*/
	String id=(String)session.getAttribute("id");
%>
<div class="text-center">
<h3>파일 업로드 폼</h3>
<p><strong><%=id %></strong>님 파일 업로드</p><a href="index.jsp?nav=FileUpload/list.jsp">목록</a>
<form action="index.jsp?nav=FileUpload/private/upload.jsp" method="post" enctype="multipart/form-data">
	<lable for="title">제목</lable>
	<input type="text" name="title" id="title" /><br />
	<lable for="myFile">첨부파일</lable><br />
	<input type="file" name="myFile" id="myFile" style="display:inline;" /><br />
	<button type="submit">업로드</button>
</form>
</div>