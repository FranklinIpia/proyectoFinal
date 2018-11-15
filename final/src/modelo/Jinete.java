package modelo;

public class Jinete {
	
	private int numero;
	private int cantidadCarrerasGanadas;
	private int cantidadCarrerasPerdidas;
	
	
	private Jinete anterior;
	private Jinete siguiente;
	private Caballo primerCaballo;
	
	public Jinete() {
		
	}
	
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCantidadCarrerasGanadas() {
		return cantidadCarrerasGanadas;
	}

	public void setCantidadCarrerasGanadas(int cantidadCarrerasGanadas) {
		this.cantidadCarrerasGanadas = cantidadCarrerasGanadas;
	}

	public int getCantidadCarrerasPerdidas() {
		return cantidadCarrerasPerdidas;
	}

	public void setCantidadCarrerasPerdidas(int cantidadCarrerasPerdidas) {
		this.cantidadCarrerasPerdidas = cantidadCarrerasPerdidas;
	}

	public Jinete getAnterior() {
		return anterior;
	}

	public void setAnterior(Jinete anterior) {
		this.anterior = anterior;
	}

	public Jinete getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Jinete siguiente) {
		this.siguiente = siguiente;
	}

	public Caballo getPrimerCaballo() {
		return primerCaballo;
	}

	public void setPrimerCaballo(Caballo primerCaballo) {
		this.primerCaballo = primerCaballo;
	}

	

}
