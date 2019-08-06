package com.spring.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestExController {
	@RequestMapping(value="/")
	public person mappingtest()
	{
		person a = new person();
		return a;
	}
}
