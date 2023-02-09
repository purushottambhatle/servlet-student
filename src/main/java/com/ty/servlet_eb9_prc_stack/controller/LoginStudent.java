package com.ty.servlet_eb9_prc_stack.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.servlet_eb9_prc_stack.dao.Studentdao;

public class LoginStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Studentdao dao=new Studentdao();
		String password1=dao.getLogin(email);
		if(password1.equals(password)) {
			resp.sendRedirect("https://stackoverflow.com/");
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("login.html");
			requestDispatcher.forward(req, resp);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

}
