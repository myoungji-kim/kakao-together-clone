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

@WebServlet("/fund/now/update")
public class FundNowUpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("mode", "update");
		String idx = request.getParameter("idx");
		String next = "";
		
		NowService service = new NowServiceImpl();
		try {
			NowDTO dto = service.selectNowContent(idx);
			String subtopic = service.selectNowContentTag(dto.getSubtopic()); // 주제 가져오기 (ex. 어린이, 여성, ..)
			request.setAttribute("nowContent", dto);
			request.setAttribute("subtopic", subtopic);
			next = "/fundraising/nowContent.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			next = "/Error500";
		}
		request.getRequestDispatcher("/write.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
