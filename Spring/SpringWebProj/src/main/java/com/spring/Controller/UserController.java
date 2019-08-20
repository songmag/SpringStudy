package com.spring.Controller;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.dto.UserDTO;
import com.spring.model.service.MenuService;
import com.spring.model.service.UserService;
import com.spring.model.vo.UserVo;

@Controller
public class UserController {
	@Autowired UserService user_service;
	@RequestMapping("/")
	public String main()
	{
		return "redirect:/login";
	}
	@GetMapping("/signin")
	public String signin()
	{
		return "signin";
	}
	@GetMapping("/logout")
	public String logOut(HttpServletRequest req) {
		req.getSession().removeAttribute("user");
		return "redirect:/login";
	}
	@PostMapping("/signin")
	public String signin(@ModelAttribute UserDTO user, @ModelAttribute("pw") String pw,HttpServletRequest req) {
		UserVo vo = new UserVo();
		vo.setId(user.getId());
		vo.setPw(pw);
		vo.setName(user.getName());
		vo.setPhone_number(user.getPhone_number());
		vo.setSelf_instruction(user.getSelf_instruction());
		UserDTO dto = user_service.addUser(vo);
		req.getSession().setAttribute("user", user);
		if(dto != null) {
			return "redirect:/menu/list";
		}
		return "forward:/";
	}
	@GetMapping(value="/login")
	public String main_page(HttpServletRequest req)
	{
		if(req.getSession().getAttribute("user")!= null)
		{
			return "redirect:/menu/list";
		}
		return "login";
	}
	@PostMapping(value="/login")
	public String login(@ModelAttribute UserDTO user, @ModelAttribute("pw") String pw,HttpServletRequest req)
	{
		UserVo vo  = new UserVo();
		vo.setId(user.getId());
		vo.setPw(pw);
		UserDTO dto = user_service.login(vo);
		if(dto == null)
		{
			return "forward:/";
		}
		req.getSession().setAttribute("user",dto);
		return "redirect:/menu/list";
	}
}
