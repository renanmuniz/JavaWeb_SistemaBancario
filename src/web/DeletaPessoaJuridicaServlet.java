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

/**
 * Servlet implementation class DeletePessoaJuridicaServlet
 */
@WebServlet("/deletaPessoaJuridica")
public class DeletaPessoaJuridicaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("Deletando pessoa jurídica");
		
		String cnpjPj      = request.getParameter("cnpj");
		
		PessoaJuridicaDAO pjDAO = new PessoaJuridicaDAO();
       
		Integer regsDeletados = pjDAO.deletePessoaJuridica(cnpjPj);
        
        System.out.println("### Registros Deletados: " + regsDeletados + " ###");
        
        if (regsDeletados != 0)
        {
        	System.out.println("### Deletado Cadastro de Pessoa Jurídica ###");   
        	request.setAttribute("pessoaJuridicaDeletada", cnpjPj);
        	RequestDispatcher rd = request.getRequestDispatcher("/PessoaJuridicaDeletada.jsp");
        	rd.forward(request, response);
        }
        else
        {
        	System.out.println("### Erro ao deletar Cadastro de Pessoa Jurídica ###");
        	System.out.println("### Exception: " + PessoaJuridicaDAO.retornaErro());
        	request.setAttribute("pessoaJuridicaNaoDeletada", cnpjPj);
        	request.setAttribute("erro", PessoaJuridicaDAO.retornaErro());
        	RequestDispatcher rd = request.getRequestDispatcher("/PessoaJuridicaNaoDeletada.jsp");
        	rd.forward(request, response);
        }
		//request.setAttribute("pessoaFisicaDeletada", cpfPf);
		//response.sendRedirect("listaPessoasFisicasCadastradas");
		
//		//chamar o JSP ou Servlet
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
