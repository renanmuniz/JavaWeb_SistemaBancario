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

import dao.ContaPJDAO;

/**
 * Servlet implementation class DeleteContaPJServlet
 */
@WebServlet("/deletaContaPJ")
public class DeletaContaPJServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Deletando conta pessoa jurídica");
		
		String numContaPJ      = request.getParameter("numConta");
        String numAgenciaPJ      = request.getParameter("numAgencia");
                        
		
		ContaPJDAO cDAO = new ContaPJDAO();
		
		Integer regsDeletados = cDAO.deleteContaPJ(numContaPJ,numAgenciaPJ);
           
        
		System.out.println("### Registros Alterados: " + regsDeletados + " ###");
	       
		if (regsDeletados != 0)
		{
			System.out.println("### Alterado Cadastro de Conta Pessoa Jurídica ###");   
			request.setAttribute("contaPessoaJuridicaDeletada", numContaPJ);		
			RequestDispatcher rd = request.getRequestDispatcher("/ContaPJDeletada.jsp");
			rd.forward(request, response);
		}
		else
		{
	       	System.out.println("### Erro ao Alterar Cadastro de Conta Pessoa jurídica ###");
	       	System.out.println("### Exception: " + cDAO.retornaErro());
	       	request.setAttribute("contaPessoaJuridicaNaoDeletada", numContaPJ);
	       	request.setAttribute("erro", cDAO.retornaErro());
	       	RequestDispatcher rd = request.getRequestDispatcher("/ContaPJNaoDeletada.jsp");
	       	rd.forward(request, response);
		}
        
        
        
        /*
        request.setAttribute("ContaPJDeletada", numContaPJ);
		RequestDispatcher rd = request.getRequestDispatcher("/ContaPJDeletada.jsp");
		rd.forward(request, response);
        */
		//request.setAttribute("pessoaFisicaDeletada", cnpjPJ);
		//response.sendRedirect("listaPessoasFisicasCadastradas");
		
//		//chamar o JSP ou Servlet
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
