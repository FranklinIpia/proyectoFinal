package modelo;



import java.util.ArrayList;

import Comparador.ComparadorApuesta;
import Comparador.ComparadorEdad;
import Comparador.ComparadorNombre;
import Excepciones.ExcepcionElUsuarioYaEstaRegistrado;
import interfazes2.FixedCaballo;


public  class SimuladorApuesta implements FixedCaballo  {
	
	public static final int MAX_USUARIOS=20;
	
	
	private Jinete primerJinete;
	private UsuarioVip usuarioVipRaiz;
	private Usuario[] usuarios;

	private int cantidadUsuarios;
	private int cantidadUsuariosVip;
	private int totalUsuariosVip;
	
	
	
	public SimuladorApuesta() {
	this.usuarios= new Usuario[MAX_USUARIOS];
	cantidadUsuarios=0;
	

	}
	
	
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


	
	public UsuarioVip getUsuarioVipRaiz() {
		return usuarioVipRaiz;
	}


	public void setUsuarioVipRaiz(UsuarioVip usuarioVipRaiz) {
		this.usuarioVipRaiz = usuarioVipRaiz;
	}
	
	
	
	
	


	public int getTotalUsuariosVip() {
		return totalUsuariosVip;
	}


	public void setTotalUsuariosVip(int totalUsuariosVip) {
		this.totalUsuariosVip = totalUsuariosVip;
	}
	
	
	
	
	
	
	
///////////////////////////////////////////////////////////////////////////////
	///////////// METODOS DE ORDENAMIENTO//////////////////////////////////////
	
	
	
	public void imprimirUsuarios() {
		System.out.println("Entro aca pero no");
		for (int i = 0; i < usuarios.length; i++) {
			if(usuarios[i]!=null) {
				System.out.println("Nombre usuariios" +usuarios[i].getNombre() +"\n");
			}
		}
	}



	///Este metodo ordena los usuario en base al orden parcial que
	//hace referncia al nombre
	public Usuario[] ordenarUsuariosSeleccion() {
		Usuario[] usuariosSeleccion=usuarios.clone();
		
		for (int i = 0; i < usuariosSeleccion.length-1; i++) {
		Usuario menor=usuariosSeleccion[i];
		int pos=i;
		
		for (int j = i+1; j < usuariosSeleccion.length; j++) {
			ComparadorNombre conM=new ComparadorNombre();

			if(conM.compare(usuariosSeleccion[j],menor)<0) {
				menor=usuariosSeleccion[j];
				pos=j;
			}
		}
		
		Usuario temp= usuariosSeleccion[i];
		usuariosSeleccion[i]=menor;
		usuariosSeleccion[pos]=temp;
			
		}
		return usuariosSeleccion;
	}
	
	
	
	//Este metodo ordena los usarios en base a un orden parcial el cual 
	// es la edad
	public Usuario[] ordenarUsuariosInserccion() {
		Usuario[] usaruisInserccion=usuarios.clone();
		for (int i = 1; i < usaruisInserccion.length; i++) {
			ComparadorEdad comEdad= new ComparadorEdad();
			for (int j = i; j >0&&  comEdad.compare(usaruisInserccion[j-1],usaruisInserccion[j])>0; j--) {
				
				Usuario temp= usaruisInserccion[j];
				usaruisInserccion[j]=usaruisInserccion[j-1];
				usaruisInserccion[j-1]=temp;
			}
			
		}
		
		return usaruisInserccion;
		
	}
	
	
	
	//Este metodo ordena los usuarios en base a un orden parcial
	//el cual es la apuesta
	public Usuario[] ordenarUsuariosBurbuja() {

	Usuario[] usaruosBurbuja=usuarios.clone();
	
	for (int i =  usaruosBurbuja.length; i>0;i--) {
		for (int j = 0; j < i-1; j++) {
			ComparadorApuesta comApuesta= new ComparadorApuesta();
			if (comApuesta.compare(usaruosBurbuja[j], usaruosBurbuja[j+1])>0) {
				Usuario temp=usaruosBurbuja[j];
				usaruosBurbuja[j]=usaruosBurbuja[j+1];
				usaruosBurbuja[j+1]=temp;
			}
			
			
		}
	}
		
		
		return usaruosBurbuja;
	}
	

	
	
	
///////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	
	
	
////////////////////////////////////////////////////////////////////////////////
////////////////////////////IMPLEMENTACION BUSQUEDA BINARIIA//////////////////	
	
	
	
//METODO PARA IMPLEMENTAR LA BUSQUEDA BINARIA

	public Usuario buscarUsuarioId(String cedula) {
		boolean encontro=false;
		Usuario usuarioEncontrado=null;
		int inicio=0;
		int fin=usuarios.length-1;
		while(inicio<=fin&&!encontro) {
			int medio=(inicio+fin)/2;
			
			
			
				if(usuarios[medio].getCedula().compareTo(cedula)==0) {
					usuarioEncontrado=usuarios[medio];
					encontro=true;
			
			
			}else if(usuarios[medio].getCedula().compareTo(cedula)>0) {
				fin=medio-1;
			}else{
				inicio=medio+1;
			}
		}
		
		return usuarioEncontrado;
	}
	
	public Usuario buscarUsuarioNombre(String nombre) {
	
		
		boolean encontro=false;
		int inicio=0;
		int fin=usuarios.length-1;
		Usuario usuarioEncontrado=null;
		
		
		while(inicio<=fin&&!encontro) {
			int medio=(inicio+fin)/2;
			if(usuarios[medio].getNombre().compareTo(nombre)==0) {
				usuarioEncontrado=usuarios[medio];
				encontro=true;
			}else if(usuarios[medio].getNombre().compareTo(nombre)>0) {
				fin=medio -1;
			}else {
				inicio=medio +1;
			}
			
			
		}
		
		return usuarioEncontrado;
	}
	
	
	public Usuario buscarUsuariofor(String cedula) {
		
		Usuario usuarioEn=null;
		boolean encontro=false;
		for(int i=0;i<usuarios.length&&!encontro;i++) {
			if(usuarios[i]!=null) {
				if(usuarios[i].getCedula().compareTo(cedula)==0) {
					encontro=true;
					usuarioEn=usuarios[i];
				}
			}
		}
		return usuarioEn;
	}
	
	
	
////////////////////////////////////////////////////////////////////////////////
	/////////////////Implementacion metodos recursivos/////////////////////////
	
	
	
	
	
	
	public void insertarUsuarioVip(String nombre, String apellido, String cedula,String contraseña, int edad, int genero, double dinero, String claveUsuario,
			String correoElectronico,int apuestasGanadas,Apuesta apuestaUsuario,int tarjetaVip) throws ExcepcionElUsuarioYaEstaRegistrado {
			
		UsuarioVip nuevoVip= new UsuarioVip(nombre, apellido, cedula, contraseña, edad, genero, dinero, claveUsuario, correoElectronico, apuestasGanadas, apuestaUsuario, tarjetaVip);
		if(this.usuarioVipRaiz==null) {
			this.usuarioVipRaiz=nuevoVip;
			this.cantidadUsuariosVip+=1;
		}else {
			usuarioVipRaiz.insertar(nuevoVip);
			this.cantidadUsuarios+=1;
		}
		
	}
	
	
	
	 private void imprimirEntre (UsuarioVip reco)
	    {
	        if (reco != null)
	        {    
	            imprimirEntre (reco.getIzquierdo());
	            System.out.print(reco.getNombre()+ " ");
	            imprimirEntre (reco.getDerecho());
	        }else {
	        	System.out.println("No hay usuarios VIP");
	        }
	    }

	    public void imprimirEntre ()
	    {
	        imprimirEntre (this.usuarioVipRaiz);
	        System.out.println();
	    }
	
	
	
	
	public void eliminarUsuarioVip(String nombre) {
		usuarioVipRaiz=usuarioVipRaiz.eliminar(nombre);
		this.cantidadUsuariosVip--;
		
	}
	
	public UsuarioVip buscarUsarioVip(int tarjetaApuesta) {
		if(usuarioVipRaiz==null) {
			return null;
		}else {
			return usuarioVipRaiz.buscarUsuarioVip(tarjetaApuesta);
		}
		
	}
	
	


	
	
	
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
	
	public Caballo buscarCaballo(int numero) {
		Jinete actual=primerJinete;
		
		while(actual!=null) {
			Caballo actualCab= actual.getPrimerCaballo();
			
			while(actualCab!=null) {
				if(numero==actualCab.getNumero()) {
					return actualCab;
				}else {
					actualCab=actualCab.getSiguiente();
				}
			}
			actual=actual.getSiguiente();
			
		}
		return null;
	}
	
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


	@Override
	public double fixedGanador() {
		double ganador=0;
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
						double velocidad = actualcaballo.getVelocidadMaxima();
						int carrerasGanadas=actual.getCantidadCarrerasGanadas();
						ganador = velocidad/carrerasGanadas;
					}

				}
				
				actual=actual.getSiguiente();
				
				
			}
			
			
		}
		
		return ganador;
		
		
	}


	@Override
	public double fixedSegundo() {
		double segundo=0;
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
						double velocidad = actualcaballo.getVelocidadMaxima();
						int carrerasPerdidas=actual.getCantidadCarrerasPerdidas();
						segundo = velocidad/carrerasPerdidas;
					}

				}
				
				actual=actual.getSiguiente();
				
				
			}
			
			
		}
		
		return segundo;
	}


	@Override
	public double fixedColocado() {
		
		double colocado=0;
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
						double totalA = fixedGanador()+fixedSegundo();
						double carrerastotales=actual.getCantidadCarrerasPerdidas()+actual.getCantidadCarrerasGanadas();
						colocado = totalA/carrerastotales;
					}

				}
				
				actual=actual.getSiguiente();
				
				
			}
			
			
		}
		
		return colocado;
	}


	@Override
	public double prueba(int pCaba) {
		Caballo bo = buscarCaballo(pCaba);
		double ganador=0;
		
		double velocidad=bo.getVelocidadMaxima();
		double carreras=bo.getCarrerasGanadas();
		
		ganador= velocidad/carreras;
		return ganador+1;
		
	
		
	}


	


}
