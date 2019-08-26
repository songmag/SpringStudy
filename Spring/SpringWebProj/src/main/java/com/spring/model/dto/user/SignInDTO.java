package com.spring.model.dto.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SignInDTO {
	@NotNull(message ="NullValueCome")
	@NotEmpty(message = "이름값은 필수입니다!")
	private String name = null;
	@NotNull(message ="NullValueCome")
	@NotEmpty(message= "PW 값은 필수입니다.")
	private String pw = null;
	@NotNull(message ="NullValueCome")
	@NotEmpty(message="ID 값은 필수입니다.")
	private String id = null;
	@NotNull(message ="NullValueCome")
	private String phone_number = null;
	@NotNull(message ="NullValueCome")
	private String address = null;
	@NotNull(message ="NullValueCome")
	private String self_instruction = null;
	
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}
