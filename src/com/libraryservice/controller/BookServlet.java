package com.libraryservice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		
		String addtitle = req.getParameter("addtitle");
		String author = req.getParameter("author");
		String delname = req.getParameter("deltitle");
		if(addtitle.length() > 0 && author.length() > 0) {
			BookDAOimpl bd = new BookDAOimpl();
			bd.addBook(addtitle.toLowerCase(), author.toLowerCase());
			System.out.print("Book Added");
			RequestDispatcher rd = req.getRequestDispatcher("/book.jsp");
			rd.forward(req, res);
		} 
		
	}
}
