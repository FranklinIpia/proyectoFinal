package modelo;

public class Apuesta {

	
	private int tipoApuesta;
	
	private double cantidadApostar;
	
	private double potencialGanancia;
	
	private int numeroApuestasGanadas;
	
	private int numeroApuestasPerdidas;

	public Apuesta(int tipoApuesta, double cantidadApostar, double potencialGanancia, int numeroApuestasGanadas,
			int numeroApuestasPerdidas) {

		this.tipoApuesta = tipoApuesta;
		this.cantidadApostar = cantidadApostar;
		this.potencialGanancia = potencialGanancia;
		this.numeroApuestasGanadas = numeroApuestasGanadas;
		this.numeroApuestasPerdidas = numeroApuestasPerdidas;
	}

	public int getTipoApuesta() {
		return tipoApuesta;
	}

	public void setTipoApuesta(int tipoApuesta) {
		this.tipoApuesta = tipoApuesta;
	}

	public double getCantidadApostar() {
		return cantidadApostar;
	}

	public void setCantidadApostar(double cantidadApostar) {
		this.cantidadApostar = cantidadApostar;
	}

	public double getPotencialGanancia() {
		return potencialGanancia;
	}

	public void setPotencialGanancia(double potencialGanancia) {
		this.potencialGanancia = potencialGanancia;
	}

	public int getNumeroApuestasGanadas() {
		return numeroApuestasGanadas;
	}

	public void setNumeroApuestasGanadas(int numeroApuestasGanadas) {
		this.numeroApuestasGanadas = numeroApuestasGanadas;
	}

	public int getNumeroApuestasPerdidas() {
		return numeroApuestasPerdidas;
	}

	public void setNumeroApuestasPerdidas(int numeroApuestasPerdidas) {
		this.numeroApuestasPerdidas = numeroApuestasPerdidas;
	}
	
	
	
	
	
	
	
	
}
