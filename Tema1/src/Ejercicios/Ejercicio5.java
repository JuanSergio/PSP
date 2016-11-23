/*
 * Modificar el programa anterior para que admita como parámetros de entrada más
 *  de una aplicación y espere a que todas terminen para mostrar
 *  el mensaje por pantalla “Aplicaciones finalizadas.”.
 */

package Ejercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio5 {
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
