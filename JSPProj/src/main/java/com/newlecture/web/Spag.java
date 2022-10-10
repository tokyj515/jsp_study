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
		
		//MVC model2���: ��Ʈ�ѷ��� ��� �и�
		
		int num = 0;
		String _num = request.getParameter("n");
		if(_num != null && !_num.equals(""))
			num = Integer.parseInt(_num);
		
		String result;
		if(num % 2 != 0){
			result = "Ȧ��";
		}
		else{
			result = "¦��";
		}
		request.setAttribute("result", result);
		
		
		//�迭 EL ��� Ȯ���� ���� �迭
		String[] names = {"newlec", "dragon"};
		request.setAttribute("names", names);
		
		//Map
		Map<String, Object> notice = new HashMap<String, Object>();
		notice.put("id", 1);
		notice.put("title", "EL�� ���ƿ�");
		request.setAttribute("notice", notice);
		
		
		
		
		
		
		
		
		
		
		
		//forwading:�����۾��� ������ �̾���� �ϴ� ��
		//redirect: �̾ ���� �ƴ� ���ο� ���� �����̷�Ʈ
		
		RequestDispatcher dispatcher                    //spag.jsp: jsp���������� ��������
			= request.getRequestDispatcher("spag.jsp"); //url������ ���� ���丮 ���̶� ���ϸ���
		dispatcher.forward(request, response); //���� �۾��� ������ ����
	}
	
}








