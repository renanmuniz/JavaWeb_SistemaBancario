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

/**
 * Servlet implementation class DeletePessoaFisicaServlet
 */
@WebServlet("/deletaAgencia")
public class DeletaAgenciaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Deletando agência");
		
		String numAgencia      = request.getParameter("numAgencia");
		
		AgenciaDAO agDAO = new AgenciaDAO();
		
		Integer regsDeletados = agDAO.deleteAgencia(numAgencia);
        
        System.out.println("### Registros Deletados: " + regsDeletados + " ###");
        
        if (regsDeletados != 0)
        {
        	System.out.println("### Deletado Cadastro de Agência ###");   
        	request.setAttribute("agenciaDeletada", numAgencia);
        	RequestDispatcher rd = request.getRequestDispatcher("/AgenciaDeletada.jsp");
        	rd.forward(request, response);
        }
        else
        {
        	System.out.println("### Erro ao deletar Cadastro de Agência ###");
        	System.out.println("### Exception: " + AgenciaDAO.retornaErro());
        	request.setAttribute("agenciaNaoDeletada", numAgencia);
        	request.setAttribute("erro", AgenciaDAO.retornaErro());
        	RequestDispatcher rd = request.getRequestDispatcher("/AgenciaNaoDeletada.jsp");
        	rd.forward(request, response);
        }
		
		
		
		
		/*
        request.setAttribute("agenciaDeletada", numAgencia);
		RequestDispatcher rd = request.getRequestDispatcher("/AgenciaDeletada.jsp");
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
