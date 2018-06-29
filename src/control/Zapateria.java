package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Zapato;
import servicios.IServicios;
import servicios.Servicios;

/**
 * Servlet implementation class Zapateria
 */
@WebServlet("/Zapateria")
public class Zapateria extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IServicios servicios = new Servicios();

	/**
	 * Default constructor.
	 */
	public Zapateria() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String origen = request.getParameter("page");
		if (origen.equals("listado")) {
			// LISTADO
			System.out.println("misout");
			goListado(request, response);

		}
		if (origen.equals("añadir")) {
			// LISTADO
			System.out.println("anadi");
			goListCategoria(request, response);

		}
	}

	////////// NUEVO//////////
	protected void goListado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Zapato> listaZapatos = servicios.listarZapatos();
		System.out.println(request);
		System.out.println("-");
		System.out.println(response);
		request.setAttribute("zapatos", listaZapatos);
		System.out.println("hi");
		RequestDispatcher view = request.getRequestDispatcher("/listado.jsp");
		view.forward(request, response);
	}

	protected void goListCategoria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Zapato> listaZapatos = servicios.listarZapatos();
		System.out.println(request);
		System.out.println("-");
		System.out.println(response);
		request.setAttribute("zapatos", listaZapatos);
		System.out.println("hi");
		RequestDispatcher view = request.getRequestDispatcher("/formanh.jsp");
		view.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
