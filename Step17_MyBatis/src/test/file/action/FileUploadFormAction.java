package test.file.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.controller.Action;
import test.controller.ActionForward;

public class FileUploadFormAction extends Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		return new ActionForward("/views/file/upload_form.jsp");
	}
	
}









