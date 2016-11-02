package Controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Agregadores.LojaComGeladeiras;
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

		// Buscando lista de geladeiras previamente existentes em relacao a loja escolhida
		Loja loja = Fachada.buscarLoja(nomeDaLoja);
		List<Geladeira> geladeiras = Fachada.buscarTodasGeladeirasDaLoja(loja.getNome());
		
		// Inserindo as caracteristicas da nova geladeira criada
		String novaCaracteristica = request.getParameter("novaCaracteristica");
		String[] tokenCaracteristicas = novaCaracteristica.split(",");
		List<Caracteristica> caracteristicas = new ArrayList<Caracteristica>();
		
		for(String caracteristica : tokenCaracteristicas){
			if(!caracteristica.isEmpty()){
				caracteristicas.add(Fachada.criarNovaCaracteristica(caracteristica, true));	
			}	
		}
		
		// Criando nova geladeira com as caracteristicas
		Geladeira geladeira = Fachada.criarNovaGeladeira(nome, marca, fabricante, caracteristicas);
		
		// Inserindo nova geladeira criada 
		geladeiras.add(geladeira);
		Fachada.criarNovaLojaComGeladeiras(loja, geladeiras);
		
		request.setAttribute("todasGeladeirasDaLoja", Fachada.buscarTodasGeladeirasDaLoja(loja.getNome()));
		request.setAttribute("nomeLoja", nomeDaLoja);
		request.getRequestDispatcher("CadaGela.jsp").forward(request, response);
	}
}