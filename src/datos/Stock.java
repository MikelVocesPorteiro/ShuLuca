package datos;

import java.io.IOException;
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
	private Map<Integer, Zapato> stock;		
	
	public Stock(Map<Integer, Zapato> stock){
		super();
		this.stock = stock;
	}
	 public Stock(){
		 
	 }

  
    public void listarZapatos() {
    	List<Zapato> listaZapatos = new ArrayList<Zapato>();
    	listaZapatos = con.listarZapatos("SELECT * FROM zapato");
    }
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
