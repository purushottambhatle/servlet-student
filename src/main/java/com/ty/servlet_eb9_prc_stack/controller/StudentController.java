package com.ty.servlet_eb9_prc_stack.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.servlet_eb9_prc_stack.dao.Studentdao;
import com.ty.servlet_eb9_prc_stack.dto.Student;

public class StudentController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String fname=req.getParameter("fname");
		String mname=req.getParameter("mname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		//String school=req.getParameter("school");
		//double fee=Double.parseDouble(req.getParameter("fee"));
		
		Student student=new Student();
		student.setName(mname);
		student.setFname(fname);
		student.setMname(mname);
		student.setEmail(email);
		student.setPassword(password);
		
		ServletContext servletContext=getServletContext();
		String school=servletContext.getInitParameter("school");
		
		ServletConfig servletConfig=getServletConfig();
		double fees=Double.parseDouble(servletConfig.getInitParameter("fess"));
		
//		student.setSchool(school);
//		student.setFee(fee);
		
		Studentdao dao=new Studentdao();
		dao.saveStudent(student);
		PrintWriter out=resp.getWriter();
		out.print("sucessfully saved");
		RequestDispatcher requestDispatcher=req.getRequestDispatcher("sucessfullysubmitted.html");
		requestDispatcher.forward(req, resp);
	}

}
