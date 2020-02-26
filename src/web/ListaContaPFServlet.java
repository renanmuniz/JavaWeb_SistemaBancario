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

import dao.ContaPFDAO;
import model.ContaPF;

/**
 * Servlet implementation class ListaEmpresasServlet
 */
@WebServlet("/listaContaPF")
public class ListaContaPFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		List<ContaPF> lista = ContaPFDAO.selectAllContaPF();
		
		request.setAttribute("ContasPFCadastradas", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formListaContaPF.jsp");
		rd.forward(request, response);


	}

}
