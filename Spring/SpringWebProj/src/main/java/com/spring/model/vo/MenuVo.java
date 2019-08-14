package com.spring.model.vo;

public class MenuVo {
	private String menu_name;
	private int menu_num = 0;
	private int menu_count = 0;
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
		this.menu_count = menu_count;
	}
}
