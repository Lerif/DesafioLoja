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
@WebServlet("/servCaLo")
public class ServletCadastroDeLojas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		Fachada.criarNovaLoja(request.getParameter("nomeDaLoja"), request.getParameter("iconeDaLoja"));
		request.setAttribute("lojas", Fachada.buscarTodasLojas());
		request.getRequestDispatcher("CadastroDaLoja.jsp").forward(request, response);
	}
}
