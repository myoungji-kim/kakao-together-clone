package com.controller.fundraising;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.fundraising.NowDTO;
import com.service.fundraising.NowService;
import com.service.fundraising.NowServiceImpl;


@WebServlet("/fundraising/now/content")
public class FundraisingNowContentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ncode = request.getParameter("ncode");
		String next = "";
		
		NowService service = new NowServiceImpl();
		try {
			NowDTO dto = service.selectNowContent(ncode);
			request.setAttribute("nowContent", dto);
			next = "/fundraising/nowContent.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			next = "/error/500error.jsp";
		}
		
		// main.jsp에 위임
		request.getRequestDispatcher(next).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
