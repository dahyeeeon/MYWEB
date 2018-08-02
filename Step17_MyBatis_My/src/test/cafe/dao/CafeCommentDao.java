package test.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.cafe.dto.CafeCommentDto;
import test.cafe.dto.CafeDto;
import test.mybatis.SqlMapConfig;

public class CafeCommentDao {
	private static CafeCommentDao dao;
	private static SqlSessionFactory factory;
	private CafeCommentDao() {}
	
	public static CafeCommentDao getInstance() {
		if(dao==null) {
			dao=new CafeCommentDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	//댓글 저장하는 메소드
	public boolean insert(CafeCommentDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.insert("cafeComment.insert",dto);
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
	
	//댓글의 글번호를 리턴해주는 메소드
	public int getSequence() {
		SqlSession session = null;
		int num = 0;
		try {
			session=factory.openSession();
			num=session.selectOne("cafeComment.getSequence");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return num;
	}
	
	//댓글 목록을 리턴하는 메소드
	public List<CafeCommentDto> getList(int ref_group){
		SqlSession session = null;
		List<CafeCommentDto> list=null;
		try {
			session = factory.openSession(true);
			list=session.selectList("cafeComment.getList",ref_group);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	public boolean delete(int num) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.delete("cafeComment.delete", num);
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
	public boolean update(CafeCommentDto dto) {
		SqlSession session = null;
		int flag = 0;
		try {
			session = factory.openSession(true);
			flag=session.update("cafeComment.update", dto);
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
	public CafeCommentDto getData(CafeCommentDto dto) {
		SqlSession session=null;
		CafeCommentDto resultDto=null;
		try {
			session=factory.openSession();
			resultDto=session.selectOne("cafeComment.getData", dto);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return resultDto;
	}
}
