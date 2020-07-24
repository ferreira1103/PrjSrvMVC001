<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Incluir</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>

	<%@include file="includes/header.jsp"%>

	<div id="wrapper">

		<main>
		<div id="content">
			<div class="innertube">
				<h1>.:: Incluir(JSP) [PrjSrvMVC001]::.</h1>
				<br />
				<div align="center">
					<form method="post" action="/PrjSrvMVC001/EstudanteController">
						<table>
							<tr>
								<td>Codigo</td>
								<td><input type="text" name="id" id="nome"></td>
							</tr>
							<tr>
								<td>Nome</td>
								<td><input type="text" name="name" id="nome"></td>
							</tr>
							<tr>
								<td>Cidade</td>
								<td><input type="text" name="city" id="city"></td>
							</tr>
							<tr>
								<td>Telefone</td>
								<td><input type="text" name="phone" id="phone"></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="hidden" value="incluir" name="acao"
									id="acao"></td>
								<td><input type="submit" value="Incluir" name="btnIncluir"
									id="btnIncluir"></td>
							</tr>
						</table>
					</form>
				</div>

				<img src="images/Avatar.jpg" alt="Italian Trulli">

			</div>
		</div>
		</main>

		<%@include file="includes/menu.jsp"%>

		<div class="push"></div>
	</div>

	<%@include file="includes/footer.jsp"%>

</body>
</html>