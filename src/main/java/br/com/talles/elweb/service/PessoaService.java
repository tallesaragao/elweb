package br.com.talles.elweb.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.google.common.base.Strings;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;
import br.com.caelum.vraptor.validator.Severity;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.talles.elweb.model.Pessoa;
import br.com.talles.elweb.repository.PessoaRepository;

@RequestScoped
public class PessoaService {

	private PessoaRepository pessoaRepository;
	private CPFValidator cpfValidator;

	@Deprecated
	public PessoaService() {
		this(null, null);
	}

	@Inject
	public PessoaService(PessoaRepository pessoaRepository, CPFValidator cpfValidator) {
		this.pessoaRepository = pessoaRepository;
		this.cpfValidator = cpfValidator;
	}

	public List<SimpleMessage> validarDadosPessoa(Pessoa pessoa) {
		List<SimpleMessage> erros = new ArrayList<>();
		if (Strings.isNullOrEmpty(pessoa.getCpf())) {
			erros.add(new SimpleMessage("pessoa.cpf", "O CPF é obrigatório", Severity.ERROR));
		} else {
			try {
				cpfValidator.assertValid(pessoa.getCpf());
			} catch (InvalidStateException e) {
				erros.add(new SimpleMessage("pessoa.cpf", "CPF inválido", Severity.ERROR));
			}
		}
		if (Strings.isNullOrEmpty(pessoa.getNome())) {
			erros.add(new SimpleMessage("pessoa.nome", "O nome é obrigatório", Severity.ERROR));
		}
		if (pessoa.getAltura() <= Double.valueOf(0)) {
			erros.add(new SimpleMessage("pessoa.altura", "A altura deve ser superior a zero", Severity.ERROR));
		}
		if (pessoa.getMassa() <= Double.valueOf(0)) {
			erros.add(new SimpleMessage("pessoa.massa", "O peso deve ser superior a zero", Severity.ERROR));
		}
		return erros;
	}
	
	public void inserirPessoa(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}
	
	public void alterarDadosPessoa(Pessoa pessoa) {
		Pessoa pessoaOld = pessoaRepository.findById(pessoa.getId());
		pessoaOld.setAltura(pessoa.getAltura());
		pessoaOld.setMassa(pessoa.getMassa());
		pessoaOld.setCpf(pessoa.getCpf());
		pessoaOld.setNome(pessoa.getNome());
		pessoaRepository.update(pessoaOld);
	}
	
	public void excluirPessoa(Long id) {
		Pessoa pessoa = pessoaRepository.findById(id);
		pessoa.setAtivo(false);
		pessoaRepository.update(pessoa);
	}
	
	public List<Pessoa> listarAtivos() {
		return pessoaRepository.listAtivos();
	}
	
	public List<Pessoa> listarAtivosPorPagina(int pagina, int resultadosPorPagina) {
		int firstIndex = 1;
		firstIndex = firstIndex + (firstIndex * (pagina - 1));
		return pessoaRepository.listAtivosByRange(firstIndex, resultadosPorPagina);
	}
	
	public Pessoa buscarPorId(Long id) {
		return pessoaRepository.findById(id);
	}
	
	public int getNumeroPaginasPessoasAtivas(int resultadosPorPagina) {
		int numeroPessoasAtivas = pessoaRepository.getNumeroPessoasAtivas(resultadosPorPagina);
		int paginas = (int) Math.ceil(Double.valueOf(numeroPessoasAtivas) / Double.valueOf(resultadosPorPagina));
		return paginas;
	}
	
}
