package com.spring.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.model.vo.UserVo;


@Repository
public class UserDAO{
	/**
	 * ID,PW CHECK 해서 리턴이 없으면 FALSE RETURN
	 * @param sql
	 * @param user
	 * @return Boolean
	 */
	public boolean login_check(SqlSession sql,UserVo user)
	{
		if(sql.selectOne("user-mapper.loginCheck",user) == null)
			return false;
		return true;
	}
	/**
	 * ID 존재하면 FALSE RETURN
	 * @param sql
	 * @param user
	 * @return boolean
	 */
	public boolean id_check(SqlSession sql,UserVo user)
	{
		if(sql.selectOne("user-mapper.idCheck",user) != null) 
			return false;
		return true;
	}
	/**
	 * 
	 * @param sql
	 * @return LIST<USERVO>
	 */
	public List<UserVo> getAll(SqlSession sql) {
		return sql.selectList("user-mapper.getAllUser");
	}
	/**
	 * 
	 * @param sql
	 * @param vo
	 */
	public void addUser(SqlSession sql,UserVo vo) {
		sql.insert("user-mapper.addUser",vo);
	}
	/**
	 * 
	 * @param sql
	 * @param vo
	 */
	public void deleteUser(SqlSession sql,UserVo vo) {
		sql.delete("user-mapper.deleteUserById",vo);
	}
	/**
	 * 
	 * @param sql
	 * @param vo
	 */
	public void updateUser(SqlSession sql,UserVo vo)
	{
			sql.update("user-mapper.updateUserById",vo);
	}
	/**
	 * 
	 * @param sql
	 * @param vo
	 * @return USERVO
	 */
	public UserVo getOnce(SqlSession sql,UserVo vo) {
		return sql.selectOne("user-mapper.getUserById", vo);
	}
}
