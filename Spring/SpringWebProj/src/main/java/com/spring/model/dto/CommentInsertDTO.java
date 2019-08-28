package com.spring.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CommentInsertDTO {
	@NotNull
	private int post_num;
	@NotNull
	@NotEmpty(message="context 입력 하고 제출해주세요")
	private String context;
	public int getPost_num() {
		return post_num;
	}
	public void setPost_num(int post_num) {
		this.post_num = post_num;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
}
