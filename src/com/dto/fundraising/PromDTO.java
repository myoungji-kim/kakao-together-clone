package com.dto.fundraising;

public class PromDTO {
	int nIdx;
	String nCode;
	String nTopic;
	String nTitle;
	String nAgency;
	int nPrice;
	int nPricestate;
	String nWriteday;
	int nCheer;
	String nImage0;
	String nHead1;
	String nBody1;
	String nImage1;
	String nYoutube1;
	String nTag1;
	String nTag2;
	String nTag3;
	
	public PromDTO() {}
	
	public int getnIdx() {
		return nIdx;
	}
	public void setnIdx(int nIdx) {
		this.nIdx = nIdx;
	}
	public String getnCode() {
		return nCode;
	}
	public void setnCode(String nCode) {
		this.nCode = nCode;
	}
	public String getnTopic() {
		return nTopic;
	}
	public void setnTopic(String nTopic) {
		this.nTopic = nTopic;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public String getnAgency() {
		return nAgency;
	}
	public void setnAgency(String nAgency) {
		this.nAgency = nAgency;
	}
	public int getnPrice() {
		return nPrice;
	}
	public void setnPrice(int nPrice) {
		this.nPrice = nPrice;
	}
	public int getnPricestate() {
		return nPricestate;
	}
	public void setnPricestate(int nPricestate) {
		this.nPricestate = nPricestate;
	}
	public String getnWriteday() {
		return nWriteday;
	}
	public void setnWriteday(String nWriteday) {
		this.nWriteday = nWriteday;
	}
	public int getnCheer() {
		return nCheer;
	}
	public void setnCheer(int nCheer) {
		this.nCheer = nCheer;
	}
	public String getnImage0() {
		return nImage0;
	}
	public void setnImage0(String nImage0) {
		this.nImage0 = nImage0;
	}
	public String getnHead1() {
		return nHead1;
	}
	public void setnHead1(String nHead1) {
		this.nHead1 = nHead1;
	}
	public String getnBody1() {
		return nBody1;
	}
	public void setnBody1(String nBody1) {
		this.nBody1 = nBody1;
	}
	public String getnImage1() {
		return nImage1;
	}
	public void setnImage1(String nImage1) {
		this.nImage1 = nImage1;
	}
	public String getnYoutube1() {
		return nYoutube1;
	}
	public void setnYoutube1(String nYoutube1) {
		this.nYoutube1 = nYoutube1;
	}
	public String getnTag1() {
		return nTag1;
	}
	public void setnTag1(String nTag1) {
		this.nTag1 = nTag1;
	}
	public String getnTag2() {
		return nTag2;
	}
	public void setnTag2(String nTag2) {
		this.nTag2 = nTag2;
	}
	public String getnTag3() {
		return nTag3;
	}
	public void setnTag3(String nTag3) {
		this.nTag3 = nTag3;
	}
	
	@Override
	public String toString() {
		return "NowDTO [nIdx=" + nIdx + ", nCode=" + nCode + ", nTopic=" + nTopic + ", nTitle=" + nTitle + ", nAgency="
				+ nAgency + ", nPrice=" + nPrice + ", nPricestate=" + nPricestate + ", nWriteday=" + nWriteday
				+ ", nCheer=" + nCheer + ", nImage0=" + nImage0 + ", nHead1=" + nHead1 + ", nBody1=" + nBody1
				+ ", nImage1=" + nImage1 + ", nYoutube1=" + nYoutube1 + ", nTag1=" + nTag1 + ", nTag2=" + nTag2
				+ ", nTag3=" + nTag3 + "]";
	}
	
}
