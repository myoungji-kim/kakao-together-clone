package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.board.BoardService;
import com.service.board.BoardServiceImpl;

@WebServlet("/del.action")
public class DeleteActionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "";
		String idx = request.getParameter("idx");
		String cate = request.getParameter("cate"); // fund or prom
		System.out.println("cate:::"+cate);
		BoardService service = new BoardServiceImpl();
		
		try {
			int num = service.deleteOne(Integer.parseInt(idx));
			
			if (cate.equals("fund")) next = "/fundraising/deleteSuccess.jsp";
			else if (cate.equals("prom")) next = "/promotion/deleteSuccess.jsp";
		} catch (Exception e) {
			next = "/Error500";
			e.printStackTrace();
		}
		
		
		
		response.sendRedirect(next);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
