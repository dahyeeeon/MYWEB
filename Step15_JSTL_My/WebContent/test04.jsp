<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test04.jsp</title>
</head>
<body>
<%--page 영역에 값 저장하기
	pageContext.setAttribute();
 --%>
 
 <c:set var="num" value="1"/>
 <c:set var="name" value="김구라"/> 
  <c:set var="addr" value="노량진"/>
  
  <p>번호<strong>${num }</strong></p>
  <p>이름<strong>${name }</strong></p>
  <p>주소<strong>${addr }</strong></p>
 <!-- c:out은 기본값을 따로 지정할 수 있다. --> 
  <p>번호: <strong><c:out value="${num2 }" default="0"></c:out></strong></p>
  <p>이름: <strong><c:out value="${name2 }" default="기본값"></c:out></strong></p>
   <p>주소: <strong><c:out value="${addr2 }" default="아무거나"></c:out></strong></p> 
   
   <% //테스트를 위해 request에 문자열 담기
   	request.setAttribute("markup","<a href=''>링크</a>");
   %>
   
   <p>${markup }</p>
   <p><code><c:out value="${markup }" escapeXml="true"></c:out></code></p>
   
</body>
</html>