package com.spring.model.dto;

import java.util.LinkedList;
import java.util.List;

import com.spring.model.vo.CommentVo;
import com.spring.model.vo.PostVo;

public class PostContentsDTO {
	private PostDTO data;
	private List<CommentDTO> comment_list;
	public PostContentsDTO() {
		comment_list = new LinkedList<CommentDTO>();
	}
	public PostDTO getData() {
		return data;
	}
	public void setData(PostDTO data) {
		this.data = data;
	}
	public List<CommentDTO> getComment_list() {
		return comment_list;
	}
	public void setComment_list(List<CommentDTO> comment_list) {
		this.comment_list = comment_list;
	}
	@Override
	public String toString() {
		return "PostContentsDTO [data=" + data + ", comment_list=" + comment_list + "]";
	}
}
