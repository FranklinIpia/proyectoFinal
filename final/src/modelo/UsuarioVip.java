package modelo;

import java.io.Serializable;

import Excepciones.ExcepcionElUsuarioYaEstaRegistrado;



public class UsuarioVip   extends Usuario  implements Serializable{

	private int tarjetaVip;
	private UsuarioVip derecho;
	private UsuarioVip izquierdo;
	private Apuesta raizApuestaVip;
public UsuarioVip(String nombre, String apellido, String cedula,String contrase�a, int edad, int genero, double dinero, String claveUsuario,
		String correoElectronico,int apuestasGanadas,Apuesta apuestaUsuario,int tarjetaVip) {
	super(nombre,apellido,cedula,contrase�a,edad,genero,dinero,correoElectronico,apuestasGanadas,apuestaUsuario);
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
 * Retorna el contacto que alfab�ticamente corresponde al menor contacto del �rbol que parte de este nodo
 * @return contacto con menor nombre
 */
public UsuarioVip darMenor( )
{
    return ( derecho == null ) ? this : izquierdo.darMenor( );
}



/**
 * Inserta un nuevo contacto al �rbol que comienza en este nodo.
 * @param nuevo el el nuevo contacto que se va a insertar - nuevo != null
 * @throws ContactoRepetidoException se lanza esta excepci�n si el contacto que se quiere agregar ya est� en el directorio
 */
public void insertar( UsuarioVip nuevo ) throws ExcepcionElUsuarioYaEstaRegistrado {
	
	if(this.tarjetaVip==nuevo.getTarjetaVip()) {
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
        // Localiza el menor contacto del sub�rbol derecho
        UsuarioVip sucesor = derecho.darMenor( );
        // Elimina del sub�rbol derecho el elemento que acaba de localizar
        derecho = derecho.eliminar( sucesor.getNombre() );
        // Deja el elemento localizado en la ra�z del �rbol de respuesta
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
