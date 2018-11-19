package modelo;

import java.util.ArrayList;

import javax.print.attribute.standard.PrinterMoreInfo;

import com.sun.javafx.scene.traversal.TopMostTraversalEngine;

public class SimuladorApuesta {
	
	public static final int MAX_USUARIOS=100;
	
	
	private Jinete primerJinete;
	private Usuario[] usuarios;
	private UsuarioVip raiz;
	private int cantidadUsuarios;
	private int cantidadUsuariosVip;
	
	
	
	public SimuladorApuesta() {
	this.usuarios= new Usuario[MAX_USUARIOS];
	cantidadUsuarios=0;

	}
	
	
	// METODOS BASADOS EN LA RUBRICA
	//PARA CADA METODO DE ORNDENAMIENTO SE DEBE UTILIZAR UN CRITERIO
	//DE COMPARACION DIFERENTE
	
	public Jinete getPrimerJinete() {
		return primerJinete;
	}


	public void setPrimerJinete(Jinete primerJinete) {
		this.primerJinete = primerJinete;
	}


	public Usuario[] getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}


	public UsuarioVip getRaiz() {
		return raiz;
	}


	public void setRaiz(UsuarioVip raiz) {
		this.raiz = raiz;
	}


	public int getCantidadUsuarios() {
		return cantidadUsuarios;
	}


	public void setCantidadUsuarios(int cantidadUsuarios) {
		this.cantidadUsuarios = cantidadUsuarios;
	}


	public int getCantidadUsuariosVip() {
		return cantidadUsuariosVip;
	}


	public void setCantidadUsuariosVip(int cantidadUsuariosVip) {
		this.cantidadUsuariosVip = cantidadUsuariosVip;
	}


	
	
	///Este metodo ordena los usuario en base al orden parcial que
	//hace referncia al nombre
	public Usuario[] ordenarUsuariosSeleccion() {
		Usuario[] usuariosSeleccion=usuarios.clone();
		
		for (int i = 0; i < usuariosSeleccion.length; i++) {
//		Usuario menor=usuariosSeleccion[]
			
			
		}
		
		
		
		
		
		
		
		return usuariosSeleccion;
	}
	
	public void ordenarUsuariosInserccion() {
		
	}
	
	public void ordenarUsuariosBurbuja() {
		
	}
	

	
	
//METODO PARA IMPLEMENTAR LA BUSQUEDA BINARIA

	public Usuario buscarUsuarioId(String cedula) {
		boolean encontro=false;
		Usuario usuarioEncontrado=null;
		for(int i=0;i<usuarios.length&&!encontro;i++) {
			if(usuarios[i]!=null) {
				if(usuarios[i].getCedula().compareTo(cedula)==0) {
					usuarioEncontrado=usuarios[i];
					encontro=true;
					}
			}
			
		}
		
		return usuarioEncontrado;
	}
	
	public Usuario buscarUsuarioNombre() {
		return null;
	}
	
	
	
	
	
	
	
	// IMPLEMENTAR CUATRO METODOS RECURSIVOS
	
	//posibles metodos a implementar recursivamente
	//1: insertarUsuarioVip.
	//2:buscarCaballoVip.
	//3:eliminarUsuarioVip.
	//4:buscarUsuarioVip.
	
	
	
	
	// metodo insertar, recibe por parametro todos los atributos 
	//del obejto usuario y creo un nuevo usuario
	//llama al meotod insertarUusario . metodo recursivo que agrega un nuevo usuario
//	public void insertar(String nombre,String apellido,String cedula,int edad, int genero,double dinero,String claveUsuario,String correoElectronico) {
//		UsuarioVip nuevoUsuario= new UsuarioVip(nombre,apellido,cedula,edad,genero,dinero,claveUsuario,correoElectronico);
//		insertarUsuario(nuevoUsuario,raiz);
//	}
//	public void insertarUsuario(Usuario nuevoUsuario, Usuario raiz) {
//		
//		if(this.raiz==null) {
//			this.raiz=nuevoUsuario;
//		}
//		
//		else {
//			
//			if(raiz.compareTo(nuevoUsuario)>0) {
//				if(raiz.getIzquierdo()==null) {
//					raiz.setIzquierdo(nuevoUsuario);
//				}else {
//					insertarUsuario(nuevoUsuario, raiz.getIzquierdo());
//				}
//				
//				
//			}else {
//				
//				if(raiz.getDerecho()==null) {
//					raiz.setDerecho(nuevoUsuario);
//				}else {
//					insertarUsuario(nuevoUsuario, raiz.getDerecho());
//				}
//				
//				
//			}
//			
//			
//		}
//		
//		
//	}
	

	
	//Metodo retorna la  cantidad de usuarios que hay en el sistema
	//este metodo llama al metodo recursivo cantidadUsuarios que recibe un usaurio
//	public int cantidadUsuarios() {
//		 this.cantidadUsuarios=0;
//		cantidadUsuarios(this.raiz);
//		return cantidadUsuarios;
//	}
	/// metodo recursivo que cuenta la cantidad de usuarios en el sistema
//	public void cantidadUsuarios(Usuario raiz) {
//		if(raiz!=null) {
//			cantidadUsuarios++;
//			cantidadUsuarios(raiz.getDerecho());
//			cantidadUsuarios(raiz.getIzquierdo());
//		}
//	}
//	
	//metodo para implementar la el metodo de busqueda bianria propia
	//para buscar un usuario
	public String buscarUsuarioBinario(String nombre,Usuario raiz) {
//		boolean encontro=false;
//		int inicio=0;
//		int fin=cantidadUsuarios-1;
//		
//		
//		if(inicio<=fin&&!encontro) {
//			
//		}
		return "";
	}
	
	
	
	//Este metodo busca un usuario  de forma recursiva
	// este metodo recibe un string cedula y un usuario 
//	public Usuario buscarUsuario(String cedula, Usuario raiz) {
//		Usuario usuarioEncontrado=null;
//		if(raiz==null) {
//			System.out.println("No existe el elemento buscado");
//		}else{
//			
//			if(raiz.getCedula().compareTo(cedula)==0) {
//				return usuarioEncontrado=raiz;
//			}
//			else {
//				
//				if( cedula.compareTo(raiz.getCedula())>0) {
//					return buscarUsuario(cedula,raiz.getDerecho());
//				}else {
//					 return buscarUsuario(cedula,raiz.getIzquierdo());
//				}
//				
//				
//			}
//			
//			
//			
//			
//		}
//		return usuarioEncontrado;
//	} 
//	
	
	
	
	//Este metod inserta un jinete de forma recursiva
	
	
	
	public void insertarJinete(Jinete nuevoJinete) {
		insertarJinete(nuevoJinete,this.primerJinete);
	}
	
	
	
	public void insertarJinete(Jinete nuevoJinete,Jinete primerJinete) {
		if(this.primerJinete==null) {
			this.primerJinete=nuevoJinete;
			cantidadUsuarios++;
		}
		
		else {
			Jinete actual=primerJinete;
			if(nuevoJinete.getEdad()>actual.getEdad()) {
				if(actual.getSiguiente()==null) {
					actual.setSiguiente(nuevoJinete);
					nuevoJinete.setAnterior(actual);
					cantidadUsuarios++;
				}else {
					insertarJinete(nuevoJinete,actual.getSiguiente());
				}
				
			}
			
			
			else {
				
				if(actual.getAnterior()==null) {
					actual.setAnterior(nuevoJinete);
					nuevoJinete.setSiguiente(actual);
					this.primerJinete=nuevoJinete;
					cantidadUsuarios++;
				}
				
				else if(actual.getAnterior()!=null && actual.getSiguiente()!=null) {
					nuevoJinete.setSiguiente(actual);
					nuevoJinete.setAnterior(actual.getAnterior());
					actual.getAnterior().setSiguiente(nuevoJinete);
					actual.setAnterior(nuevoJinete);
					cantidadUsuarios++;
				}
				
				else if(actual.getAnterior()!=null&&actual.getSiguiente()==null) {
					nuevoJinete.setSiguiente(actual);
					nuevoJinete.setAnterior(actual.getAnterior());
					actual.getAnterior().setSiguiente(nuevoJinete);
					actual.setAnterior(nuevoJinete);
					cantidadUsuarios++;
				}
				
			}
			
			
		}
	}
	
	
	//Este metod inserta un  caballo a un jinete
	public void insertarCaballoAJinete(Jinete jinete,Caballo caballo) {
		jinete.insertarCaballo(caballo);
	}
	
	
	
	
	
	//Este metodo busca jinete dado un numero el cual lo identifica en la carrera
	//este metodo llama a un metodo recursivo y le pasa pro parametro el primero de la lista mas el numero
	public Jinete buscarJinete(int numero) {
		return buscarJinete(numero,this.primerJinete);
	}
	
	
	public Jinete buscarJinete(int numero, Jinete primerJinete) {
		Jinete buscado=null;
		if(primerJinete!=null) {
			if(primerJinete.getNumero()==numero) {
				buscado=primerJinete;
			return buscado;
			}else {
				return buscarJinete(numero, primerJinete.getSiguiente());
			}
		}
		
		
	return buscado;

		
	}

	

	
//	public Caballo buscarCaballo(int numero) {
//		
//		
//		
//	}
	
	public void imprimirCaballos() {
		
		if(primerJinete==null) {
			System.out.println("No hay jinetes");
		}else {
			
			Jinete actual=primerJinete;
			while(actual!=null) {
				if(actual.getPrimerCaballo()==null) {
					System.out.println("No tiene caballos");
				}else {
					
					Caballo actualcaballo= actual.getPrimerCaballo();
					while(actualcaballo!=null) {
						System.out.println("Numero del caballo" + actualcaballo.getNumero());
						actualcaballo=actualcaballo.getSiguiente();
					}

				}
				
				actual=actual.getSiguiente();
				
				
			}
			
			
		}
		
		
	}
	
	
	
	
	
//	public void insertarJinete(Jinete nuevoJinete) {
//		insertarJinete(nuevoJinete,primerJinete);
//	}
//	
//	public void insertarJinete(Jinete nuevoJinete,Jinete primerJinete) {
//		
//		if(this.primerJinete==null) {
//			this.primerJinete=nuevoJinete;
//		}else if(this.primerJinete.compareTo(nuevoJinete)>0){
//			nuevoJinete.setSiguiente(primerJinete);
//			this.primerJinete=nuevoJinete;
//		}else {
//			
//			Jinete actual=primerJinete;
//			if(actual.compareTo(nuevoJinete)<0) {
//				if(actual.getSiguiente()==null) {
//					actual.setSiguiente(nuevoJinete);
//				}
//			}else if(actual.getSiguiente().compareTo(nuevoJinete)>0) {
//				nuevoJinete.setSiguiente(actual.getSiguiente());
//				actual.setSiguiente(nuevoJinete);
//			}else {
//				actual=actual.getSiguiente();
//				insertarJinete(nuevoJinete,actual);
//			}
//			
//		}
//	}
	
	
	
	//Este metodo inserta un caballo a un jinete
	public void insertarCaballo() {
		
	}
//	public String buscarJugador(ArrayList<Jugador> jugadores,String nombre) {
//		String nombreJugador="No se econtro el jugador";
//		Jugador jugadorsitos[]= new Jugador[jugadores.size()];
//		for(int i=0;i<jugadores.size();i++) {
//			jugadorsitos[i]=jugadores.get(i);
//			
//		}
//		
//		boolean encontro=false;
//		int inicio=0;
//		int fin=jugadorsitos.length-1;
////		ComparadorNombre comNom= new ComparadorNombre();
//		while(inicio<=fin&&!encontro) {
//			int medio=(inicio+fin)/2;
//			if(jugadorsitos[medio].darNombre().equalsIgnoreCase(nombre)) {
//				encontro=true;
//				nombreJugador=jugadorsitos[medio].darNombre()+"  "+"Puntaje : " + jugadorsitos[medio].darPuntaje();
//			}else if(jugadorsitos[medio].darNombre().compareTo(nombre)>0) {
//				fin=medio-1;
//			}else {
//				inicio=medio+1;
//			}
//			
//		}
//		return nombreJugador;
//	}
	
	
	
	public void mostrarJinetes() {
		if(this.primerJinete==null) {
			System.out.println("No existe ningun jinete");
		}else {
			
			Jinete actual=primerJinete;
			
			while(actual!=null) {
				System.out.println(actual.getNombre() + " numero: " + actual.getNumero());
				actual=actual.getSiguiente();
			}
			
			
		}
		
		
	}


}
