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
		
		//입력출력을 위한 코드(한글 안깨지게)
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		
		//PrintWriter out = response.getWriter();
		
		
		String x_ =request.getParameter("x");
		String y_ =request.getParameter("y");

		
		//기본값
		int x = 0; 
		int y = 0;
		
		//빈문자열 오는지 체크
		if(!x_.equals("")) x = Integer.parseInt(x_);
		if(!y_.equals("")) y = Integer.parseInt(y_);
		
		
		int result = x+y;
		
		
		response.getWriter().printf("result is %d\n", result);		
		
		
	}
}









