package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;



@WebServlet("/hi")
public class Nana extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
		//�ѱ� �� ������ �ϴ� ���
		resp.setCharacterEncoding("UTF-8"); //����ڰ� ������ ���ڵ����
		resp.setContentType("text/html; charset=UTF-8");
		
		
		
		PrintWriter out = resp.getWriter();
		
		String cnt_ = req.getParameter("cnt");
		
		int cnt = 100;
		if(cnt_ !=null && !cnt_.equals("")) {
			cnt = Integer.parseInt(cnt_);
		}
		
		
		
		
		
		
		for(int i=0; i<cnt; i++) {
			//out.println(i+1+": Hello Servlet");
			out.println(i+1+": �ȳ� Servlet <br>");
		}
	}
}





