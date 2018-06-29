package funciones;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LeerDatos  {
	public static Logger logger;
	static{
		try{
			logger = LogManager.getLogger(LeerDatos.class);
		}catch(Throwable e){
			System.out.println("No funciona");
		}
	}
	
	// LEER ENTERO (una vez)
	public static int leerEntero(String msg)throws  IOException{
		//Me creo el objeto que almacena la informacion leida
		BufferedReader almEnteros;
		String str ;
		int numero=0;
		System.out.println(msg);
		try{
			almEnteros = new BufferedReader(new InputStreamReader(System.in));
			str = almEnteros.readLine();
			numero = Integer.parseInt(str);
			System.out.println("Leida: "+numero);
//			almEnteros.close();
		}catch(IOException e){
			logger.error(e);
		}
		return numero;
	}
	
	
	
	// LEER DECIMALES
	public static double leerDecimales(String msg)throws  IOException{
		//Me creo el objeto que almacena la informacion leida
		BufferedReader almEnteros;
		String str ;
		double numero=0;
		System.out.println(msg);
		try{
			almEnteros = new BufferedReader(new InputStreamReader(System.in));
			str = almEnteros.readLine();
			numero = Double.parseDouble(str);
			System.out.println("Leida: "+numero);
//			almEnteros.close();
		}catch(IOException e){
			logger.error(e);
		}
		return numero;
	}
	
	// LEER TEXTO
	public static String leerTexto(String msg)throws  IOException{
		//Me creo el objeto que almacena la informacion leida
		BufferedReader almEnteros;
		String str =null ;
		System.out.println(msg);
		try{
			almEnteros = new BufferedReader(new InputStreamReader(System.in));
			str = almEnteros.readLine();
			System.out.println("Leida: "+str);
//			almEnteros.close();
		}catch(IOException e){
			logger.error(e);
		}
		return str;
	}
	
}
