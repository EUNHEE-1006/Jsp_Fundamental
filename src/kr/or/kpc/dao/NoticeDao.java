package kr.or.kpc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.kpc.dto.NoticeDto;
import kr.or.kpc.util.ConnLocator;

public class NoticeDao {
	private static NoticeDao dao;
	private NoticeDao() {}

	public static NoticeDao getInstance() {
		if (dao == null) {
			dao = new NoticeDao();
		}
		
		return dao;
	}
	public int insert(NoticeDto dto) {
		int resultCount = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnLocator.getConnect();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO notice(n_num, n_writer, n_title, n_content, n_regdate) ");
			sql.append("VALUES(?,?,?,?,NOW()) ");

			pstmt = con.prepareStatement(sql.toString());

			int index = 0;
			pstmt.setInt(++index, dto.getNum());
			pstmt.setString(++index, dto.getWriter());
			pstmt.setString(++index, dto.getTitle());
			pstmt.setString(++index, dto.getContent());

			resultCount = pstmt.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return resultCount;

	}
	public int update(NoticeDto dto) {
	int resultCount = 0;

	Connection con = null;
	PreparedStatement pstmt = null;

	try {
		con = ConnLocator.getConnect();
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE notice ");
		sql.append("SET n_writer=?, n_title=?, n_content=?, n_regdate= NOW() ");
		sql.append("WHERE n_num = ? ");

		pstmt = con.prepareStatement(sql.toString());

		int index = 0;
		pstmt.setString(++index, dto.getWriter());
		pstmt.setString(++index, dto.getTitle());
		pstmt.setString(++index, dto.getContent());
		pstmt.setInt(++index, dto.getNum());

		resultCount = pstmt.executeUpdate();

	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} finally {
		try {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	return resultCount;

	}
	public int delete(int num) {
		int resultCount = 0;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = ConnLocator.getConnect();
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM notice ");
			sql.append("WHERE n_num = ? ");

			pstmt = con.prepareStatement(sql.toString());

			int index = 0;
			pstmt.setInt(++index, num);

			resultCount = pstmt.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return resultCount;

	}
	public ArrayList<NoticeDto> select(int start, int len){
		
		ArrayList<NoticeDto> list = new ArrayList<NoticeDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ConnLocator.getConnect();

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT n_num, n_writer, n_title, n_content, date_format(n_regdate, '%Y.%m.%d %h:%i') ");
			sql.append("FROM notice ");
			sql.append("ORDER BY n_num DESC ");
			sql.append("LIMIT ?,? ");

			pstmt = con.prepareStatement(sql.toString());

			int index = 0;
			pstmt.setInt(++index, start);
			pstmt.setInt(++index, len);
			

			rs = pstmt.executeQuery();
			while (rs.next()) {
				index = 0;
				int num = rs.getInt(++index);
				String writer = rs.getString(++index);
				String title = rs.getString(++index);
				String content = rs.getString(++index);
				String regdate = rs.getString(++index);

				list.add(new NoticeDto(num,writer,title,content,regdate));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
		
	}
	public NoticeDto select(int num){
		NoticeDto dto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ConnLocator.getConnect();

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT n_num, n_writer, n_title, n_content, date_format(n_regdate, '%Y.%m.%d %h:%i') ");
			sql.append("FROM notice ");
			sql.append("WHERE n_num=? ");

			pstmt = con.prepareStatement(sql.toString());

			int index = 0;
			pstmt.setInt(++index, num);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				index = 0;
				int _num = rs.getInt(++index);
				String writer = rs.getString(++index);
				String title = rs.getString(++index);
				String content = rs.getString(++index);
				String regdate = rs.getString(++index);
				dto = new NoticeDto(_num, writer, title, content, regdate);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return dto;
	}
	public int getRows() {
		int count =0;
		
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		
		try {
			con = ConnLocator.getConnect();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT COUNT(*) FROM notice ");

			
			pstmt = con.prepareStatement(sql.toString());
			
			
			int index=0;			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				index = 0;
				count = rs.getInt(++index);
			
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return count;
	}
	
	public int getMaxNum() {
		int max =0;
		
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		
		try {
			con = ConnLocator.getConnect();
			
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT ifnull(MAX(n_num)+1,1) FROM notice ");

			
			pstmt = con.prepareStatement(sql.toString());
			
			
			int index=0;			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				index = 0;
				max = rs.getInt(++index);
			
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return max;
	}
public String selectJson(int start, int len){
		
	/* 설계필수
	 * {
	 *  "items" : [
	 *  	{"num":1, "writer":"작성자1", "title":"제목1", "regdate":"2020.06.19"},
	 *  	{"num":1, "writer":"작성자1", "title":"제목1", "regdate":"2020.06.19"},
	 *  	{"num":1, "writer":"작성자1", "title":"제목1", "regdate":"2020.06.19"},
	 *  	{"num":1, "writer":"작성자1", "title":"제목1", "regdate":"2020.06.19"},
	 *  	{"num":1, "writer":"작성자1", "title":"제목1", "regdate":"2020.06.19"},
	 *  	........
	 *  	]
	 *  }
	 * <items>
	 * 		<item>
	 * 			<num>1</num>
	 * 			<wirter>작성자1</writer>
	 * 			<regdate>2020.06.19</regdate>
	 * 		</item>
	 * <item>
	 * 			<num></num>
	 * 			<wirter></writer>
	 * 			<regdate></regdate>
	 * 		</item>
	 * <item>
	 * 			<num></num>
	 * 			<wirter></writer>
	 * 			<regdate></regdate>
	 * 		</item>
	 * 	</itmes>
	 * */
		
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = ConnLocator.getConnect();

			StringBuffer sql = new StringBuffer();
			sql.append("SELECT n_num, n_writer, n_title, n_content, date_format(n_regdate, '%Y.%m.%d %h:%i') ");
			sql.append("FROM notice ");
			sql.append("ORDER BY n_num DESC ");
			sql.append("LIMIT ?,? ");

			pstmt = con.prepareStatement(sql.toString());

			int index = 0;
			pstmt.setInt(++index, start);
			pstmt.setInt(++index, len);
			
			rs = pstmt.executeQuery();
			JSONObject obj1= null;
			
			while (rs.next()) {
				index = 0;
				int num = rs.getInt(++index);
				String writer = rs.getString(++index);
				String title = rs.getString(++index);
				String content = rs.getString(++index);
				String regdate = rs.getString(++index);
				obj1 = new JSONObject();
				//통상적으로 숫자도 문자로 넘기는 경우가 많아. 
				//즉 모두 문자로, 실제 json데이터를 보면 숫잔데, 문자열일 경우가 많아.				
				obj1.put("num", String.valueOf(num));
				obj1.put("writer", writer);
				obj1.put("title", title);
				obj1.put("regdate", regdate);
				array.add(obj1);				
			}
			obj.put("itmes", array);
			//속도가 느려지는 웹페이지 부분에서는 ajax를 이용해서 데이터를 가져오면 빨라져
			//웹페이지 로딩하다가 ajax로딩 부분은 무시하고, 나머지를 생성한 후, ajax로딩하기 때문에!!
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return obj.toJSONString();
		
	}
	
}
