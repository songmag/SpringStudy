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
	UserVo vo;
	@Before
	public void before()
	{
		vo = new UserVo();
		vo.setId("123");
		
	}
	
	@Test
	public void testDelete()
	{
		vo.setId("123");
		userdao.getOnce(vo);
		assertThat(vo.getName(),is("123"));
		userdao.deleteUser(vo);
	}
	@Test
	public void testAddUser()
	{
		vo.setPw("123");
		vo.setName("123");
		userdao.addUser(vo);
		userdao.getOnce(vo);
	}
}
