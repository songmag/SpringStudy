package com.spring.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.model.vo.MenuVo;

@Repository
public class MenuDAO {
	public List<MenuVo> getMenuAll(SqlSession sql)
	{
		return sql.selectList("menu-mapper.getMenuAll"); 
	}
	public MenuVo getMenu(SqlSession sql, int menu_num)
	{
		return sql.selectOne("menu-mapper.getMenuByNum",menu_num);
	}
	public MenuVo getMenu(SqlSession sql, String menu_name)
	{
		return sql.selectOne("menu-mapper.getMenuByName",menu_name);
	}
	public void deleteMenu(SqlSession sql,int menu_num)
	{
		sql.delete("menu-mapper.deleteMenuByNum",menu_num);
	}
	public void deleteMenu(SqlSession sql,String menu_name)
	{
		sql.delete("menu-mapper.deleteMenuByName",menu_name);
	}
	public MenuVo updateMenu(SqlSession sql,MenuVo menu,MenuVo menu2)
	{
		sql.update("menu-mapper.updateMenu",menu2);
		menu = getMenu(sql,menu2.getMenu_name());
		return menu;
	}
	/**
	 * menu가 존재하면 return false
	 * menu가 존재하지 않으면 true
	 * @param sql
	 * @param menu
	 * @return
	 */
	public boolean checkMenu(SqlSession sql, MenuVo menu)
	{
		if(sql.selectOne("menu-mapper.checkMenu",menu.getMenu_name()) != null)
			return false;
		return true;
	}
	/**
	 * menu가 존재하면 return false
	 * menu가 존재하지 않으면 true
	 * @param sql
	 * @param menu_name
	 * @return
	 */
	public boolean checkMenu(SqlSession sql,String menu_name)
	{
		if(sql.selectOne("menu-mapper.checkMenu",menu_name) != null)
			return false;
		return true;
	}
	public void insertMenu(SqlSession sql,MenuVo menu)
	{
		sql.insert("menu-mapper.insertMenu",menu);
	}
}
