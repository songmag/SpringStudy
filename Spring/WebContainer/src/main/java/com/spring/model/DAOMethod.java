package com.spring.model;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface DAOMethod {
	List<VoObject> getAll();
	VoObject getOnce();
	
}
