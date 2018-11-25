package modelo;

import java.io.Serializable;

import Excepciones.ExcepcionElUsuarioYaEstaRegistrado;



public class UsuarioVip   extends Usuario  implements Serializable{

	private int tarjetaVip;
	private UsuarioVip derecho;
	private UsuarioVip izquierdo;
	private Apuesta raizApuestaVip;
public UsuarioVip(String nombre, String apellido, String cedula,String contraseña, int edad, int genero, double dinero, String claveUsuario,
		String correoElectronico,int apuestasGanadas,Apuesta apuestaUsuario,int tarjetaVip) {
	super(nombre,apellido,cedula,contraseña,edad,genero,dinero,correoElectronico,apuestasGanadas,apuestaUsuario);
	this.tarjetaVip=tarjetaVip;
}

public int getTarjetaVip() {
	return tarjetaVip;
}

public void setTarjetaVip(int tarjetaVip) {
	this.tarjetaVip = tarjetaVip;
}

public UsuarioVip getDerecho() {
	return derecho;
}

public void setDerecho(UsuarioVip derecho) {
	this.derecho = derecho;
}

public UsuarioVip getIzquierdo() {
	return izquierdo;
}

public void setIzquierdo(UsuarioVip izquierdo) {
	this.izquierdo = izquierdo;
}

/**
 * Indica si este nodo es una hoja
 * @return true si este nodo es una hoja y false en caso contrario
 */
public boolean esHoja( )
{
    return derecho == null && izquierdo == null;
}


/**
 * Retorna el contacto que alfabéticamente corresponde al menor contacto del árbol que parte de este nodo
 * @return contacto con menor nombre
 */
public UsuarioVip darMenor( )
{
    return ( derecho == null ) ? this : izquierdo.darMenor( );
}

public int darPeso( )
{
    int p1 = ( izquierdo== null ) ? 0 : izquierdo.darPeso( );
    int p2 = ( derecho == null ) ? 0 : derecho.darPeso( );
    return 1 + p1 + p2;
}

/**
 * Inserta un nuevo contacto al árbol que comienza en este nodo.
 * @param nuevo el el nuevo contacto que se va a insertar - nuevo != null
 * @throws ContactoRepetidoException se lanza esta excepción si el contacto que se quiere agregar ya está en el directorio
 */
public void insertar( UsuarioVip nuevo ) throws ExcepcionElUsuarioYaEstaRegistrado {
	
	if(this.tarjetaVip==nuevo.getTarjetaVip()) {
		System.out.println(nuevo.getGenero()+"genero"+ nuevo.getTarjetaVip()+"tarjeta vip");
//		System.out.println(this.getGenero()+"generovip"+ this.getTarjetaVip()+"Tarjetavipvip");
//		System.out.println("El que voy a greegar"+nuevo.getTarjetaVip()+ "-"+ this.tarjetaVip);
		throw new ExcepcionElUsuarioYaEstaRegistrado("Ya existe un usuarios vip con la tarjera" + nuevo.getTarjetaVip());
	}
	
	if(this.tarjetaVip>nuevo.getTarjetaVip()) {
		if(izquierdo==null) {
			izquierdo=nuevo;
		}else {
			izquierdo.insertar(nuevo);
		}
		
	}else {
		if(derecho==null) {
			derecho=nuevo;
		}else {
			derecho.insertar(nuevo);
		}
		
		
	}
	
	
}



public void agregarApuesta1(Apuesta a1) {
	
	if(this.raizApuestaVip==null) {
		this.raizApuestaVip=a1;
	}else {
		try {
			this.raizApuestaVip.insertar(a1);
		} catch (ExcepcionElUsuarioYaEstaRegistrado e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}



public UsuarioVip eliminar( String cedula )
{
    if( esHoja( ) )
        // Tiene que ser el elemento que estamos buscando
        return null;
    if( this.cedula.compareToIgnoreCase( cedula) == 0 )
    {
        if( izquierdo == null ) {
            return derecho;

        }
        if( derecho == null ) {
            return izquierdo;
        }
        // Localiza el menor contacto del subárbol derecho
        UsuarioVip sucesor = derecho.darMenor( );
        // Elimina del subárbol derecho el elemento que acaba de localizar
        derecho = derecho.eliminar( sucesor.getNombre() );
        // Deja el elemento localizado en la raíz del árbol de respuesta
        sucesor.izquierdo = izquierdo;
        sucesor.derecho = derecho;
        return sucesor;
    }
    else if( this.cedula.compareToIgnoreCase( cedula ) > 0 ) {
        izquierdo = izquierdo.eliminar( cedula);
    }
    else {
        derecho = derecho.eliminar( cedula);
    }
    return this;
}



public UsuarioVip buscarUsuarioVip(int tarjetaVip) {
	
	if(this.tarjetaVip==tarjetaVip) {
		return this;
	}else if(this.tarjetaVip>tarjetaVip) {
		if(izquierdo!=null) {
			return izquierdo.buscarUsuarioVip(tarjetaVip);
		}else {
			return null;
		}
		
	}else {
		if(derecho!=null) {
			return derecho.buscarUsuarioVip(tarjetaVip);
		}else {
			return null;
		}
	}
//	return null;
}



	
	
	
}
