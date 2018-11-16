package modelo;

import java.util.ArrayList;

public class SimuladorApuesta {
	
	public static final int MAX_USUARIOS=100;
	
	
	private Jinete primerJinete;
	private Usuario[] usuarios;
	private UsuarioVip raiz;
	private int cantidadUsuarios;
	private int cantidadUsuariosVip;
	
	
	
	public SimuladorApuesta() {
	this.usuarios= new Usuario[MAX_USUARIOS];
	}
	
	
	// METODOS BASADOS EN LA RUBRICA
	//PARA CADA METODO DE ORNDENAMIENTO SE DEBE UTILIZAR UN CRITERIO
	//DE COMPARACION DIFERENTE
	
	public void ordenarUsuariosSeleccion() {
		
	}
	
	public void ordenarUsuariosInserccion() {
		
	}
	
	public void ordenarUsuariosBurbuja() {
		
	}
	

	
	
//METODO PARA IMPLEMENTAR LA BUSQUEDA BINARIA

	public Usuario buscarUsuarioId() {
		return null;
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
	
	public void insertarJinete() {
		
	}
	
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
	


}
