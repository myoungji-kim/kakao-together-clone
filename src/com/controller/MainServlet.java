package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.fundraising.NowDTO;
import com.service.fundraising.NowService;
import com.service.fundraising.NowServiceImpl;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String next = "";
		NowService service = new NowServiceImpl();
		try {
//			int test = service.countAllNow();
			List<NowDTO> list = service.selectAllNow();
			request.setAttribute("nowList", list);
			next = "main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Main 요청시 예외 발생");
			next = "error/error.jsp";
		}
		
		request.getRequestDispatcher(next).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
