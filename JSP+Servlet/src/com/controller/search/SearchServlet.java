package com.controller.search;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.board.BoardDTO;
import com.dto.board.PageDTO;
import com.service.board.BoardService;
import com.service.board.BoardServiceImpl;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "";
		String key = request.getParameter("q");
		
		if (key != null) {
			BoardService service = new BoardServiceImpl();
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("key", key);
			List<BoardDTO> searchList;
			try {
				searchList = service.searchOne(map);
				request.setAttribute("searchList", searchList);
				next = "/search.jsp";
			} catch (Exception e) {
				next = "/Error500";
				e.printStackTrace();
			}
		} else {
			next = "/search.jsp";
		}
		
		request.getRequestDispatcher(next).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
