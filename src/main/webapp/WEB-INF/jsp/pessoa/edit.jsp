<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="app" %>
<!DOCTYPE html>
<html>
<c:import url="/WEB-INF/jsp/head.jsp" />
<body>
	<c:import url="/WEB-INF/jsp/navbar.jsp" />
	<div class="container conteudo">
		<c:if test="${not empty sucesso}">
			<div class="alert alert-success">				
				<i class="fa fa-check"></i> ${sucesso}
			</div>
		</c:if>
		<h1>Edição de Pessoa</h1>
		<form method="post">
		<input type="hidden" name="pessoa.id" value="${pessoa.id}"/>
			<div class="row">
				<div class="col-12 col-md-6">
					<div class="form-group">
						<label for="nome">Nome</label>
						<input name="pessoa.nome" type="text" class="form-control" id="nome" value="${pessoa.nome}">
						<app:validationMessage name="pessoa.nome"/>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="form-group">
						<label for="cpf">CPF</label>
						<input type="text" name="pessoa.cpf" class="form-control" id="cpf"
						value="${pessoa.cpf}" data-mask="000.000.000-00" data-mask-reverse="true">
						<app:validationMessage name="pessoa.cpf"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12 col-md-6">
					<div class="form-group">
						<label for="altura">Altura (m)</label>
						<input type="text" name="pessoa.altura" class="form-control" id="altura"
						value="<fmt:formatNumber value='${pessoa.altura}' minFractionDigits='2'/>"
						data-mask="#0,00" data-mask-reverse="true">
						<app:validationMessage name="pessoa.altura"/>
					</div>
				</div>
				<div class="col-12 col-md-6">
					<div class="form-group">
						<label for="massa">Massa (kg)</label>
						<input type="text" name="pessoa.massa" class="form-control" id="massa"
					 	value="<fmt:formatNumber value='${pessoa.massa}' minFractionDigits='2'/>"
					 	data-mask="#0,00" data-mask-reverse="true">
						<app:validationMessage name="pessoa.massa"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<button type="submit" formaction="${linkTo[PessoaController].alterar(null)}"
					class="btn btn-block btn-primary">Alterar</button>
				</div>
				<div class="col-6">
					<a href="${linkTo[PessoaController].list()}"
					class="btn btn-block btn-outline-secondary">Cancelar</a>
				</div>
			</div>			
		</form>
	</div>
	<c:import url="/WEB-INF/jsp/scripts.jsp"/>
</body>
</html>