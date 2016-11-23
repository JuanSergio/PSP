package Ejercicios;

import java.awt.Container;
import java.awt.event.ContainerAdapter;
import java.beans.MethodDescriptor;
import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

public class HiloEjercicio9 extends Thread{
	
	static int contador = 0;
	static String frase;
	
	public void run(){
		if (this.getName().compareTo("hilo1")==0)
			this.contarA();
	}

	public  synchronized void contarA(){
		for (int i=0; i < frase.length(); i++){
			if(frase.charAt(i)== 'a' || frase.charAt(i)== 'A' )
				contador++;
		}
	}
	

		
	public static void main(String args[]){
		Scanner tlc = new Scanner(System.in);
		String palabra = tlc.nextLine();
		
		
		int inicio= 0;
		HiloEjercicio9 hilo1 = new Thread();
		Thread hilo2 = new Thread();
		Thread hilo3 = new Thread();
		Thread hilo4 = new Thread();
		Thread hilo5 = new Thread();
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		
		try{
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
			hilo5.join();
			
		}catch(Exception e){
			System.err.println("No hay más hilos que esperar");
			
		}
		
	}
}


