package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servicios.IServicios;

/**
 * Servlet implementation class Zapateria
 */
@WebServlet("/Zapateria")
public class Zapateria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IServicios servicios;

    /**
     * Default constructor. 
     */
    public Zapateria() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String origen = request.getParameter("page");
        if(origen.equals("listado")) {
            // LISTADO
        	goListado(request, response);
            
        }
	}
	
	protected void goListado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("listaZapato", servicios.listarZapatos());
        RequestDispatcher view = request.getRequestDispatcher("/listado.jsp");
        view.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
