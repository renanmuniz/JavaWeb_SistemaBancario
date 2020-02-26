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
import model.PessoaFisica;

/**
 * Servlet implementation class AlteraPessoaFisicaServlet
 */
@WebServlet("/alteraPessoaFisica")
public class AlteraPessoaFisicaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{		
		//Tratamento de Consistência de Dados:		
		String cpfPf;
		if (request.getParameter("cpf") == "")
		{
			cpfPf = null;
		}
		else
		{
			cpfPf = request.getParameter("cpf");;
		}
		
        
		String nomePf;
		if (request.getParameter("nome") == "")
		{
			nomePf = null;
		}
		else
		{
			nomePf = request.getParameter("nome");
		}
		
		String enderecoPf;
		if (request.getParameter("endereco") == "")
		{
			enderecoPf = null;
		}
		else
		{
			enderecoPf = request.getParameter("endereco");
		}
		
		String cidadePf;
		if (request.getParameter("cidade") == "")
		{
			cidadePf = null;
		}
		else
		{
			cidadePf = request.getParameter("cidade");
		}
		
		String estadoPf;
		if (request.getParameter("estado") == "")
		{
			estadoPf = null;
		}
		else
		{
			estadoPf = request.getParameter("estado");
		}
		
		String telefonePf;
		if (request.getParameter("telefone") == "")
		{
			telefonePf = null;
		}
		else
		{
			telefonePf = request.getParameter("telefone");
		}
		//---------------------------------------------------------
		
		PessoaFisica pf = new PessoaFisica(cpfPf, nomePf, enderecoPf, cidadePf, estadoPf, telefonePf);
		
		PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
        
		Integer regsAlterados = pfDAO.updatePessoaFisica(pf);
		
		 System.out.println("### Registros Alterados: " + regsAlterados + " ###");
        
        if (regsAlterados != 0)
        {
        	System.out.println("### Alterado Cadastro de Pessoa Física ###");   
        	request.setAttribute("pessoaFisicaAlterada", nomePf);		
    		RequestDispatcher rd = request.getRequestDispatcher("/PessoaFisicaAlterada.jsp");
    		rd.forward(request, response);
        }
        else
        {
        	System.out.println("### Erro ao alterar Cadastro de Pessoa Física ###");
        	System.out.println("### Exception: " + PessoaFisicaDAO.retornaErro());
        	request.setAttribute("pessoaFisicaNaoAlterada", nomePf);
        	request.setAttribute("erro", PessoaFisicaDAO.retornaErro());
        	RequestDispatcher rd = request.getRequestDispatcher("/PessoaFisicaNaoAlterada.jsp");
        	rd.forward(request, response);
        }	
		 
		 
		 
		 
		/* 
        request.setAttribute("pessoaFisicaAlterada", pf.getNome());		
		RequestDispatcher rd = request.getRequestDispatcher("/PessoaFisicaAlterada.jsp");
		rd.forward(request, response);
        */
        
        
        
		//request.setAttribute("pessoaFisicaAlterada", pf.getNome());
		//response.sendRedirect("listaPessoasFisicasCadastradas");
		
		//chamar o JSP ou Servlet
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
