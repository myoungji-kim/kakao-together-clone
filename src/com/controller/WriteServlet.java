package com.controller;

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

@WebServlet("/write")
public class WriteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "";
		String idx = request.getParameter("idx");
		String cate = request.getParameter("cate");
		
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("idx", idx);
		
		if (idx == null) {
			request.setAttribute("content", null);
			next = "/write.jsp";
		} else {
			BoardService service = new BoardServiceImpl();
			try {
				BoardDTO dto = null;
				if (cate.equals("fund")) dto = service.selectNowContent(map);
				else if (cate.equals("prom")) dto = service.selectPromContent(map);
				request.setAttribute("content", dto);
				next = "/write.jsp";
			} catch (Exception e) {
				e.printStackTrace();
				next = "/Error500";
			}
				
		}
		request.getRequestDispatcher(next).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
