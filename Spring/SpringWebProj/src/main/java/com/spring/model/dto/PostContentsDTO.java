package com.spring.model.dto;

import java.util.LinkedList;
import java.util.List;

import com.spring.model.vo.CommentVo;
import com.spring.model.vo.PostVo;

public class PostContentsDTO {
	private PostVo data;
	private List<CommentVo> comment_list;
	public PostContentsDTO() {
		comment_list = new LinkedList<CommentVo>();
	}
	public PostVo getData() {
		return data;
	}
	public void setData(PostVo data) {
		this.data = data;
	}
	public List<CommentVo> getComment_list() {
		return comment_list;
	}
	public void setComment_list(List<CommentVo> comment_list) {
		this.comment_list = comment_list;
	}
	@Override
	public String toString() {
		return "PostContentsDTO [data=" + data + ", comment_list=" + comment_list + "]";
	}
}
