package test.gallery.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.gallery.dao.GalleryDao;
import test.gallery.dto.GalleryDto;


public class GalleryUpload_FormAction extends Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String id=(String)request.getSession().getAttribute("id");
		//2. 아이디를 이용해서 회원정보를 얻어온다.
		request.setAttribute("id", id);
		return new ActionForward("/views/gallery/private/upload_form.jsp");
	}

}
