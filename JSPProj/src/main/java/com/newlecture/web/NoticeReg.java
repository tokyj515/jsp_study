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
		
		//�Է������ ���� �ڵ�(�ѱ� �ȱ�����)
		resp.setCharacterEncoding("UTF-8"); 
		resp.setContentType("text/html; charset=UTF-8");
		//req.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
		
		
		
		
		//reg.html�� ���� �Ѿ���� Ű��: title, content
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		
		out.println(title);
		out.println(content);
		
		
		
		
	}
}





