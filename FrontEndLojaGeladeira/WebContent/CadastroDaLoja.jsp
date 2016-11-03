<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.xml.ws.Response"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<link href="/FrontEndLojaGeladeira/homestyle.css" rel="stylesheet"
	type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Lojas</title>
</head>
<body>
	<h1 align="center">Cadastro de Loja</h1>

	<h2 align="center">Preencha o formulário abaixo para cadastrar sua loja </h2>
	<br/>
	

	<form name="CadastroLoja" id="formularioCadastro" action="servCaLo" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>CADASTRO</legend>
			<table>
				<tr>
					<td><label for="nome">Nome: </label></td>
					
					<td align="left"><input type="text" name="nomeDaLoja"></td>
					<td><label for="imagem">Icone da loja:</label></td>
					<td><input id="idIcone" type="file" name="iconeDaLoja"></td>
				</tr>
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
	
	<form name="CadastroGeladeira" id="formularioGeladeira" action="ServletNomeLojaParaGeladeira" method="post">
		<table border="1">
			<tr>
				<th>Loja</th>
				<th>Icone</th>
			</tr>

			<c:forEach items="${lojas}" var="loja">
				<tr>
					<td><button name="lojaBotao" onClick="cadastrarGeladeira" value="${loja.nome}"> ${loja.nome}
					</button></td>
					
					<td><img src="${loja.foto}" width="50px" height="50px"></td>
				</tr>
			</c:forEach>
		</table>
	</form>
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
	
	function cadastrarGeladeira(){
		document.getElementById("formularioGeladeira").submit();
	}

	function voltar() {
		var nomeLoja = document.forms["CadastroLoja"]["nomeDaLoja"].value;
		var iconeDaLoja = document.getElementById("idIcone").value;
		
		if ( (nomeLoja != "") || (iconeDaLoja != "") ) {
			var confirmaVoltar = confirm("Voltando perdera todos dados digitados.\nTem certeza que deseja voltar ?");
			if (confirmaVoltar == true) {
				location.href = "Index.jsp";
			}
		}
		else 
		{
			location.href = "Index.jsp";	
		}
	}
</script>
</html>