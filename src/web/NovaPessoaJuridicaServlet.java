package web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaFisicaDAO;
import dao.PessoaJuridicaDAO;
import model.PessoaJuridica;

/**
 * Servlet implementation class novaPessoaJuridica
 */
@WebServlet("/novaPessoaJuridica")
public class NovaPessoaJuridicaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("Cadastrando nova pessoa Jurídica");
		
		String cnpjPj          = request.getParameter("cnpj");
		String cpfSocioPj      = request.getParameter("cpfSocio");
		String razaoSocialPj   = request.getParameter("razaoSocial");
		String enderecoPj 	   = request.getParameter("endereco");
		String cidadePj        = request.getParameter("cidade");
		String estadoPj        = request.getParameter("estado");
		String telefonePj      = request.getParameter("telefone");
		
		PessoaJuridica pj = new PessoaJuridica(cnpjPj, cpfSocioPj, razaoSocialPj, enderecoPj, cidadePj, estadoPj, telefonePj);
		
		PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO();
		
		Integer regsInseridos = pjDAO.inserePessoaJuridica(pj);		
		
		System.out.println("### Registros Inseridos: " + regsInseridos + " ###");
	       
		if (regsInseridos != 0)
		{
			System.out.println("### Inserido Cadastro de Pessoa Jurídica ###");   
			request.setAttribute("pessoaJuridicaCadastrada", razaoSocialPj);		
			RequestDispatcher rd = request.getRequestDispatcher("/PessoaJuridicaCadastrada.jsp");
			rd.forward(request, response);
		}
		else
		{
	       	System.out.println("### Erro ao Inserir Cadastro de Pessoa Jurídica ###");
	       	System.out.println("### Exception: " + PessoaJuridicaDAO.retornaErro());
	       	request.setAttribute("pessoaJuridicaNaoCadastrada", razaoSocialPj);
	       	request.setAttribute("erro", PessoaJuridicaDAO.retornaErro());
	       	RequestDispatcher rd = request.getRequestDispatcher("/PessoaJuridicaNaoCadastrada.jsp");
	       	rd.forward(request, response);
		}
		
		
		/*request.setAttribute("pessoaJuridicaCadastrada", pj.getRazaoSocial());		
		RequestDispatcher rd = request.getRequestDispatcher("/PessoaJuridicaCadastrada.jsp");
		rd.forward(request, response);
		*/

	}

}
