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

import dao.AgenciaDAO;
import dao.PessoaJuridicaDAO;
import model.Agencia;


/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaAgencia")
public class NovaAgenciaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		
		System.out.println("Cadastrando nova agência");
		
		String numAgencia = request.getParameter("numAgencia");
		String enderecoAg = request.getParameter("endereco");
		String cidadeAg   = request.getParameter("cidade");
		String estadoAg   = request.getParameter("estado");
		String telefoneAg = request.getParameter("telefone");
		
		Agencia ag = new Agencia(numAgencia, enderecoAg, cidadeAg, estadoAg, telefoneAg);
		
		AgenciaDAO agDAO = new AgenciaDAO();
        
		Integer regsInseridos = agDAO.insereAgencia(ag);
        
		//request.setAttribute("pessoaFisicaCadastrada", pf.getNome());
		//response.sendRedirect("PessoaFisicaCadastrada.jsp");
		
		if (regsInseridos != 0)
		{
			System.out.println("### Inserido Cadastro de Agência ###");   
			request.setAttribute("agenciaCadastrada", numAgencia);		
			RequestDispatcher rd = request.getRequestDispatcher("/AgenciaCadastrada.jsp");
			rd.forward(request, response);
		}
		else
		{
	       	System.out.println("### Erro ao Inserir Cadastro de Agência ###");
	       	System.out.println("### Exception: " + AgenciaDAO.retornaErro());
	       	request.setAttribute("agenciaNaoCadastrada", numAgencia);
	       	request.setAttribute("erro", AgenciaDAO.retornaErro());
	       	RequestDispatcher rd = request.getRequestDispatcher("/AgenciaNaoCadastrada.jsp");
	       	rd.forward(request, response);
		}
		
		
		
		
		
		/*
		request.setAttribute("agenciaCadastrada", numAgencia);		
		RequestDispatcher rd = request.getRequestDispatcher("/AgenciaCadastrada.jsp");
		rd.forward(request, response);
		*/
		
//		//chamar o JSP ou Servlet
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
