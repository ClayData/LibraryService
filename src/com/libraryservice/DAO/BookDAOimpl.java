package com.libraryservice.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAOimpl {
	
	public void addBook(String title, String author) {
		CreateConnect cc = new CreateConnect();
		Connection con = cc.makeConnection();
		
		try {
			PreparedStatement pre = con.prepareStatement("insert into books values(?, ?, ?)");
			pre.setString(1, title.toLowerCase());
			pre.setString(2, author.toLowerCase());
			pre.setString(3, "in");
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void deleteBook(String title) {
		CreateConnect cc = new CreateConnect();
		Connection con = cc.makeConnection();
		
		try {
			PreparedStatement pre = con.prepareStatement("delete from books where title = ?");
			pre.setString(1, title.toLowerCase());
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
