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

import domain.Zapato;

/**
 * @author admin
 *
 */
public class Conexion {
	public static Logger logger;
	static{
		try{
			logger = LogManager.getLogger(LeerDatos.class);
		}catch(Throwable e){
			System.out.println("No funciona");
		}
	}


	
	public static Connection conectar(){
		Connection con = null ;
		Statement st = null ;
		ResultSet rs = null;
	
		
		try{
			String driverClassName = "com.mysql.jdbc.Driver";
			String driverUrl = "jdbc:mysql://localhost/zapato";
			String user = "root";
			String password = "1111";
			Class.forName(driverClassName);
			con = DriverManager.getConnection(driverUrl,user, password);
			st = con.createStatement();
			
			
					
		}catch(ClassNotFoundException e){
			logger.warn("No se encuentra el driver");
		}catch(SQLException e){
			logger.warn("Excepcion SQL: " + e.getMessage());
			logger.warn("Estado SQL: " + e.getSQLState());
			logger.warn("Codigo del error: " + e.getErrorCode());
		}finally{
			try{
				if (rs != null) rs.close();
				if (st != null) st.close();
				if (con != null) con.close();
			}catch(SQLException  e){
				e.printStackTrace();
			}
		}
		return con;
	}
	public Conexion(){
	
	}
		
	public static List<Zapato> listarZapatos(String query){
		List<Zapato> lista = new ArrayList<Zapato>();
		Connection con = conectar();
		Statement st=null;
		
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
