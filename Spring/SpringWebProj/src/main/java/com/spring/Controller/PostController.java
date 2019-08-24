package com.spring.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.dto.PostContentsDTO;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@GetMapping("/insert")
	public ModelAndView postinsert()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("postInsert");
		return view;
	}
	@PostMapping("/insert")
	public ModelAndView postinsert(@ModelAttribute PostContentsDTO dto)
	{
		return null;
	}

	@GetMapping(value ="/post/testCheck")
	public ModelAndView getTest()
	{
		ModelAndView view = new ModelAndView();
		view.setViewName("postInsert");	
		view.addObject("errorCode","Test");
		return view;
	}
}
