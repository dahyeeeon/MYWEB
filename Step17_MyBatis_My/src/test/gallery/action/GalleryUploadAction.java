package test.gallery.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import test.controller.Action;
import test.controller.ActionForward;
import test.gallery.dao.GalleryDao;
import test.gallery.dto.GalleryDto;

public class GalleryUploadAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ServletContext applictaion=request.getServletContext();
		String realPath=applictaion.getRealPath("/upload");

		int sizeLimit=1024*1024*50; //50 Mbyte
		MultipartRequest mr;
		try {
			mr = new MultipartRequest(request,
					realPath,
					sizeLimit,
					"utf-8",
					new DefaultFileRenamePolicy());
		
		//업로드된 파일의 정보는 mr 객체를 이용해서 얻어온다.
		String caption=mr.getParameter("caption");
		//파일 시스템에 저장된 파일명 
		String saveFileName=mr.getFilesystemName("image");
		
		HttpSession session=request.getSession();
		String writer=(String)session.getAttribute("id");
		
		GalleryDto dto=new GalleryDto();
		dto.setWriter(writer);
		dto.setCaption(caption);
		dto.setImagePath("/upload/"+saveFileName);
		
	
		boolean isSuccess=GalleryDao.getInstance().insert(dto);
		//응답	
		String cPath=request.getContextPath();
		request.setAttribute("isSuccess", isSuccess);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ActionForward("/views/gallery/private/upload.jsp");
	}

}
