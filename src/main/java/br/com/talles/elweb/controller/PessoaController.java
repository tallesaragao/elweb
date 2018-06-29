package br.com.talles.elweb.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.talles.elweb.model.Pessoa;
import br.com.talles.elweb.service.PessoaService;

@Controller
public class PessoaController {

	private Result result;
	private Validator validator;
	private PessoaService pessoaService;

	public PessoaController() {
		this(null, null, null);
	}
	
	@Inject
	public PessoaController(Result result, Validator validator, PessoaService pessoaService) {
		this.result = result;
		this.validator = validator;
		this.pessoaService = pessoaService;
	}

	public void form() {
		
	}
	
	@Path("pessoa/edit/{id}")
	public void edit(Long id) {
		if(!result.included().containsKey("pessoa")) {
			Pessoa pessoa = pessoaService.buscarPorId(id);
			if(pessoa == null) {
				result.include("aviso", "Pessoa não encontrada");
				result.redirectTo(this).list();
			} else {
				result.include("pessoa", pessoa);
			}
		}
	}
	
	public void list() {
		if(!result.included().containsKey("pessoas")) {
			result.redirectTo(this).listarAtivosPagina(1);
		}
	}
	
	@Path("pessoa/list/page/{pagina}")
	public void listarAtivosPagina(int pagina) {
		final int resultadosPorPagina = 5;
		int paginas = pessoaService.getNumeroPaginasPessoasAtivas(resultadosPorPagina);
		if(paginas == 0) {
			result.include("aviso", "Nenhuma pessoa encontrada");
			result.include("paginas", paginas);
			result.redirectTo(this).list();
		} else if(pagina > paginas) {
			result.include("aviso", "Página não encontrada");
			result.include("paginas", paginas);
			result.redirectTo(this).listarAtivosPagina(1);
		} else {
			List<Pessoa> pessoas = pessoaService.listarAtivosPorPagina(pagina, resultadosPorPagina);
			result.include("pessoas", pessoas);
			result.include("paginaSelecionada", pagina);
			result.include("paginas", paginas);
			result.use(Results.page()).of(PessoaController.class).list();
		}
	}
	
	@Post
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
		result.redirectTo(this).list();
	}
	
	@Post
	public void alterar(Pessoa pessoa) {
		List<SimpleMessage> erros = pessoaService.validarDadosPessoa(pessoa);
		for(SimpleMessage erro : erros) {
			validator.add(erro);
		}
		if(validator.hasErrors()) {
			result.include("pessoa", pessoa);
		}
		validator.onErrorRedirectTo(this).edit(pessoa.getId());
		pessoaService.alterarDadosPessoa(pessoa);
		result.include("sucesso", "Pessoa alterada com sucesso");
		result.redirectTo(this).list();
	}
	
	@Post
	public void excluir(Long id) {
		Pessoa pessoa = pessoaService.buscarPorId(id);
		if(pessoa == null) {
			result.include("aviso", "Pessoa não encontrada");
			result.redirectTo(this).list();
		} else {
			pessoaService.excluirPessoa(id);
			result.include("sucesso", "Pessoa excluída com sucesso");
			result.redirectTo(this).list();
		}
	}

}
