/***********************************************************/
/*	Ejercicio 2
 * 	Autor: Juan Sergio Heredia
 * 	Fecha: 25/11/2016
 */
/***********************************************************/	


package PruebaJuanSeHeredia;

class HiloEjercicio2 extends Thread {
	private long espera;
	
	public HiloEjercicio2 (long espera, String nombre) {
		this.espera = espera;
		this.setName(nombre);
	}
	
	public void run() {
		String nombreHilo = this.getName();
		
		try {
			System.out.println(nombreHilo);
			Thread.sleep(espera);
		} catch (InterruptedException e) {
			System.out.println(nombreHilo +" interrumpido");
			return;
		}
	}
}

class Ejercicio2 {
	public static void main(String[] args){
		
		
		for (int i = 0; i < 5; i++){	
			HiloEjercicio2 thread1 = new HiloEjercicio2(3000, "A mí me rebota y	a ti te	explota ");
			thread1.start();
			
		}
		for (int i = 0; i < 5; i++){
			HiloEjercicio2 thread2 = new HiloEjercicio2(7000, "Y tú más ");
			thread2.start();
			
		}

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Hilo PRINCIPAL interrumpido");
			return;
		}
		System.out.println("Dejaos de gilipolleces");
	}
}


