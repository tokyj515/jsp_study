package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//톰캣이 실행될 때마다 한번씩
		//그 뒤로 요청이 있을 때마다 한번씩 실행
		
		
		request.setCharacterEncoding("UTF-8"); //필터가 오기 전에
		//System.out.println("before filter");
		chain.doFilter(request, response);
		//System.out.println("after filter");
	}

}
