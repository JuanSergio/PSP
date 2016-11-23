package Ejercicios;
/*
Crea un programa que cree un hilo que realice el cálculo de los primeros N
números de la sucesión de Fibonacci.
La sucesión de Fibonacci comienza con los números 0 y 1 y 
el siguiente elemento es la suma
de los dos elementos anteriores. Así la sucesión de 
Fibonacci sería 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
El parámetro N se pedirá y recogerá en el hilo principal 
e irá indicado cuando se llamé al
constructor de la clase Thread correspondiente.*/

import java.util.Scanner;

public class CalculoNumeros {
	public static void main(String args[]) {
		Scanner tlc = new Scanner(System.in);
		System.out.println("Introduce un número");
		int numero = tlc.nextInt();
		Thread hilo = new Thread(numero);
		hilo.start();
		
		
	}

}
class hilo extends Thread{
	public int numero;
		
	class hilo(int numero){
		
	}
}

class run implements Runnable {
	public void run() {
		for(int i=1; i<=5; i++){
			System.out.println("Ejecutando"+Thread.currentThread().getName()+":"+i);
		}
	}
}


