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
 * Servlet implementation class AlteraPessoaFisicaServlet
 */
@WebServlet("/alteraAgencia")
public class AlteraAgenciaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		System.out.println("Alterando agência");
		
		String numAgencia = request.getParameter("numAgencia");
		String enderecoAg = request.getParameter("endereco");
		String cidadeAg   = request.getParameter("cidade");
		String estadoAg   = request.getParameter("estado");
		String telefoneAg = request.getParameter("telefone");
		
		Agencia ag = new Agencia(numAgencia, enderecoAg, cidadeAg, estadoAg, telefoneAg);
		
		AgenciaDAO agDAO = new AgenciaDAO();
		
		Integer regsAlterados = agDAO.updateAgencia(ag);
        
		System.out.println("### Registros Alterados: " + regsAlterados + " ###");
	       
		if (regsAlterados != 0)
		{
			System.out.println("### Alterado Cadastro de Agência ###");   
			request.setAttribute("agenciaAlterada", numAgencia);		
			RequestDispatcher rd = request.getRequestDispatcher("/AgenciaAlterada.jsp");
			rd.forward(request, response);
		}
		else
		{
	       	System.out.println("### Erro ao Alterar Cadastro de Agência ###");
	       	System.out.println("### Exception: " + AgenciaDAO.retornaErro());
	       	request.setAttribute("agenciaNaoAlterada", numAgencia);
	       	request.setAttribute("erro", AgenciaDAO.retornaErro());
	       	RequestDispatcher rd = request.getRequestDispatcher("/AgenciaNaoAlterada.jsp");
	       	rd.forward(request, response);
		}		
		
		/*
        request.setAttribute("agenciaAlterada", ag.getNumAgencia());		
		RequestDispatcher rd = request.getRequestDispatcher("/AgenciaAlterada.jsp");
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
