package SocketCasa;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
	private final int puerto = 1234;
	private final String host = "localhost";
	protected String mensajeServidor;//mensajes entrantes leidos en el server
	protected ServerSocket serverSocket;
	protected Socket clienteSocket;
	protected DataOutputStream salidaServidor, salidaCliente;//salida datos
	
	public Conexion (String tipo)throws IOException{
		if(tipo.equalsIgnoreCase("servidor")){
			serverSocket = new ServerSocket(puerto);
			clienteSocket = new Socket();
			
		}else{
			clienteSocket = new Socket(host, puerto);
		}
	}

}
