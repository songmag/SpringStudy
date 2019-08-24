package com.spring.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.error.ErrorCheckerFactory;
import com.spring.model.dao.UserDAO;
import com.spring.model.dto.UserDTO;
import com.spring.model.vo.UserVo;

/**
 * DTO 를 입력받고, VO를 변형 DAO 작업을 수행하고, DTO로 변환시켜 다시 반환
 * @author SongDevelop
 *
 */
@Service
public class UserService {
	@Autowired SqlSession sql;
	@Autowired UserDAO dao;
	///////////////Private Part /////////////////////////
	private UserVo transDtoToVo(UserDTO user,String pw)
	{
		UserVo vo;
		vo = new UserVo();
		vo.setUserDTO(user);
		vo.setPw(pw);
		return vo;
	}
	private UserDTO transVoToDTO(UserVo user)
	{
		UserDTO dto;
		dto = new UserDTO();
		dto.setAddress(user.getAddress());
		dto.setId(user.getId());
		dto.setId_num(user.getId_num());
		dto.setName(user.getName());
		dto.setPhone_number(user.getPhone_number());
		dto.setSelf_instruction(user.getSelf_instruction());
		return dto;
	}
	private UserDTO transVoToDTO(UserVo user,UserDTO dto)
	{
		dto.setAddress(user.getAddress());
		dto.setId(user.getId());
		dto.setId_num(user.getId_num());
		dto.setName(user.getName());
		dto.setPhone_number(user.getPhone_number());
		dto.setSelf_instruction(user.getSelf_instruction());
		return dto;
	}
	///////////////Public Part /////////////////////////
	public UserDTO login(UserDTO user,String pw)
	{
		UserVo vo;
		vo = transDtoToVo(user,pw);
		if(!dao.login_check(sql, vo)) return null;
		vo = dao.getOnce(sql,vo);
		return transVoToDTO(vo,user);
	}
	public UserDTO addUser(UserDTO user,String pw)
	{
		UserVo vo;
		vo = transDtoToVo(user,pw);
		if(vo.getPw() == null) return null;
		if(vo.getName() == null) return null;
		if(!dao.id_check(sql, vo)) return null; //존재하면 리턴
		
		dao.addUser(sql, vo);
		vo = dao.getOnce(sql,vo);
		return transVoToDTO(vo, user);
	}
	public void deleteUser(UserDTO user,String pw) 
	{
		UserVo vo;
		vo = transDtoToVo(user,pw);
		if(!dao.login_check(sql,vo)) return;//존재하지 않으면 리턴 , pw 틀려도 리턴
		dao.deleteUser(sql,vo);
	}
	public UserDTO updateUser(UserDTO user,String pw)
	{
		UserVo vo;
		System.out.println(user);
		vo = transDtoToVo(user,pw);
		if(!dao.login_check(sql,vo)) return null;//존재하지 않으면 리턴 , pw 틀려도 리턴
		dao.updateUser(sql, vo);
		vo = dao.getOnce(sql,vo);
		return transVoToDTO(vo, user);
	}
}

