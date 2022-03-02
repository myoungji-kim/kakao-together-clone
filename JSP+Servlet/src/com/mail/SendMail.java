package com.mail;

import javax.mail.PasswordAuthentication;

public class SendMail extends javax.mail.Authenticator {
	public PasswordAuthentication getPasswordAuthentication() {
		
		/*
		 *   구글에서 로그인 > 보안 > 보안수준이 낮은 앱 허용을  '활성화'로 변경
		 */
		
		return new PasswordAuthentication("ddingji99@gmail.com", "myoung9412");
	}
}