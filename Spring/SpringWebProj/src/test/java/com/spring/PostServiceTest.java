package com.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.model.dto.PostContentsDTO;
import com.spring.model.dto.PostListDTO;
import com.spring.model.service.PostService;
import com.spring.model.vo.MenuVo;
import com.spring.model.vo.PostVo;
import com.spring.model.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebContainerApplication.class)
public class PostServiceTest {
	@Autowired PostService service;
	
	@Test
	public void serviceMenuNameListTest()
	{
		MenuVo vo;
		PostListDTO dto; 
		vo = new MenuVo();
		vo.setMenu_name("C");
		dto = service.getPostList(vo,0);
		System.out.println(dto);
	}
	@Test
	public void serviceMenuNumListTest()
	{
		MenuVo vo;
		PostListDTO dto; 
		vo = new MenuVo();
		vo.setMenu_num(1);
		dto = service.getPostList(vo,0);
		System.out.println(dto);
	}
	@Test
	public void serviceUserNumListTest()
	{
		UserVo vo;
		PostListDTO dto; 
		vo = new UserVo();
		vo.setId_num(1);
		dto = service.getPostList(vo,0);
		System.out.println(dto);
	}
	@Test
	public void serviceUserIdListTest()
	{
		UserVo vo;
		PostListDTO dto; 
		vo = new UserVo();
		vo.setId("test1");
		dto = service.getPostList(vo,0);
		System.out.println(dto);
	}
	@Test
	public void serviceUserNameListTest()
	{
		UserVo vo;
		PostListDTO dto; 
		vo = new UserVo();
		vo.setName("kotest");
		dto = service.getPostList(vo,0);
		System.out.println(dto);
	}
	@Test
	public void postContentsGetByName()
	{
		PostVo post;
		PostContentsDTO dto; 
		post = new PostVo();
		post.setPost_name("test1");
		dto = service.getPostContents(post);
		System.out.println(dto);
	}
	@Test
	public void postContentsGetByNum()
	{
		PostVo post;
		PostContentsDTO dto; 
		post = new PostVo();
		post.setPost_num(1);
		dto = service.getPostContents(post);
		System.out.println(dto);
	}
}
