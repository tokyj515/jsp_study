package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;



@WebServlet("/add")
public class Add extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//�Է������ ���� �ڵ�(�ѱ� �ȱ�����)
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		
		//PrintWriter out = response.getWriter();
		
		
		String x_ =request.getParameter("x");
		String y_ =request.getParameter("y");

		
		//�⺻��
		int x = 0; 
		int y = 0;
		
		//���ڿ� ������ üũ
		if(!x_.equals("")) x = Integer.parseInt(x_);
		if(!y_.equals("")) y = Integer.parseInt(y_);
		
		
		int result = x+y;
		
		
		response.getWriter().printf("result is %d\n", result);		
		
		
	}
}









