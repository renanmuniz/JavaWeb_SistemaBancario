package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PessoaJuridicaDAO;
import model.PessoaJuridica;

/**
 * Servlet implementation class alteraPessoaJuridicaServlet
 */
@WebServlet("/alteraPessoaJuridica")
public class AlteraPessoaJuridicaServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("Alterando pessoa jurídica");
		
		String cnpjPj      = request.getParameter("cnpj");
		
		String cpfSocioPj      = request.getParameter("cpfSocio");
		String razaoSocialPj   = request.getParameter("razaoSocial");
		String enderecoPj 	   = request.getParameter("endereco");
		String cidadePj        = request.getParameter("cidade");
		String estadoPj        = request.getParameter("estado");
		String telefonePj      = request.getParameter("telefone");
		
		PessoaJuridica pj = new PessoaJuridica(cnpjPj, cpfSocioPj, razaoSocialPj, enderecoPj, cidadePj, estadoPj, telefonePj);
		
		PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO();
        
		Integer regsAlterados = pjDAO.updatePessoaJuridica(pj);
        
		System.out.println("### Registros Alterados: " + regsAlterados + " ###");
	       
		if (regsAlterados != 0)
		{
			System.out.println("### Alterado Cadastro de Pessoa Jurídica ###");   
			request.setAttribute("pessoaJuridicaAlterada", razaoSocialPj);		
			RequestDispatcher rd = request.getRequestDispatcher("/PessoaJuridicaAlterada.jsp");
			rd.forward(request, response);
		}
		else
		{
	       	System.out.println("### Erro ao Alterar Cadastro de Pessoa Jurídica ###");
	       	System.out.println("### Exception: " + PessoaJuridicaDAO.retornaErro());
	       	request.setAttribute("pessoaJuridicaNaoAlterada", razaoSocialPj);
	       	request.setAttribute("erro", PessoaJuridicaDAO.retornaErro());
	       	RequestDispatcher rd = request.getRequestDispatcher("/PessoaJuridicaNaoAlterada.jsp");
	       	rd.forward(request, response);
		}
		
		
		
		
		
		
		
		/*
        request.setAttribute("PessoaJuridicaAlterada", pj.getRazaoSocial());		
		RequestDispatcher rd = request.getRequestDispatcher("/PessoaJuridicaAlterada.jsp");
		rd.forward(request, response);
        */
        
        
        
		//request.setAttribute("PessoaJuridicaAlterada", pj.getNome());
		//response.sendRedirect("listaPessoasFisicasCadastradas");
		
//		//chamar o JSP ou Servlet
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
