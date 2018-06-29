/**
 * 
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import funciones.LeerDatos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import domain.Categoria;
import domain.Zapato;
//////////NUEVO//////////
/**
 * @author admin
 *
 */
public class Conexion {
	public static Logger logger;
	static {
		try {
			logger = LogManager.getLogger(LeerDatos.class);
		} catch (Throwable e) {
			System.out.println("No funciona");
		}
	}
	private Connection conexion;

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public void conectar() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conexion = DriverManager.getConnection("jdbc:mysql://10.90.36.39/zapato", "grupo3", "1234");
			System.out.println("Conectado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Conectado");
	}
//////////NUEVO//////////
	public void desconectar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que lista TODO (sin diferenciar por categorias) el calzado en la pagina 
	 * accediendo a la base de datos
	 * @return ArrayList de zapatos con todos ellos
	 * @throws SQLException 
	 */
	////////// NUEVO//////////
	public ArrayList<Zapato> listarZapatos() throws SQLException{
		System.out.println("conexion listar zapatos");
		ArrayList<Zapato> lista = new ArrayList<Zapato>();
		conectar();
		System.out.println("conexion despues de conectar");
		Statement  s = conexion.createStatement();
		String query = "SELECT * FROM modelo";
		ResultSet rs = s.executeQuery(query);
			while(rs.next()){
				Zapato zapa = new Zapato();
				String nombre = rs.getString("nombre");
				String talla = rs.getString("talla");
				double precio = rs.getDouble("precio");
				String color = rs.getString("color");
				String marca = rs.getString("marca");
				String url = rs.getString("url");
				
				zapa.setNombre(nombre);
				zapa.setTalla(talla);
				zapa.setPrecio(precio);
				zapa.setColor(color);
				zapa.setMarca(marca);
				zapa.setUrl(url);
				
				lista.add(zapa);
				logger.debug("Lista de zapatos: " + lista);

			}
		
		return lista;
	
	
	}
	
	public ArrayList<Categoria> listarCategorias() throws SQLException{
		System.out.println("conexion listar categorias");
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		conectar();
		System.out.println("conexion despues de conectar");
		Statement  s = conexion.createStatement();
		String query = "SELECT idcategoria, nombre FROM categoria";
		ResultSet rs = s.executeQuery(query);
			while(rs.next()){
				Categoria categor = new Categoria();
				String nombre = rs.getString("nombre");
				int id = rs.getInt("idcategoria");
				categor.setNombre(nombre);
				categor.setId(id);
				lista.add(categor);
				logger.debug("Lista de zapatos: " + lista);

			}
		
		return lista;
	
	
	}
	
	
}


