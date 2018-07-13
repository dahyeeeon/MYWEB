<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>IndexPage</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
  <style>
 @import url('https://fonts.googleapis.com/css?family=Nanum+Pen+Script');
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
	body{
	font-size:18px;
	font-family: 'Nanum Pen Script', cursive;
	}
	
	a{
	color:black;}
  </style>
</head>
<body>
 <%
 request.setCharacterEncoding("utf-8");
  String content = request.getParameter("nav");
  if(content==null){

    content="index_content.jsp";
  }
  content=content;
 

%> 


<jsp:include page="index_menu.jsp"></jsp:include>
<div class="container">
<div class="text-center">
<br /><br /><br /><br />
<jsp:include page="<%=content%>"></jsp:include>
</div>
</div>
</body>
</html>

