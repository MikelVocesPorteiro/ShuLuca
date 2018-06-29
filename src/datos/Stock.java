package datos;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import conexion.Conexion;
import domain.Categoria;
import domain.Zapato;

/**
 * 
 * @author admin
 *
 */
public class Stock implements IStock{
	//Conexion con;
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
    		Conexion con = new Conexion();
			listaZapatos = con.listarZapatos();
			System.out.println(listaZapatos);
			System.out.println("listar zapatos Stock");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al listar en Stock");
			e.printStackTrace();
		}
		System.out.println("Pasa por el metodo listarZapatos() en la capa de datos ");
		return listaZapatos;
    }
    
    public ArrayList<Categoria> listarCategorias() {
    	ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
    	try {
    		Conexion con = new Conexion();
    		listaCategorias = con.listarCategorias();
			System.out.println(listaCategorias);
			System.out.println("listar categorias Stock");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al listar en Stock");
			e.printStackTrace();
		}
		System.out.println("Pasa por el metodo listarCategorias() en la capa de datos ");
		return listaCategorias;
    }
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
