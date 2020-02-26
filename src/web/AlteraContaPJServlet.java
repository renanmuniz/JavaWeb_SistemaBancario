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
import model.ContaPJ;

/*
 * Servlet implementation class AlteraContaPJServlet
 */
@WebServlet("/alteraContaPJ")
public class AlteraContaPJServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("Alterando conta PJ");
		
        Integer numConta = Integer.parseInt(request.getParameter("numContaPJ"));
        String  tpoConta = request.getParameter("tpoContaPJ");
        String  numAgencia = request.getParameter("numAgenciaPJ");
        String  numNovaAgencia = request.getParameter("numNovaAgenciaPJ");
        String  cnpjTitular = request.getParameter("cnpjTitularPJ");
        Double  saldo = Double.parseDouble(request.getParameter("saldoPJ"));
		
		ContaPJ c = new ContaPJ(numConta, tpoConta, numAgencia, cnpjTitular, saldo);
		c.setNumNovaAgencia(numNovaAgencia);
		
		ContaPJDAO cDAO = new ContaPJDAO();
        
		Integer regsAlterados = cDAO.updateContaPJ(c);        
        
		System.out.println("### Registros Alterados: " + regsAlterados + " ###");
	       
		if (regsAlterados != 0)
		{
			System.out.println("### Alterado Cadastro de Conta Pessoa Jurídica ###");   
			request.setAttribute("contaPessoaJuridicaAlterada", cnpjTitular);		
			RequestDispatcher rd = request.getRequestDispatcher("/ContaPJAlterada.jsp");
			rd.forward(request, response);
		}
		else
		{
	       	System.out.println("### Erro ao Alterar Cadastro de Conta Pessoa jurídica ###");
	       	System.out.println("### Exception: " + cDAO.retornaErro());
	       	request.setAttribute("contaPessoaJuridicaNaoAlterada", cnpjTitular);
	       	request.setAttribute("erro", cDAO.retornaErro());
	       	RequestDispatcher rd = request.getRequestDispatcher("/ContaPJNaoAlterada.jsp");
	       	rd.forward(request, response);
		}
        
        
        /*
        request.setAttribute("ContaPJAlterada", c.getNumConta());		
		RequestDispatcher rd = request.getRequestDispatcher("/ContaPJAlterada.jsp");
		rd.forward(request, response);
        */
        
        
        
		//request.setAttribute("pessoaFisicaAlterada", PJ.getNome());
		//response.sendRedirect("listaPessoasFisicasCadastradas");
		
//		//chamar o JSP ou Servlet
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
