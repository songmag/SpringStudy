package com.spring;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.model.dto.MenuDTO;
import com.spring.model.dto.UserDTO;
import com.spring.model.service.MenuService;
import com.spring.model.service.UserService;
import com.spring.model.vo.MenuVo;
import com.spring.model.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebContainerApplication.class)
public class MenuServiceTest {
	@Autowired MenuService service;
	
	@Test
	public void startTest()
	{
		List<MenuDTO> menu =  service.getMenu();
		System.out.println(menu);
		MenuDTO temp = service.getMenu("c");
		System.out.println(temp);
		MenuVo temp_menu = new MenuVo();
		temp_menu.setMenu_name("testMenu");
		service.updateMenu(temp_menu);
		
	}
	
	//Test Scenario
	/*
	 * Scope Class Member : user1,user2
		1. Add User
			#User1
			Id = test1
			pw = 1234
			name = test1
			#User2
			Id = test2
			pw = 1234
			name = test2
		2. Search User
			#GetAllUser <List>
			#GetUser1 <Once>
			#GetUser2 <Once>
		3. Update User
			#User1 Name -> testUpdate1
			#User2 Name -> testUpdate2
		4. Delete User
			#User1 delete
			#User2 delete
			#GetAllUser <List>
			#Size check 
	*/
}