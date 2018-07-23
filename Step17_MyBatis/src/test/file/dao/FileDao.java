package test.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import test.file.dto.FileDto;
import test.mybatis.SqlMapConfig;


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
	//인자로 전달하는 파일정보를 DB 에서 삭제하는 메소드
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
	
	//파일 다운로드 횟수를 증가 시키는 메소드
	public boolean addDownCount(int num) {
		SqlSession session = null;
		int flag = 0;
		try {
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
			dto=session.selectOne("file.getData", num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return dto;
	}//getData()
	
	
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
	public List<FileDto> getList(){
		SqlSession session=null;
		List<FileDto> list=null;
		try {
			session=factory.openSession();
			/*
			 *  .selectList() 인 경우에는 
			 *  resultType : List 의 Generic type 이다. 
			 */
			list=session.selectList("file.getList");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}//getList()
}//class






















