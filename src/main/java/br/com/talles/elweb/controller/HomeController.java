package br.com.talles.elweb.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class HomeController {
	
	private Result result;

	public HomeController() {
		this(null);
	}
	
	@Inject
	public HomeController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void index() {
		result.redirectTo(PessoaController.class).list();
	}
}