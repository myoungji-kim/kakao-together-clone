package com.controller.fund;

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

@WebServlet("/fund/epil")
public class FundEpilServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "";
		String sort = request.getParameter("sort");
		// 게시글 가져올 기준들
				HashMap<String, Object> map = new HashMap<String, Object>();
				if (sort == null || sort.equals("1")) {
					map.put("sort", "desc");
				} else if (sort.equals("2")) {
					map.put("sort", "asc");
				}
				map.put("cate", "fund");
				
				BoardService service = new BoardServiceImpl();
				try {
					List<BoardDTO> list = null;
					list = service.selectAllEpil(map);
					request.setAttribute("epilList", list);
					next = "/epilogue.jsp";
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("errorMessage", "Epil 페이지 요청시 예외 발생");
					next = "/Error500";
				}
				
				request.getRequestDispatcher(next).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
