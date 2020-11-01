package com.libraryservice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.libraryservice.DAO.LoginDAOimpl;

public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String name = req.getParameter("name");
		String pass = req.getParameter("password");
		
		LoginDAOimpl li = new LoginDAOimpl();
		String user = li.getUser(name, pass);
		if(user.equals(name)) {
			HttpSession session = req.getSession();
			session.setAttribute("libname", user);
			RequestDispatcher rd = req.getRequestDispatcher("book");
			rd.forward(req, res);
		} else {
			
		}
	}
}
