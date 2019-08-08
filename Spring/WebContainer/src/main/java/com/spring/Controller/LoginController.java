package com.spring.Controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
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
	@Autowired
	DefaultListableBeanFactory df;
	
	@RequestMapping(value="/")
	public List<UserVo> getUser()
	{
		return dao.getAll();
		//return dao.getAll();
	}
	@RequestMapping(value="/test")
	public void addUser()
	{
		UserVo user = new UserVo();
		user.setName("test3");
		user.setId("test3");
		user.setPw("1234");
		dao.addUser(user);
		List<UserVo> users = dao.getAll();
		dao.deleteUser(user);
		System.out.println(users);
	}
}
