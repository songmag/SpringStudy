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
	public LinkedList<Object> getUser() throws BeansException, JSONException
	{
		LinkedList<Object> object = new LinkedList<Object>();
		for(String name : df.getBeanDefinitionNames())
		{
			object.add(name);
			System.out.println(name + "\t" + df.getBean(name).getClass().getName());
		}
		return object;
		//return dao.getAll();
	}
}
