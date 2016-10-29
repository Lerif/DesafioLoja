package Controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Fachada.Fachada;

/**
 * Servlet implementation class ServletNomeLojaParaGeladeira
 */
@WebServlet("/ServletNomeLojaParaGeladeira")
public class ServletNomeLojaParaGeladeira extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeLoja = request.getParameter("lojaBotao");
		
		request.setAttribute("nomeLoja", nomeLoja);
		request.setAttribute("geladeiras", Fachada.buscarTodasGeladeiras());
		request.getRequestDispatcher("CadaGela.jsp").forward(request, response);
	}

}
