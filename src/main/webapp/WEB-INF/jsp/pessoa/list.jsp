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
			<c:if test="${not empty aviso}">
				<div class="alert alert-warning">				
					<i class="fa fa-exclamation-triangle"></i> ${aviso}
				</div>
			</c:if>
			<h1>Lista de Pessoas</h1>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nome</th>
							<th>CPF</th>
							<th>Altura (m)</th>
							<th>Massa (kg)</th>
							<th><i class="fa fa-cog"></i> Ações</th>
						</tr>					
					</thead>
					<tbody>
						<c:forEach var="pessoa" items="${pessoas}">
							<tr>
								<td>${pessoa.nome}</td>
								<td>${pessoa.cpf}</td>
								<td>
									<fmt:formatNumber value='${pessoa.altura}' minFractionDigits="2"/>
								</td>
								<td>
									<fmt:formatNumber value="${pessoa.massa}" minFractionDigits="3"/>
								</td>
								<td>
									<a data-toggle="tooltip" title="Editar"
									href="${linkTo[PessoaController].edit(pessoa.id)}">
										<i class="fa fa-edit text-info"></i>
									</a>
									<a href="#" data-toggle="modal" data-tt="tooltip" title="Excluir" 
									data-target="#modal-exclusao-${pessoa.id}">
										<i class="fa fa-trash text-danger"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<nav id="paginacao">
				<c:set var="anteriorHabilitado" value="${false}"/>
				<c:set var="proximoHabilitado" value="${false}"/>
				
				<c:if test="${paginaSelecionada > 1}">
					<c:set var="anteriorHabilitado" value="${true}"/>
				</c:if>
				<c:if test="${paginaSelecionada != paginas}">
					<c:set var="proximoHabilitado" value="${true}"/>
				</c:if>
				
				<c:set var="paginaInicialNav" value="${paginaSelecionada}"/>
				<c:if test="${paginaInicialNav == 1}">						
					<c:set var="paginaInicialNav" value="${paginaInicialNav + 1}"/>
				</c:if>
				<c:if test="${paginaInicialNav == paginas}">						
					<c:set var="paginaInicialNav" value="${paginaInicialNav - 1}"/>
				</c:if>
				
				<div class="row">
					<div class="col-3">						
						<small class="justify-content-end">Página ${paginaSelecionada} de ${paginas}</small>
					</div>
					<div class="col-9">
						<ul class="pagination justify-content-end">
							<c:if test="${paginaSelecionada >= 1}">
								<li class="page-item ${paginaSelecionada == 1 ? 'disabled' : ''}">
									<a class="page-link" href="${linkTo[PessoaController].listarAtivosPagina(1)}">
										<i class="fa fa-angle-double-left"></i>
									</a>
								</li>
							</c:if>
							<li class="page-item ${anteriorHabilitado ? '' : 'disabled' }">
								<a class="page-link" href="${linkTo[PessoaController].listarAtivosPagina(paginaSelecionada - 1)}">
									<i class="fa fa-angle-left"></i>
		       					</a>
							</li>
							<c:forEach var="i" begin="${paginaInicialNav - 1}" end="${paginaInicialNav + 1}">
								<c:if test="${i <= paginas && i >= 1}">
									<li class="page-item ${i == paginaSelecionada ? 'active' : ''}">
										<a class="page-link" href="${linkTo[PessoaController].listarAtivosPagina(i)}">${i}</a>
									</li>
								</c:if>
							</c:forEach>
							<c:if test="${paginaSelecionada != paginas && paginas > 4}">
								<li class="page-item disabled">
									<a class="page-link" href="#">...</a>
								</li>
							</c:if>
							<li class="page-item ${proximoHabilitado ? '' : 'disabled' }">
								<a class="page-link" href="${linkTo[PessoaController].listarAtivosPagina(paginaSelecionada + 1)}">
									<i class="fa fa-angle-right"></i>
								</a>
							</li>
							<c:if test="${paginaSelecionada <= paginas}">
								<li class="page-item ${paginaSelecionada == paginas ? 'disabled' : ''}">
									<a class="page-link" href="${linkTo[PessoaController].listarAtivosPagina(paginas)}">
										<i class="fa fa-angle-double-right"></i>
									</a>
								</li>
							</c:if>
						</ul>
					</div>
				</div>
				
			</nav>
		</div>
		
		<c:forEach var="pessoa" items="${pessoas}">
			<div id="modal-exclusao-${pessoa.id}" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title">Deseja excluir essa pessoa?</h5>
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					        	<span aria-hidden="true">&times;</span>
					        </button>
						</div>
						<div class="modal-body">
							<dl>
								<dt>Nome</dt>
								<dd>${pessoa.nome}</dd>
								<dt>CPF</dt>
								<dd>${pessoa.cpf}</dd>
							</dl>
						</div>
						<div class="modal-footer">
							<form method="post" action="${linkTo[PessoaController].excluir(null)}">
								<input type="hidden" name="id" value="${pessoa.id}"/>
								<button type="button" class="btn btn-outline-secondary"
								data-dismiss="modal">Cancelar</button>
	        					<button type="submit" class="btn btn-danger">Excluir</button>
	        				</form>
						</div>
					</div>
				</div>			
			</div>
		</c:forEach>

	<c:import url="/WEB-INF/jsp/scripts.jsp"/>
</body>
</html>