<%@page import="java.util.List"%>
<%@page import="gallerydto.GalleryDto"%>
<%@page import="gallerydao.GalleryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//이미지 목록을 얻어온다.
	List<GalleryDto> list=GalleryDao.getInstance().getList();
	//컨텍스트 경로
	String cPath=request.getContextPath();
%>
<div class="container">

	<h3>사진 Gallery 입니다.</h3>
	<hr/>
	<%for(GalleryDto tmp:list){%>
	<div class="col-xs-3">
		<h4><%=tmp.getCaption() %></h4>
		<img src="<%=cPath%><%=tmp.getImagePath()%>" 
			class="img-responsive img-thumbnail"/>
		<p>
			작성자:<strong><%=tmp.getWriter() %></strong><br/>
			등록일:<strong><%=tmp.getRegdate() %></strong>
		</p>
	</div>
	<%} %>
		<a href="private/upload_form.jsp">사진 올리기</a>
</div>
