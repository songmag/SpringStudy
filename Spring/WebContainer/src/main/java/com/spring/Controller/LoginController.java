package com.spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	@RequestMapping(value="/login")
	public person login_main()
	{
		System.out.println("loginMain");
		person a = new person();
		return a;
	}
	@RequestMapping(value="/sign")
	public String sign()
	{
		System.out.println("sign");
		return "sign";
	}
	@RequestMapping(value="/sign/{id}")
	public String login()
	{
		return "login";
	}
}
