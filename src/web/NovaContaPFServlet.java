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
import dao.PessoaJuridicaDAO;
import model.ContaPF;

/**
 * Servlet implementation class NovaContaPFServlet
 */
@WebServlet("/novaContaPF")
public class NovaContaPFServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("Cadastrando nova conta pessoa física");
		
        String  numAgencia = request.getParameter("numAgenciaPF");
        String  cpfTitular = request.getParameter("cpfTitularPF");
        Double  saldo = Double.parseDouble(request.getParameter("saldoPF"));
		
		ContaPF c = new ContaPF(numAgencia, cpfTitular, saldo);
		
		ContaPFDAO cDAO = new ContaPFDAO();
		
		Integer regsInseridos = cDAO.InsereContaPF(c);
        
		System.out.println("### Registros Inseridos: " + regsInseridos + " ###");
	       
		if (regsInseridos != 0)
		{
			System.out.println("### Inserido Cadastro de Conta Pessoa Física ###");   
			request.setAttribute("contaPessoaFisicaCadastrada", cpfTitular);		
			RequestDispatcher rd = request.getRequestDispatcher("/ContaPFCadastrada.jsp");
			rd.forward(request, response);
		}
		else
		{
	       	System.out.println("### Erro ao Inserir Cadastro de Conta Pessoa Física ###");
	       	System.out.println("### Exception: " + ContaPFDAO.retornaErro());
	       	request.setAttribute("contaPessoaFisicaNaoCadastrada", cpfTitular);
	       	request.setAttribute("erro", ContaPFDAO.retornaErro());
	       	RequestDispatcher rd = request.getRequestDispatcher("/ContaPFNaoCadastrada.jsp");
	       	rd.forward(request, response);
		}
		
		
		//request.setAttribute("pessoaFisicaCadastrada", pf.getNome());
		//response.sendRedirect("PessoaFisicaCadastrada.jsp");
		/*
        request.setAttribute("contaPFCadastrada", cpfTitular);		
		RequestDispatcher rd = request.getRequestDispatcher("/ContaPFCadastrada.jsp");
		rd.forward(request, response);
        */
//		//chamar o JSP ou Servlet
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
