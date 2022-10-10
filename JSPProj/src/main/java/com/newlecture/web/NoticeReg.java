package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;



@WebServlet("/notice-reg")
public class NoticeReg extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		//입력출력을 위한 코드(한글 안깨지게)
		resp.setCharacterEncoding("UTF-8"); 
		resp.setContentType("text/html; charset=UTF-8");
		//req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		
		
		
		
		//reg.html로 부터 넘어오는 키값: title, content
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		
		out.println(title);
		out.println(content);
		
		
		
		
	}
}





