package com.spring.Error;

import java.util.LinkedList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ErrorClass {
	public static List<String> errorCodeMake(BindingResult error){
		List<String> errorCode = null;
		if(error.hasErrors())
		{
			errorCode = new LinkedList<String>();
			List<FieldError> errors = error.getFieldErrors();
			for(FieldError e : errors)
			{
				errorCode.add(e.getDefaultMessage());
			}
		}
		return errorCode;
	}

}
