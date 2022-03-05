package com.dto.board;

public class BoardDTO {
	int idx;		// 게시글 고유번호
	String topic;	// 카테고리 (모금중, 모금후기, 나눔캠페인)
	String title;	// 글 제목
	String agency;	// 작성자 이름(string)
	int price;		// 목표 모금액
	int pricestate;	// 기부 받은 금액
	String writeday;// 작성일
	int cheer;		// 응원수
	String image0;	// 썸네일
	String head1;	// 본문소제목1
	String body1;	// 본문텍스트1
	String image1;	// 본문이미지1
	String youtube1;// 영상링크
	String tag1;	// 태그1
	String tag2;	// 태그2
	String tag3;	// 태그3
	int writer;		// 작성자 idx
	String subtopic;// 주제 (어린이, 여성, ...)
	String priceChar; // 목표 모금액 숫자 3자리마다 콤마 찍은 문자열
	String enddate; // 종료일(프로모션용)
	String cate;	// fund, prom ...
	

	public BoardDTO() {}

	public BoardDTO(int idx, String topic, String title, String agency, int price, int pricestate, String writeday,
			int cheer, String image0, String head1, String body1, String image1, String youtube1, String tag1,
			String tag2, String tag3, int writer, String subtopic) {
		this.idx = idx;
		this.topic = topic;
		this.title = title;
		this.agency = agency;
		this.price = price;
		this.pricestate = pricestate;
		this.writeday = writeday;
		this.cheer = cheer;
		this.image0 = image0;
		this.head1 = head1;
		this.body1 = body1;
		this.image1 = image1;
		this.youtube1 = youtube1;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.tag3 = tag3;
		this.writer = writer;
		this.subtopic = subtopic;
	}
	
	// NowContent 1개용 생성자 + insert용
	public BoardDTO(String topic, String title, String agency, int price, String image0, String head1,
			String body1, String image1, String youtube1, String tag1, String tag2, String tag3, int writer,
			String subtopic) {
		this.topic = topic;
		this.title = title;
		this.agency = agency;
		this.price = price;
		this.image0 = image0;
		this.head1 = head1;
		this.body1 = body1;
		this.image1 = image1;
		this.youtube1 = youtube1;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.tag3 = tag3;
		this.writer = writer;
		this.subtopic = subtopic;
		this.cate = cate;
	}
	
	
	// NowContent update용
	public BoardDTO(int idx, String topic, String title, String agency, int price, String image0, String head1,
			String body1, String image1, String youtube1, String tag1, String tag2, String tag3, int writer,
			String subtopic, String cate) {
		this.idx = idx;
		this.topic = topic;
		this.title = title;
		this.agency = agency;
		this.price = price;
		this.image0 = image0;
		this.head1 = head1;
		this.body1 = body1;
		this.image1 = image1;
		this.youtube1 = youtube1;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.tag3 = tag3;
		this.writer = writer;
		this.subtopic = subtopic;
		this.cate = cate;
	}

	// NowList 보기용 생성자
	public BoardDTO(String topic, String title, String agency, int price, String image0, String head1,
			String body1, String image1, String youtube1, String tag1, String tag2, String tag3, int writer,
			String subtopic, String priceChar) {
		this.topic = topic;
		this.title = title;
		this.agency = agency;
		this.price = price;
		this.image0 = image0;
		this.head1 = head1;
		this.body1 = body1;
		this.image1 = image1;
		this.youtube1 = youtube1;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.tag3 = tag3;
		this.writer = writer;
		this.subtopic = subtopic;
		this.priceChar = priceChar;
	}

	
	
	
	// prom => insert
	public BoardDTO(String title, String agency, String image0, String head1, String body1, String image1,
			String youtube1, int writer, String enddate, String cate) {
		this.title = title;
		this.agency = agency;
		this.image0 = image0;
		this.head1 = head1;
		this.body1 = body1;
		this.image1 = image1;
		this.youtube1 = youtube1;
		this.writer = writer;
		this.enddate = enddate;
		this.cate = cate;
	}
	
	// prom => update
	public BoardDTO(int idx, String title, String agency, String image0, String head1, String body1, String image1,
			String youtube1, int writer, String enddate, String cate) {
		this.idx = idx;
		this.title = title;
		this.agency = agency;
		this.image0 = image0;
		this.head1 = head1;
		this.body1 = body1;
		this.image1 = image1;
		this.youtube1 = youtube1;
		this.writer = writer;
		this.enddate = enddate;
		this.cate = cate;
	}
	
	public void setInsertEpil(String topic, String title, String agency, int price, int pricestate,
			String image0, String head1, String body1, String image1, String youtube1, 
			String tag1, String tag2, String tag3, int writer, String cate) {
		setTopic(topic);
		setTitle(title);
		setAgency(agency);
		setPrice(price);
		setPricestate(pricestate);
		setImage0(image0);
		setHead1(head1);
		setBody1(body1);
		setImage1(image1);
		setYoutube1(youtube1);
		setTag1(tag1);
		setTag2(tag2);
		setTag3(tag3);
		setWriter(writer);
		setCate(cate);
	}
	
	public void setUpdateEpil(int idx, String topic, String title, String agency, int price, int pricestate,
			String image0, String head1, String body1, String image1, String youtube1, 
			String tag1, String tag2, String tag3, int writer, String cate) {
		setIdx(idx);
		setTopic(topic);
		setTitle(title);
		setAgency(agency);
		setPrice(price);
		setPricestate(pricestate);
		setImage0(image0);
		setHead1(head1);
		setBody1(body1);
		setImage1(image1);
		setYoutube1(youtube1);
		setTag1(tag1);
		setTag2(tag2);
		setTag3(tag3);
		setWriter(writer);
		setCate(cate);
	}


	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPricestate() {
		return pricestate;
	}

	public void setPricestate(int pricestate) {
		this.pricestate = pricestate;
	}

	public String getWriteday() {
		return writeday;
	}

	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}

	public int getCheer() {
		return cheer;
	}

	public void setCheer(int cheer) {
		this.cheer = cheer;
	}

	public String getImage0() {
		return image0;
	}

	public void setImage0(String image0) {
		this.image0 = image0;
	}

	public String getHead1() {
		return head1;
	}

	public void setHead1(String head1) {
		this.head1 = head1;
	}

	public String getBody1() {
		return body1;
	}

	public void setBody1(String body1) {
		this.body1 = body1;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getYoutube1() {
		return youtube1;
	}

	public void setYoutube1(String youtube1) {
		this.youtube1 = youtube1;
	}

	public String getTag1() {
		return tag1;
	}

	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}

	public String getTag2() {
		return tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public String getTag3() {
		return tag3;
	}

	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}

	public int getWriter() {
		return writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	public String getSubtopic() {
		return subtopic;
	}

	public void setSubtopic(String subtopic) {
		this.subtopic = subtopic;
	}
	
	public String getPriceChar() {
		return priceChar;
	}

	public void setPriceChar(String priceChar) {
		this.priceChar = priceChar;
	}
	
	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	@Override
	public String toString() {
		return "BoardDTO [idx=" + idx + ", topic=" + topic + ", title=" + title + ", agency=" + agency + ", price="
				+ price + ", pricestate=" + pricestate + ", writeday=" + writeday + ", cheer=" + cheer + ", image0="
				+ image0 + ", head1=" + head1 + ", body1=" + body1 + ", image1=" + image1 + ", youtube1=" + youtube1
				+ ", tag1=" + tag1 + ", tag2=" + tag2 + ", tag3=" + tag3 + ", writer=" + writer + ", subtopic="
				+ subtopic + ", priceChar=" + priceChar + ", enddate=" + enddate + ", cate=" + cate + "]";
	}
	
}
