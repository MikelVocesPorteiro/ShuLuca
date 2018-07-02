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
		System.out.println("  datos.Stock implements IStock principio listarZapatos ");
    	ArrayList<Zapato> listaZapatos = new ArrayList<Zapato>();
    	try {
    		Conexion con = new Conexion();
			listaZapatos = con.listarZapatos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al listar en Stock");
			e.printStackTrace();
		}
		System.out.println("  datos.Stock implements IStock fin listarZapatos ");
		System.out.println("hi");
		return listaZapatos;
    }
    
    public ArrayList<Categoria> listarCategorias() {
		System.out.println("  datos.Stock implements IStock principio listarCategorias ");
    	ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
    	try {
    		Conexion con = new Conexion();
    		listaCategorias = con.listarCategorias();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al listar en Stock");
			e.printStackTrace();
		}
		System.out.println("  datos.Stock implements IStock fin listarCategorias ");
		return listaCategorias;
    }
    
	public void anadirZapato(String nombre, String marca, String color, String talla, int categoria,
			double precio, String url){
		System.out.println("  datos.Stock implements IStock principio anadirZapato ");
		try {
    		Conexion con = new Conexion();
    		con.anadirZapato(nombre, marca, color, talla, categoria, precio, url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error al añadir en Stock");
			e.printStackTrace();
		}
		System.out.println("  datos.Stock implements IStock fin anadirZapato ");
	}
	
	public ArrayList<String> listarNombres(){
		System.out.println("  datos.Stock implements IStock principio listarNombres ");
    	ArrayList<String> listaNombres = new ArrayList<String>();
    	Conexion con = new Conexion();
		try {
			listaNombres = con.listarNombres();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("  datos.Stock implements IStock fin listarNombres ");
		return listaNombres;
	}
}
