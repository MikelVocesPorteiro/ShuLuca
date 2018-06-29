package funciones;

public class Mensaje {
	private String mensaje;
	private int valor;
	
	public Mensaje(){
		
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Mensaje [mensaje=" + mensaje + ", valor=" + valor + "]";
	}
	
	
}
