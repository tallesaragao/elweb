package br.com.talles.elweb.repository;

import java.util.List;

public interface IRepository<T> {
	
	public T findById(Long id);
	
	public List<T> listAll();
	
	public boolean save(T entity);
	
	public boolean update(T entity);
	
	public boolean delete(T entity);
}
