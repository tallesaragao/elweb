package br.com.talles.elweb.repository;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
	
	public List<Pessoa> listAtivos() {
		String jpql = "select p from Pessoa p where p.ativo = :ativo";
		TypedQuery<Pessoa> query = manager.createQuery(jpql, Pessoa.class);
		query.setParameter("ativo", true);
		return query.getResultList();
	}
	public List<Pessoa> listAtivosByRange(int firstIndex, int maxResults) {
		String jpql = "select p from Pessoa p where p.ativo = :ativo";
		TypedQuery<Pessoa> query = manager.createQuery(jpql, Pessoa.class);
		query.setParameter("ativo", true);
		query.setFirstResult(firstIndex);
		query.setMaxResults(maxResults);
		return query.getResultList();
	}

	public Long getNumeroPessoasAtivas(int resultadosPorPagina) {
		String jpql = "select count(p.id) from Pessoa p where p.ativo = :ativo";
		TypedQuery<Long> query = manager.createQuery(jpql, Long.class);
		query.setParameter("ativo", true);
		return query.getSingleResult();
		
	}
}
