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
import com.dto.donation.MydonationDTO;
import com.dto.member.MemberDTO;
import com.service.board.BoardService;
import com.service.board.BoardServiceImpl;
import com.service.donation.DonationService;
import com.service.donation.DonationServiceImpl;
import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;

@WebServlet("/mypage/mydonation")
public class MyDonationServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "";
		HashMap<String, Object> map = new HashMap<String, Object>();
		DonationService service = new DonationServiceImpl();
		HttpSession session = request.getSession();
		int writer = ((MemberDTO) session.getAttribute("login")).getIdx();
		
		try {
			List<MydonationDTO> list = service.selectMyDonation(writer);
			request.setAttribute("MydonationList", list);
			next = "/mydonation.jsp";
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
