package com.spring.model.dto.user;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginDTO {
	@NotNull(message = "아이디 입력 부탁드립니다.")
	@NotEmpty(message = "아이디 입력 부탁드립니다.")
	private String id= null;
	@NotNull(message = "비밀번호 입력 부탁드립니다.")
	@NotEmpty(message = "비밀번호 입력 부탁드립니다.")
	private String pw= null;
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
}
