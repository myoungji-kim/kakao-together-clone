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
		
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("member");
		String next = "";
		
		if (dto != null) {
			MemberService service = new MemberServiceImpl();
			try {
				MemberDTO mypageDto = service.selectForMypage(dto.getIdx());
				session.setAttribute("member", mypageDto);
				next = "/member/mypage.jsp";
			} catch (Exception e) {
				next = "/Error500";
				e.printStackTrace();
			}
		} else {
			next = "/member/sessionInvalidate.jsp";
		}
		
		request.getRequestDispatcher(next).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
