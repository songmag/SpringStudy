package com.spring.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.model.vo.CommentVo;
import com.spring.model.vo.PostVo;

@Repository
public class CommentDAO {
	public List<CommentVo> getComments(SqlSession sql,PostVo post)
	{
		if(post.getPost_num()!=0)
		{
			return sql.selectList("comment-mapper.getCommentListByNum",post.getPost_num());
		}
		return sql.selectList("comment-mapper.getCommentListByName",post.getPost_name());
	}
	public void insert_Comment(SqlSession sql,CommentVo vo)
	{
		sql.insert("comment-mapper.insertComment",vo);
	}
	public void delete_Comment(SqlSession sql,int comment_num)
	{
		sql.delete("comment-mapper.deleteComment",comment_num);
	}
	public void update_Comment(SqlSession sql,int comment_num,CommentVo vo)
	{
		
	}
}

