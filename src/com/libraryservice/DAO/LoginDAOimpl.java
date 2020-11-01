package com.libraryservice.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAOimpl {
	
	public String getUser(String name, String password) {
		CreateConnect cc = new CreateConnect();
		Connection con = cc.makeConnection();
		String resname = "";
		try {
			PreparedStatement pre = con.prepareStatement("select name from users where name = ? AND password = ?");
			pre.setString(1, name);
			pre.setString(2, password);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				resname = rs.getNString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cc.closeConnection(con);
		}
		return resname;
	}
}
