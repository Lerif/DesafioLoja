package Controlador;

import java.io.IOException;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Fachada.Fachada;

/**
 * Servlet implementation class ServletCadastroDeLojas
 */
@WebServlet("/ServletCadastroDeLojas")
public class ServletCadastroDeLojas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Fachada fachada = new Fachada();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		fachada.criarNovaLoja(request.getParameter("nomeDaLoja"), request.getParameter("iconeDaLoja"));
		atualizarTabelaLojas(request, response);
	}
	
	protected void atualizarTabelaLojas (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setAttribute("lojas", fachada.buscarTodasLojas());
		request.getRequestDispatcher("CadastroDaLoja.jsp").forward(request, response);
	}
}
