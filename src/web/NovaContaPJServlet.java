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
import dao.ContaPJDAO;
import model.ContaPJ;

/**
 * Servlet implementation class NovaContaPJServlet
 */
@WebServlet("/novaContaPJ")
public class NovaContaPJServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Cadastrando nova conta pessoa física");
		
        String  numAgencia = request.getParameter("numAgenciaPJ");
        String  cnpjTitular = request.getParameter("cnpjTitularPJ");
        Double  saldo = Double.parseDouble(request.getParameter("saldoPJ"));
		
		ContaPJ c = new ContaPJ(numAgencia, cnpjTitular, saldo);
		
		ContaPJDAO cDAO = new ContaPJDAO();
        
		Integer regsInseridos = cDAO.InsereContaPJ(c);
        
		System.out.println("### Registros Inseridos: " + regsInseridos + " ###");
	       
		if (regsInseridos != 0)
		{
			System.out.println("### Inserido Cadastro de Conta Pessoa Jurídica ###");   
			request.setAttribute("contaPessoaJuridicaCadastrada", cnpjTitular);		
			RequestDispatcher rd = request.getRequestDispatcher("/ContaPJCadastrada.jsp");
			rd.forward(request, response);
		}
		else
		{
	       	System.out.println("### Erro ao Inserir Cadastro de Conta Pessoa jurídica ###");
	       	System.out.println("### Exception: " + cDAO.retornaErro());
	       	request.setAttribute("contaPessoaJuridicaNaoCadastrada", cnpjTitular);
	       	request.setAttribute("erro", cDAO.retornaErro());
	       	RequestDispatcher rd = request.getRequestDispatcher("/ContaPJNaoCadastrada.jsp");
	       	rd.forward(request, response);
		}
        
        
        
        
        
        
		//request.setAttribute("pessoaJuridicaCadastrada", PJ.getNome());
		//response.sendRedirect("PessoaJuridicaCadastrada.jsp");
		
        /*
        request.setAttribute("ContaPJCadastrada", c.getNumConta());		
		RequestDispatcher rd = request.getRequestDispatcher("/ContaPJCadastrada.jsp");
		rd.forward(request, response);
        */
//		//chamar o JSP ou Servlet
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
