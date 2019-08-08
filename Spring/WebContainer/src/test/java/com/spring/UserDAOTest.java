package com.spring;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.model.UserDAO;
import com.spring.model.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebContainerApplication.class)
public class UserDAOTest {
	@Autowired UserDAO userdao;
	@Test
	public void testAddUser()
	{
		
	}
	@Test
	public void testDelete()
	{
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
