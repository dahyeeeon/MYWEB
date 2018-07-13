<%@page import="file.dto.FileDto"%>
<%@page import="java.util.List"%>
<%@page import="file.dao.FileDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<nav class="navbar">
      <a class="navbar-brand" href="../index.jsp">Portfolio</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
      
        <li><a href="../index.jsp?nav=community/list.jsp">커뮤니티</a></li>
        <li><a href="../index.jsp?nav=gallery/list.jsp"><span class="glyphicon glyphicon-picture"></span>갤러리</a></li>
        <li><a href="list.jsp">자료실</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">

  
       <li><a href="../index.jsp?nav=users/logout.jsp"><span class="glyphicon glyphicon-log-out"></span> 로그아웃</a></li>
	
        <li><a href="../index.jsp?nav=users/joinus_form.jsp">회원가입</a></li>
        <li><a href="../index.jsp?nav=users/userbye.jsp">회원탈퇴</a></li> 
      </ul>
</nav>
<%
	List<FileDto> list=FileDao.getInstance().getList();
	String id=(String)session.getAttribute("id");
%>
<%
if(id==null){	%>
	<script>
	alert("회원전용입니다. 로그인해주세요");
	location.href="../index.jsp?nav=users/login_form.jsp";
	</script>

<% }	else{%>
<div class="text-center">
<div class="container">
<br /><br /><br /><br />
<h3>파일 목록 입니다.</h3>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>파일명</th>
			<th>다운로드 횟수</th>
			<th>등록일</th>
			<th>삭제</th>
		</tr>	
	</thead>
	<tbody>
	
		<%for(FileDto tmp:list){ %>
		<tr>
			<td><%=tmp.getNum() %></td>
			<td><%=tmp.getWriter() %></td>
			<td><%=tmp.getTitle() %></td>
			<td><%=tmp.getOrgFileName() %>
			<a href="download.jsp?num=<%=tmp.getNum()%>"><i class="glyphicon glyphicon-download pull-right"></i></a></td>
			<td><%=tmp.getDownCount() %></td>
			<td><%=tmp.getRegdate() %></td>
			
			<td>
			<%if(id.equals(tmp.getWriter())){ %>
			<a href="javascript:deleteConfirm(<%=tmp.getNum()%>)">삭제</a></td>
		</tr>
		<%}
		} %>
	</tbody>
</table>
<a href="../index.jsp?nav=FileUpload/private/upload_form.jsp">새파일 업로드</a>
</div>
</div>
<%} %>
<script>
	//삭제 확인을 하는 함수
	//num은 tmp.getNum()에서 숫자 전달된걸 받아옴
	function deleteConfirm(num){
		var isDelete=confirm(num+"번 파일을 정말 삭제하시겠습니까?");
		if(isDelete){
			location.href="FileUpload/private/delete.jsp?num="+num;
		}
	}
</script>
