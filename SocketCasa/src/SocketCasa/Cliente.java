package SocketCasa;

import java.io.DataOutputStream;
import java.io.IOException;

public class Cliente extends Conexion {

	public Cliente() throws IOException {
		super("cliente");
	
	}
	public void startClient(){
		try{
			salidaServidor = new DataOutputStream(clienteSocket.getOutputStream());
			
			//se envian dos mensajes
			for(int i =0; i<2;i++){
				salidaServidor.writeUTF("Este es el mensaje numero: "+(i+1)+"\n");
			}
			clienteSocket.close();
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
