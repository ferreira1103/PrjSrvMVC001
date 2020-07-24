<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar estudantes - PrjSrvMVC</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>

	<%@include file="includes/header.jsp"%>

	<div id="wrapper">

		<main>
		<div id="content">
			<div class="innertube">
				<h1>.:: Corpo ::.</h1>
				
				<%
				out.println(" *** Campo recebido da controller  = " + request.getAttribute("campo"));
				%>

				<table border=1>

					<thead>
						<tr>
							<th>Código</th>
							<th>Nome</th>
							<th>Cidade</th>
							<th>Telefone</th>
							<th colspan=2>Ação</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${estudantes}" var="estudante">
							<tr>
								<td><c:out value="${estudante.codigo}" /></td>
								<td><c:out value="${estudante.nome}" /></td>
								<td><c:out value="${estudante.cidade}" /></td>
								<td><c:out value="${estudante.telefone}" /></td>
								<td><a
									href='editar.html'>Editar</a></td>
								<td><a
									href='EstudanteController?acao=excluir&id=<c:out value="${estudante.codigo}"/>'>Deletar</a></td>
							</tr>
						</c:forEach>
					</tbody>

				</table>

			</div>
		</div>
		</main>

		<%@include file="includes/menu.jsp"%>

		<div class="push"></div>
	</div>

	<%@include file="includes/footer.jsp"%>

</body>
</html>