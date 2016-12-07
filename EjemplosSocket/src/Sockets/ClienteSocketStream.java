
package Sockets;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;


public class ClienteSocketStream {
	public static void main(String[] args) {
		try {
			System.out.println("Creando socket cliente");
			Socket clientSocket = new Socket();
			System.out.println("Estableciendo la conexión");
			//modificacion para conectar al server de Jonatan
			String ip = "192.168.181";
			InetSocketAddress addr = new InetSocketAddress(InetAddress.getByName(ip), 3555);
			
			clientSocket.connect(addr);
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			System.out.println("Enviando mensaje");
			String mensaje = "mensaje desde el cliente";
			os.write(mensaje.getBytes());
			System.out.println("Mensaje enviado");
			System.out.println("Cerrando el socket cliente");
			clientSocket.close();
			System.out.println("Terminado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
	