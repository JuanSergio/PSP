package Ejercicios;

public class EjercicioImprovisado extends Thread{
	public static void main(String[] args) {
		
		int inicio= 0;
		EjercicioImprovisado hilo1 = new EjercicioImprovisado();
		EjercicioImprovisado hilo2 = new EjercicioImprovisado();
		
		hilo1.start();
		
		while(inicio==10){
			int contador1=inicio++;
			System.out.println(contador1);
			try{
				hilo1.join();
			}catch(InterruptedException e){
				System.out.println("El hilo1 esta esperando...");
				e.printStackTrace();
			}
			while(contador1==10){
				hilo2.start();
			}
		}
	}

}
