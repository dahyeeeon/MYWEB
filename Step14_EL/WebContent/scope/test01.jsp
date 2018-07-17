<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		[ 영역(scope) ]
				
		1. page 영역(scope)
		2. request 영역
		3. session 영역
		4. application 영역
	*/
	
	//page scope 에 "myName" 이라는 키값으로 String type 저장
	pageContext.setAttribute("myName", "김구라");
	//request scope 에 "yourName" 이라는 키값으로 String type 저장
	request.setAttribute("yourName", "원숭이");
	//session scope 에 "ourName" 이라는 키값으로 String type 저장
	session.setAttribute("ourName", "Acorn");
	//application scope 에 "herName" 이라는 키값으로 String type 저장
	application.setAttribute("herName", "신민아");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/scope/test01.jsp</title>
</head>
<body>
<p>myName=<strong>${pageScope.myName }</strong></p>
<p>myName=<strong>${myName }</strong></p>
<p>yourName=<strong>${requestScope.yourName }</strong></p>
<p>yourName=<strong>${yourName }</strong></p>
<% 	
	// 아래 두줄의 코드는 ${ourName} 으로 대체 할수 있다 
	String ourName=(String)session.getAttribute("ourName");
%>
<p>ourName=<strong><%=ourName %></strong></p>
<p>ourName=<strong>${sessionScope.ourName }</strong></p>
<p>ourName=<strong>${ourName }</strong></p>
<p>herName=<strong>${applicationScope.herName }</strong></p>
<p>herName=<strong>${herName }</strong></p>
</body>
</html>









