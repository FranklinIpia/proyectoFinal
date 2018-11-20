package modelo;

import javafx.scene.image.ImageView;

public class Caballo {
	
	public final static int HEMBRA=1;
	public final static int MACHO=2;

	private String nombre;
	private ImageView imagen;
	private int numero;
	
	private int edad;
	
	private double peso;
	
	private int carrerasGanadas;
	private int carrerasPerdidas;
	
	private int genero;
	
	private double altura;
	
	private double velocidadMaxima;
	private Caballo siguiente;

	private int posX;
	private int posY;
	
	
	public Caballo(ImageView imagen,String nombre, int numero, int edad, double peso, int carrerasGanadas,int carrerasPerdidas, int genero, double altura,
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
		this.imagen=imagen;
		this.posX=0;
		this.posY=0;
	}
	
	
	public ImageView getImagen() {
		return imagen;
	}


	public void setImagen(ImageView imagen) {
		this.imagen = imagen;
	}


	public Caballo getSiguiente() {
		return siguiente;
	}


	public void setSiguiente(Caballo siguiente) {
		this.siguiente = siguiente;
	}


	
	
	
	
	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
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


	public int getCarrerasPerdidas() {
		return carrerasPerdidas;
	}


	public void setCarrerasPerdidas(int carrerasPerdidas) {
		this.carrerasPerdidas = carrerasPerdidas;
	}


	public void moverCaballo() {
		int comienzo=27;
//		SecureRandom random = new SecureRandom();
//		int nuevaPosX=27;
	do {
		
	int valorEntero1 = (int) Math.floor(Math.random()*(1-30+1)+30);

//		comienzo=comienzo+ random.nextInt(this.velocidad);
		
	comienzo=valorEntero1;
		this.posX=comienzo;
		this.imagen.setX(posX);
		try {
			
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}while(this.posX<665);
		
		
		
		
	}

	
	
	
	
}
