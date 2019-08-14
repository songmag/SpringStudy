package com.spring.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.dao.CommentDAO;
import com.spring.model.dao.MenuDAO;
import com.spring.model.dao.PostDAO;
import com.spring.model.dto.PostContentsDTO;
import com.spring.model.dto.PostListDTO;
import com.spring.model.vo.MenuVo;
import com.spring.model.vo.PostVo;
import com.spring.model.vo.UserVo;

@Service
public class PostService {
	@Autowired SqlSession sql;
	@Autowired PostDAO p_dao;
	@Autowired MenuDAO m_dao;
	@Autowired CommentDAO c_dao;
	
	public PostListDTO getPostList(MenuVo menu,int page)
	{
		PostListDTO list = new PostListDTO();
		list.setMenu(menu);
		list.setPost_list(p_dao.getPostList(sql,menu,page));
		return list;
	}
	public PostListDTO getPostList(UserVo menu,int page)
	{
		PostListDTO list = new PostListDTO();
		list.setMenu(null);
		list.setPost_list(p_dao.getPostList(sql,menu,page));
		return list;
	}
	public PostContentsDTO getPostContents(PostVo post)
	{
		PostContentsDTO dto = new PostContentsDTO();
		dto.setData(p_dao.getPostContents(sql, post));
		dto.setComment_list(c_dao.getComments(sql,post));
		return dto;
	}
	public void insertPostContents(PostVo post)
	{
		p_dao.insertPost(sql, post);
	}
	public void deletePostContents(PostVo post)
	{
		p_dao.insertPost(sql, post);
	}
	public void updatePostContents(PostVo post)
	{
		
	}
}
