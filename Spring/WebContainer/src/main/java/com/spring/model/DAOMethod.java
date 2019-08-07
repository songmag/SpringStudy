package com.spring.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface DAOMethod {
	List<VoObject> getAll();
	VoObject getOnce();
}
