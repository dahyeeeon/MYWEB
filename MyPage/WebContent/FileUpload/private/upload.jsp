<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="file.dao.FileDao"%>
<%@page import="file.dto.FileDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String realPath=application.getRealPath("/upload");
	int sizeLimit=1024*1024*50; //50 Mbyte

	MultipartRequest mr=new MultipartRequest(request,
			realPath,
			sizeLimit,
			"utf-8",
			new DefaultFileRenamePolicy());
	//업로드된 파일의 정보는 mr 객체를 이용해서 얻어온다.
	String title=mr.getParameter("title");
	//원본 파일명
	String orgFileName=mr.getOriginalFileName("myFile");
	//파일 시스템에 저장된 파일명 
	String saveFileName=mr.getFilesystemName("myFile");
	//파일의 크기 
	long fileSize=mr.getFile("myFile").length();

	String writer=(String)session.getAttribute("id");

	FileDto dto=new FileDto();
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setOrgFileName(orgFileName);
	dto.setSaveFileName(saveFileName);
	dto.setFileSize(fileSize);
	
	//DB 에 저장한다.
	boolean isSuccess=FileDao.getInstance().insert(dto);
	
	//응답
%>

<script>
location.href="index.jsp?nav=FileUpload/list.jsp";

</script>