<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="javax.xml.ws.Response"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<link href="/FrontEndLojaGeladeira/homestyle.css" rel="stylesheet"
	type="text/css">
<title>Cadastrar Geladeira</title>
</head>
<body>

	<h1>Formulario para cadastro de geladeira</h1>
	<form name="form1" id="idCadastroGeladeira" action="CadastroGela" method="post">
		<fieldset>
		<legend> 
			<input hidden="true" name="nomeDaLoja" value="${nomeLoja}"/>
			<label> ${nomeLoja} </label> 
		</legend>
			<div align="center">
				<label>Nome: </label>
				<input type="text" name="nome" placeholder="Nome da geladeira"/>
				
				<lable>Marca:</lable>
				<input name="marca" wrap="hard" placeholder="Marca da geladeira"/>
				
				<lable>Frabricante: </lable>
				<input name="fabricante" wrap="hard" placeholder="Fabricante da geladeira"/>
			</div>
			<div align="center">
				<br>
				<lable>Caracteristicas: </lable>
				<c:forEach items="${caracteristicas}" var = "caracteristica">
					<input type="checkbox" name="caracteristica" value="${caracteristica.tipo}"/> ${caracteristica.tipo}
				</c:forEach>
			</div>
			<div align="center">
				<label>Adicionar nova caracteristica: </label>
				<input type="text" name="novaCaracteristica" placeholder="Inserir nova caracteristica"/>
		</div>
		</fieldset>
	</form>
	
	<form name="formNovaCaracteristica" id="idCadastroGeladeira" method="post" action="ServletNovaCaracteristica">
	<fieldset>
	<legend>Nova caracteristica</legend>
		<div align="center">
			<label>Adicionar nova caracteristica: </label>
			<input type="text" name="novaCaracteristica" placeholder="Inserir nova caracteristica"/>
		</div>
	</fieldset>
	</form>

	<div align="center">
		<button onclick="aviso()">Inserir geladeira</button>
		<button onClick="voltar()">Voltar para tela inicial</button>
	</div>
	<br>

	<div align="center">
		<table border="1">
			<tr>
				<th align="center"><p>Nome</p></th>
				<th align="center"><p>Marca</p></th>
				<th align="center"><p>Fabricante</p></th>
			</tr>
			<c:forEach items="${geladeiras}" var="geladeira">
				<tr>
					<td align="center">${geladeira.nome}</td>
					<td align="center">${geladeira.marca}</td>
					<td align="center">${geladeira.fabricante}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>

<script>
	function aviso() {
		var nome = document.forms["form1"]["nome"].value;
		var marca = document.forms["form1"]["marca"].value;
		var fabricante = document.forms["form1"]["fabricante"].value;
		if (nome == "") {
			alert("Campo nome obrigatorio");
			return;
		}
		if (marca == "") {
			alert("Campo marca obrigatorio");
			return;
		}
		document.getElementById("idCadastroGeladeira").submit();
	}
	
	function voltar() {
		
		var nome = document.forms["form1"]["nome"].value;
		var marca = document.forms["form1"]["marca"].value;
		var fabricante = document.forms["form1"]["fabricante"].value;
		
		if(nome != "" || marca !="" || fabricante !=""){
			var confirmaVoltar = confirm("Voltando perdera todos dados digitados.\nTem certeza que deseja voltar ?");
			if (confirmaVoltar == true) {
				location.href = "Index.jsp";
			}	
		}
		else{
			location.href = "Index.jsp";
		}
	}
</script>