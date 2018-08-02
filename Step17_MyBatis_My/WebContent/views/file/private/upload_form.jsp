<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><strong>${id }</strong>님 로그인중..</p>
<h3>파일 업로드 폼</h3>
<form action="upload.do" method="post" enctype="multipart/form-data">
	<lable for="title">제목</lable>
	<input type="text" name="title" id="title" />
	<lable for="myFile">첨부파일</lable>
	<input type="file" name="myFile" id="myFile" />
	<button type="submit">업로드</button>
</form>
</body>
</html>