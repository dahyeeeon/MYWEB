package test.gallery.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.gallery.dao.GalleryDao;
import test.gallery.dto.GalleryDto;

public class GalleryListAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		List<GalleryDto> list=GalleryDao.getInstance().getList();
		//컨텍스트 경로
		String cPath=request.getContextPath();
		request.setAttribute("list", list);
		request.setAttribute("cPath", cPath);
		
		return new ActionForward("/views/gallery/list.jsp");
	}

}
