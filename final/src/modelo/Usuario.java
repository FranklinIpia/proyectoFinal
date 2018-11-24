package modelo;

import java.io.Serializable;

import Excepciones.ExcepcionElUsuarioYaEstaRegistrado;

public class Usuario extends Administrador implements Comparable<Usuario>,Serializable{
	

	
	private double dinero;
    private String correoElectronico;
    private int apuestasGanadas;
  private Apuesta raizApuesta;
    private Apuesta apuestaUsuario;
    
    
    
    public Usuario(String nombre, String apellido, String cedula,String contraseña, int edad, int genero, double dinero,
			String correoElectronico,int apuestasGanadas,Apuesta apuestaUsuario) {
	
	super(nombre,apellido,cedula,contraseña,edad,genero);
		this.dinero = dinero;
		this.correoElectronico = correoElectronico;
		this.apuestasGanadas=apuestasGanadas;
		this.apuestaUsuario=apuestaUsuario;
		this.raizApuesta=apuestaUsuario;
	}
    

    
   


	public Apuesta getApuestaUsuario() {
		return apuestaUsuario;
	}






	public void setApuestaUsuario(Apuesta apuestaUsuario) {
		this.apuestaUsuario = apuestaUsuario;
	}






	public double getDinero() {
		return dinero;
	}





	public void setDinero(double dinero) {
		this.dinero = dinero;
	}









	public String getCorreoElectronico() {
		return correoElectronico;
	}





	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}






	public int getApuestasGanadas() {
		return apuestasGanadas;
	}



	public void setApuestasGanadas(int apuestasGanadas) {
		this.apuestasGanadas = apuestasGanadas;
	}






	@Override
	public int compareTo(Usuario u1) {
		if(this.cedula.compareTo(u1.getCedula())==0) {
			return 0;
		}else if(this.cedula.compareTo(u1.getCedula())>0) {
			return 1;
		}else {
			return 0;
		}
	
	}




	public void agregarApuesta(Apuesta ap1) {
		if(raizApuesta==null) {
			raizApuesta=ap1;
		}else {
			try {
				raizApuesta.insertar(ap1);
			} catch (ExcepcionElUsuarioYaEstaRegistrado e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
	

	
	

}
