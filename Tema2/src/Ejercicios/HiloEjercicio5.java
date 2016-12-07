package Ejercicios;

class HiloEjercicio5 extends Thread {
	private long espera;
	
	public HiloEjercicio5 (long espera, String nombre) {
		this.espera = espera;
		this.setName(nombre);
	}
	
	public void run() {
		String nombreHilo = this.getName();
		System.out.println("Soy el "+ nombreHilo +" empezando.");
		try {
			System.out.println("Soy el "+ nombreHilo + "y me voy a esperar "
					+ espera/1000 +" segundos");
			Thread.sleep(espera);
		} catch (InterruptedException e) {
			System.out.println(nombreHilo +" interrumpido");
			return;
		}
		System.out.println(nombreHilo +" acabando.");
	}
}

class Ejercicio5 {
	public static void main(String[] args) {
		System.out.println("Hilo PRINCIPAL empezando.");
		
		HiloEjercicio5 thread1 = new HiloEjercicio5(3000, "Hilo 1");
		HiloEjercicio5 thread2 = new HiloEjercicio5(7000, "hilo 2");
				
		thread1.start();
		thread2.start();

		System.out.println("Soy el hilo PRINCIPAL y voy a esperarme 4 segundos.");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Hilo PRINCIPAL interrumpido");
			return;
		}
		System.out.println("Hilo PRINCIPAL acabando.");
	}
}
