package com.spring.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.dao.CommentDAO;
import com.spring.model.dto.CommentInsertDTO;
import com.spring.model.vo.CommentVo;

@Service
public class CommentService {
	@Autowired CommentDAO dao;
	@Autowired SqlSession sql;
	public void InsertComment(CommentInsertDTO dto,int id_num)
	{
		CommentVo temp = new CommentVo();
		temp.setId_num(id_num);
		temp.setContext(dto.getContext().replaceAll("\r\n","<br>"));
		temp.setPost_num(dto.getPost_num());
		dao.insert_Comment(sql,temp);
	}
}
