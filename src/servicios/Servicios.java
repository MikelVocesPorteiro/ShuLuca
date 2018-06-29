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
public class Servicios implements IServicios{
	private IStock stock = new Stock();

	@Override
	public ArrayList<Zapato> listarZapatos() {
		ArrayList<Zapato> listaZapatos = new ArrayList<Zapato>();
		listaZapatos = stock.listarZapatos();
		System.out.println("Pasa por el metodo listarZapatos() en la capa de servicios ");
		return listaZapatos;
		
	}
	
	@Override
	public ArrayList<Categoria> listarCategorias() {
		ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
		listaCategorias = stock.listarCategorias();
		System.out.println("Pasa por el metodo listarCategorias() en la capa de servicios ");
		
		return listaCategorias;
		
	}
	
	
}
