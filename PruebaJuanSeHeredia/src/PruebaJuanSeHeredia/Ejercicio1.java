/***********************************************************/
/*	Ejercicio 1
 * 	Autor: Juan Sergio Heredia
 * 	Fecha: 25/11/2016
 */
/***********************************************************/	
package PruebaJuanSeHeredia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {
	public static void main (String[] args) throws IOException {
		
		String comando = "gedit";
		String comando2 = "firefox";
			
		try{
			Process proceso1 = Runtime.getRuntime().exec(comando);
				
			InputStreamReader entrada = new InputStreamReader (proceso1.getInputStream());
			BufferedReader salida = new BufferedReader (entrada);
				
			String linea;
				
		while ((linea=salida.readLine()) !=null){
					System.out.println(linea);
				}
		}catch (Exception e){
				System.out.println(e.getMessage());
		}
		try{
			Process proceso2 = Runtime.getRuntime().exec(comando2);
				
			InputStreamReader entrada = new InputStreamReader (proceso2.getInputStream());
			BufferedReader salida = new BufferedReader (entrada);
				
			String linea;
				
		while ((linea=salida.readLine()) !=null){
					System.out.println(linea);
				}
		}catch (Exception e){
				System.out.println(e.getMessage());
		}			
	}
}
