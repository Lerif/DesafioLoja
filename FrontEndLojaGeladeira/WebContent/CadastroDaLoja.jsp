<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.xml.ws.Response"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Lojas</title>
</head>
<body>
	<h1 align="center">Cadastro de Loja</h1>

	<h2 align="center">Preencha o formulário abaixo para sua cadastrar
		loja</h2>
	<br />
	

	<form name="CadastroLoja" id="formularioCadastro"
		action="servCaLo" method="post">

		<!-- DADOS PESSOAIS-->
		<fieldset>

			<legend>CADASTRO</legend>

			<table>
				<tr>
					<td><label for="nome">Nome: </label></td>
					<td align="left"><input type="text" name="nomeDaLoja"></td>
					<td><label for="imagem">Icone da loja:</label></td>
					<td><input id="idIcone" type="file" name="iconeDaLoja"></td>
					<td><button onClick="voltar()" >Enviar Foto</button></td>
			</table>
		</fieldset>
		<br>
	</form>
	<button onClick="cadastrar()" value="Submit form">Cadastrar</button>
	<button onClick="voltar()">Voltar</button>
	<br>
	<br>
	<br>
	<div align="center">
		<table border="1">
			<tr>
				<th>Loja</th>
				<th>Icone</th>
			</tr>

			<c:forEach items="${lojas}" var="loja">

				<tr>
					<td>${loja.nome}</td>
					<td><img src=${loja.foto } width="18px" height="18px"></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
<script>
	function cadastrar() {
		var nomeLoja = document.forms["CadastroLoja"]["nomeDaLoja"].value;
		var iconeDaLoja = document.getElementById("idIcone").value;
		if (nomeLoja == "") {
			alert("Campo nome obrigatorio");
			return;
		}
		if (iconeDaLoja == "") {
			alert("Icone da loja obrigatorio");
			return;
		}

		document.getElementById("formularioCadastro").submit();
	}

	function voltar() {
		var confirmaVoltar = confirm("Voltando perdera todos dados digitados.\nTem certeza que deseja voltar ?");

		if (confirmaVoltar == true) {
			location.href = "Index.jsp";
		}
	}
</script>

</html>