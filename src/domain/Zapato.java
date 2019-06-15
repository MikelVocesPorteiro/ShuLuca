package domain;

/**
 * Clase Zapato
 * Informacion del zapato
 * @author Rocio
 *
 */

public class Zapato {
	/**
	 * Nombre del zapato
	 */
	
	private String nombre;
	/**
	 * Marca del zapato
	 */
	private String marca;
	/**
	 * Color del zapato
	 */
	private String color;
	/**
	 * Talla del zapato
	 */
	private String talla;
	/**
	 * Categortia del zapato
	 */
	private int categoria;
	/**
	 * Precio del zapato
	 */
	private double precio;
	/**
	 * Url del zapato
	 */
	private String url;
	
	
	/**
	 * Constuctor vacio
	 */
	public Zapato(){
		
	}
	
	/**
	 * Constructor con 8 parametros
	 * @param nombre
	 * 			Nombre del zapato
	 * @param marca
	 * 			Marca del zapato
	 * @param color
	 * 			Color del zapato
	 * @param talla
	 * 			Talla del zapato
	 * @param categoria
	 * 			Categoria del zapato

	 * @param precio
	 * 			Precio del zapato
	 * @param url
	 * 			Url del zapato
	 */
	
    public Zapato(String nombre, String marca, String color, String talla, int categoria,
			double precio, String url) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.color = color;
		this.talla = talla;
		this.categoria = categoria;
		this.precio = precio;
		this.url = url;
	}

    /**
     * 
     * @return nombre
     */
	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @param nombre
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * 
	 * @return marca
	 */

	public String getMarca() {
		return marca;
	}
	/**
	 * 
	 * @param marca
	 */

	public void setMarca(String marca) {
		this.marca = marca;
	}
	/**
	 * 
	 * @return color
	 */

	public String getColor() {
		return color;
	}
	
	/**
	 * 
	 * @param color
	 */

	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * 
	 * @return Talla
	 */

	public String getTalla() {
		return talla;
	}
	
	/**
	 * 
	 * @param talla
	 */

	public void setTalla(String talla) {
		this.talla = talla;
	}
	/**
	 * 
	 * @return categoria
	 */

	public int getCategoria() {
		return categoria;
	}
	
	/**
	 * 
	 * @param categoria
	 */

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	
	/**
	 * 
	 * @return precio
	 */

	public double getPrecio() {
		return precio;
	}
	
	/**
	 * 
	 * @param precio
	 */

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	/**
	 * 
	 * @return url
	 */

	public String getUrl() {
		return url;
	}
	/**
	 * 
	 * @param url
	 */

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Zapato [nombre=");
		builder.append(nombre);
		builder.append(", marca=");
		builder.append(marca);
		builder.append(", color=");
		builder.append(color);
		builder.append(", talla=");
		builder.append(talla);
		builder.append(", categoria=");
		builder.append(categoria);
		builder.append(", precio=");
		builder.append(precio);
		builder.append(", url=");
		builder.append(url);
		builder.append("]");
		return builder.toString();
	}


	/**
	 * El método toString muestra la informacion completa del zapato
	 */


}
	
	

		