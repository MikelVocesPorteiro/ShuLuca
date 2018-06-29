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
}
