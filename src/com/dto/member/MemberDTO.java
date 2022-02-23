package com.dto.member;

public class MemberDTO {
	int idx;
	String userid;
	String passwd;
	String username;
	String phone1;
	String phone2;
	String phone3;
	String email1;
	String email2;
	String post;
	String addr1;
	String addr2;
	String joindate;
	
	public MemberDTO() {}
	
	// All Data
	public MemberDTO(int idx, String userid, String passwd, String username, String phone1, String phone2,
			String phone3, String email1, String email2, String post, String addr1, String addr2, String joindate) {
		this.idx = idx;
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.email1 = email1;
		this.email2 = email2;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.joindate = joindate;
	}

	// 회원가입용 생성자
	public MemberDTO(String userid, String passwd, String username, String phone1, String phone2,
			String phone3, String email1, String email2, String post, String addr1, String addr2) {
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.email1 = email1;
		this.email2 = email2;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
	}
	
	// 마이페이지 정보 수정용 생성자
	public MemberDTO(int idx, String phone1, String phone2, String phone3, String email1, String email2, String post,
			String addr1, String addr2) {
		this.idx = idx;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.email1 = email1;
		this.email2 = email2;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	@Override
	public String toString() {
		return "MemberDTO [idx=" + idx + ", userid=" + userid + ", passwd=" + passwd + ", username=" + username
				+ ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3=" + phone3 + ", email1=" + email1
				+ ", email2=" + email2 + ", post=" + post + ", addr1=" + addr1 + ", addr2=" + addr2 + ", joindate="
				+ joindate + "]";
	}
	
}
