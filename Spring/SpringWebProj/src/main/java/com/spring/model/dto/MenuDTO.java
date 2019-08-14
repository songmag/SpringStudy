package com.spring.model.dto;

public class MenuDTO {
	private String menu_name;
	private int menu_num;
	private int menu_count;
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
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
		this.menu_count = menu_count-1;
	}
	@Override
	public String toString() {
		return "MenuDTO [menu_name=" + menu_name + ", menu_num=" + menu_num + ", menu_count=" + menu_count + "]";
	}
}
