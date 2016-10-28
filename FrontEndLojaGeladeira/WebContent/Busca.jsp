<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@page import="Dominio.BE"%> --%>
<html>
<head>

<link href="/FrontEndLojaGeladeira/homestyle.css" rel="stylesheet"
	type="text/css">
</head>
<body>

	<h1 align="center">Busca</h1>


	<form action="buscaserv" method="post">

		<div align="center">
			<textarea name="busca" wrap="hard"
				placeholder="O que voce quer achar?"></textarea>
		</div>
		<div align="center">
			<input type="submit" value="Busca Google">
		</div>
	</form>

	<div align="center">
		<table border="1">
			<tr>
				<th><p>Nome</th>
				<th><p>Marca</th>
				<th><p>Fabricante</th>
			</tr>

			<%
				int id = 0;
			%>

			<c:forEach items="${geladeiras}" var="geladeira">

				<tr id="row_${id}">
					<td>${geladeira.nome}</td>
					<td>${geladeira.marca}</td>
					<td>${geladeira.fabricante}</td>
				</tr>

				<!-- definicao do modal -->
				<div id="mod_${id}" class="modal">
					<div class="modal-content">
						<span class="close">x</span>
						<p>${geladeira.nome}</p>
						<p>${geladeira.marca}</p>
						<p>${geladeira.fabricante}</p>
					</div>
				</div>


				<%
					id++;
				%>



			</c:forEach>
		</table>
	</div>



	<script>
		var modal = document.getElementById('meuModal');
		var bto = document.getElementById("minhaLinha");
		var span = document.getElementsByClassName("close")[0];
		bto.onclick = function() {
			modal.style.display = "block";
		}

		bto.on
		span.onclick = function() {
			modal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

</body>
</html>

