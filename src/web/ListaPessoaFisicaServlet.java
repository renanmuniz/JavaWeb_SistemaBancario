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

import dao.PessoaFisicaDAO;
import model.PessoaFisica;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
@WebServlet("/listaPessoas")
public class ListaPessoaFisicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		List<PessoaFisica> lista = PessoaFisicaDAO.selectAllPF();
		
		request.setAttribute("pessoasCadastradas", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formListaPessoaFisica.jsp");
		rd.forward(request, response);


	}

}
