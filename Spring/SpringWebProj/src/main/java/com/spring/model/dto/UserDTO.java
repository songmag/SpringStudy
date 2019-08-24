package com.spring.model.dto;

import javax.validation.constraints.NotBlank;

public class UserDTO {
	private int id_num;
	private String name;
	
	private String id;
	private String phone_number;
	private String address;
	private String self_instruction;
	public int getId_num() {
		return id_num;
	}
	public void setId_num(int id_num) {
		this.id_num = id_num;
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
	public String getSelf_instruction() {
		return self_instruction;
	}
	public void setSelf_instruction(String self_instruction) {
		this.self_instruction = self_instruction;
	}
	@Override
	public String toString() {
		return "UserDTO [id_num=" + id_num + ", name=" + name + ", id=" + id + ", phone_number=" + phone_number
				+ ", address=" + address + ", self_instruction=" + self_instruction + "]";
	}
}
