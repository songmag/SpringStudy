package com.spring.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.dao.UserDAO;
import com.spring.model.dto.UserDTO;
import com.spring.model.vo.UserVo;

@Service
public class UserService {
	@Autowired SqlSession sql;
	@Autowired UserDAO dao;
	
	//로그인 체크 해서 아이디가 존재하면 DTO 에 SETTING
	//아이디가 존재하지 않으면 null 리턴
	public UserDTO login(UserVo user)
	{
		if(!dao.login_check(sql, user)) return null;
		UserDTO dto = new UserDTO();
		
		UserVo temp = dao.getOnce(sql,user);
		dto.setAddress(temp.getAddress());
		dto.setId(temp.getId());
		dto.setId_num(temp.getId_num());
		dto.setName(temp.getName());
		dto.setPhone_number(temp.getPhone_number());
		dto.setSelf_instruction(temp.getSelf_instruction());
		return dto;
	}
	public UserDTO addUser(UserVo user)
	{
		if(!dao.id_check(sql, user)) return null; //존재하면 리턴
		UserDTO dto = new UserDTO();
		dao.addUser(sql, user);
		UserVo temp = dao.getOnce(sql,user);
		dto.setAddress(temp.getAddress());
		dto.setId(temp.getId());
		dto.setId_num(temp.getId_num());
		dto.setName(temp.getName());
		dto.setPhone_number(temp.getPhone_number());
		dto.setSelf_instruction(temp.getSelf_instruction());
		return dto;
	}
	public void deleteUser(UserVo user) 
	{
		if(!dao.login_check(sql,user)) return;//존재하지 않으면 리턴 , pw 틀려도 리턴
		dao.deleteUser(sql,user);
	}
	public UserDTO updateUser(UserVo user)
	{
		if(!dao.login_check(sql,user)) return null;//존재하지 않으면 리턴 , pw 틀려도 리턴
		UserDTO dto = new UserDTO();
		dao.updateUser(sql, user);
		UserVo temp = dao.getOnce(sql,user);
		dto.setAddress(temp.getAddress());
		dto.setId(temp.getId());
		dto.setId_num(temp.getId_num());
		dto.setName(temp.getName());
		dto.setPhone_number(temp.getPhone_number());
		dto.setSelf_instruction(temp.getSelf_instruction());
		return dto;
	}
}
