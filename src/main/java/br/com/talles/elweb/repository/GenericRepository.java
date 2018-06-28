package br.com.talles.elweb.repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public abstract class GenericRepository<T> implements IRepository<T> {

	protected EntityManager manager;
	protected Class<T> classe;
	
	@Override
	public T findById(Long id) {
		return manager.find(classe, id);
	}
	
	@Override
	public List<T> listAll() {
		String jpql = "select e from " + classe.getSimpleName() + " e";
		TypedQuery<T> query = manager.createQuery(jpql, classe);
		return query.getResultList();
	}

	@Override
	public boolean save(T entity) {
		if(entity.getClass().isAnnotationPresent(Entity.class)) {
			manager.getTransaction().begin();
			manager.persist(entity);
			manager.getTransaction().commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean update(T entity) {
		if(entity.getClass().isAnnotationPresent(Entity.class)) {
			manager.getTransaction().begin();			
			manager.merge(entity);
			manager.getTransaction().commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(T entity) {
		if(entity.getClass().isAnnotationPresent(Entity.class)) {
			manager.getTransaction().begin();	
			manager.remove(entity);
			manager.getTransaction().commit();
			return true;
		}
		return false;
	}

}
