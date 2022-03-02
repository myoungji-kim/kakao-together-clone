package com.controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.board.BoardDTO;
import com.dto.board.PageDTO;
import com.dto.member.MemberDTO;
import com.service.board.BoardService;
import com.service.board.BoardServiceImpl;
import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;

@WebServlet("/mypage/mywrite")
public class MyWriteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "";
		String pageNum = request.getParameter("no"); // 페이지 번호
		HashMap<String, Object> map = new HashMap<String, Object>();
		BoardService service = new BoardServiceImpl();
		
		HttpSession session = request.getSession();
		int writer = ((MemberDTO) session.getAttribute("login")).getIdx();
		
		try {
			map.put("writer", writer);
			int total = service.countTotalMywrite(map);
			
			PageDTO paging = new PageDTO(total, pageNum);
			map.put("page", paging);
			
			List<BoardDTO> list = null;
			list = service.selectAllMywrite(map);
			request.setAttribute("mywriteList", list);
			
			Map<String, Object> page = paging.getPageInfo();
			request.setAttribute("page", page);
			
			next = "/mywrite.jsp";
		} catch (Exception e) {
			next = "/Error500";
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(next).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
