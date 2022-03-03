package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.board.BoardDTO;
import com.service.board.BoardService;
import com.service.board.BoardServiceImpl;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "";
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sort", "desc");
		map.put("cate", "fund");
		
		BoardService service = new BoardServiceImpl();
		try {
			List<BoardDTO> list = service.selectAllNow(map);
			request.setAttribute("nowList", list);
			next = "main.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Main 요청시 예외 발생");
			next = "/error/500error.jsp";
		}
		
		request.getRequestDispatcher(next).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
