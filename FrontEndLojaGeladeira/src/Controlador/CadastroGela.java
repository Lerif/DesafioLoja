package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Caracteristica;
import Entidades.Geladeira;
import Entidades.Loja;
import Fachada.Fachada;

@WebServlet("/CadastroGela")
public class CadastroGela extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome, marca, fabricante, nomeDaLoja;
		nome = request.getParameter("nome");
		marca = request.getParameter("marca");
		fabricante = request.getParameter("fabricante");
		nomeDaLoja = request.getParameter("nomeDaLoja");
				
		Geladeira geladeira = Fachada.criarNovaGeladeira(nome, marca, fabricante, null);

		// Agregando Loja com lista de geladeiras
		Loja loja = Fachada.buscarUltimaLoja();
		List<Geladeira> geladeiras = Fachada.buscarTodasGeladeirasDaLoja(loja);
		geladeiras.add(geladeira);
		Fachada.criarNovaLojaComGeladeiras(loja, geladeiras);
		
		String novaCaracteristica = request.getParameter("novaCaracteristica");
		Fachada.criarNovaCaracteristica(novaCaracteristica, true);
		
		request.setAttribute("caracteristicas", Fachada.buscarTodasCaracteristicas());
		
		request.setAttribute("nomeLoja", nomeDaLoja);
		request.setAttribute("geladeiras", Fachada.buscarTodasGeladeirasDaLoja(loja));
		request.getRequestDispatcher("CadaGela.jsp").forward(request, response);
	}
}