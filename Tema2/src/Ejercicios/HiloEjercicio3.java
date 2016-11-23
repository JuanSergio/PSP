package Ejercicios;

public class HiloEjercicio3 extends Thread{
	public void run(){
		System.out.println("Soy el "+ Thread.currentThread().getName() +" empezando.");
		try{
			System.out.println("Voy a esperar 3 segundos");
			this.sleep(20000);
			
		}catch(InterruptedException e){
			System.out.println("Hilo creado interrumpido.");
			return;
		}
		System.out.println("Soy el hilo creado que va a acabar.");
	}
}

class Ejercicio3 {
	public static void main(String args[]){
		HiloEjercicio3 hiloEjercicio3 = new HiloEjercicio3();
		hiloEjercicio3.start();
		try{
			Thread.sleep(3000);
		}catch (Exception e){
			return;
		}
		HiloEjercicio3.interrupted();
	}
}