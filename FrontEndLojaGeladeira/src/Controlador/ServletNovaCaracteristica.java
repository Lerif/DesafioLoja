package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Caracteristica;
import Fachada.Fachada;

/**
 * Servlet implementation class ServletNovaCaracteristica
 */
@WebServlet("/ServletNovaCaracteristica")
public class ServletNovaCaracteristica extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String novaCaracteristica = request.getParameter("novaCaracteristica");
		Fachada.criarNovaCaracteristica(novaCaracteristica, true);
		
		for (Caracteristica caracteristica : Fachada.buscarTodasCaracteristicas()){
			System.out.println("car: " + caracteristica);
		}
		
		request.setAttribute("caracteristicas", Fachada.buscarTodasCaracteristicas());
		request.getRequestDispatcher("CadaGela.jsp").forward(request, response);
	}

}
