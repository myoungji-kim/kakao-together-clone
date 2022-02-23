package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.member.MemberDTO;


@WebServlet("/LoginSessionFilter")
public class LoginSessionFilter implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		MemberDTO loginDTO = (MemberDTO) session.getAttribute("login");
		if (loginDTO == null) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("/member/sessionInvalidate.jsp");
			return;
		} 
		chain.doFilter(request, response);
	}
	
	public void destroy() {
	}
	
}
