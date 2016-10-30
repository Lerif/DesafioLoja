package Controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import Fachada.Fachada;

/**
 * Servlet implementation class ServletCadastroDeLojas
 */
@WebServlet("/servCaLo")
public class ServletCadastroDeLojas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//System.out.println("nome: " + request.getParameter("nomeDaLoja"));
		salvarImagem(request, response);
		Fachada.criarNovaLoja(request.getParameter("nomeDaLoja"), request.getParameter("iconeDaLoja"));
		atualizarTabelaLojas(request, response);
	}

	protected void atualizarTabelaLojas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("lojas", Fachada.buscarTodasLojas());
		request.getRequestDispatcher("CadastroDaLoja.jsp").forward(request, response);
	}
	
	protected void salvarImagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    try {
	        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest((RequestContext) request);
	        for (FileItem item : items) {
	            if (item.isFormField()) {
	                // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
	                String fieldName = item.getFieldName();
	                String fieldValue = item.getString();
	                System.out.println("item: " + fieldName);
	            } else {
	                // Process form file field (input type="file").
	                String fieldName = item.getFieldName();
	                String fileName = FilenameUtils.getName(item.getName());
	                InputStream fileContent = item.getInputStream();
	                

					File uploadDir = new File("//home//skannon//Desktop");
					File file = File.createTempFile("img", ".png", uploadDir);
					item.write(file);
	            }
	        }
	    } catch (FileUploadException e) {
	        throw new ServletException("Cannot parse multipart request.", e);
	    } catch(Exception ex){
	    	System.out.println("Can't save due to: " + ex);
	    }
	}
	
	protected void salvaImagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FileItemFactory itemfactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemfactory);
		
		Part filePart = request.getPart("file"); // Retrieves <input type="file">
		InputStream filecontent = filePart.getInputStream();
	}

	protected void guardarUploadDeImagem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FileItemFactory itemfactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(itemfactory);

		try {
			List<FileItem> items = upload.parseRequest((RequestContext) request);
			
			for (FileItem item : items) {
				String contentType = item.getContentType();
				if (!contentType.equals("image/png")) {
					System.out.println("Only png format image files supported");
					continue;
				}

				File uploadDir = new File("//home//skannon//Desktop");
				File file = File.createTempFile("img", ".png", uploadDir);
				item.write(file);

				System.out.println("File Saved Successfully");
			}
		} catch (FileUploadException e) {
			System.out.println("Upload fail: " + e);
		} catch (Exception ex) {
			System.out.println("Can't save due to: " + ex);
		}
	}
}
