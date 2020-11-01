package com.libraryservice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libraryservice.DAO.RegistrationDAOImpl;
import com.libraryservice.model.RegistrationModel;

public class RegisterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		String name = req.getParameter("name");
		String pass = req.getParameter("password");
		
		RegistrationModel rm = new RegistrationModel(name, pass, "yes", "no");
		RegistrationDAOImpl rd = new RegistrationDAOImpl();
		rd.saveData(rm);
		
	}
}
