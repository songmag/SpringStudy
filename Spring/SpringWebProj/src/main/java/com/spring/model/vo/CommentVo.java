package com.spring.model.vo;

import java.sql.Date;

public class CommentVo {
	private int comment_num;
	private int post_num;
	private int id_num;
	private Date comment_date;
	private String context;
	
	public int getComment_num() {
		return comment_num;
	}
	public void setComment_num(int comment_num) {
		this.comment_num = comment_num;
	}
	public int getPost_num() {
		return post_num;
	}
	public void setPost_num(int post_num) {
		this.post_num = post_num;
	}
	public int getId_num() {
		return id_num;
	}
	public void setId_num(int id_num) {
		this.id_num = id_num;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
}
