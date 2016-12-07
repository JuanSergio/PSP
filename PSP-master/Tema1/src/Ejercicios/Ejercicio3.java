/*
 3.- Realiza un programa en Java que admita como parámetro de entrada 
 el comando a ejecutar en la consola del sistema operativo y muestre 
 en pantalla el resultado.

 */

package Ejercicios;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		try{
			Process proceso = Runtime.getRuntime().exec(args);
				
			InputStreamReader entrada = new InputStreamReader (proceso.getInputStream());
			BufferedReader salida = new BufferedReader (entrada);
				
			String linea;
				
		while ((linea=salida.readLine()) !=null){
					System.out.println(linea);
				}
		;
		}catch (Exception e){
				System.out.println(e.getMessage());
		}				
	
	}
}
