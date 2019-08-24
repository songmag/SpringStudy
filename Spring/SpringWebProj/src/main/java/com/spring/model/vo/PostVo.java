package com.spring.model.vo;

import java.lang.reflect.Field;
import java.sql.Date;

import com.spring.model.dto.PostDTO;

public class PostVo {
	private int post_num = 0;
	private int id_num = 0;
	private int menu_num = 0 ;
	private Date post_date=null;
	private String post_name=null;
	private String thumbnail=null;
	private String post_contents=null;
	private String id=null;
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
	public int getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public String getPost_name() {
		return post_name;
	}
	public void setPost_name(String post_name) {
		if(post_name.isEmpty())
		{
			this.post_name = null;
			return;
		}
		this.post_name = post_name;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		if(thumbnail.isEmpty())
		{
			this.thumbnail = null;
			return;
		}
		this.thumbnail = thumbnail;
	}	
	public String getPost_contents() {
		return post_contents;
	}
	public void setPost_contents(String post_contents) {
		if(post_contents.isEmpty())
		{
			this.post_contents = null;
			return;
		}
		this.post_contents = post_contents;
	}
	public void setPostDTO(PostDTO dto)
	{		
		this.setId_num(dto.getId_num());
		this.setId(dto.getId());
		this.setMenu_num(dto.getMenu_num());
		this.setPost_contents(dto.getPost_contents());
		this.setPost_num(dto.getPost_num());
		this.setPost_date(dto.getPost_date());
		this.setPost_name(dto.getPost_name());
		this.setThumbnail(dto.getThumbnail());
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		if(id.isEmpty())
		{
			this.id=null;
			return;
		}
		this.id = id;
	}
}
