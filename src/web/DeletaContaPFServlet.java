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

import dao.ContaPFDAO;

/**
 * Servlet implementation class DeleteContaPFServlet
 */
@WebServlet("/deletaContaPF")
public class DeletaContaPFServlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("Deletando conta pessoa física");
		
		String numContaPF      = request.getParameter("numContaPF");
        String numAgenciaPF      = request.getParameter("numAgenciaPF");
                        
		
		ContaPFDAO cDAO = new ContaPFDAO();
		
        Integer regsDeletados = cDAO.deleteContaPF(numContaPF,numAgenciaPF);
        
		if (regsDeletados != 0)
		{
			System.out.println("### Cadastro de Conta Pessoa Física Deletado###");   
			request.setAttribute("contaPessoaFisicaCadastrada", numContaPF);		
			RequestDispatcher rd = request.getRequestDispatcher("/ContaPFDeletada.jsp");
			rd.forward(request, response);
		}
		else
		{
	       	System.out.println("### Erro ao Deletar Cadastro de Conta Pessoa Física ###");
	       	System.out.println("### Exception: " + ContaPFDAO.retornaErro());
	       	request.setAttribute("contaPessoaFisicaNaoCadastrada", numContaPF);
	       	request.setAttribute("erro", ContaPFDAO.retornaErro());
	       	RequestDispatcher rd = request.getRequestDispatcher("/ContaPFNaoDeletada.jsp");
	       	rd.forward(request, response);
		}
        /*
        request.setAttribute("contaPFDeletada", numContaPF);
		RequestDispatcher rd = request.getRequestDispatcher("/ContaPFDeletada.jsp");
		rd.forward(request, response);
        */
		//request.setAttribute("pessoaFisicaDeletada", cpfPf);
		//response.sendRedirect("listaPessoasFisicasCadastradas");
		
//		//chamar o JSP ou Servlet
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
