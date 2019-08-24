package com.spring.error;

import java.util.LinkedList;

import org.springframework.stereotype.Component;
@Component
public interface ErrorCheckerFactory {
	/**
	 * @param dto Object[]
	 * @param dto_class Class[]
	 * @param errorCode String
	 * 	{@value
	 * 		UserDTO = "updateCheck, deleteCheck, signInCheck,logInCheck"<br>
	 *      MenuDTO = "insertCheck, deleteCheck, updateCheck"<br>
	 *    	PostDTO = "insertCheck, deleteCheck, updateCheck"<br>
	 *   	CommentDTO = "insertCheck, deleteCheck, updateCheck"<br>
	 *   }
	 * @return ErrorString
	 */
	public Object errorChecker(Object[] dto,Class[] dto_class,String errorCode);
	public LinkedList<String> errorEmptyChecker(Object[] obj,Class[] cls,String...errorField);
}
