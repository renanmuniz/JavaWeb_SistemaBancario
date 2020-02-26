package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContaPJDAO;
import model.ContaPJ;

/**
 * Servlet implementation class ListaContasPJServlet
 */
@WebServlet("/listaContaPJ")
public class ListaContaPJServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		List<ContaPJ> lista = ContaPJDAO.selectAllContaPJ();
		
		request.setAttribute("ContasPJCadastradas", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formListaContaPJ.jsp");
		rd.forward(request, response);
	}

}
