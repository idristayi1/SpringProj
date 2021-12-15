package com.qa.dogSpring.service;

import java.util.List;

public interface ServiceMethods <T> {
	
	
	// CRUD Method -----Create, Read, Update and Delete
	
	//Create
	T create(T t);
	
	//Read All
	List<T> getAll();
	
	//Read By Id
	T getById(long id);
	
	//Update
	T update(long id, T t);
	
	//Delete
	boolean delete(long id);
	

}
