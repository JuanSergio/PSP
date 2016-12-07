package sockets;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class ServidorSocketStream {
	public static void main(String[] args) {
		try {
			
			System.out.println("Creando socket servidor");
			ServerSocket serverSocket = new ServerSocket();

			System.out.println("Realizando el bind");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			serverSocket.bind(addr);
			//Se aceptará al hilo y se crea un contador como maximo 5 hilos, 5 conexiones
			System.out.println("Aceptando conexiones");
			int i = 0;
			while (i < 5) {
				Socket newSocket = serverSocket.accept();
				i++;
				hilo1 hilos = new hilo1(newSocket);
				hilos.start();
				
				
			}
			//fuera del bucle while se cierra el server
			System.out.println("Ye! aquí ha pasado algo");
			serverSocket.close();

			System.out.println("Terminado);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
//Se crea el socket que seran hilos
class hilo1 extends Thread {
	private Socket socket;

	public hilo1(Socket socket) {
		this.socket = socket;
	}
//la clase run sera el contenido del hilo
	public void run() {
		try {

			System.out.println("Conexión recibida");
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			byte[] mensaje = new byte[25];
			is.read(mensaje);

			System.out.println("Mensaje recibido:" + new String(mensaje));
			System.out.println("Cerrando el nuevo socket");
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
