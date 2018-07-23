package test.controller;

import test.action.HomeAction;
import test.member.action.MemberDeleteAction;
import test.member.action.MemberInsertAction;
import test.member.action.MemberInsertformAction;
import test.member.action.MemberListAction;
import test.member.action.MemberUpdateAction;
import test.member.action.MemberUpdateformAction;
import test.users.action.CheckIdAction;
import test.users.action.LoginAction;
import test.users.action.LoginFormAction;
import test.users.action.LogoutAction;
import test.users.action.SignupAction;
import test.users.action.SignupFormAction;
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
			action=new SignupFormAction();
		}else if(command.equals("/users/checkid")) {
			action=new CheckIdAction();
		}else if(command.equals("/users/signup")) {
			action=new SignupAction();
		}else if(command.equals("/users/loginform")) {
			action=new LoginFormAction();
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
		}
		
		return action;
	}
}







