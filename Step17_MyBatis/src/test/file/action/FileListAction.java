package test.file.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;
import test.file.dao.FileDao;
import test.file.dto.FileDto;
/*
 *  파일 목록을 출력해주는 액션
 */
public class FileListAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//1. 파일 목록을 불러와서
		List<FileDto> list=FileDao.getInstance().getList();
		//2. request 에 담고
		request.setAttribute("list", list);
		//3. view 페이지로 forward 이동
		return new ActionForward("/views/file/list.jsp");
	}

}
















