package test.file.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;

public class FiledownloadAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		 int num=Integer.parseInt(request.getParameter("num"));
		   //DB에서 해당 파일 정보를 얻어온다음
		   FileDto dto =FileDao.getInstance().getData(num);
		   request.setAttribute("dto", dto);
		   //view페이지로 forward
		return new ActionForward("/views/file/download.jsp");
	}

}
