package com.controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.member.MemberDTO;
import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;

@WebServlet("/join.action")
public class JoinActionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "";
		String username = request.getParameter("username");
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String post = request.getParameter("post");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone1 = request.getParameter("post");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		MemberService service = new MemberServiceImpl();
		MemberDTO dto = new MemberDTO(userid, passwd, username, phone1, phone2, phone3, email1, email2, post, addr1, addr2);
		try {
			int num = service.insertMember(dto);
			next = "/member/joinSuccess.jsp";
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