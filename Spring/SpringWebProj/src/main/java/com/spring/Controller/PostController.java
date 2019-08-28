package com.spring.Controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.Error.ErrorClass;
import com.spring.model.dto.CommentInsertDTO;
import com.spring.model.dto.PostContentsDTO;
import com.spring.model.dto.PostDTO;
import com.spring.model.dto.PostInsertDTO;
import com.spring.model.dto.user.UserDTO;
import com.spring.model.service.CommentService;
import com.spring.model.service.MenuService;
import com.spring.model.service.PostService;

@Controller
@RequestMapping("/post")
public class PostController {
	@Autowired MenuService m_service;
	@Autowired PostService p_service;
	@Autowired CommentService c_service;
	@RequestMapping("/insert")
	public ModelAndView postinsert()
	{
		ModelAndView view = new ModelAndView();
		view.addObject("menu",m_service.getMenu());
		view.setViewName("postInsert");
		return view;
	}
	@PostMapping("/insert/checker")
	public ModelAndView postinsert(@Validated @ModelAttribute PostInsertDTO dto,BindingResult error,HttpServletRequest req)
	{
		ModelAndView view = new ModelAndView();
		if(error.hasErrors())
		{
			view.addObject("errorCode",ErrorClass.errorCodeMake(error));
			view.setViewName("forward:/post/insert");
			return view;
		}
		PostDTO post_dto = new PostDTO();
		post_dto.setId_num(((UserDTO)req.getSession().getAttribute("user")).getId_num());
		post_dto.setPost_name(dto.getPost_name());
		post_dto.setPost_contents(dto.getPost_contents());
		post_dto.setMenu_num(Integer.parseInt(dto.getMenu_num()));
		p_service.insertPostContents(post_dto);
		view.setViewName("forward:/list/post/"+dto.getMenu_num()+"/0");
		return view;
	}
	@RequestMapping("/contents/{post_num}")
	public ModelAndView postContents(@PathVariable int post_num)
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("postContents");
		PostDTO dto = new PostDTO();
		dto.setPost_num(post_num);
		PostContentsDTO temp = p_service.getPostContents(dto);
		view.addObject("post",temp);
		return view;
	}
	@PostMapping("/comment/{post_num}")
	public ModelAndView commentInPost(@PathVariable int post_num,@Validated @ModelAttribute(value="comment_context") CommentInsertDTO dto, BindingResult error,HttpServletRequest req)
	{
		ModelAndView view = new ModelAndView();
		if(error.hasErrors())
		{
			List<String> errorCode = ErrorClass.errorCodeMake(error);
			view.addObject("errorCode",errorCode);
		}
		dto.setPost_num(post_num);
		view.setViewName("forward:/post/contents/"+post_num);
		
		UserDTO user = (UserDTO) req.getSession().getAttribute("user");
		if(user!= null) {
			System.out.println(user);
			c_service.InsertComment(dto,user.getId_num());
		}
		else {
			view.setViewName("forward:/login");
		}
		return view;
	}
}
