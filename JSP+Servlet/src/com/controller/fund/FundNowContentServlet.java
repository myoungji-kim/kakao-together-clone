package com.controller.fund;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.board.BoardDTO;
import com.service.board.BoardService;
import com.service.board.BoardServiceImpl;


@WebServlet("/fund/now/content")
public class FundNowContentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String next = "";
		String idx = request.getParameter("idx");
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("idx", idx);
		map.put("cate", "fund");
		
		BoardService service = new BoardServiceImpl();
		
		try {
			BoardDTO dto = service.selectNowContent(map);
			String subtopic = service.selectNowContentTag(dto.getSubtopic()); // 주제 가져오기 (ex. 어린이, 여성, ..)
			request.setAttribute("content", dto);
			request.setAttribute("subtopic", subtopic);
			next = "/fundraising/nowContent.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			next = "/Error500";
		}
		
		// main.jsp에 위임
		request.getRequestDispatcher(next).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
