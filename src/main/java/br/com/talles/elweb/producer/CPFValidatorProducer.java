package br.com.talles.elweb.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import br.com.caelum.stella.validation.CPFValidator;

@ApplicationScoped
public class CPFValidatorProducer {

	@Produces
	@ApplicationScoped
	public CPFValidator getCPFValidator() {
		return new CPFValidator();
	}
	
	public void dispose(@Disposes CPFValidator cpfValidator) {
		cpfValidator = null;
	}
}
