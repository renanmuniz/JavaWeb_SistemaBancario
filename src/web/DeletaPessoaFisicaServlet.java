package web;



import java.io.IOException;
import java.sql.SQLException;
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

/**
 * Servlet implementation class DeletePessoaFisicaServlet
 */
@WebServlet("/deletaPessoaFisica")
public class DeletaPessoaFisicaServlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("### Deletando pessoa física ###");
		
		String cpfPf      = request.getParameter("cpf");
		
		PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();

        Integer regsDeletados = pfDAO.deletePessoaFisica(cpfPf);
        
        System.out.println("### Registros Deletados: " + regsDeletados + " ###");
        
        if (regsDeletados != 0)
        {
        	System.out.println("### Deletado Cadastro de Pessoa Física ###");   
        	request.setAttribute("pessoaFisicaDeletada", cpfPf);
        	RequestDispatcher rd = request.getRequestDispatcher("/PessoaFisicaDeletada.jsp");
        	rd.forward(request, response);
        }
        else
        {
        	System.out.println("### Erro ao deletar Cadastro de Pessoa Física ###");
        	System.out.println("### Exception: " + PessoaFisicaDAO.retornaErro());
        	request.setAttribute("pessoaFisicaNaoDeletada", cpfPf);
        	request.setAttribute("erro", PessoaFisicaDAO.retornaErro());
        	RequestDispatcher rd = request.getRequestDispatcher("/PessoaFisicaNaoDeletada.jsp");
        	rd.forward(request, response);
        }	      	
    	   	
	}

}
