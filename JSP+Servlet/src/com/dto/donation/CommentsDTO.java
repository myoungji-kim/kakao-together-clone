package com.dto.donation;

// select a.comments, b.userid 
public class CommentsDTO {
	String comments;
	String userid;
	int donation;
	String date_donation;
	

	public CommentsDTO(String comments, String userid, int donation) {
		this.comments = comments;
		this.userid = userid;
		this.donation = donation;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public int getDonation() {
		return donation;
	}

	public void setDonation(int donation) {
		this.donation = donation;
	}

	public String getDate_donation() {
		return date_donation;
	}

	public void setDate_donation(String date_donation) {
		this.date_donation = date_donation;
	}
	
}
