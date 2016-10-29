<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="/FrontEndLojaGeladeira/homestyle.css" rel="stylesheet"
	type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bem Vindo</title>
</head>
<body>
	<div align="center">
		<div align="right">
			<form id="cadastrarLoja" method="post" action="CarregaLojas">
				<input  id="cadastrarLojaBotaoId" value="Cadastrar loja" type="button" onclick="chamaCarregaLojas()" />
			</form>
		</div>
		
		<h1>Bem vindo ao Sistema Gelux</h1>
		<br>
		
		<input type="text" name="procurarGeladeiras" id="campoProcurarGeladeirasId"  width="200" maxlength="256" dir="auto" placeholder="Procurar Geladeiras"/>
		<input id="imagemProcurarGeladeiraId" type="button" />
		<br>
	</div>
</body>
<script>
	function chamaCarregaLojas() {
		document.getElementById("cadastrarLoja").submit();
	}
</script>
</html>