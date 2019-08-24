package com.spring.error;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.spring.error.errorchecker.CommentErrorCheckerImpl;
import com.spring.error.errorchecker.MenuErrorCheckerImpl;
import com.spring.error.errorchecker.PostErrorCheckerImpl;
import com.spring.error.errorchecker.UserErrorCheckerImpl;

@Component
public class ErrorCheckerFactoryImpl implements ErrorCheckerFactory{

	@Autowired
	ApplicationContext application;
	@Override
	public Object errorChecker(Object[] dto, Class[] dto_class, String errorCode) {
		Class checker = null;
		System.out.println(dto_class[0].getName());
		if(!dto_class[0].getName().equals(dto[0].getClass().getName()))
		{
			System.out.println("Class Miss Match");
			return null;
		}
		if(dto_class[0].getName().equals("com.spring.model.dto.UserDTO"))
		{
			checker = UserErrorCheckerImpl.class;
		}
		else if(dto_class[0].getName().equals("com.spring.model.dto.MenuDTO"))
		{
			checker = MenuErrorCheckerImpl.class;
		}
		else if(dto_class[0].getName().equals("com.spring.model.dto.PostDTO"))
		{
			checker = PostErrorCheckerImpl.class;
		}
		else if(dto_class[0].getName().equals("com.spring.model.dto.CommentDTO"))
		{
			checker = CommentErrorCheckerImpl.class;
		}
		try {
			Method method = checker.getMethod(errorCode,dto_class);
			try {
				String checker_name = checker.getSimpleName();
				String bean_name = checker_name.substring(0,1).toLowerCase()+checker_name.substring(1);
				System.out.println(bean_name);
				return method.invoke(application.getBean(bean_name),dto);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			System.out.println("Method get Error");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 중복제거, 각각 클래스별 오브젝트 한개
	 */
	@Override
	public LinkedList<String> errorEmptyChecker(Object[] obj, Class[] cls, String...errorField) {
		/**
		 * Developer Error
		 */
		LinkedList<Class> list = new LinkedList<Class>();
		LinkedList<String> errorCode = new LinkedList<String>();
		for(Class cl : cls)
		{
			list.add(cl);
		}
		HashSet<Class> hash = new HashSet<Class>(list);
		//중복제거
		Map<String,Class> field_name;
		if(obj.length != hash.size())
		{
			errorCode.add("Error Code : obj miss class or Multiple Same Class");
			return errorCode;
		}
		for(int i = 0 ; i<obj.length ; i++)
		{
			if(!cls[i].getSimpleName().equals(obj[i].getClass().getSimpleName()))
			{
				errorCode.add("Error Code : class, obj miss match");
				return errorCode;
			}
		}
		for(Class cl : cls)
		{
			if(cl == String.class)
			{
				errorCode.add("String Object In");
				return errorCode;
			}
		}
		field_name = new HashMap<String,Class>();
		for(String error : errorField)
		{
			field_name.put(error,null);
			System.out.println("Error" + error);
			for(int i = 0 ; i< cls.length ; i++)
			{
				Field[] fields = cls[i].getDeclaredFields();
				for(Field field : fields)
				{
					System.out.println("field Name : "+ field.getName());
					if(error.equals(field.getName()))
					{
						
						String getMethodName="get"+field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
						try {
							Object field_value = cls[i].getMethod(getMethodName).invoke(obj[i]);
							if(field_value == null)
							{
								break;
							}
							else if(field_value.getClass() == String.class)
							{
								if(((String)field_value).isEmpty())
								{
									errorCode.add("ErrorCode : "+ error + " is Empty");
								}
							}
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
								| NoSuchMethodException | SecurityException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						field_name.put(error,cls[i]);
						break;
					}
				}
			}
			if(field_name.get(error) == null)
			{
				errorCode.add("ErrorField No match in Classes");
				return errorCode;
			}
		}
		if(errorCode.size() == 0)
			return null;
		return errorCode;
	}
}
