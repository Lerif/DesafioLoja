<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/FrontEndLojaGeladeira/homestyle.css" rel="stylesheet"
	type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bem Vindo</title>
</head>
<body>
	<form action="CarregaLojas" id="id" method="post">
		<h1>Bem vindo ao Sistema Gelux</h1>
	</form>
	
	<button onclick="chamaCarregaLojas()">Cadastrar nova loja</button>
	<br>
	<a href="Busca.jsp">Busca</a>
	<br>
</body>
<script>
	function chamaCarregaLojas() {
		document.getElementById("id").submit();
	}
</script>
</html>
