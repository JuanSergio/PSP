import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
public static void main (String args []){
		
		try {
			
			System.out.println("Creando socket servidor");
			ServerSocket serverSocket = new ServerSocket();
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			serverSocket.bind(addr);
			
			System.out.println("Aceptando conexiones");
			Socket newSocket = serverSocket.accept();
			System.out.println("Conexión recibida");
			
			
			System.out.println("Cerrando el nuevo socket");
			newSocket.close();
			
			System.out.println("Cerrando el socket servidor");
			serverSocket.close();
			
			System.out.println("Terminado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

class HiloServer extends Thread{
	
	
}

}