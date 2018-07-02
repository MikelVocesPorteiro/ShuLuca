/**

 * 
 */
package datos;
import java.util.ArrayList;

import domain.Categoria;
import domain.Zapato;
/**
 * @author admin
 *
 */
public interface IStock {
	 public ArrayList<Zapato> listarZapatos();
	 public ArrayList<Categoria> listarCategorias();
	 public void anadirZapato(String nombre, String marca, String color, String talla, int categoria,
				double precio, String url);
	 
	 public ArrayList<String> listarNombres();
}
