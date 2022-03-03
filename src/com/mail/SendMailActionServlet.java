package com.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMailServlet
 */
@WebServlet("/sendmail.action")
public class SendMailActionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subject = request.getParameter("subject");
		String fromName = request.getParameter("fromName"); // 보낸 이 (이름)
		String from = request.getParameter("fromMail"); 	// 보낸 이 (메일)
		String content = "보낸 사람 이메일 주소: "+from+"<br>내용:"+request.getParameter("content"); 	// 보낼 내용
		
		
		String host = "smtp.gmail.com";
		String to = "myoung9412@daum.net"; // 받는 메일 (나)
		

		try{
			//프로퍼티 값 인스턴스 생성과 기본세션(SMTP 서버 호스트 지정)
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", 465); 
			props.put("mail.smtp.auth", "true"); 
			props.put("mail.smtp.ssl.enable", "true"); 
			props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

			Authenticator auth = new SendMail();
			Session mailSession = Session.getDefaultInstance(props,auth);

			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(from, MimeUtility.encodeText(fromName,"UTF-8","B"))); //보내는 사람 설정
			InternetAddress[] address = {new InternetAddress(to)};

			msg.setRecipients(Message.RecipientType.TO, address); // 받는 사람설정
			msg.setSubject(subject); // 제목설정
			msg.setSentDate(new java.util.Date()); //         보내는 날짜 설정
			msg.setContent(content,"text/html; charset=UTF-8"); // 내용 설정(MIME 지정-HTML 형식)

			Transport.send(msg); // 메일 보내기

		}catch(MessagingException ex){
			System.out.println("mail send error : "+ex.getMessage());
			ex.printStackTrace();
		}catch(Exception e){
			System.out.println("error : "+e.getMessage());
			e.printStackTrace();
		}

		response.sendRedirect("/sendmail/sendmailSuccess.jsp");

	}//end doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}