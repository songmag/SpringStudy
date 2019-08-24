package com.spring.Controller;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.error.ErrorCheckerFactory;
import com.spring.model.dto.UserDTO;
import com.spring.model.service.UserService;

@Controller
public class LoginController {
	@Autowired UserService user_service;
	@Autowired ErrorCheckerFactory error;
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
	public String login_post(@ModelAttribute UserDTO dto,@ModelAttribute("pw") String pw,HttpServletRequest req)
	{
		//Form Error Checking ServerSide
		String errorCode = (String) error.errorChecker(new Object[]{dto,pw},new Class[]{ UserDTO.class,String.class},"logInCheck");
		if(errorCode != null) {
			req.setAttribute("errorCode",errorCode);
			return "forward:/login";
		}
		//Service Error Checking
		UserDTO user;
		user = user_service.login(dto, pw);
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
	public String signin(@ModelAttribute UserDTO dto,@ModelAttribute("pw") String pw, HttpServletRequest req)
	{
		if(req.getSession().getAttribute("user") != null)
		{
			return "redirect:/list/menu";
		}
		LinkedList<String> errorCode;
		errorCode = error.errorEmptyChecker(new Object[]{dto}, new Class[]{ UserDTO.class},"id","name");
		if(pw.isEmpty())
		{
			errorCode.add("ErrorCode : password is Empty");
		}
		if(errorCode != null)
		{
			req.setAttribute("errorCode",errorCode);
			return "forward:/signin";
		}
		UserDTO user;
		user=user_service.addUser(dto, pw);
		
		if(user == null)
		{
			return "redirect:/login";
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
