package com.libraryservice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libraryservice.DAO.BookDAOimpl;

public class BookCheckServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			String title = req.getParameter("checkname");
			
			if(title != null) {
			BookDAOimpl bd = new BookDAOimpl();
			String check = bd.bookChecker(title);
			out.print("<p>Is the book checked in " + check + "</p>");
			}
	}
}
