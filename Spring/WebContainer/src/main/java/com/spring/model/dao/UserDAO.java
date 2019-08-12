package com.spring.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.spring.model.vo.UserVo;


@Repository
public class UserDAO{	
	@Autowired private SqlSession sql;
	private boolean login_check(UserVo user)
	{
		return sql.selectOne("user-mapper.loginCheck",user);
	}
	public List<UserVo> getAll() {
		return sql.selectList("user-mapper.getAllUser");
	}
	public void addUser(UserVo vo) {
		if(login_check(vo)) return;
		sql.insert("user-mapper.addUser",vo);
	}
	public void deleteUser(UserVo vo) {
		if(login_check(vo))
			sql.delete("user-mapper.deleteUserById",vo);
	}
	public void UpdateUser(UserVo vo)
	{
		if(login_check(vo))
			sql.update("user-mapper.updateUserById",vo);
	}
	public UserVo getOnce(UserVo vo) {
		if(!login_check(vo)) return null;
		return sql.selectOne("user-mapper.getUserById", vo);
	}
}
