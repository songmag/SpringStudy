package com.spring.error.errorchecker;

import com.spring.model.dto.UserDTO;
/**
 * 
 * @author songm
 * @param UserDTO, String pw
 * @apiNote 
 *  updateCheck, deleteCheck, signInCheck,logInCheck
 */
public interface UserErrorChecker {
	public Object updateCheck(UserDTO dto,String pw);
	public Object deleteCheck(UserDTO dto,String pw);
	public Object signInCheck(UserDTO dto,String pw);
	public Object logInCheck(UserDTO dto,String pw);
}
