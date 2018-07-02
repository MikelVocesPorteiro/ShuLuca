/**
 * 
 */
package conexion;

import funciones.LeerDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
		System.out.println("principio conexion.conexion conectar");
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conexion = DriverManager.getConnection("jdbc:mysql://10.90.36.39/zapato", "grupo3", "1234");
			System.out.println("Conectado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("fin Conexion.conexion conectar");
	}

	public void desconectar() {
		System.out.println("principio conexion.conexion desconectar");
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("fin conexion.conexion desconectar");
	}

	/**
	 * Metodo que lista TODO (sin diferenciar por categorias) el calzado en la
	 * pagina accediendo a la base de datos
	 * 
	 * @return ArrayList de zapatos con todos ellos
	 * @throws SQLException
	 */
	public ArrayList<Zapato> listarZapatos() throws SQLException {
		System.out.println("principio conexion.conexion listarZapatos");
		ArrayList<Zapato> lista = new ArrayList<Zapato>();
		conectar();
		Statement s = conexion.createStatement();
		String query = "SELECT * FROM modelo";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
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
			// logger.debug("Lista de zapatos: " +
			// lista);----------------------------------------------

		}
		System.out.println("fin conexion.conexion listarZapatos");
		desconectar();
		return lista;

	}

	public ArrayList<Categoria> listarCategorias() throws SQLException {
		System.out.println("principio conexion.conexion listarCategorias");
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		conectar();
		Statement s = conexion.createStatement();
		String query = "SELECT idcategoria, nombre FROM categoria";
		ResultSet rs = s.executeQuery(query);
		while (rs.next()) {
			Categoria categor = new Categoria();
			String nombre = rs.getString("nombre");
			int id = rs.getInt("idcategoria");
			categor.setNombre(nombre);
			categor.setId(id);
			lista.add(categor);
			// logger.debug("Lista de zapatos: " +
			// lista);----------------------------------

		}
		System.out.println("fin conexion.conexion listarCategorias");
		desconectar();
		return lista;
	}

	public void anadirZapato(String nombre, String marca, String color, String talla, int categoria, double precio,
			String url) throws SQLException {
		System.out.println("principio conexion.conexion anadirZapato");
		System.out.println("la url : " + url );
		ArrayList<Categoria> lista = new ArrayList<Categoria>();
		conectar();
		Statement s = conexion.createStatement();
		categoria = Integer.valueOf(categoria);
		System.out.println("fewf"+categoria);
		String query = "INSERT INTO modelo (`nombre`, `marca`, `color`, `talla`, `precio`, `url`, `idcategoria`) "
				+ "VALUES ('" + nombre + "', '" + marca + "','" +color+ "','" + talla + "'," + precio + ",'" + url + "'," + categoria + ")";

//		//String query = " INSERT INTO zapato (nombre,marca,color,talla,categoria,precio,url)"
//				+ " values (?, ?, ?, ?, ?,?,?)";
//		
//		PreparedStatement preparedStmt = conexion.prepareStatement(query);
//		preparedStmt.setString(1, "nombre");
//		preparedStmt.setString(2, "marca");
//		preparedStmt.setString(3, "color");
//		preparedStmt.setString(4, "talla");
//		preparedStmt.setString(5, "categoria");
//		preparedStmt.setDouble(6, precio);
//		preparedStmt.setString(7, "url");
		System.out.println(query);
		int rs = s.executeUpdate(query);
		desconectar();
	}

	public ArrayList<String> listarNombres() throws SQLException{
		System.out.println("principio conexion.conexion listarNombres");
		ArrayList<String> lista = new ArrayList<String>();
		conectar();
		Statement  s = conexion.createStatement();
		String query = "SELECT nombre FROM zapato.modelo;";
		ResultSet rs = s.executeQuery(query);
		while(rs.next()){
			
			String nombre = rs.getString("nombre");
			lista.add(nombre);

		}
		System.out.println("fin conexion.conexion listarNombres");
		desconectar();
		return lista;	
	} 
}
