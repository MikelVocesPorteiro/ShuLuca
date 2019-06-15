package funciones;

import java.util.Scanner;

public class LeerTeclado {
	
	@SuppressWarnings("resource")
	public static int LeerInt(){
		return new Scanner(System.in).nextInt();
	}
	
	public static int LeerInt(String msg){
		System.out.println(msg);
		return LeerInt();
	}
	
	@SuppressWarnings("resource")
	public static String LeerTexto(){
		return new Scanner(System.in).nextLine();
	}
	
	public static String LeerTexto(String msg){
		System.out.println(msg);
		return LeerTexto();
	}	
}
