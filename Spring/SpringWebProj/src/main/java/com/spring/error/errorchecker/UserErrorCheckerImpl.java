package com.spring.error.errorchecker;

import org.springframework.stereotype.Component;

import com.spring.model.dto.UserDTO;

@Component
public class UserErrorCheckerImpl implements UserErrorChecker{

	@Override
	public Object updateCheck(UserDTO dto, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object deleteCheck(UserDTO dto, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object signInCheck(UserDTO dto, String pw) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object logInCheck(UserDTO dto, String pw) {
		if(dto.getId().isEmpty()) {
			return "ID 칸을 채워주세요";
		}
		if(pw.isEmpty())
		{
			return "pw 칸을 채워주세요";
		}
		return null;
	}
		
}
