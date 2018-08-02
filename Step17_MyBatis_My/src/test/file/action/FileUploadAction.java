package test.file.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;
import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class FileUploadAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//ServletContext 객체는 request 객체로부터 얻어낼 수 있다.
		ServletContext applictaion=request.getServletContext();
		String realPath=applictaion.getRealPath("/upload");

		//최대 업로드 사이즈 값 지정
		int sizeLimit=1024*1024*50; //50 Mbyte
		/*
			WEB-INF/lib/cos.jar 파일이 있어야 아래의 MultipartRequest,
			DefaultFileRenamePolicy 클래스를 import 해서 사용할수 있다.
		*/
		
		// MultipartRequest 객체를 생성한다. 이거 없으면 request.getparameter은 null
		// 객체가 성공적으로 생성되면 클라이언트가 업로드한 파일이
		// WebContent/upload 폴더에 저장된다. 
		MultipartRequest mr;
		try {
			mr = new MultipartRequest(request,
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
		
		//업로드한 클라이언트의 아이디
		HttpSession session=request.getSession();
		String writer=(String)session.getAttribute("id");
		
		//업로드된 파일의 정보를 FileDto 에 담고 
		FileDto dto=new FileDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setOrgFileName(orgFileName);
		dto.setSaveFileName(saveFileName);
		dto.setFileSize(fileSize);
		
		//DB 에 저장한다.
		boolean isSuccess=FileDao.getInstance().insert(dto);
		//성공 여부를 request에 담기
		request.setAttribute("isSuccess", isSuccess);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
				return new ActionForward("/views/file/private/upload.jsp");
			}

}
