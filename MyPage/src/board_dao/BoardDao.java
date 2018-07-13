package board_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board_dto.BoardDto;
import test.util.DbcpBean;
import user.dto.UsersDto;

public class BoardDao {
	private static BoardDao dao;
	private BoardDao() {}
	public static BoardDao getInstance() {
		if(dao==null) {
			dao=new BoardDao();
		}
		return dao;
	}
	public boolean update(BoardDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DbcpBean().getConn();
			//실행할 sql 문 작성하기
			String sql = "UPDATE my_board "
					+ " SET title=?,content=?"
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용 결정하기 
			
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getNum());
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
	
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DbcpBean().getConn();
			//실행할 sql 문 작성하기
			String sql = "DELETE FROM my_board "
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			//? 에 바인딩할 내용 결정하기 
			pstmt.setInt(1, num);
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
	
	
	public BoardDto getData(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//select 된 결과를 담을 지역변수 만들기 
		BoardDto dto=null;
		try {
			conn = new DbcpBean().getConn();
			//실행할 select 문 
			String sql = "SELECT num,writer,title,content,"
					+ "TO_CHAR(regdate,'YYYY.MM.DD AM HH:MI') regdate"
					+ " FROM my_board"
					+ " WHERE num=?";
			pstmt = conn.prepareStatement(sql);
			//? 에 값 바인딩 
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet 에 있는 내용 추출 
			while (rs.next()) {
				dto=new BoardDto();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
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
		//BoardDto 객체 리턴해주기 
		return dto;
	}
	
	public boolean insert(BoardDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			//Connection Pool 로 부터 Connection 객체 가져오기 
			conn=new DbcpBean().getConn();
			String sql="INSERT INTO my_board"
					+ " (num,writer,title,content,regdate)"
					+ " VALUES(board_guest_seq.NEXTVAL,?,?,?,SYSDATE)";
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩하기 
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			// insert 문 수행하고 추가된 row 의 갯수 리턴 받기 
			flag=pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				// Connection Pool 에 Connection 객체 반납하기 
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(flag>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<BoardDto> getList(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//select 된 결과를 담을 지역변수 만들기 
		List<BoardDto> list=new ArrayList<>();
		try {
			conn = new DbcpBean().getConn();
			//실행할 select 문 
			String sql = "SELECT num,writer,title,content,"
					+ "TO_CHAR(regdate,'YYYY.MM.DD AM HH:MI') regdate"
					+ " FROM my_board"
					+ " ORDER BY num DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet 에 있는 내용 추출 
			while (rs.next()) {
				//BoardDto 객체를 생성해서 
				BoardDto dto=new BoardDto();
				//ResultSet 에 있는 글 하나의 정보를 담는다.
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				//ArrayList 객체에 BoardDto 객체 누적 시키기 
				list.add(dto);
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
		//글목록이 담겨 있는 ArrayList 객체 리턴해 주기 
		return list;
	}
}
