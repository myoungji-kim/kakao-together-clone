package com.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.member.MemberDTO;
import com.service.member.MemberService;
import com.service.member.MemberServiceImpl;

@WebServlet("/JoinIdCheck")
public class JoinIdCheckServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		
		MemberService service = new MemberServiceImpl();
		String mesg = "";
		try {
			MemberDTO dto = service.idDuplicateCheck(userid);
			if (dto == null) mesg = "가능";
			else mesg = "불가능";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(mesg);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
