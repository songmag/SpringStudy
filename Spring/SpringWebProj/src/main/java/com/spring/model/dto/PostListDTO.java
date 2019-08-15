package com.spring.model.dto;

import java.util.List;

import com.spring.model.vo.MenuVo;
import com.spring.model.vo.PostVo;

public class PostListDTO {
	private MenuVo menu;
	private List<PostDTO> post_list;	
	public List<PostDTO> getPost_list() {
		return post_list;
	}
	public void setPost_list(List<PostDTO> post_list) {
		this.post_list = post_list;
	}
	public MenuVo getMenu() {
		return menu;
	}
	public void setMenu(MenuVo menu) {
		this.menu = menu;
	}
	@Override
	public String toString() {
		StringBuilder rs = new StringBuilder();
		rs.append("PostListDTO [menu=");
		try {
		rs.append(menu.getMenu_name());
		}catch(NullPointerException e)
		{
			System.out.println("menu_null");
			rs.append("null");
		}
		rs.append(", post_list=");
		for(PostDTO post : post_list)
		{
			rs.append(post.getPost_name());
			rs.append("\t");
		}
		rs= rs.append("]");
		return rs.toString();
	}
}
