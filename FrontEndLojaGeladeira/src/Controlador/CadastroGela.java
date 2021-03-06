package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				
		Fachada.criarNovaGeladeira(nome, marca, fabricante);
		
		System.out.println("Loja: " + nomeDaLoja);
		
		request.setAttribute("nomeLoja", nomeDaLoja);
		request.setAttribute("geladeiras", Fachada.buscarTodasGeladeiras());
		request.getRequestDispatcher("CadaGela.jsp").forward(request, response);
	}
}
