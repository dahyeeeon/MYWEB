package user.dao;

import user.dto.UsersDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import test.util.DbcpBean;
import user.dao.UsersDao;

public class UsersDao {
	private static UsersDao dao;
	private UsersDao() {}
	public static UsersDao getInstance() {
		if(dao==null) {
			dao=new UsersDao();
		}
		
		return dao;
	}
	
	public UsersDto getData(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//select 된 결과를 담을 지역변수 만들기
		UsersDto dto=null;
		try {
			conn = new DbcpBean().getConn();
			//실행할 select 문
			String sql = "select pwd,name,phone from my_user where id=?";
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			//select 된 결과가 있다면 ResultSet에 있는 내용 추출
			if (rs.next()) {
				dto=new UsersDto();
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		//회원 한명의 정보가 담겨 있는 UsersDto 객체 리턴해주기
		return dto;
	}
	
	public boolean delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DbcpBean().getConn();
			//실행할 sql 문 작성하기
			String sql = "delete from my_user where id=?";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용 결정하기 
			pstmt.setString(1,id);
			flag = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//회원가입
	public boolean insert(UsersDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DbcpBean().getConn();
			//실행할 sql 문 작성하기
			String sql = "insert into my_user(id,pwd,name,phone,regdate)"
					+ " values(?,?,?,?,SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용 결정하기 
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			flag = pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (flag > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//인자로 전달된 회원정보가 유효한 정보인지 여부를 리턴하는 메소드
	public boolean isValid(UsersDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//select 된 결과를 담을 지역변수 만들기
		boolean isValid=false;
		
		try {
			conn = new DbcpBean().getConn();
			//실행할 select 문
			String sql = "select * from my_user where id=? And pwd=?";
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPwd());

			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet에 있는 내용 추출
			if (rs.next()) {
				//select된 row가 있으면 true
				isValid=true;

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		//아이디,비밀번호의 유효성 여부를 리턴
		return isValid;
	}
	
	//인자로 전달되는 아이디가 사용가능한지 여부를 리턴해주는 메소드
	public boolean canUseId(String inputId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//select 된 결과를 담을 지역변수 만들기
		boolean canUse=true;
		try {
			conn = new DbcpBean().getConn();
			//실행할 select 문
			String sql = "select * from my_user where id=?";
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩
			pstmt.setString(1, inputId);
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet에 있는 내용 추출
			while (rs.next()) {
				//select된 row가 있으면
				//이미 존재하는 아이디 임으로 사용 불가
				canUse=false;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {}
		
		}
		//사용가능 여부를 리턴
		return canUse;
	}
}

