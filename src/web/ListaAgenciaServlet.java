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

import dao.AgenciaDAO;
import model.Agencia;

/**
 * Servlet implementation class ListaAgenciaServlet
 */
@WebServlet("/listaAgencia")
public class ListaAgenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		List<Agencia> lista = AgenciaDAO.selectAllAG();
		
		request.setAttribute("agenciasCadastradas", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formListaAgencia.jsp");
		rd.forward(request, response);


	}

}
