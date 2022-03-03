package com.dto.donation;

public class MydonationDTO {
	int content_idx;
	int donation;
	String date_donation;
	int member_idx;
	String title;
	String image0;
	
	public int getContent_idx() {
		return content_idx;
	}
	public void setContent_idx(int content_idx) {
		this.content_idx = content_idx;
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
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage0() {
		return image0;
	}
	public void setImage0(String image0) {
		this.image0 = image0;
	}
	
	@Override
	public String toString() {
		return "MydonationDTO [content_idx=" + content_idx + ", donation=" + donation + ", date_donation="
				+ date_donation + ", member_idx=" + member_idx + ", title=" + title + ", image0=" + image0 + "]";
	}
	
}
