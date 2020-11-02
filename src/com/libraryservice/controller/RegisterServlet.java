package com.libraryservice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libraryservice.DAO.RegistrationDAOImpl;
import com.libraryservice.model.RegistrationModel;

@WebServlet(value="/register")
public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String name = req.getParameter("username");
		String pass = req.getParameter("pass");
		
		if(name != null && pass != null) { 
		RegistrationModel rm = new RegistrationModel(name.toLowerCase(), pass.toLowerCase(), "yes", "no");
		RegistrationDAOImpl rd = new RegistrationDAOImpl();
		rd.saveData(rm);
		System.out.println("add user");
		RequestDispatcher rq = req.getRequestDispatcher("/register.jsp");
		rq.forward(req, res);
		}
	}
}
