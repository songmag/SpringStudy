package com.spring;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.model.dao.UserDAO;
import com.spring.model.vo.UserVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebContainerApplication.class)
public class UserDAOTest {
	@Autowired UserDAO userdao;
	UserVo user1,user2;
	@Before
	public void setUser()
	{
		user1 = new UserVo();
		user2 = new UserVo();
		user1.setId("test1");
		user1.setPw("1234");
		user1.setName("test1");

		user2.setId("test2");
		user2.setPw("1234");
		user2.setName("test2");
	}
	@Test
	public void allTest()
	{
		testAddUser();
		testSearch();
		testDelete();
	}
	
	public void testAddUser()
	{
		userdao.addUser(user1);
		userdao.addUser(user2);
	}
	public void testSearch()
	{
		List<UserVo> users = userdao.getAll();
		user1 = userdao.getOnce(user1);
		user2 = userdao.getOnce(user2);
		assertThat(users.size(),is(2));
		assertThat(user1.getPhone_number(),is("000-000-0000"));
		assertThat(user2.getPhone_number(),is("000-000-0000"));
	}
	public void testDelete()
	{
		userdao.deleteUser(user1);
		userdao.deleteUser(user2);
		List<UserVo> users = userdao.getAll();
		assertThat(users.size(),is(0));
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
