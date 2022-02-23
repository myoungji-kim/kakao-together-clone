package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.fundraising.NowDTO;
import com.dto.member.MemberDTO;
import com.service.fundraising.NowService;
import com.service.fundraising.NowServiceImpl;
import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;

@WebServlet("/write")
public class WriteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cate = request.getParameter("cate");
		String idx = request.getParameter("idx");
		String next = "";
		
		if (idx == null) {
			request.setAttribute("nowContent", null);
			next = "/write.jsp";
		} else {
			if (cate.equals("fund")) {
				NowService service = new NowServiceImpl();
				try {
					NowDTO dto = service.selectNowContent(idx);
					next = "/write.jsp";
					request.setAttribute("nowContent", dto);
					request.setAttribute("cate", "fund");
				} catch (Exception e) {
					e.printStackTrace();
					next = "/Error500";
				}
			} else if (cate.equals("prom")) {
				System.out.println("WriteServlet에서 출력 : prom 게시글 편집");
			}
		}
		request.getRequestDispatcher(next).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
