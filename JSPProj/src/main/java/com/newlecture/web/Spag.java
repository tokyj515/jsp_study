package com.newlecture.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/spag")
public class Spag extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//MVC model2방식: 컨트롤러와 뷰로 분리
		
		int num = 0;
		String _num = request.getParameter("n");
		if(_num != null && !_num.equals(""))
			num = Integer.parseInt(_num);
		
		String result;
		if(num % 2 != 0){
			result = "홀수";
		}
		else{
			result = "짝수";
		}
		request.setAttribute("result", result);
		
		
		//배열 EL 결과 확인을 위한 배열
		String[] names = {"newlec", "dragon"};
		request.setAttribute("names", names);
		
		//Map
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL은 좋아요");
		request.setAttribute("notice", notice);
		
		
		
		
		
		
		
		
		
		
		
		//forwading:현재작업한 내용을 이어가도록 하는 것
		//redirect: 이어간 것이 아닌 새로운 것은 리다이렉트
		
		RequestDispatcher dispatcher                    //spag.jsp: jsp파일이지만 서블릿임
			= request.getRequestDispatcher("spag.jsp"); //url상으로 같은 디렉토리 안이라 파일명만
		dispatcher.forward(request, response); //현재 작업한 내용을 공유
	}
	
}









