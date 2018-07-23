package test.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import test.mybatis.SqlMapConfig;
import test.users.dto.UsersDto;

public class UsersDao {
	private static UsersDao dao;
	private static SqlSessionFactory factory;
	private UsersDao() {}
	//UsersDao 객체의 참조값을 리턴해주는 static 메소드 
	public static UsersDao getInstance() {
		if(dao==null) {
			dao=new UsersDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	//인자로 전달되는 아이디가 사용가능한지 여부를 리턴해주는 메소드
	public boolean canUseId(String inputId) {
		SqlSession session=null;
		String result=null;
		try {
			//SqlSession 객체의 참조값 얻어오기 
			session=factory.openSession();
			result=session.selectOne("users.isExist", inputId);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		if(result==null) {// select 된 결과가 없으면 사용가능 
			return true;
		}else {
			return false;
		}
	}
	
	//회원 정보를 수정하는 메소드
	public boolean update(UsersDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			//auto commit 되는 SqlSession 객체의 참조값 얻어오기 
			session = factory.openSession(true);
			flag=session.update("users.update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//회원 한명의 정보 삭제하기
	public boolean delete(String id) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.delete("users.delete", id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//회원 한명의 정보를 리턴하는 메소드
	public UsersDto getData(String id) {
		SqlSession session=null;
		UsersDto dto=null;
		try {
			session=factory.openSession();
			/*
			 * Mapper namespace : users
			 * sql id : getData
			 * parameterType : string
			 * resultType : test.users.dto.UsersDto 
			 * 
			 * select 된 row 가 하나인 경우는 .selectOne()
			 * select 된 row 가 여러개인 경우는 .selectList()
			 */
			dto=session.selectOne("users.getData", id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}
	
	//인자로 전달된 회원정보가 유효한 정보인지 여부를 리턴하는 메소드
	public boolean isValid(UsersDto dto) {
		SqlSession session=null;
		String result=null;
		try {
			session=factory.openSession();
			// dto 에 담긴 아이디 비밀번호가 유효한 정보이면 
			// result 가 null 이 아니다. 
			result=session.selectOne("users.isValid", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		if(result==null) {
			return false;
		}else {
			return true;
		}
	}
	
	//회원정보를 DB 에 저장하는 메소드
	public boolean insert(UsersDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.insert("users.insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}























