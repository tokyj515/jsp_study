package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;



@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//�����¸� �����ϱ� ���� ��ü , application, session, cookie
		ServletContext application = request.getServletContext(); //v�� op ����
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		
		
		
		String v_ =request.getParameter("v");
		String op = request.getParameter("operator");

		
		//�⺻��, ���ڿ� ������ üũ
		int v = 0;
		if(!v_.equals("")) 
			v = Integer.parseInt(v_);
		
		
		
		//���
		if(op.equals("=")) {
			int result = 0;
			
			//int x = (Integer)application.getAttribute("value");
			//int x = (Integer)session.getAttribute("value");
			int x = 0;
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}	
			int y = v; //�����Է¹��� ��
			
			//String operator = (String)application.getAttribute("op");
			//String operator = (String)session.getAttribute("op");
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			
			if(operator.equals("+")) { //+, -�� ������ �Ͼ� ȭ�鸸 ������ �ٽ� �ڷΰ��� �� �ٸ� �� �ֱ�
				result = x + y;
			}
			else {
				result = x - y;
			}
			
			out.printf("result is %d\n", result);	
		}
		
		//���� ����
		else {
			//application.setAttribute("value", v); //map
			//application.setAttribute("op", op); //map
			session.setAttribute("value", v); //map
			session.setAttribute("op", op); //map
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v)); //��Ű�� �ݵ�� ���������� ��������
			Cookie opCookie = new Cookie("op", op);
			
			valueCookie.setPath("/calc2");
			valueCookie.setMaxAge(60*60*24); //�ʴ���, �������κ��� ���ᳯ¥
			opCookie.setPath("/calc2");
			
			//Ŭ���̾�Ʈ�� ��Ű�� ������ �� ����
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			//�����̷�Ʈ
			response.sendRedirect("calc2.html");
		}


		
		
	}
}













