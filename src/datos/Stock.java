package datos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import conexion.Conexion;
import domain.Zapato;

/**
 * 
 * @author admin
 *
 */
public class Stock implements IStock{
	Conexion con;
	private ArrayList<Zapato> stock;		
	
	public Stock(ArrayList< Zapato> stock){
		super();
		this.stock = stock;
	}
	 public Stock(){
		 
	 }

  /**
   * 
   */
//////////NUEVO//////////
    public ArrayList<Zapato> listarZapatos() {
    	ArrayList<Zapato> listaZapatos = new ArrayList<Zapato>();
    	try {
			listaZapatos = con.listarZapatos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Pasa por el metodo listarZapatos() en la capa de datos ");
		return listaZapatos;
    }
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
