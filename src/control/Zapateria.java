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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String origen = request.getParameter("page");
		System.out.println( " control.zapateria /Zapateria principio processRequest con origen = " + origen );
		System.out.println("comienzo if");
		
		if (origen.equals("listado")) {
			System.out.println("  control.zapateria /Zapateria  processRequest principio if listado ");
			goListado(request, response);
			System.out.println("  control.zapateria /Zapateria  processRequest fin if listado ");

		}
		/**
		 * 
		 */
		if (origen.equals("form-insertar")) {
			System.out.println("  control.zapateria /Zapateria  processRequest principio if form-inserta ");
			goListCategoria(request, response);
			System.out.println("  control.zapateria /Zapateria  processRequest fin if form-inserta ");
		}
		if (origen.equals("insertar")) {
			System.out.println("  control.zapateria /Zapateria  processRequest principio if insertar ");
			goAnadirZapato(request, response);
			System.out.println("  control.zapateria /Zapateria  processRequest fin if insertar ");
		}
		
		if (origen.equals("modificar")) {
			System.out.println("  control.zapateria /Zapateria  processRequest principio if modificar ");
			goFormularioModificar(request, response);
			System.out.println("  control.zapateria /Zapateria  processRequest fin if modificar ");
		}
		
		if (origen.equals("es una cascara")) {
			System.out.println("  control.zapateria /Zapateria  processRequest principio if es una cascara ");
			
			
			
			System.out.println("  control.zapateria /Zapateria  processRequest fin if es una cascara ");

		}
		System.out.println( "  control.zapateria /Zapateria fin processRequest" );
	}
	
	protected void goListado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("  control.zapateria /Zapateria principio golistado ");
		
		ArrayList<Zapato> listaZapatos = servicios.listarZapatos();
		request.setAttribute("zapatos", listaZapatos);
		RequestDispatcher view = request.getRequestDispatcher("/listado.jsp");
		view.forward(request, response);
		
		System.out.println("  control.zapateria /Zapateria fin golistado ");
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void goListCategoria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("  control.zapateria /Zapateria principio goListCategoria ");
		
		ArrayList<Categoria> listaCategorias = servicios.listarCategorias();
		request.setAttribute("categorias", listaCategorias);
		RequestDispatcher view = request.getRequestDispatcher("/formanh.jsp");
		view.forward(request, response);
		
		System.out.println("  control.zapateria /Zapateria fin goListCategoria ");
	}
	/**
	 * Me devuelve la lista de categorias en un arraylist de strings
	 * @param request
	 * @param response
	 * @return lista de categorias en un arraylist
	 * @throws ServletException
	 * @throws IOException
	 */
	protected ArrayList<Categoria> getListCategoria(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("  control.zapateria /Zapateria principio goListCategoria ");
		ArrayList<Categoria> listaCategorias = servicios.listarCategorias();
		System.out.println("  control.zapateria /Zapateria fin goListCategoria ");
		return listaCategorias;
	}
	/**
	 * Me da lista de nombres para modificar posteriormente
	 * @param request
	 * @param response
	 * @return arraylist de strings que hacen referencia a los nombres de los zapatos
	 * @throws ServletException
	 * @throws IOException
	 */
	protected ArrayList<String> getListNombres(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("  control.zapateria /Zapateria principio goListNombres ");
		ArrayList<String> listaNombres = servicios.listarNombres();
		System.out.println("  control.zapateria /Zapateria fin goListNombres ");
		return listaNombres;
	}
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void goAnadirZapato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("  control.zapateria /Zapateria principio goAnadirZapato ");
		
		String nombre = request.getParameter("nombre");
		String marca = request.getParameter("marca");
		String color = request.getParameter("color");
		String talla = request.getParameter("talla");
		int categoria =Integer.parseInt(request.getParameter("categoria"));
		double precio =Double.parseDouble(request.getParameter("precio"));
//		String precio = request.getParameter("precio");
	
		String url = request.getParameter("url");

		System.out.println("la url : " + url );
		System.out.println("Categoria: "+ categoria);

		
		
		servicios.anadirZapato(nombre, marca, color, talla, categoria, precio, url);
		goListado(request, response);
		
		System.out.println("  control.zapateria /Zapateria fin goAnadirZapato ");
	}
	
	protected void goFormularioModificar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("  control.zapateria /Zapateria principio goFormularioModificar ");
		ArrayList<String> listaNombres = getListNombres(request, response);
		ArrayList<Categoria> listaCategorias = getListCategoria(request, response);
		System.out.println("Lista nombres: " + listaNombres);
		System.out.println("Lista categorias: " + listaCategorias);
		
		request.setAttribute("nombres", listaNombres);
		request.setAttribute("categorias", listaCategorias);
		
		RequestDispatcher view = request.getRequestDispatcher("/modificar.jsp");
		view.forward(request, response);
		
		System.out.println("  control.zapateria /Zapateria fin goFormularioModificar ");
		
		
		
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
