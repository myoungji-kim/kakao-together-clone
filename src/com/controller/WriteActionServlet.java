package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.fundraising.NowDTO;
import com.service.fundraising.NowService;
import com.service.fundraising.NowServiceImpl;

@WebServlet("/write.action")
public class WriteActionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String next = "";
		String mode = request.getParameter("mode"); // insert or update
		String topic = "";
		String cate = request.getParameter("cate"); // fund or prom
		if (cate.equals("fund")) { topic = request.getParameter("topic"); }
		String idx = request.getParameter("idx");
		String title = request.getParameter("title");
		String agency = request.getParameter("agency");
		String price = request.getParameter("price");
		String image0 = request.getParameter("image0");
		if (image0.equals("")) { image0 = "no_image.png"; }
		String head1 = request.getParameter("head1");
		String body1 = request.getParameter("body1");
		String image1 = request.getParameter("image1");
		String youtube1 = request.getParameter("youtube1");
		String tag1 = request.getParameter("tag1");
		String tag2 = request.getParameter("tag2");
		String tag3 = request.getParameter("tag3");
		String writer = request.getParameter("writer");
		String subtopic = "";
		if (topic.equals("1")) { subtopic = request.getParameter("subtopic"); }
		System.out.println("cate: "+cate);
		
		NowService service = new NowServiceImpl();
		if (cate.equals("fund")) {
			if (topic.equals("1")) { // now - 모금중
//				System.out.println(topic+" "+title+" "+agency+" "+Integer.parseInt(price)+" "+
//						image0+" "+head1+" "+body1+" "+image1+" "+youtube1+" "+tag1+" "+
//						tag2+" "+tag3+" "+Integer.parseInt(writer)+" "+subtopic);
				
				NowDTO nowDTO = new NowDTO(topic, title, agency, Integer.parseInt(price),
						image0, head1, body1, image1, youtube1, tag1,
						tag2, tag3, Integer.parseInt(writer), subtopic);
				try {
					int num = service.insertNow(nowDTO);
					next = "/fund/now?sort=1";
				} catch (Exception e) {
					next = "/Error500";
					e.printStackTrace();
				}
				
			} else if (topic.equals("2")) { // epilogue - 모금후기
				next = "/fundraising/epil";
				System.out.println("2번으로 들어옴");
				
			} else if (topic.equals("3")) { // campaign - 나눔캠페인
				next = "/fundraising/campaign";
				System.out.println("3번으로 들어옴");
				
			}
			
		} else if (cate.equals("prom")) {
			next = "/promotion";
		}
		response.sendRedirect(next);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
