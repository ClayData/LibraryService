package com.libraryservice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.libraryservice.DAO.BookDAOimpl;

@WebServlet(value="/book")
public class BookServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		
		HttpSession session = req.getSession();
		String libname = (String) session.getAttribute("libname");
		
		String addname = req.getParameter("addname");
		String author = req.getParameter("author");
		if(addname.length() > 0 && author.length() > 0) {
			BookDAOimpl bd = new BookDAOimpl();
			bd.addBook(addname, author);
			out.print("Book Added");
		} 
		String delname = req.getParameter("deltitle");
		if(delname.length() > 0) {
			BookDAOimpl bd = new BookDAOimpl();
			bd.deleteBook(delname);
		}
	}
}
