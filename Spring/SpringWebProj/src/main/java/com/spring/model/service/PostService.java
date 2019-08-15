package com.spring.model.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.dao.CommentDAO;
import com.spring.model.dao.MenuDAO;
import com.spring.model.dao.PostDAO;
import com.spring.model.dto.CommentDTO;
import com.spring.model.dto.MenuDTO;
import com.spring.model.dto.PostContentsDTO;
import com.spring.model.dto.PostDTO;
import com.spring.model.dto.PostListDTO;
import com.spring.model.dto.UserDTO;
import com.spring.model.vo.CommentVo;
import com.spring.model.vo.MenuVo;
import com.spring.model.vo.PostVo;
import com.spring.model.vo.UserVo;
/**
 * DTO 데이터를 받아 VO 데이터 설정으로 DAO 접근 이후 반환은 모두 DTO로 한다.
 * 
 * @author SongDevelop
 *
 */
@Service
public class PostService {
	@Autowired SqlSession sql;
	@Autowired PostDAO p_dao;
	@Autowired MenuDAO m_dao;
	@Autowired CommentDAO c_dao;
	private List<CommentVo> c_list;
	////////Private Part/////////////////////////////////////////////////////////
	private List<CommentDTO> transCommentListVoToListDTO(List<CommentVo> c_list)
	{
		List<CommentDTO> dtos = new LinkedList<CommentDTO>();
		for(CommentVo vo : c_list)
		{
			dtos.add(transVoToDTO(vo));
		}
		return dtos;
	}
	private PostDTO transVoToDTO(PostVo vo)
	{
		PostDTO dto;
		dto = new PostDTO();
		dto.setId_num(vo.getId_num());
		dto.setMenu_num(vo.getMenu_num());
		dto.setPost_contents(vo.getPost_contents());
		dto.setPost_date(vo.getPost_date());
		dto.setPost_name(vo.getPost_name());
		dto.setPost_num(vo.getPost_num());
		dto.setThumbnail(vo.getThumbnail());
		return dto;
	}
	private CommentDTO transVoToDTO(CommentVo vo)
	{
		CommentDTO dto = new CommentDTO();
		dto.setComment_date(vo.getComment_date());
		dto.setComment_num(vo.getComment_num());
		dto.setContext(vo.getContext());
		dto.setId_num(vo.getId_num());
		dto.setPost_num(vo.getPost_num());
		return dto;
	}
	////////////////////////////////////////////////////////////////////////////////
	
	
	public PostListDTO getPostList(MenuDTO menu_dto,int page)
	{
		PostListDTO list = new PostListDTO();
		MenuVo menu = new MenuVo();
		menu.setMenuDTO(menu_dto);
		list.setMenu(menu);
		list.setPost_list(transPostListVoToListDTO(p_dao.getPostList(sql, menu, page)));
		return list;
	}
	private List<PostDTO> transPostListVoToListDTO(List<PostVo> p_list)
	{
		List<PostDTO> dtos = new LinkedList<PostDTO>();
		for(PostVo vo : p_list)
		{
			dtos.add(transVoToDTO(vo));
		}
		return dtos;
	}
	public PostListDTO getPostList(UserDTO user_dto,int page)
	{
		PostListDTO list = new PostListDTO();
		UserVo user = new UserVo();
		user.setUserDTO(user_dto);
		list.setMenu(null);
		list.setPost_list(transPostListVoToListDTO(p_dao.getPostList(sql,user,page)));
		return list;
	}
	public PostContentsDTO getPostContents(PostDTO post_dto)
	{
		PostVo post = new PostVo();
		post.setPostDTO(post_dto);
		PostContentsDTO dto = new PostContentsDTO();
		dto.setData(transVoToDTO(p_dao.getPostContents(sql,post)));
		dto.setComment_list(transCommentListVoToListDTO(c_dao.getComments(sql,post)));
		return dto;
	}
	public void insertPostContents(PostDTO post)
	{
		PostVo vo = new PostVo();
		vo.setPostDTO(post);
		p_dao.insertPost(sql, vo);
	}
	public void deletePostContents(PostDTO post)
	{
		PostVo vo = new PostVo();
		vo.setPostDTO(post);
		p_dao.insertPost(sql, vo);
	}
	public void updatePostContents(PostDTO post)
	{
		
	}
}
