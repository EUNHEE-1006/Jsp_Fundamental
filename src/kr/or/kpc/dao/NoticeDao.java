package kr.or.kpc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.kpc.dto.NoticeDto;
import kr.or.kpc.util.ConnLocator;

public class NoticeDao {
	public static NoticeDao dao;
	private NoticeDao() {}
	public static NoticeDao getInstance() {
		if(dao ==null) {
			dao = new NoticeDao();
		}
		return dao;
	}
	public int insert(NoticeDto dto) {
		int resultCount = 0;

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = ConnLocator.getConnect();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO (noticen_num, n_writer, n_title, n_content, n_regdate) ");
			sql.append("VALUES(?,?,?,?, NOW()) ");
			
			pstm = con.prepareStatement(sql.toString());
			
			int index = 0;
			pstm.setInt(++index, dto.getNum());
			pstm.setString(++index, dto.getTitle());
			pstm.setString(++index, dto.getWriter());
			pstm.setString(++index, dto.getContent());

			resultCount = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultCount;
	}
	public int update(NoticeDto dto) {
		int resultCount = 0;

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = ConnLocator.getConnect();
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE notice ");
			sql.append("SET n_writer=?, n_title=?,n_content=?, n_regdate = NOW() ");
			sql.append("WHERE n_num =? ");
			
			pstm = con.prepareStatement(sql.toString());

			int index = 0;
			pstm.setString(++index, dto.getWriter());
			pstm.setString(++index, dto.getTitle());
			pstm.setString(++index, dto.getContent());
			pstm.setInt(++index, dto.getNum());

			resultCount = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultCount;
	}
	public int delete(int num) {
		int resultCount = 0;

		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = ConnLocator.getConnect();
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM notice ");
			sql.append("WHERE n_num=? ");
			
			pstm = con.prepareStatement(sql.toString());
			
			int index = 0;
			pstm.setInt(++index, num);
			resultCount = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultCount;
	}

	public ArrayList<NoticeDto> select(int start, int len){
		ArrayList<NoticeDto> list = new ArrayList<NoticeDto>();

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = ConnLocator.getConnect();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT n_num, n_writer, n_title, n_content,DATE_FORMAT(n_regdate, '%Y.%m.%d %h:%i') ");
			sql.append("FROM notice ");
			sql.append("ORDER BY n_num DESC ");
			sql.append("LIMIT ?, ? ");

			pstm = con.prepareStatement(sql.toString());
			
			rs = pstm.executeQuery();
			int index = 0;
			pstm.setInt(++index, start);
			pstm.setInt(++index, len);
			

			while (rs.next()) {
				index =0;
				int num = rs.getInt(++index);
				String writer = rs.getString(++index);
				String title = rs.getString(++index);
				String content = rs.getString(++index);
				String regdate = rs.getString(++index);

				list.add(new NoticeDto(num, writer, title, content, regdate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
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
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = ConnLocator.getConnect();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT n_num, n_writer, n_title, n_content, DATE_FORMAT(n_regdate, '%Y.%m.%d %h:%i') ");
			sql.append("FROM notice ");
			sql.append("WHERE n_num = ? ");

			pstm = con.prepareStatement(sql.toString());
			int index =0;
			pstm.setInt(++index, num);
			rs = pstm.executeQuery();

			if (rs.next()) {
				index = 0;
				int _num = rs.getInt(++index);
				String writer = rs.getString(++index);
				String title = rs.getString(++index);
				String content = rs.getString(++index);
				String regdate = rs.getString(++index);
				
				dto = new NoticeDto(_num, writer, title, content, regdate);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	
}
