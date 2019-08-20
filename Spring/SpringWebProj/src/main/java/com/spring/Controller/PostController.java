package com.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.service.PostService;
import com.spring.model.vo.MenuVo;
import com.spring.model.vo.PostVo;

@Controller
@RequestMapping(value="/post")
public class PostController {
	@Autowired PostService post_service;
	@RequestMapping(value="/list")
	public ModelAndView getList(@ModelAttribute("menu_num") MenuVo menu)
	{
		System.out.println(menu);
		ModelAndView view = new ModelAndView();
		view.setViewName("postList");
		view.addObject("list",post_service.getPostList(menu,0));
		return view;
	}
	@GetMapping(value="/contents/{post_num}")
	public ModelAndView getContents(@PathVariable("post_num") int post_num) {
		PostVo vo = new PostVo();
		vo.setPost_num(post_num);
		ModelAndView view = new ModelAndView();
		view.setViewName("postContents");
		view.addObject("post",post_service.getPostContents(vo));
		return view;
	}
}
