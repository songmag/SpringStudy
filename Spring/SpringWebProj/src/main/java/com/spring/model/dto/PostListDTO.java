package com.spring.model.dto;

import java.util.List;

import com.spring.model.vo.MenuVo;
import com.spring.model.vo.PostVo;

public class PostListDTO {
	private MenuVo menu;
	private List<PostVo> post_list;	
	public List<PostVo> getPost_list() {
		return post_list;
	}
	public void setPost_list(List<PostVo> post_list) {
		this.post_list = post_list;
	}
	public MenuVo getMenu() {
		return menu;
	}
	public void setMenu(MenuVo menu) {
		this.menu = menu;
	}
}
