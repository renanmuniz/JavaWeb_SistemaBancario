package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");		
		
		RequestDispatcher rd; 
		
		switch(paramAcao)
		{
		case "novaPessoaFisica":		
			rd = request.getRequestDispatcher("/formIncluiPessoaFisica.jsp");
			rd.forward(request, response);
			break;
			
		case "listaPessoaFisica":		
			rd = request.getRequestDispatcher("/listaPessoas");
			rd.forward(request, response);
			break;	
			
		case "deletaPessoaFisica":		
			System.out.println("UnicaEntradaServlet > deletaPessoaFisica");
			rd = request.getRequestDispatcher("/formDeletaPessoaFisica.jsp");
			rd.forward(request, response);
			break;	
			
		case "alteraPessoaFisica":		
			System.out.println("UnicaEntradaServlet > alteraPessoaFisica");
			rd = request.getRequestDispatcher("/formAlteraPessoaFisica.jsp");
			rd.forward(request, response);
			break;
			
		case "novaPessoaJuridica":
			rd = request.getRequestDispatcher("/formIncluiPessoaJuridica.jsp");
			rd.forward(request, response);
			break;

		case "deletaPessoaJuridica":		
			System.out.println("UnicaEntradaServlet > deletaPessoaJuridica");
			rd = request.getRequestDispatcher("/formDeletaPessoaJuridica.jsp");
			rd.forward(request, response);
			break;	
			
		case "alteraPessoaJuridica":		
			System.out.println("UnicaEntradaServlet > alteraPessoaJuridica");
			rd = request.getRequestDispatcher("/formAlteraPessoaJuridica.jsp");
			rd.forward(request, response);
			break;
			
		case "listaPessoaJuridica":
			rd = request.getRequestDispatcher("/listaPessoaJuridica");
			rd.forward(request, response);
			break;
			
		case "novaAgencia":
			rd = request.getRequestDispatcher("/formIncluiAgencia.jsp");
			rd.forward(request, response);
			break;
			
		case "deletaAgencia":		
			System.out.println("UnicaEntradaServlet > deletaAgencia");
			rd = request.getRequestDispatcher("/formDeletaAgencia.jsp");
			rd.forward(request, response);
			break;	
			
		case "alteraAgencia":		
			System.out.println("UnicaEntradaServlet > alteraAgencia");
			rd = request.getRequestDispatcher("/formAlteraAgencia.jsp");
			rd.forward(request, response);
			break;
			
		case "listaAgencia":
			rd = request.getRequestDispatcher("/listaAgencia");
			rd.forward(request, response);
			break;
			
		case "novaContaPF":
			rd = request.getRequestDispatcher("/formIncluiContaPF.jsp");
			rd.forward(request, response);
			break;
		
		case "deletaContaPF":		
			System.out.println("UnicaEntradaServlet > deletaContaPF");
			rd = request.getRequestDispatcher("/formDeletaContaPF.jsp");
			rd.forward(request, response);
			break;	
			
		case "alteraContaPF":		
			System.out.println("UnicaEntradaServlet > alteraContaPF");
			rd = request.getRequestDispatcher("/formAlteraContaPF.jsp");
			rd.forward(request, response);
			break;			
			
		case "listaContaPF":
			rd = request.getRequestDispatcher("/listaContaPF");
			rd.forward(request, response);
			break;
			
		case "novaContaPJ":
			rd = request.getRequestDispatcher("/formIncluiContaPJ.jsp");
			rd.forward(request, response);
			break;
			
		case "deletaContaPJ":		
			System.out.println("UnicaEntradaServlet > deletaContaPJ");
			rd = request.getRequestDispatcher("/formDeletaContaPJ.jsp");
			rd.forward(request, response);
			break;	
			
		case "alteraContaPJ":		
			System.out.println("UnicaEntradaServlet > alteraContaPJ");
			rd = request.getRequestDispatcher("/formAlteraContaPJ.jsp");
			rd.forward(request, response);
			break;			
			
		case "listaContaPJ":
			rd = request.getRequestDispatcher("/listaContaPJ");
			rd.forward(request, response);
			break;			
			
		default:
			rd = request.getRequestDispatcher("MenuPrincipal.html");
			rd.forward(request, response);
			break;
		
		}		
		
	}

}
