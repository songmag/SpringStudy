package com.spring.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.dto.UserDTO;
import com.spring.model.service.MenuService;
import com.spring.model.vo.MenuVo;
import com.spring.model.vo.PostVo;

@Controller
@RequestMapping(value = "/menu")
public class MenuController {
	@Autowired MenuService menu_service;
	
	@RequestMapping(value="/list")
	public ModelAndView getList(@ModelAttribute UserDTO dto,HttpServletRequest req)
	{
		ModelAndView view = new ModelAndView();
		if(req.getSession().getAttribute("user")== null)
		{
			view.setViewName("login");
		}
		else {
			view.setViewName("menu");
			view.addObject("menu_list",menu_service.getMenu());
		}
		return view;
	}
	@RequestMapping(value="/list/{menu_num}")
	public String getPostContents(@PathVariable("menu_num") int menu,HttpServletRequest req)
	{
		return "redirect:/post/list?menu_num={menu_num}";
	}
}
