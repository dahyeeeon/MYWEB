package test.gallery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import test.file.dto.FileDto;
import test.gallery.dto.GalleryDto;
import test.member.dto.MemberDto;
import test.mybatis.SqlMapConfig;


public class GalleryDao {
	private static GalleryDao dao;
	private static SqlSessionFactory factory;
	private GalleryDao() {}
	public static GalleryDao getInstance() {
		if(dao==null) {
			dao=new GalleryDao();
			factory=SqlMapConfig.getSqlSession();
		}
		return dao;
	}
	public boolean insert(GalleryDto dto) {
		// DB 에 작업을 할 SqlSession 객체를 담을 지역 변수 만들기
				SqlSession session = null;
				int flag = 0;
				try {
					// .openSession(auto commit 여부) 
					session = factory.openSession(true);
					// .insert("mapper이름.sql아이디, 파라미터 )
					flag=session.insert("gallery.insert", dto);
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
	public List<GalleryDto> getList(){
		SqlSession session=null;
		List<GalleryDto> list=null;
		try {
			session=factory.openSession();
			/*
			 *  Mapper namespace : member
			 *  sql id : getList
			 *  parameterType: X
			 *  resultType : MemberDto
			 */
			list=session.selectList("gallery.list");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
}
