package modelo;

public class Jinete implements Comparable<Jinete>{
	
	private String nombre;
	private int edad;
	private double peso;
	private double altura;
	private int numero;
	private int cantidadCarrerasGanadas;
	private int cantidadCarrerasPerdidas;
	private Jinete anterior;
	private Jinete siguiente;
	private Caballo primerCaballo;
	
	public Jinete(String nombre, int edad, double peso,int numero,int carrerasGanadas,int carrerasPerdidas,double altura) {
		this.nombre=nombre;
		this.edad=edad;
		this.peso=peso;
		this.altura=altura;
		this.numero=numero;
		this.cantidadCarrerasGanadas=carrerasGanadas;
		this.cantidadCarrerasPerdidas=carrerasPerdidas;
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
	
	
	
	
	
	
	
	
	

public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	//Este metdo inserta un caballo al jinere
//recibe como parametro un caballo
	public void insertarCaballo(Caballo nuevoCaballo) {
		
		if(primerCaballo==null) {
			primerCaballo=nuevoCaballo;
		}else {
			
			Caballo actual= primerCaballo;
			Boolean connect=false;
			while(actual!=null&&!connect) {
				
				if(actual.getSiguiente()==null) {
					actual.setSiguiente(nuevoCaballo);
					connect=true;
					actual=actual.getSiguiente();	
				}
				
				else{
				actual=actual.getSiguiente();
					
				}
				
				
				
				
			}
			
			
			
		}
		
	}
	
	
	public void mostrarCaballo() {
		if(primerCaballo==null) {
			System.out.println("No hay caballos");
		}else {
			Caballo actual=primerCaballo;
			while(actual!=null) {
				System.out.println("Caballo " + actual.getNumero());
				actual=actual.getSiguiente();
			}
			
		}
	}

	@Override
	public int compareTo(Jinete j1) {
		if(this.nombre.compareTo(j1.getNombre())>0) {
			return 1;
		}else if(this.nombre.compareTo(j1.getNombre())<0) {
			return -1;
		}else {
			return 0;
		}

	}
	
	

}
