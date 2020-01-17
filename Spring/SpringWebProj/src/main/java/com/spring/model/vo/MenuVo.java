package com.spring.model.vo;

import com.spring.model.dto.MenuDTO;

public class MenuVo {
	private String menu_name=null;
	private int menu_num = 0;
	private int menu_count = 0;
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		if(menu_name.isEmpty())
		{
			this.menu_name = null;
			return;
		}
		this.menu_name = menu_name;
	}
	public int getMenu_num() {
		return menu_num;
	}
	public void setMenu_num(int menu_num) {
		this.menu_num = menu_num;
	}
	public int getMenu_count() {
		return menu_count;
	}
	public void setMenu_count(int menu_count) {
		this.menu_count = menu_count;
	}

	@Override
	public String toString() {
		return "MenuVo [menu_name=" + menu_name + ", menu_num=" + menu_num + ", menu_count=" + menu_count + "]";
	}

	public void setMenuDTO(MenuDTO dto)
	{
		this.setMenu_count(dto.getMenu_count());
		if(dto.getMenu_name() != null)
		this.setMenu_name(dto.getMenu_name());
		this.setMenu_num(dto.getMenu_num());
	}
}
