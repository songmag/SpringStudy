package com.spring.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.dto.MenuDTO;
import com.spring.model.dto.PostListDTO;
import com.spring.model.service.MenuService;
import com.spring.model.service.PostService;

@Controller
@RequestMapping(value="/list")
public class ListController {
	@Autowired MenuService menu_service;
	@Autowired PostService post_service;
	@RequestMapping(value="/menu")
	public ModelAndView getList(HttpServletRequest req)
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("menu");
		view.addObject("menu_list",menu_service.getMenu());
		System.out.println(req.getAttribute("errorCode"));
		view.addObject("errorCode",req.getAttribute("errorCode"));
		return view;
	}
	@GetMapping(value="/post/{menu_num}")
	public ModelAndView getList(@PathVariable("menu_num") int menu_num)
	{
		MenuDTO menu = new MenuDTO();
		menu.setMenu_num(menu_num);
		ModelAndView view = new ModelAndView();
		view.setViewName("postList");
		PostListDTO dto = post_service.getPostList(menu, 0);
		System.out.println(dto);
		view.addObject("list",post_service.getPostList(menu, 0));
		return view;
	}
}
