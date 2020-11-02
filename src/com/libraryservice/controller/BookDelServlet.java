package com.libraryservice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libraryservice.DAO.BookDAOimpl;

@WebServlet(value="/bookdel")
public class BookDelServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			String delname = req.getParameter("deltitle");
		if(delname.length() > 0) {
			BookDAOimpl bd = new BookDAOimpl();
			bd.deleteBook(delname.toLowerCase());
			System.out.print("Book Deleted");
			RequestDispatcher rd = req.getRequestDispatcher("/bookdel.jsp");
			rd.forward(req, res);
		}
	}
}
