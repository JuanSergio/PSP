package Ejercicios;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ejercicio1 {
	public static void main (String[] args) throws IOException {
			
		String comando = "ifconfig";
			
		try{
			Process proceso = Runtime.getRuntime().exec(comando);
				
			InputStreamReader entrada = new InputStreamReader (proceso.getInputStream());
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

