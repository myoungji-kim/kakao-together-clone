package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.board.BoardDTO;
import com.service.board.BoardService;
import com.service.board.BoardServiceImpl;

@WebServlet("/write.action")
public class WriteActionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String next = "";
		String idx = request.getParameter("idx");
		String mode = request.getParameter("mode"); // insert or update
		String cate = request.getParameter("cate"); // fund or prom
		String topic = "";
		if (cate.equals("fund")) topic = request.getParameter("topic");
		String title = request.getParameter("title");
		String agency = request.getParameter("agency");
		String price = request.getParameter("price");
		String image0 = request.getParameter("image0");
		if (image0.equals("")) image0 = "no_image.png";
		String head1 = request.getParameter("head1");
		String body1 = request.getParameter("body1");
		String image1 = request.getParameter("image1");
		String youtube1 = request.getParameter("youtube1");
		String tag1 = request.getParameter("tag1");
		String tag2 = request.getParameter("tag2");
		String tag3 = request.getParameter("tag3");
		String writer = request.getParameter("writer");
		String subtopic = "";
		String enddate = request.getParameter("enddate");
		if (topic.equals("1")) subtopic = request.getParameter("subtopic");
		BoardService service = new BoardServiceImpl();

		if (cate.equals("fund")) {
			if (topic.equals("1")) { // now - 모금중
				try {
					int num = 0;
					// insert
					if (mode.equals("insert")) {
						BoardDTO boardDTO = new BoardDTO(topic, title, agency, Integer.parseInt(price), image0, head1, body1,
								image1, youtube1, tag1, tag2, tag3, Integer.parseInt(writer), subtopic, cate);
						num = service.insertNow(boardDTO);

					// update
					} else if (mode.equals("update")) {
						BoardDTO boardDTO = new BoardDTO(Integer.parseInt(idx), topic, title, agency, Integer.parseInt(price),
								image0, head1, body1, image1, youtube1, tag1, tag2, tag3, Integer.parseInt(writer),
								subtopic, cate);
						num = service.updateNow(boardDTO);
					}
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
			try {
				int num = 0;
				
				// insert
				if (mode.equals("insert")) {
					BoardDTO boardDTO = new BoardDTO(title, agency, image0, head1, body1, image1, 
													 youtube1, Integer.parseInt(writer), enddate, cate);
					num = service.insertProm(boardDTO);
					next = "/prom?sort=1";
					
				// update
				} else if (mode.equals("update")) {
					System.out.println("idx:::"+Integer.parseInt(idx));
					BoardDTO boardDTO = new BoardDTO(Integer.parseInt(idx), title, agency, image0, head1, body1, 
													 image1, youtube1, Integer.parseInt(writer), enddate, cate);
					num = service.updateProm(boardDTO);
					next = "/prom/content?idx="+Integer.parseInt(idx);
				}

			} catch (Exception e) {
				next = "/Error500";
				e.printStackTrace();
			}
		}
		response.sendRedirect(next);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
