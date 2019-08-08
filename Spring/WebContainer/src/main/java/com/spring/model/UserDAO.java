package com.spring.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAO{	
	@Autowired private SqlSession sql;
	
	public List<UserVo> getAll() {
		return sql.selectList("user-mapper.getAllUser");
	}
	public void addUser(UserVo vo) {
		sql.insert("user-mapper.addUser",vo);
	}
	public void deleteUser(UserVo vo) {
		sql.delete("user-mapper.deleteUserById",vo);
	}
	public void UpdateUser(UserVo vo)
	{
		sql.update("user-mapper.updateUserById",vo);
	}
	public UserVo getOnce(UserVo vo) {
		return sql.selectOne("user-mapper.getUserById", vo);
	}
}
