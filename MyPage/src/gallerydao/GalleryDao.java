package gallerydao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gallerydto.GalleryDto;
import test.util.DbcpBean;

public class GalleryDao {
	private static GalleryDao dao;
	private GalleryDao() {}
	public static GalleryDao getInstance() {
		if(dao==null) {
			dao=new GalleryDao();
		}
		return dao;
	}
	public List<GalleryDto> getList(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//select 된 결과를 담을 지역변수 만들기
		List<GalleryDto> list=new ArrayList<>();
		try {
			conn = new DbcpBean().getConn();
			//실행할 select 문
			String sql = "select num,writer,caption,imagePath,regdate"
					+ " from my_gallery ";
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩
			
			rs = pstmt.executeQuery();
			//반복문 돌면서 ResultSet에 있는 내용 추출
			while (rs.next()) {
				GalleryDto dto=new GalleryDto();
				dto.setNum(rs.getInt("num"));
				dto.setWriter(rs.getString("writer"));
				dto.setCaption(rs.getString("caption"));
				dto.setImagePath(rs.getString("imagePath"));
				dto.setRegdate(rs.getString("regdate"));
				//List에 누적한다.
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
		return list;
	}
}
