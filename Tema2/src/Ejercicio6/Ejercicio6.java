package Ejercicio6;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Ejercicio6 {
	private static String mensaje;
	
	public static void main(String[] ars) throws IOException {
		
		HiloServer  server = new HiloServer();
		HiloCliente cliente = new HiloCliente();
		server.start();
		cliente.start();

	}
}
class HiloServer extends Thread{

	public void run() {
		try {
			System.out.println("Server iniciado...");
			ServerSocket serverSocket = new ServerSocket();
			InetSocketAddress addr = new InetSocketAddress("192.168.26.181", 60000);
			serverSocket.bind(addr);
			//System.out.println("Estableciendo conexión");
			Socket nuevoSocket = serverSocket.accept();
			System.out.println("Cliente conectado");
			
			while(true){
				
			}

		}catch(IOException e){
			e.printStackTrace();

		}
	}


}

class HiloCliente extends Thread{

	public void run() {
		
		Socket clienteSocket = new Socket();

		do{
			try {

				clienteSocket = new Socket("192.168.26.186", 60000);
				

			}catch (IOException e) {
				System.out.println("error, no hay conexión");
				try{
					Thread.sleep(3000);
					//marcar un catch que haga excepcion de interrupcion
				}catch (InterruptedException e2){
					e2.printStackTrace();
					
					
				}
			}
		}while(!clienteSocket.isConnected());
		System.out.println("Conectado al servidor");
		while(true){
			
		}
	}

}




