package kr.or.kpc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import kr.or.kpc.dto.MemberDto;
import kr.or.kpc.util.ConnLocator;

//웹에서의 DB연결!!!
public class MemberDao {
	
	public static MemberDao dao;
	private MemberDao() {}
	public static MemberDao getInstance() {
		if(dao ==null) {
			dao = new MemberDao();
		}
		return dao;
	}
	
	public int insert(MemberDto mdto) {
		int resultCount = 0;

		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
		
			con = ConnLocator.getConnect();
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO member(num, NAME, addr) VALUES(?,?,?)");

			pstm = con.prepareStatement(sql.toString());
			int index = 0;
			pstm.setInt(++index, mdto.getNum());
			pstm.setString(++index, mdto.getName());
			pstm.setString(++index, mdto.getAddr());

			resultCount = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				//Connection 자원을 반납한다. 
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultCount;
		
		
	}

	public int update(MemberDto mdto) {
		int resultCount = 0;
		// alt + shift + z ==>블록처리 후 try catch
		
		Connection con = null;
		PreparedStatement pstm = null;

		try {
			con = ConnLocator.getConnect();
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE member ");
			sql.append("set name = ?, addr = ? ");
			sql.append("WHERE num = ?");

			pstm = con.prepareStatement(sql.toString());
			int index = 0;
			pstm.setString(++index, mdto.getName());
			pstm.setString(++index, mdto.getAddr());
			pstm.setInt(++index, mdto.getNum());

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
			sql.append("DELETE FROM member ");
			sql.append("WHERE num = ?");

			pstm = con.prepareStatement(sql.toString());
			pstm.setInt(1, num);
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

	public ArrayList<MemberDto> select() {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();

		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = ConnLocator.getConnect();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT num, NAME, addr ");
			sql.append("FROM member ");
			sql.append("ORDER BY num DESC ");

			pstm = con.prepareStatement(sql.toString());
			rs = pstm.executeQuery();

			while (rs.next()) {
				int index = 0;
				int num = rs.getInt(++index);
				String name = rs.getString(++index);
				String addr = rs.getString(++index);
				list.add(new MemberDto(num, name, addr)); // 중요!!!!!!
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

	public MemberDto select(int num) {
		MemberDto dto = null;
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = ConnLocator.getConnect();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT num, NAME, addr ");
			sql.append("FROM member ");
			sql.append("WHERE num = ?");

			pstm = con.prepareStatement(sql.toString());
			pstm.setInt(1, num);
			rs = pstm.executeQuery();

			if (rs.next()) {
				int index = 0;
				int _num = (rs.getInt(++index));
				String _name = (rs.getString(++index));
				String _addr = (rs.getString(++index));
				dto = new MemberDto(_num, _name, _addr);
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
		return dto;
	}

}

