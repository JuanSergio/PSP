package SocketCasa;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Servidor extends Conexion{

	public Servidor() throws IOException {
		super("servidor");//constructor del servidor

	}
	public void startServer(){
		try{
			System.out.println("Esperando...");//espera conexion
			clienteSocket = serverSocket.accept();//Acepta la conexion
			System.out.println("Cliente en linea");
			
			//Flujo de salida del cliente para mensajes
			salidaCliente = new DataOutputStream(clienteSocket.getOutputStream());
			
			//Se envia un mensaje al cliente con el flujo de salida
			salidaCliente.writeUTF("Peticion recibida y aceptada");
			
			//Flujo entrante desde cliente
			BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
			
			//Mientras haya mensajes desde el cliente
			while((mensajeServidor = entrada.readLine())!=null){
				//Muestra mensaje recibido
				System.out.println(mensajeServidor);
				
			}
			System.out.println("Fin de la conexión");
			
			serverSocket.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
