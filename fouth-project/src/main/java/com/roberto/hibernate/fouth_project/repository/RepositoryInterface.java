package com.roberto.hibernate.fouth_project.repository;

import java.util.List;


public interface RepositoryInterface {

	public <T> Long create(T entity);
	
	public <T> List<T> findAll();
	
	public <T> T findById(T id);
	
	public <T> boolean update(T entityToUpdate);
	
	public <T> boolean delete(T id);
	
	public int deleteAll();
}
