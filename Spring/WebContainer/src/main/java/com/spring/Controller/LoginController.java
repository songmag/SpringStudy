package com.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.UserDAO;
import com.spring.model.UserVo;
import com.spring.model.VoObject;


@RestController
@RequestMapping(value = "/login")
public class LoginController {
	@Autowired private UserDAO dao;
	@RequestMapping(value="/")
	public List<VoObject> getUser()
	{
		return dao.getAll();
	}
}
