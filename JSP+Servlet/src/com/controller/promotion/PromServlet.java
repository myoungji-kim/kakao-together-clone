package com.controller.promotion;

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

@WebServlet("/prom")
public class PromServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "";
		String phase = request.getParameter("phase"); // 진행중, 종료
		String pageNum = request.getParameter("no"); // 페이지 번호
		
		// 게시글 가져올 기준들
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("phase", phase);
		
		BoardService service = new BoardServiceImpl();
		
		try {
			int total = service.countTotalProm();
			PageDTO paging = new PageDTO(total, pageNum);
			map.put("page", paging);
			
			List<BoardDTO> list = null;
			list = service.selectAllProm(map);
			request.setAttribute("promList", list);
			
			Map<String, Object> page = paging.getPageInfo();
			request.setAttribute("page", page);
			
			next = "/promotion.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Now 페이지 요청시 예외 발생");
			next = "/Error500";
		}
		
		
		request.getRequestDispatcher("/promotion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
