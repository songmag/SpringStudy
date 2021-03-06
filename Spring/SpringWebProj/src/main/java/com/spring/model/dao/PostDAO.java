package com.spring.model.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.model.vo.MenuVo;
import com.spring.model.vo.PostVo;
import com.spring.model.vo.UserVo;

@Repository
public class PostDAO {
	private final int OFFSET = 20;
	public PostVo getPostContents(SqlSession sql,PostVo post)
	{
		return sql.selectOne("post-mapper.getPostNumContents",post.getPost_num());	
	}
	public List<PostVo> getPostList(SqlSession sql,int page)
	{
		return sql.selectList("post-mapper.getAllPost",(page == 0 )? page : (page*OFFSET-1));
	}
	public List<PostVo> getPostList(SqlSession sql,MenuVo menu,int page)
	{
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("page",(page == 0 )? page : (page*OFFSET-1));
		if(menu.getMenu_num() != 0)
		{
			param.put("menu_num", menu.getMenu_num());
			return sql.selectList("post-mapper.getPostListByMenuNum",param);
		}
		else
		{
			param.put("menu_name", menu.getMenu_name());
			return sql.selectList("post-mapper.getPostListByMenuName",param);	
		}
	}
	public List<PostVo> getPostList(SqlSession sql,UserVo user,int page)
	{
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("page",(page == 0 )? page : (page*OFFSET-1));
		if(user.getId_num() != 0) {
			param.put("id_num", user.getId_num());
			return sql.selectList("post-mapper.getPostListByIdNum",param);		
		}
		else if(user.getId() != null)
		{
			param.put("id", user.getId());
			return sql.selectList("post-mapper.getPostListById",param);	
		}
		else
		{
			param.put("name", user.getName());
			return sql.selectList("post-mapper.getPostListByUserName",param);
		}
	}
	public void insertPost(SqlSession sql,PostVo post)
	{
		sql.insert("post-mapper.insertPost",post);
	}
	public void deletePost(SqlSession sql,PostVo post)
	{
		sql.delete("post-mapper.deletePost",post);
	}
	public void updatePost(SqlSession sql,PostVo post)
	{	
	}
}
