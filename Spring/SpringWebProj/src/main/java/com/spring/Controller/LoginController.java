package com.spring.Controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.Error.ErrorClass;
import com.spring.model.dto.user.LoginDTO;
import com.spring.model.dto.user.SignInDTO;
import com.spring.model.dto.user.UserDTO;
import com.spring.model.service.UserService;

@Controller
public class LoginController {
	@Autowired UserService user_service;
	/**
	 * 
	 * @return root page => login
	 */
	@RequestMapping("/")
	public String mainPage()
	{
		return "redirect:/login";
	}
	/**
	 * 
	 * @param req
	 * @return login Page Return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest req)
	{
		if(req.getSession().getAttribute("user")!= null)
		{
			return "redirect:/list/menu";
		}
		return "login";
	}
	/**
	 * 
	 * @param dto UserDTO
	 * @param pw String 
	 * @param req HttpServletRequest <= getSession
	 * @return errorCode:form Error(page), Login Error(service)<br>
	 * forward:/login or redirect:/list/menu
	 */
	@PostMapping("/login/checking")
	public String login_post(@Valid @ModelAttribute LoginDTO dto,BindingResult result,HttpServletRequest req)
	{
		if(result.hasErrors())
		{
			req.setAttribute("errorCode", ErrorClass.errorCodeMake(result));
			return "forward:/login";
		}
		//Service Error Checking
		UserDTO user = new UserDTO();
		user.setId(dto.getId());
		user = user_service.login(user,dto.getPw());
		if(user == null)
		{
			req.setAttribute("errorCode","Login 정보가 없습니다.");
			return "forward:/login";
		}
		req.getSession().setAttribute("user",user);
		return "redirect:/list/menu";
	}
	@RequestMapping("/signin")
	public String signin()
	{
		return "signin";
	}
	@PostMapping("/signin/checking")
	public String signin(@Valid @ModelAttribute SignInDTO dto,BindingResult error, HttpServletRequest req)
	{
		if(req.getSession().getAttribute("user") != null)
		{
			return "redirect:/list/menu";
		}
		if(error.hasErrors())
		{
			req.setAttribute("errorCode", ErrorClass.errorCodeMake(error));
			return "forward:/signin";
		}
		
		UserDTO user;
		user = new UserDTO();
		user.setId(dto.getId());
		user.setAddress(dto.getAddress());
		user.setName(dto.getName());
		user.setPhone_number(dto.getPhone_number());
		user.setSelf_instruction(dto.getSelf_instruction());
		user=user_service.addUser(user,dto.getPw());
		if(user == null)
		{
			req.setAttribute("errorCode","Id가 존재합니다.");
			return "forward:/signin";
		}
		req.getSession().setAttribute("user",user);
		return "forward:/list/menu";
	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest req)
	{
		req.getSession().removeAttribute("user");
		return "redirect:/login";
	}
	@GetMapping("/changeInfo")
	public ModelAndView changeInfo(HttpServletRequest req)
	{
		ModelAndView view;
		view = new ModelAndView();
		view.setViewName("changeInfo");
		if(req.getSession().getAttribute("user") == null)
		{
			view.setViewName("redirect:/login");
		}
		view.addObject("user",req.getSession().getAttribute("user"));
		return view;
	}
	@PostMapping("/changeInfo/checking")
	public String changeInfo(@ModelAttribute UserDTO user,@ModelAttribute(name = "pw") String pw,HttpServletRequest req){
		UserDTO dto = (UserDTO) req.getSession().getAttribute("user");
		dto.setName(user.getName());
		dto.setAddress(user.getAddress());
		dto.setPhone_number(user.getPhone_number());
		dto.setSelf_instruction(user.getSelf_instruction());
		dto = user_service.updateUser(dto,pw);
		if(dto == null)
		{
			return "redirect:/list/menu";
		}
		req.removeAttribute("user");
		req.setAttribute("user", dto);
		return "redirect:/login";
	}
}
