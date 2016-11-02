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

	<h1>Formulario para cadastro de geladeiras</h1>
	<form name="form1" id="idCadastroGeladeira" action="CadastroGela" method="post">
		<fieldset>
		<legend> 
			<input hidden="true" name="nomeDaLoja" value="${nomeLoja}"/>
			<label> Loja: ${nomeLoja} </label> 
		</legend>
			<div align="center">
				<label>Nome: </label>
				<input type="text" name="nome" placeholder="Nome da geladeira"/>
				
				<lable>Marca:</lable>
				<input name="marca" wrap="hard" placeholder="Marca da geladeira"/>
				
				<lable>Fabricante: </lable>
				<input name="fabricante" wrap="hard" placeholder="Fabricante da geladeira"/>
			</div>
			<div align="center">
				<br>
				<label>Adicionar caracteristicas: </label>
				<input size="77" type="text" name="novaCaracteristica" placeholder="Separe por virgulas. ex: frost-free, branca, etc..."/>
			</div>
		</fieldset>
	</form>

	<div align="center">
		<button onclick="aviso()">Inserir geladeira</button>
		<button onClick="voltarInicial()">Voltar para tela inicial</button>
		<form id="cadastrarLoja" method="post" action="CarregaLojas">
			<input  id="voltarLojaBotaoId" value="Voltar para tela de lojas" type="button" onclick="voltarLojas()" />
		</form>
	</div>
	<br>

	<div align="center">
		<table border="1">
			<tr>
				<th align="center"><p>Nome</p></th>
				<th align="center"><p>Marca</p></th>
				<th align="center"><p>Fabricante</p></th>
				<th align="center"><p>Caracteristicas</p></th>
			</tr>
			<c:forEach items="${todasGeladeirasDaLoja}" var="geladeira">
				<tr>
					<td align="center">${geladeira.nome}</td>
					<td align="center">${geladeira.marca}</td>
					<td align="center">${geladeira.fabricante}</td>
					
					<c:forEach items="${geladeira.caracteristicas}" var="caracteristica">
						<td align="center">${caracteristica.tipo}</td>
					</c:forEach>
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
		var fabricante = document.forms["form1"]["fabricante"].value;
		if (nome == "") {
			alert("Campo Nome obrigatorio");
			return;
		}
		if (marca == "") {
			alert("Campo Marca obrigatorio");
			return;
		}
		if (fabricante == "") {
			alert("Campo Fabricante obrigatorio");
			return;
		}
		document.getElementById("idCadastroGeladeira").submit();
	}
	
	function voltarLojas() {
		
		var nome = document.forms["form1"]["nome"].value;
		var marca = document.forms["form1"]["marca"].value;
		var fabricante = document.forms["form1"]["fabricante"].value;
		
		if(nome != "" || marca !="" || fabricante !=""){
			var confirmaVoltar = confirm("Voltando perdera todos dados digitados.\nTem certeza que deseja voltar ?");
			if (confirmaVoltar == true) {
				document.getElementById("cadastrarLoja").submit();
			}	
		}
		else{
			document.getElementById("cadastrarLoja").submit();
		}
	}
	
	function voltarInical() {
		
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