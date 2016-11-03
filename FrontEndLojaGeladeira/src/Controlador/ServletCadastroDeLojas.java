package Controlador;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Fachada.Fachada;

/**
 * Servlet implementation class ServletCadastroDeLojas
 */
@WebServlet("/servCaLo")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class ServletCadastroDeLojas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected static final String UPLOAD_DIRETORIO = "imagens/IconesLojas";
	protected static final String CAMINHO_ABSOLUTO_DO_PROJETO_WEB_CONTENT =  System.getProperty("user.dir") + File.separator + "FrontEndLojaGeladeira/WebContent"; 
	protected String nomeDaImagemLoja;
	protected String caminhoDoDiretorioImagem;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		salvarImagem(request, response);
		if(Fachada.criarNovaLoja(request.getParameter("nomeDaLoja"), UPLOAD_DIRETORIO + File.separator + nomeDaImagemLoja) == null){
			request.setAttribute("avisoLojaExistente", true);
		}
		else{
			request.setAttribute("avisoLojaExistente", false);
		}
		atualizarTabelaLojas(request, response);
	}

	protected void atualizarTabelaLojas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("lojas", Fachada.buscarTodasLojas());
		request.getRequestDispatcher("CadastroDaLoja.jsp").forward(request, response);
	}

	protected void salvarImagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Cria caminho que as imagens serao salvas
		caminhoDoDiretorioImagem = CAMINHO_ABSOLUTO_DO_PROJETO_WEB_CONTENT + File.separator + UPLOAD_DIRETORIO;

		// Cria diretorio de imagens caso nao exista
		File fileSaveDir = new File(caminhoDoDiretorioImagem);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		// Busca todos input
		for (Part part : request.getParts()) {
			nomeDaImagemLoja = extractFileName(part);

			if (!nomeDaImagemLoja.isEmpty()) {
				System.out.println("Imagem salva em (caminho absoluto): " + caminhoDoDiretorioImagem + File.separator
						+ nomeDaImagemLoja);
				part.write(caminhoDoDiretorioImagem + File.separator + nomeDaImagemLoja);
			}
		}
	}

	/**
	 * Extrai nome do arquivo do HTTP header content-disposition
	 */
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}
