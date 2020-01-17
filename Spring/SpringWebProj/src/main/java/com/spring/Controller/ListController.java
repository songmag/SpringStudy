package com.spring.Controller;

import javax.servlet.http.HttpServletRequest;

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
		if(req.getAttribute("user") == null)
		{
			view.setViewName("redirect:/login");
		}
		view.setViewName("menu");
		view.addObject("menu_list",menu_service.getMenu());
		view.addObject("errorCode",req.getAttribute("errorCode"));
		return view;
	}
	@RequestMapping(value="/post/{menu_num}/{page}")
	public ModelAndView getList(@PathVariable("menu_num") int menu_num,@PathVariable("page") int page_num)
	{
		MenuDTO menu = new MenuDTO();
		menu.setMenu_num(menu_num);
		ModelAndView view = new ModelAndView();
		view.setViewName("postList");
		PostListDTO dto = post_service.getPostList(menu, page_num);
		System.out.println(dto);
		view.addObject("list",dto);
		return view;
	}
}
