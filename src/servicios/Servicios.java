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
		
		return listaCategorias;
		
	}
	
	
}
