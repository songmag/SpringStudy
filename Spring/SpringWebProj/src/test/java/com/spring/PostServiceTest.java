package com.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.model.dto.MenuDTO;
import com.spring.model.dto.PostContentsDTO;
import com.spring.model.dto.PostDTO;
import com.spring.model.dto.PostListDTO;
import com.spring.model.dto.UserDTO;
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
		MenuDTO vo;
		PostListDTO dto; 
		vo = new MenuDTO();
		vo.setMenu_name("C");
		dto = service.getPostList(vo,0);
		System.out.println(dto);
	}
	@Test
	public void serviceMenuNumListTest()
	{
		MenuDTO vo;
		PostListDTO dto; 
		vo = new MenuDTO();
		vo.setMenu_num(1);
		dto = service.getPostList(vo,0);
		System.out.println(dto);
	}
	@Test
	public void serviceUserNumListTest()
	{
		UserDTO vo;
		PostListDTO dto; 
		vo = new UserDTO();
		vo.setId_num(1);
		dto = service.getPostList(vo,0);
		System.out.println(dto);
	}
	@Test
	public void serviceUserIdListTest()
	{
		UserDTO vo;
		PostListDTO dto; 
		vo = new UserDTO();
		vo.setId("test1");
		dto = service.getPostList(vo,0);
		System.out.println(dto);
	}
	@Test
	public void serviceUserNameListTest()
	{
		UserDTO vo;
		PostListDTO dto; 
		vo = new UserDTO();
		vo.setName("kotest");
		dto = service.getPostList(vo,0);
		System.out.println(dto);
	}
	@Test
	public void postContentsGetByNum()
	{
		PostDTO post;
		PostContentsDTO dto; 
		post = new PostDTO();
		post.setPost_num(1);
		dto = service.getPostContents(post);
		System.out.println(dto);
	}
	@Test
	public void postInsert()
	{
		PostDTO dto = new PostDTO();
		for(int i = 0 ; i <10;i++) {
			dto.setId_num(1);
			dto.setMenu_num(1);
			dto.setPost_contents("TestFileInsertData"+ i);
			dto.setPost_name("Test"+i);
			service.insertPostContents(dto);
		}
	}
}
