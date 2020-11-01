package com.libraryservice.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAOimpl {
	
	public String getUser(String name, String password) {
		CreateConnect cc = new CreateConnect();
		Connection con = cc.makeConnection();
		String resname = "";
		try {
//			con.setAutoCommit(false);
			
			PreparedStatement pre = con.prepareStatement("select book_priv from users where name = ? AND password = ?");
			pre.setString(1, name);
			pre.setString(2, password);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				resname = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resname;
	}
	
	public static void main(String[] args) {
		LoginDAOimpl li = new LoginDAOimpl();
		String name = "clay_admin";
		String p = "admin";
		String ret = li.getUser(name.toLowerCase(), p.toLowerCase());
		System.out.println(ret);
	}
}
