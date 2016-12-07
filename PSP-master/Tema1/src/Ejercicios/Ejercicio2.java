/*
2.- Realiza un programa en Java que abra alguna aplicación 
windows/linux y muestre el mensaje “La aplicación se ha cerrado con éxito.” 
Al cerrar la aplicación ejecutada.
*/
package Ejercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio2 {
	public static void main(String[] args) {
		String comando = "gedit";
		
		try{
			Process proceso = Runtime.getRuntime().exec(comando);
				
			InputStreamReader entrada = new InputStreamReader (proceso.getInputStream());
			BufferedReader salida = new BufferedReader (entrada);
				
			String linea;
				
		while ((linea=salida.readLine()) !=null){
					System.out.println(linea);
				}
		proceso.destroy();
		System.out.println("La aplicación se ha cerrado con éxito.");
		}catch (Exception e){
				System.out.println(e.getMessage());
		}				
	
	}
}
