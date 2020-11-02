package com.libraryservice.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public String bookChecker(String title) {
		CreateConnect cc = new CreateConnect();
		Connection con = cc.makeConnection();
		String check = "";
		try {
			PreparedStatement pre = con.prepareStatement("select checked from books where title = ?");
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals("no")) {
					check = "yes";
				} else {
					check = "no";
				}
			}
			if(check.equals("yes")) {
				PreparedStatement yes = con.prepareStatement("update books set checked = 'yes' where title = ?");
				yes.setString(1, title);
				yes.executeUpdate();
			} else {
				PreparedStatement no = con.prepareStatement("update books set checked = 'no' where title = ?");
				no.setString(1, title);
				no.executeUpdate();
			}
			
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
		return check;
	}
}
