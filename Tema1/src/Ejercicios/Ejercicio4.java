/*
 * Realiza un programa en Java que admita como parámetro de entrada 
 * la ruta de un archivo ejecutable, ejecute dicha aplicación y muestre 
 * por pantalla el mensaje “Aplicación finalizada.” al finalizar la aplicación 
 * ejecutada.
 */
package Ejercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio4 {
	public static void main(String[] args) {
		
		try{
			Process proceso = Runtime.getRuntime().exec(args);
				
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

