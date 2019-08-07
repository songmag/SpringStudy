package com.spring.model;

import java.util.List;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	@Override
	public VoObject getOnce() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
