package com.spring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.service.UserService;


@RestController
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired private UserService user_service;
	
}
