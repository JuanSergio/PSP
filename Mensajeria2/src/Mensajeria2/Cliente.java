package Mensajeria2;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;



public class Cliente {

	public static void main(String[] args) {
		Scanner tcl = new Scanner(System.in);
		boolean fin = false;
		int opcion;
		
		
		
		try {
			System.out.println("Creando socket cliente");
			Socket clientSocket = new Socket();
			
			System.out.println("Estableciendo la conexión");
			InetSocketAddress addr = new InetSocketAddress("192.168.26.12", 5555);
			
			clientSocket.connect(addr);
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			
			while (!fin){
			System.out.println("********************************");
			System.out.println("Elige una opción: ");
			System.out.println("1)Enviar un número");
			System.out.println("2)Leer lista");
			System.out.println("3)Salir");
			System.out.println("********************************");
			opcion = tcl.nextInt();
			
			
				switch (opcion) {
				case 1:

					System.out.println("Enviando teléfono Juanse...");
					String mensaje = "675904178";
					os.write(mensaje.getBytes());
					System.out.println("Mensaje enviado");

					break;

				/*
				 * case 2: System.out.println("Enviando teléfono Juanse...");
				 * String mensaje2 = "675904178"; os.write(mensaje2.getBytes());
				 * System.out.println("Mensaje enviado"); clientSocket.close();
				 * break;
				 */
				case 3:
					System.out.println("Cerrando socket...");
					clientSocket.close();
					System.out.println("Conexión finalizada");
					fin = true;

					break;

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
