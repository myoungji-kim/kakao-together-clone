package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.fundraising.NowDTO;
import com.service.fundraising.NowService;
import com.service.fundraising.NowServiceImpl;

@WebServlet("/del.action")
public class DeleteActionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "";
		String idx = request.getParameter("idx");
		String cate = request.getParameter("cate"); // fund or prom
		
		NowService service = new NowServiceImpl();
		
		if (cate.equals("fund")) {
			try {
				int num = service.deleteNow(Integer.parseInt(idx));
				next = "/fundraising/deleteSuccess.jsp";
			} catch (Exception e) {
				next = "/Error500";
				e.printStackTrace();
			}
		} else if (cate.equals("prom")) {
			// 미완
		}
		response.sendRedirect(next);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
