package com.controller.promotion;

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


@WebServlet("/prom/content")
public class PromContentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String next = "";
		String idx = request.getParameter("idx");
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("idx", idx);
		map.put("cate", "prom");
		
		BoardService service = new BoardServiceImpl();
		
		try {
			BoardDTO dto = service.selectPromContent(map);
			request.setAttribute("content", dto);
			next = "/promotion/promContent.jsp";
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
