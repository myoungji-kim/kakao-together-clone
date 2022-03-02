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
import com.service.cheer.CheerService;
import com.service.cheer.CheerServiceImpl;


@WebServlet("/fund/insertCheer")
public class FundCheerInsertServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cIdx = request.getParameter("cIdx");
		String mIdx = request.getParameter("mIdx");
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("content_idx", cIdx);
		map.put("member_idx", mIdx);
		
		CheerService service = new CheerServiceImpl();
		
		try {
			int num = service.insertCheer(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
