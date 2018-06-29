package servicios;
import datos.IStock;
import datos.Stock;

/**
 * @author admin
 *
 */
public class Servicios implements IServicios{
	private IStock stock;

	@Override
	public void listarZapatos() {
		stock.listarZapatos();
		System.out.println("Entra");
	}
	
	
}
