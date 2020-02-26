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
import model.ContaPF;

/*
 * Servlet implementation class AlteraContaPFServlet
 */
@WebServlet("/alteraContaPF")
public class AlteraContaPFServlet extends HttpServlet 
{
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("Alterando conta PF");
		
        Integer numConta = Integer.parseInt(request.getParameter("numContaPF"));
        String  tpoConta = request.getParameter("tpoContaPF");
        String  numAgencia = request.getParameter("numAgenciaPF");
        String  numNovaAgencia = request.getParameter("numAgenciaNovaPF");
        String  cpfTitular = request.getParameter("cpfTitularPF");
        Double  saldo = Double.parseDouble(request.getParameter("saldoPF"));
		
		ContaPF c = new ContaPF(numConta, tpoConta, numAgencia, cpfTitular, saldo);
		c.setNumAgenciaNovo(numNovaAgencia);
		
		ContaPFDAO cDAO = new ContaPFDAO();
        
		Integer regsAlterados = cDAO.updateContaPF(c);
        
		if (regsAlterados != 0)
		{
			System.out.println("### Inserido Cadastro de Conta Pessoa Física ###");   
			request.setAttribute("contaPessoaFisicaAlterada", numConta);		
			RequestDispatcher rd = request.getRequestDispatcher("/ContaPFAlterada.jsp");
			rd.forward(request, response);
		}
		else
		{
	       	System.out.println("### Erro ao Inserir Cadastro de Conta Pessoa Física ###");
	       	System.out.println("### Exception: " + ContaPFDAO.retornaErro());
	       	request.setAttribute("contaPessoaFisicaNaoAlterada", numConta);
	       	request.setAttribute("erro", cDAO.retornaErro());
	       	RequestDispatcher rd = request.getRequestDispatcher("/ContaPFNaoAlterada.jsp");
	       	rd.forward(request, response);
		}
		
		/*
        request.setAttribute("contaPFAlterada", c.getNumConta());		
		RequestDispatcher rd = request.getRequestDispatcher("/ContaPFAlterada.jsp");
		rd.forward(request, response);
        */
        
        
        
		//request.setAttribute("pessoaFisicaAlterada", pf.getNome());
		//response.sendRedirect("listaPessoasFisicasCadastradas");
		
//		//chamar o JSP ou Servlet
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
