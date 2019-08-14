package com.spring.model.service;

import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.dao.MenuDAO;
import com.spring.model.dto.MenuDTO;
import com.spring.model.vo.MenuVo;

@Service
public class MenuService {
	@Autowired SqlSession sql;
	@Autowired MenuDAO dao;
	public List<MenuDTO> getMenu()
	{
		List<MenuDTO> dtos = new LinkedList<MenuDTO>();
		for(MenuVo vo : dao.getMenuAll(sql))
		{
			MenuDTO dto = new MenuDTO();
			dto.setMenu_count(vo.getMenu_count());
			dto.setMenu_name(vo.getMenu_name());
			dto.setMenu_num(vo.getMenu_num());
			dtos.add(dto);
		}
		return dtos;
	}
	public MenuDTO getMenu(String menu_name)
	{
		MenuDTO dto = new MenuDTO();
		MenuVo temp = dao.getMenu(sql, menu_name);
		dto.setMenu_count(temp.getMenu_count());
		dto.setMenu_name(temp.getMenu_name());
		dto.setMenu_num(temp.getMenu_num());
		return dto;
	}
	public MenuDTO getMenu(int menu_num)
	{
		MenuDTO dto = new MenuDTO();
		MenuVo temp = dao.getMenu(sql, menu_num);
		dto.setMenu_count(temp.getMenu_count());
		dto.setMenu_name(temp.getMenu_name());
		dto.setMenu_num(temp.getMenu_num());
		return dto;
	}
	public void addMenu(MenuVo menu)
	{
		dao.insertMenu(sql, menu);
	}
	public void deletMenu(String menu_name)
	{
		dao.deleteMenu(sql, menu_name);
	}
	public void deletMenu(int menu_num)
	{
		dao.deleteMenu(sql, menu_num);
	}
	
	public MenuDTO updateMenu(MenuVo menu)
	{
		if(dao.checkMenu(sql,menu)) return null;
		MenuDTO dto = new MenuDTO();
		MenuVo temp = new MenuVo();
		temp.setMenu_num(menu.getMenu_num());
		temp.setMenu_name(menu.getMenu_name());
				dao.updateMenu(sql,menu,temp);
		dto.setMenu_count(temp.getMenu_count());
		dto.setMenu_name(temp.getMenu_name());
		dto.setMenu_num(temp.getMenu_num());
		return dto;
	}
}
