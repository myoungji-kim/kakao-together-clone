package com.controller.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.member.MemberDTO;
import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;

@WebServlet("/login.action")
public class LoginActionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String next = "";
		
		MemberService service = new MemberServiceImpl();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		
		try {
			MemberDTO dto = service.selectMember(map);
			if (dto == null) {
				next = "/member/loginFail.jsp";
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("member", dto);
				next = "/main";
			}
			
		} catch (Exception e) {
			next = "/Error500";
			e.printStackTrace();
		}
		response.sendRedirect(next);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
