package test.file.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.file.dto.FileDto;
import test.member.dto.MemberDto;
import test.mybatis.SqlMapConfig;
import test.users.dto.UsersDto;

public class FileDao {
	private static FileDao dao;
	private static SqlSessionFactory factory;
	private FileDao() {}
	public static FileDao getInstance() {
		if(dao==null) {
			dao=new FileDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	//인자로 전달하는 파일정보를 db에서 삭제하는 메소드
	public boolean delete(int num) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.delete("file.delete", num);
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
	
	
	public boolean addDownCount(int num) {
		SqlSession session = null;
		int flag = 0;
		try {
			//auto commit 되는 SqlSession 객체의 참조값 얻어오기 
			session = factory.openSession(true);
			flag=session.update("file.addDownCount", num);
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
	
	//파일 하나의 정보를 리턴해주는 메소드
	public FileDto getData(int num) {
		SqlSession session=null;
		FileDto dto=null;
		try {
			session=factory.openSession();
			//목록 하나일때 selectOne, 여러개일때 selectList
			dto=session.selectOne("file.getData", num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}
	
	//파일 정보를 저장하는 메소드
	public boolean insert(FileDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.insert("file.insert", dto);
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
	//파일 목록을 리턴 하는 메소드
	public List<FileDto> getList(FileDto dto){
		SqlSession session=null;
		List<FileDto> list=null;
		try {
			session=factory.openSession();
			/*.selectList()인 경우에는
			 * resultType:List의 Generic type이다.
			 * */
			list=session.selectList("file.getList",dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	} //getList()
	
	//전체 row의 갯수를 리턴하는 메소드
	public int getCount() {
		SqlSession session=null;
		int count=0;
		try {
			session=factory.openSession();
			count=session.selectOne("file.getCount");
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
		}
		return count;
	}
}
