package servicios;

import java.util.ArrayList;

import datos.IStock;
import datos.Stock;
import domain.Categoria;
import domain.Zapato;

/**
 * @author admin
 *
 */
public class Servicios implements IServicios {
	private IStock stock = new Stock();

	@Override
	public ArrayList<Zapato> listarZapatos() {
		System.out.println("  servicios.Servicios implements IServicios principio listarZapatos ");
		ArrayList<Zapato> listaZapatos = new ArrayList<Zapato>();
		listaZapatos = stock.listarZapatos();
		System.out.println("  servicios.Servicios implements IServicios fin listarZapatos ");
		return listaZapatos;

	}

	@Override
	public ArrayList<Categoria> listarCategorias() {
		System.out.println("  servicios.Servicios implements IServicios principio listarCategorias ");
		ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
		listaCategorias = stock.listarCategorias();
		System.out.println("  servicios.Servicios implements IServicios fin listarCategorias ");
		System.out.println("cambios");

		return listaCategorias;

	}

	public ArrayList<String> listarNombres(){
		System.out.println("  servicios.Servicios implements IServicios principio listarNombres ");
		ArrayList<String> listaNombres = new ArrayList<String>();
		listaNombres = stock.listarNombres();
		System.out.println("  servicios.Servicios implements IServicios fin listarNombres ");

		return listaNombres;
	}

	@Override
	public void anadirZapato(String nombre, String marca, String color, String talla, int categoria, double precio,
			String url) {
		System.out.println("  servicios.Servicios implements IServicios principio anadirZapato ");
		stock.anadirZapato(nombre, marca, color, talla, categoria, precio, url);
		System.out.println("  servicios.Servicios implements IServicios fin anadirZapato ");

	}

}
