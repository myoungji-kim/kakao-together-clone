package com.controller.member;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.member.MemberDTO;
import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;

@WebServlet("/mypage")
public class MypageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String next = "";
		HttpSession session = request.getSession();
		MemberDTO loginDTO = (MemberDTO) session.getAttribute("login");
		MemberService service = new MemberServiceImpl();
		try {
			MemberDTO mypageDto = service.selectForMypage(loginDTO.getIdx());
			session.setAttribute("member", mypageDto);
			next = "/mypage.jsp";
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
