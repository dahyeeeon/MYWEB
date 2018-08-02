package test.controller;

import test.action.HomeAction;
import test.cafe.action.CafeCommentInsertAction;
import test.cafe.action.CafeDelete2Action;
import test.cafe.action.CafeDeleteAction;
import test.cafe.action.CafeDetailAction;
import test.cafe.action.CafeInsertAction;
import test.cafe.action.CafeInsertformAction;
import test.cafe.action.CafeListAction;
import test.cafe.action.CafeUpdateAction;
import test.cafe.action.CafeUpdateCommentFormAction;
import test.cafe.action.CafeUpdateformAction;
import test.file.action.FileDeleteAction;
import test.file.action.FileListAction;
import test.file.action.FileUploadAction;
import test.file.action.FileUploadFormAction;
import test.file.action.FiledownloadAction;
import test.gallery.action.GalleryListAction;
import test.gallery.action.GalleryUploadAction;
import test.gallery.action.GalleryUpload_FormAction;
import test.member.action.MemberDeleteAction;
import test.member.action.MemberInsertAction;
import test.member.action.MemberInsertformAction;
import test.member.action.MemberListAction;
import test.member.action.MemberUpdateAction;
import test.member.action.MemberUpdateformAction;
import test.users.action.CheckIdAction;
import test.users.action.LoginAction;
import test.users.action.LoginformAction;
import test.users.action.LogoutAction;
import test.users.action.SignupAction;
import test.users.action.SignupformAction;
import test.users.action.UsersDeleteAction;
import test.users.action.UsersInfoAction;
import test.users.action.UsersUpdateAction;
import test.users.action.UsersUpdateFormAction;

public class UserActionFactory {
	private static UserActionFactory factory;
	private UserActionFactory(){}
	//자신의 참조값을 리턴해주는 메소드
	public static UserActionFactory getInstance(){
		if(factory==null){
			factory=new UserActionFactory();
		}
		return factory;
	}
	
	//인자로 전달되는 command 를 수행할 Action type 객체를 리턴해주는 
	//메소드
	public Action action(String command){
		//Action 추상클래스 type 을 담을 지역변수 만들기 
		Action action=null;
		if(command.equals("/home")) {
			//홈 요청 처리 
			action=new HomeAction();
		}else if(command.equals("/member/list")) {
			//회원 목록 요청 처리 
			action=new MemberListAction();
		}else if(command.equals("/member/insertform")) {
			//회원 추가 폼 요청 처리 
			action=new MemberInsertformAction();
		}else if(command.equals("/member/insert")) {
			//회원 추가 요청 처리 
			action=new MemberInsertAction();
		}else if(command.equals("/member/delete")) {
			//회원 삭제 요청 처리
			action=new MemberDeleteAction();
		}else if(command.equals("/member/updateform")) {
			//회원 수정 폼 요청 처리
			action=new MemberUpdateformAction();
		}else if(command.equals("/member/update")) {
			//회원 정보 수정 반영 요청 처리
			action=new MemberUpdateAction();
		}else if(command.equals("/users/signup_form")) {
			action=new SignupformAction();
		}else if(command.equals("/users/checkid")) {
			action=new CheckIdAction();
		}else if(command.equals("/users/signup")) {
			action=new SignupAction();
		}else if(command.equals("/users/loginform")) {
			action=new LoginformAction();
		}else if(command.equals("/users/login")) {
			action=new LoginAction();
		}else if(command.equals("/users/logout")) {
			action=new LogoutAction();
		}else if(command.equals("/users/private/info")) {
			action=new UsersInfoAction();
		}else if(command.equals("/users/private/updateform")) {
			action=new UsersUpdateFormAction();
		}else if(command.equals("/users/private/update")) {
			action=new UsersUpdateAction();
		}else if(command.equals("/users/private/delete")) {
			action=new UsersDeleteAction();
		}else if(command.equals("/file/list")) {
			action=new FileListAction();
		}else if(command.equals("/file/private/upload_form")) {
			action=new FileUploadFormAction();
		}else if(command.equals("/file/private/upload")) {
			action=new FileUploadAction();
		}else if(command.equals("/file/download")) {
			action=new FiledownloadAction();
		}else if(command.equals("/file/private/delete")) {
			action=new FileDeleteAction();
		}else if(command.equals("/cafe/list")) {
			action=new CafeListAction();
		}else if(command.equals("/cafe/private/insertform")) {
			action=new CafeInsertformAction();
		}else if(command.equals("/cafe/private/insert")) {
			action=new CafeInsertAction();
		}else if(command.equals("/cafe/detail")) {
			action=new CafeDetailAction();
		}else if(command.equals("/cafe/private/delete")) {
			action=new CafeDeleteAction();
		}else if(command.equals("/cafe/private/updateform")) {
			action=new CafeUpdateformAction();
		}else if(command.equals("/cafe/private/update")) {
			action=new CafeUpdateAction();
		}else if(command.equals("/cafe/comment_insert")) {
			action=new CafeCommentInsertAction();
		}else if(command.equals("/cafe/private/delete2")) {
			action=new CafeDelete2Action();
		}else if(command.equals("/cafe/private/update2")) {
			action=new CafeUpdateCommentFormAction();
		}else if(command.equals("/gallery/private/upload")) {
			action=new GalleryUploadAction();
		}else if(command.equals("/gallery/private/upload_form")) {
			action=new GalleryUpload_FormAction();
		}else if(command.equals("/gallery/list")) {
			action=new GalleryListAction();
		}
		
		return action;
	}
}







