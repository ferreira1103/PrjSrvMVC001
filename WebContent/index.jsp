<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Projeto Servlet MVC [index.jsp]</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<%-- 	<jsp:forward page="/EstudanteController" /> --%>
	<jsp:forward page="/EstudanteController?acao=listar" />
</body>
</html>
