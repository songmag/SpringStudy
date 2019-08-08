package com.spring.model;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements DAOMethod{	
	@Autowired private SqlSession sql;
	@Override
	public List<VoObject> getAll() {
		return sql.selectList("db_mapper.all_identity");
	}	
	public void addUser(UserVo vo) {
		sql.insert("db_mapper.add_user",vo);
	}
	public void deleteUser(UserVo vo) {
		sql.delete("db_mapper.delete_user",vo);
	}
	public void UpdateUser(UserVo vo)
	{
		sql.update("db_mapper.update_user",vo);
	}
	@Override
	public VoObject getOnce() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
