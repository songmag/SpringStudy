package com.spring.model.vo;

import java.lang.reflect.Field;
import java.sql.Date;

import com.spring.model.dto.UserDTO;
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
		if(name == null) return;
		if(name.isEmpty())
		{
			this.name = null;
			return;
		}
		this.name = name;
		return;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		if(id==null) return;
		if(id.isEmpty())
		{
			this.id = null;
			return;
		}
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		if(pw == null) return;
		if(pw.isEmpty())
		{
			this.pw = null;
			return;
		}
		this.pw = pw;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		if(phone_number == null) return;
		if(phone_number.isEmpty())
		{
			this.phone_number=null;
			return;
		}
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(address == null) return;
		if(address.isEmpty())
		{
			this.address = null;
			return;
		}
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
		if(self_instruction==null) return; 
		if(self_instruction.isEmpty())
		{
			this.self_instruction = null;
			return;
		}
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
	public void setUserDTO(UserDTO dto)
	{
		this.setId(dto.getId());
		this.setAddress(dto.getAddress());
		this.setId_num(dto.getId_num());
		this.setName(dto.getName());
		this.setPhone_number(dto.getPhone_number());
		this.setSelf_instruction(dto.getSelf_instruction());
	}
}
