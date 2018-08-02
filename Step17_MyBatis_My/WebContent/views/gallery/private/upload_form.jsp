<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/gallery/private/upload_form.jsp</title>
</head>
<body>
<h3>사진 업로드폼</h3>
<p><strong>${id }</strong>님 로그인중..</p><a href="../list.do">목록</a>
<form action="upload.do" method="post" enctype="multipart/form-data">
	<label for="caption">설명</label>
	<input type="text" name="caption" id="caption" /><br />
	<label for="image">사진</label>
	<input type="file" name="image" id="image" /><br />
	<button type="submit">업로드</button>
</form>
</body>
</html>