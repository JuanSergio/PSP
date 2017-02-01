import java.io.Serializable;

public class Mensaje implements Serializable{
	
	private Integer codigo;
	private String mensaje;
	private String usuario; 
	
	public Mensaje(){
		this.codigo=null;
		this.mensaje= null;
		this.usuario=null;
	}
	
	public Integer getId() {
		return codigo;
	}

	public void setId(Integer id) {
		this.codigo = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	

}
