package com.libraryservice.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.libraryservice.model.RegistrationModel;

public class RegistrationDAOImpl {
	
	public void saveData(RegistrationModel obj) {
		CreateConnect cc = new CreateConnect();
		Connection con = cc.makeConnection();
		
		try {
			PreparedStatement pre = con.prepareStatement("insert into users values (?,?,?,?)");
			pre.setString(1, obj.getName());
			pre.setString(2, obj.getPassword());
			pre.setString(3, obj.getBookPriv());
			pre.setString(4, obj.getUserPriv());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
