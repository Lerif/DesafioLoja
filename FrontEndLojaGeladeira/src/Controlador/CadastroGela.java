package Controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Fachada.Fachada;
import domain.Facade;
import domain.Pessoa;

@WebServlet("/CadastroGela")
public class CadastroGela extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroGela() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome, marca, fabricante;
		nome = request.getParameter("nome");
		marca = request.getParameter("marca");
		fabricante = request.getParameter("fabricante");

		
//
//				Facade.AdicionaPessoa(nome, sexo, carro, foguete);
//
//		List<Pessoa> a = Facade.getRepositorioFalso();
//		request.setAttribute("pessoas", a);
//
//		request.getRequestDispatcher("Login.jsp").forward(request, response);

	}

}
