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
			<h1>Lista de Pessoas</h1>

	<c:import url="/WEB-INF/jsp/scripts.jsp"/>
</body>
</html>