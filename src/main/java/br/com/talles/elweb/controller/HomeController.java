package br.com.talles.elweb.controller;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class HomeController {
	
	private Result result;
	private EntityManager manager;

	public HomeController() {
		this(null, null);
	}
	
	@Inject
	public HomeController(Result result, EntityManager manager) {
		this.result = result;
		this.manager = manager;
	}

	@Path("/")
	public void index() {
		result.include("msg", "Message from your controller");
	}
}