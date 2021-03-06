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

import com.libraryservice.DAO.LoginDAOimpl;

@WebServlet(value="/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String name = req.getParameter("name");
		String pass = req.getParameter("password");
		
		LoginDAOimpl li = new LoginDAOimpl();
		String bookpriv = li.getUser(name.toLowerCase(), pass.toLowerCase());
		if(bookpriv.equals("yes")) {
			HttpSession session = req.getSession();
			session.setAttribute("libname", name);
			RequestDispatcher rd = req.getRequestDispatcher("/book.jsp");
			rd.forward(req, res);
			out.print("<h3>" + name + "</h3>");
		} else if (bookpriv.equals("no")){
			System.out.println("going to register...");
			HttpSession session = req.getSession();
			session.setAttribute("adminname", name);
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.forward(req, res);
		} else {
			out.print("Invalid username/password");
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.forward(req, res);
		}
	}
}
