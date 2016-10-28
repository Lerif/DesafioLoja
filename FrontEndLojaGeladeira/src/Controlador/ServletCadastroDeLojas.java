package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		System.out.println("nome: " + request.getParameter("nomeDaLoja"));
		System.out.println("icon: " + request.getParameter("iconeDaLoja"));
		
		fachada.criarNovaLoja(request.getParameter("nomeDaLoja"), request.getParameter("iconeDaLoja"));
		
		request.setAttribute("lojas", fachada.buscarTodasLojas());
		request.getRequestDispatcher("CadastroDaLoja.jsp").forward(request, response);
	}
}
