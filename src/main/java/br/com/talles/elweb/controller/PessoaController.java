package br.com.talles.elweb.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.talles.elweb.model.Pessoa;
import br.com.talles.elweb.service.PessoaService;

@Controller
public class PessoaController {

	private Result result;
	private Validator validator;
	private PessoaService pessoaService;

	public PessoaController() {
		this(null, null, null, null);
	}
	
	@Inject
	public PessoaController(Result result, Validator validator, PessoaService pessoaService, EntityManager manager) {
		this.result = result;
		this.validator = validator;
		this.pessoaService = pessoaService;
	}

	public void form() {
		
	}
	
	public void list() {
		
	}
	
	public void inserir(Pessoa pessoa) {
		List<SimpleMessage> erros = pessoaService.validarDadosPessoa(pessoa);
		for(SimpleMessage erro : erros) {
			validator.add(erro);
		}
		if(validator.hasErrors()) {
			result.include("pessoa", pessoa);
		}
		validator.onErrorRedirectTo(this).form();
		pessoaService.inserirPessoa(pessoa);
		result.include("sucesso", "Pessoa cadastrada com sucesso");
		result.redirectTo(this).form();
	}

}
