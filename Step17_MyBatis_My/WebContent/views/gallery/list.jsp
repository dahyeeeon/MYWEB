<%@page import="test.gallery.dao.GalleryDao"%>
<%@page import="test.gallery.dto.GalleryDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/gallery/list.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>

<div class="container">
   <a href="private/upload_form.do">사진 올리기</a>
   <h3>사진 Gallery 입니다.</h3>
   <br/>
   <c:forEach var="tmp" items="${list }">
   <div class="col-xs-6 col-sm-3">
      <h4>${tmp.caption }</h4>
      <img src="${cPath}${tmp.imagePath}" 
         class="img-responsive img-thumbnail"/>
      <p>작성자:<strong>${tmp.writer }</strong></p><br />
      <p>등록일:<strong>${tmp.regdate }</strong></p><br />
   </div>
   </c:forEach>
</div>
</body>
</html>