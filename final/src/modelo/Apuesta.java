package modelo;

import java.io.Serializable;

import Excepciones.ExcepcionElUsuarioYaEstaRegistrado;

public class Apuesta implements Serializable,Comparable<Apuesta>{

	
	public final static int APUESTA_GANADOR=1;
	public final static int APUESTA_SEGUNDO=2;
	public final static int APUESTA_COLOCADO=3;
	
	private int tipoApuesta;
	private String IdApuesta;
private int numeroCaballo;
private double cuotaCaballo;
	
	private Apuesta iz;
	private Apuesta der;

	public Apuesta(int tipoApuesta, double cantidadApostar,String IdApuesta,int numeroCaballo) {

		this.tipoApuesta = tipoApuesta;
		this.IdApuesta=IdApuesta;
		this.cuotaCaballo=cuotaCaballo;
		this.numeroCaballo=numeroCaballo;
		
	}

	public int getTipoApuesta() {
		return tipoApuesta;
	}

	public void setTipoApuesta(int tipoApuesta) {
		this.tipoApuesta = tipoApuesta;
	}

	public int getNumeroCaballo() {
		return numeroCaballo;
	}

	public void setNumeroCaballo(int numeroCaballo) {
		this.numeroCaballo = numeroCaballo;
	}

	public double getCuotaCaballo() {
		return cuotaCaballo;
	}

	public void setCuotaCaballo(double cuotaCaballo) {
		this.cuotaCaballo = cuotaCaballo;
	}

	public String getIdApuesta() {
		return IdApuesta;
	}

	public void setIdApuesta(String IdApuesta) {
		this.IdApuesta = IdApuesta;
	}

	public Apuesta getIz() {
		return iz;
	}

	public void setIz(Apuesta iz) {
		this.iz = iz;
	}

	public Apuesta getDer() {
		return der;
	}

	public void setDer(Apuesta der) {
		this.der = der;
	}
	
	
	
	
	
	public void insertar( Apuesta nuevo ) throws ExcepcionElUsuarioYaEstaRegistrado {
		
		if(compareTo(nuevo)==0) {
			throw new ExcepcionElUsuarioYaEstaRegistrado("Ya existe una apuesta con ese mismo ID" + nuevo.getIdApuesta());
		}
		
		if(compareTo(nuevo)<1) {
			if(iz==null) {
				iz=nuevo;
			}else {
				iz.insertar(nuevo);
			}
			
		}else {
			if(der==null) {
				der=nuevo;
			}else {
				der.insertar(nuevo);
			}
			
			
		}
		
		
	}
	
	
	
	public Apuesta darMenor() {
		if(iz!=null) {
			iz.darMenor();
		}
		return this;
	}

public Apuesta eliminar( String IdApuesta)
{
    if( this.iz==null&&this.der==null )
        // Tiene que ser el elemento que estamos buscando
        return null;
    if( this.IdApuesta.compareToIgnoreCase( IdApuesta ) == 0 )
    {
        if( iz == null ) {
            return der;

        }
        if( der == null ) {
            return iz;
        }
        // Localiza el menor contacto del subárbol derecho
        Apuesta sucesor = der.darMenor( );
        // Elimina del subárbol derecho el elemento que acaba de localizar
        der = der.eliminar( sucesor.getIdApuesta());
        // Deja el elemento localizado en la raíz del árbol de respuesta
        sucesor.iz = iz;
        sucesor.der = der;
        return sucesor;
    }
    else if( this.IdApuesta.compareToIgnoreCase( IdApuesta ) > 0 ) {
        iz = iz.eliminar( IdApuesta );
    }
    else {
        der = der.eliminar( IdApuesta);
    }
    return this;
}




public Apuesta buscarApuesta(String idApuesta) {
	
	if(this.IdApuesta.compareToIgnoreCase(idApuesta)==0) {
		return this;
	}else if(this.IdApuesta.compareToIgnoreCase(idApuesta)>0) {
		if(iz!=null) {
		return	iz.buscarApuesta(idApuesta);
		}else {
			return null;
		}
		
	}else {
		if(der!=null) {
			return der.buscarApuesta(idApuesta);
		}else {
			return null;
		}
	}
	
}





@Override
public int compareTo(Apuesta a1) {
	// TODO Auto-generated method stub
	if(this.IdApuesta.compareTo(a1.getIdApuesta())==0) {
		return 0;
	}else if(this.IdApuesta.compareTo(a1.getIdApuesta())>0) {
		return 1;
	}else {
		return -1;
	}
}
	
	
	
	
}
