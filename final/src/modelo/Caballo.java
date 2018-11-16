package modelo;

public class Caballo {

	private String nombre;
	
	private int numero;
	
	private int edad;
	
	private double peso;
	
	private int carrerasGanadas;
	private int carrerasPerdidas;
	
	private int genero;
	
	private double altura;
	
	private double velocidadMaxima;
	private Caballo siguiente;

	
	public Caballo(String nombre, int numero, int edad, double peso, int carrerasGanadas,int carrerasPerdidas, int genero, double altura,
			double velocidadMaxima) {
		
		this.nombre = nombre;
		this.numero = numero;
		this.edad = edad;
		this.peso = peso;
		this.carrerasGanadas = carrerasGanadas;
		this.carrerasPerdidas=carrerasPerdidas;
		this.genero = genero;
		this.altura = altura;
		this.velocidadMaxima = velocidadMaxima;
	}
	
	
	public Caballo getSiguiente() {
		return siguiente;
	}


	public void setSiguiente(Caballo siguiente) {
		this.siguiente = siguiente;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getCarrerasGanadas() {
		return carrerasGanadas;
	}

	public void setCarrerasGanadas(int carrerasGanadas) {
		this.carrerasGanadas = carrerasGanadas;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getVelocidadMaxima() {
		return velocidadMaxima;
	}

	public void setVelocidadMaxima(double velocidadMaxima) {
		this.velocidadMaxima = velocidadMaxima;
	}


	

	
	
	
	
}
