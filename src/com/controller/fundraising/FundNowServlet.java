package com.controller.fundraising;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.fundraising.NowDTO;
import com.service.fundraising.NowService;
import com.service.fundraising.NowServiceImpl;

@WebServlet("/fund/now")
public class FundNowServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 정렬
		String sort = request.getParameter("sort");
		if (sort == null || sort.equals("1")) sort = "desc";
		else if (sort.equals("2")) sort = "asc";
		
		String next = "";
		String subtopic = request.getParameter("subtopic");
		NowService service = new NowServiceImpl();
		
		try {
			List<NowDTO> list = null;
			if (subtopic != null && subtopic != "") {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("sort", sort);
				map.put("subtopic", subtopic);
				list = service.selectTopicNow(map);
			} else {
				list = service.selectAllNow(sort);
			}
			request.setAttribute("nowList", list);
			next = "../now.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Now 페이지 요청시 예외 발생");
			next = "/Error500";
		}
		
		request.getRequestDispatcher(next).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
