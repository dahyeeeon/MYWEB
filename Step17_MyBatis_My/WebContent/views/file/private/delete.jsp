<%@page import="java.io.File"%>
<%@page import="test.file.dto.FileDto"%>
<%@page import="test.file.dao.FileDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 삭제할 파일 번호를 읽어온다.
	int num=Integer.parseInt(request.getParameter("num"));

	//파일 시스템에서 삭제하기 위해서는 저장된 파일명을 알아야한다.
	FileDto dto=FileDao.getInstance().getData(num);
	
	String saveFileName=dto.getSaveFileName();
	
	//세션의 아이디와 삭제할 글의 작성자와 같은지 한번더 확인
	String id=(String)session.getAttribute("id");
	//세션의 아이디와 삭제할 글의 작성자가 다르면
	if(!id.equals(dto.getWriter())){
		/*에러코드,"에러메세지")*/
		//금지된 요청이라고 에러를 응답한다. 
		response.sendError(HttpServletResponse.SC_FORBIDDEN);
		//서비스 메소드 종료
		return;
	}
	
	
	// 1. DB 에서 파일 정보 삭제
	FileDao.getInstance().delete(num);
	
	// 2. WebContent/upload 폴더에서 실제 파일 삭제 
	
	//삭제할 파일의 전체 경로 구성 
	String path=application.getRealPath("/upload")+
		File.separator+saveFileName;
	
	//File 객체를 생성해서 삭제
	new File(path).delete();
	
	//응답하기 
	String cPath=request.getContextPath();
	//response.sendRedirect(cPath+"/file/list.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/file/private/delete.jsp</title>
</head>
<body>
<p> 파일을 삭제 했습니다. </p>
<a href="<%=cPath%>/file/list.do">확인</a>
</body>
</html>
