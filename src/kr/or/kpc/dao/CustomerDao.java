package kr.or.kpc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.kpc.dto.CustomerDto;
import kr.or.kpc.util.ConnLocator;

public class CustomerDao {
	public static CustomerDao dao;
	private CustomerDao() {}
	public static CustomerDao getInstance() {
		if(dao ==null) {
			dao = new CustomerDao();
		}
		return dao;
	}
	public CustomerDto getLogin(String email, String pwd) {
		CustomerDto dto = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			con = ConnLocator.getConnect();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT c_email, c_pwd, c_name ");
			sql.append("FROM customer ");
			sql.append("WHERE c_email = '?' AND c_pwd=PASSWORD(?) ");

			pstm = con.prepareStatement(sql.toString());
			int index = 0;
			pstm.setString(++index, email);
			pstm.setString(++index, pwd);
			rs = pstm.executeQuery();

			if (rs.next()) {
				index = 0;
				String _email = rs.getString(++index);
				String _pwd = rs.getString(++index);
				String _name = rs.getString(++index);
				dto = new CustomerDto(_email,_pwd,_name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
