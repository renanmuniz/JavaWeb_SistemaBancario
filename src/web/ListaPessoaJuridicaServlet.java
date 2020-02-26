package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaJuridicaDAO;
import model.PessoaJuridica;

/**
 * Servlet implementation class ListaJuridicaServlet
 */
@WebServlet("/listaPessoaJuridica")
public class ListaPessoaJuridicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		List<PessoaJuridica> lista = PessoaJuridicaDAO.selectAllPJ();
		
		request.setAttribute("pessoasCadastradas", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formListaPessoaJuridica.jsp");
		rd.forward(request, response);
	}

}
