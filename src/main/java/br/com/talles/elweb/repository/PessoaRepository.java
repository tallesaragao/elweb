package br.com.talles.elweb.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.talles.elweb.model.Pessoa;

@RequestScoped
public class PessoaRepository extends GenericRepository<Pessoa> {
	
	public PessoaRepository() {
		this(null);
	}
	
	@Inject
	public PessoaRepository(EntityManager manager) {
		this.manager = manager;
		this.classe = Pessoa.class;
	}
	
	public List<Pessoa> listByRange(int firstIndex, int maxResults) {
		String jpql = "select p from Pessoa p";
		TypedQuery<Pessoa> query = manager.createQuery(jpql, Pessoa.class);
		query.setFirstResult(firstIndex);
		query.setMaxResults(maxResults);
		return query.getResultList();
	}
}
