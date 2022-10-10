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
		
		//전상태를 저장하기 위한 객체 , application, session, cookie
		ServletContext application = request.getServletContext(); //v와 op 저장
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		
		
		
		String v_ =request.getParameter("v");
		String op = request.getParameter("operator");

		
		//기본값, 빈문자열 오는지 체크
		int v = 0;
		if(!v_.equals("")) 
			v = Integer.parseInt(v_);
		
		
		
		//계산
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
			int y = v; //현재입력받은 값
			
			//String operator = (String)application.getAttribute("op");
			//String operator = (String)session.getAttribute("op");
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			
			if(operator.equals("+")) { //+, -를 누르면 하얀 화면만 나오고 다시 뒤로가기 후 다른 값 넣기
				result = x + y;
			}
			else {
				result = x - y;
			}
			
			out.printf("result is %d\n", result);	
		}
		
		//값을 저장
		else {
			//application.setAttribute("value", v); //map
			//application.setAttribute("op", op); //map
			session.setAttribute("value", v); //map
			session.setAttribute("op", op); //map
			
			Cookie valueCookie = new Cookie("value", String.valueOf(v)); //쿠키는 반드시 문자형으로 보내야함
			Cookie opCookie = new Cookie("op", op);
			
			valueCookie.setPath("/calc2");
			valueCookie.setMaxAge(60*60*24); //초단위, 지금으로부터 만료날짜
			opCookie.setPath("/calc2");
			
			//클라이언트의 쿠키에 보내기 및 저장
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			
			//리다이렉트
			response.sendRedirect("calc2.html");
		}


		
		
	}
}













