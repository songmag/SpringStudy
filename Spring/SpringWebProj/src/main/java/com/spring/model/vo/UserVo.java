package com.spring.model.vo;

import java.sql.Date;
public class UserVo {
	private int id_num=0;
	private String name=null;
	private String id=null;
	private String pw=null;
	private String phone_number=null;
	private String address=null;
	private Date date=null;
	private String self_instruction=null;
	public UserVo() {}
	public UserVo(int id_num, String name, String id, String pw, String phone_number, String address, Date date,
			String self_instruction) {
		super();
		this.id_num = id_num;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phone_number = phone_number;
		this.address = address;
		this.date = date;
		this.self_instruction = self_instruction;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getSelf_instruction() {
		return self_instruction;
	}
	public void setSelf_instruction(String self_instruction) {
		this.self_instruction = self_instruction;
	}
	public int getId_num() {
		return id_num;
	}
	public void setId_num(int id_num)
	{
		this.id_num = id_num;
	}
	@Override
	public String toString() {
		return "UserVo [id_num=" + id_num + ", name=" + name + ", id=" + id + ", pw=" + pw + ", phone_number="
				+ phone_number + ", address=" + address + ", date=" + date + ", self_instruction=" + self_instruction
				+ "]";
	}
}