package com.rlagus.board.controller.dto;

public class boardDto {
	private int bnum;				// 게시판 글번호(기본키)
	private String writer;			// 글쓴이 이름
	private String sunject;			// 글 제목
	private String content;			// 글 내용
	private String wdate;			// 작성 일시
	
	public boardDto() {
		super();
	}
	
	public boardDto(int bnum, String writer, String sunject, String content, String wdate) {
		super();
		this.bnum = bnum;
		this.writer = writer;
		this.sunject = sunject;
		this.content = content;
		this.wdate = wdate;
	}
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSunject() {
		return sunject;
	}
	public void setSunject(String sunject) {
		this.sunject = sunject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}	
}