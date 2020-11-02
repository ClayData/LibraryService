package com.libraryservice.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.libraryservice.DAO.RegistrationDAOImpl;

public class ViewServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		RegistrationDAOImpl rd = new RegistrationDAOImpl();
		String libs = rd.getLibrarians();
		String[] libarr = libs.split(";");
		for(String librarian : libarr) {
			out.print("<p>" +librarian+"</p>");
		}
	}
}
