package modelo;

import java.io.Serializable;

public class Apuesta implements Serializable{

	
	public final static int APUESTA_GANADOR=1;
	public final static int APUESTA_SEGUNDO=2;
	public final static int APUESTA_COLOCADO=3;
	
	private int tipoApuesta;
	private String IdApuesta;

	
	private Apuesta iz;
	private Apuesta der;

	public Apuesta(int tipoApuesta, double cantidadApostar,String IdApuesta,int numeroCaballo,int cuatoCaballo) {

		this.tipoApuesta = tipoApuesta;
		this.IdApuesta=IdApuesta;
		
	}

	public int getTipoApuesta() {
		return tipoApuesta;
	}

	public void setTipoApuesta(int tipoApuesta) {
		this.tipoApuesta = tipoApuesta;
	}





	public String getIdApuesta() {
		return IdApuesta;
	}

	public void setIdApuesta(String IdApuesta) {
		this.IdApuesta = IdApuesta;
	}

	public Apuesta getIz() {
		return iz;
	}

	public void setIz(Apuesta iz) {
		this.iz = iz;
	}

	public Apuesta getDer() {
		return der;
	}

	public void setDer(Apuesta der) {
		this.der = der;
	}
	
	
	
	
}
