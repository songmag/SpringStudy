package com.spring.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PostInsertDTO {
	@NotNull(message = "포스트 제목은 있어야합니다.")
	@NotEmpty(message = "포스트 제목은 있어야합니다.")
	private String post_name=null;
	private String post_pw=null;
	@NotNull(message = "포스트 내용은 있어야합니다.")
	@NotEmpty(message = "포스트 내용은 있어야합니다.")
	private String post_contents=null;
	@NotNull
	private String menu_num=null;
	private String user_num=null;
	
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}
	public String getPost_pw() {
		return post_pw;
	}
	public void setPost_pw(String post_pw) {
		this.post_pw = post_pw;
	}
	public String getPost_contents() {
		return post_contents;
	}
	public void setPost_contents(String post_contents) {
		this.post_contents = post_contents.replaceAll("\r\n", "<br>");	
	}
	public String getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(String menu_num) {
		this.menu_num = menu_num;
	}
	@Override
	public String toString() {
		return "PostInsertDTO [post_name=" + post_name + ", post_pw=" + post_pw + ", post_contents=" + post_contents
				+ ", menu_num=" + menu_num + ", user_num=" + user_num + "]";
	}
	
}
