package modelo;

import java.io.Serializable;

public class Apuesta implements Serializable{

	
	public final static int APUESTA_GANADOR=1;
	public final static int APUESTA_SEGUNDO=2;
	public final static int APUESTA_COLOCADO=3;
	
	private int tipoApuesta;
	


	private String numeroApuesta;
	
	private Apuesta iz;
	private Apuesta der;

	public Apuesta(int tipoApuesta, double cantidadApostar,String numeroApuesta) {

		this.tipoApuesta = tipoApuesta;
		this.numeroApuesta=numeroApuesta;
	}

	public int getTipoApuesta() {
		return tipoApuesta;
	}

	public void setTipoApuesta(int tipoApuesta) {
		this.tipoApuesta = tipoApuesta;
	}





	public String getNumeroApuesta() {
		return numeroApuesta;
	}

	public void setNumeroApuesta(String numeroApuesta) {
		this.numeroApuesta = numeroApuesta;
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
