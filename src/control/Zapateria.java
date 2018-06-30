package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Categoria;
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
		System.out.println( " control.zapateria /Zapateria principio processRequest con origen = " + origen );
		if (origen.equals("listado")) {
			System.out.println("  control.zapateria /Zapateria  processRequest principio if listado ");
			goListado(request, response);
			System.out.println("  control.zapateria /Zapateria  processRequest fin if listado ");

		}
		if (origen.equals("insertar")) {
			System.out.println("  control.zapateria /Zapateria  processRequest principio if insertar ");
			goListCategoria(request, response);
			System.out.println("  control.zapateria /Zapateria  processRequest fin if insertar ");

		}
		
		if (origen.equals("es una cascara")) {
			System.out.println("  control.zapateria /Zapateria  processRequest principio if es una cascara ");
			
			
			
			System.out.println("  control.zapateria /Zapateria  processRequest fin if es una cascara ");

		}
		System.out.println( "  control.zapateria /Zapateria fin processRequest" );
	}

	////////// NUEVO//////////
	protected void goListado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("  control.zapateria /Zapateria principio golistado ");
		ArrayList<Zapato> listaZapatos = servicios.listarZapatos();
		request.setAttribute("zapatos", listaZapatos);
		RequestDispatcher view = request.getRequestDispatcher("/listado.jsp");
		view.forward(request, response);
		System.out.println("  control.zapateria /Zapateria fin golistado ");
	}

	protected void goListCategoria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("  control.zapateria /Zapateria principio goListCategoria ");
		ArrayList<Categoria> listaCategorias = servicios.listarCategorias();
		request.setAttribute("categorias", listaCategorias);
		RequestDispatcher view = request.getRequestDispatcher("/formanh.jsp");
		view.forward(request, response);
		System.out.println("  control.zapateria /Zapateria fin goListCategoria ");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("  control.zapateria /Zapateria principio doget ");
		processRequest(request, response);
		System.out.println("  control.zapateria /Zapateria fin doget ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("  control.zapateria /Zapateria principio doPost ");
		doGet(request, response);
		System.out.println("  control.zapateria /Zapateria fin dopost ");
	}

}
