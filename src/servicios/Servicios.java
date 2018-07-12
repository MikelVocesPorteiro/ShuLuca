package servicios;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	private static final Logger log = LogManager.getLogger("Stock");

	@Override
	public ArrayList<Zapato> listarZapatos() {
		log.info("  servicios.Servicios implements IServicios principio listarZapatos ");
		ArrayList<Zapato> listaZapatos = new ArrayList<Zapato>();
		listaZapatos = stock.listarZapatos();
		log.info("  servicios.Servicios implements IServicios fin listarZapatos ");
		return listaZapatos;

	}

	@Override
	public ArrayList<Categoria> listarCategorias() {
		log.info("  servicios.Servicios implements IServicios principio listarCategorias ");
		ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
		listaCategorias = stock.listarCategorias();
		log.info("  servicios.Servicios implements IServicios fin listarCategorias ");
		log.info("cambios");

		return listaCategorias;

	}

	public ArrayList<String> listarNombres(){
		log.info("  servicios.Servicios implements IServicios principio listarNombres ");
		ArrayList<String> listaNombres = new ArrayList<String>();
		listaNombres = stock.listarNombres();
		log.info("  servicios.Servicios implements IServicios fin listarNombres ");

		return listaNombres;
	}

	@Override
	public void anadirZapato(String nombre, String marca, String color, String talla, int categoria, double precio,
			String url) {
		log.info("  servicios.Servicios implements IServicios principio anadirZapato ");
		stock.anadirZapato(nombre, marca, color, talla, categoria, precio, url);
		log.info("  servicios.Servicios implements IServicios fin anadirZapato ");

	}

}
