package EjemploSocketHora;
	import java.io.IOException;
	import java.net.DatagramPacket;
	import java.net.DatagramSocket;
	import java.net.InetAddress;

public class ClienteHora {
	public static void main(String[] args) {
		try {
			System.out.println("Creando socket datagrama");

			DatagramSocket datagramSocket = new DatagramSocket();

			System.out.println("Enviando petición al servidor");

			String mensaje = new String("hora ");
			String mensaje2 = new String("fecha ");

			InetAddress serverAddr = InetAddress.getByName("localhost");
			DatagramPacket datagrama1 = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, serverAddr,
					5555);
			datagramSocket.send(datagrama1);
			DatagramPacket datagrama2 = new DatagramPacket(mensaje2.getBytes(), mensaje2.getBytes().length, serverAddr,
					5555);
			datagramSocket.send(datagrama2);

			System.out.println("Mensaje enviado");

			System.out.println("Recibiendo respuesta");

			byte[] respuesta = new byte[100];
			DatagramPacket datagrama3 = new DatagramPacket(respuesta, respuesta.length);
			datagramSocket.receive(datagrama3);

			System.out.println("Mensaje recibido: " + new String(respuesta));

			System.out.println("Cerrando el socket datagrama");

			datagramSocket.close();

			System.out.println("Terminado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
