package modelo;

import java.io.Serializable;

public class Usuario extends Administrador implements Comparable<Usuario>,Serializable{
	

	
	private double dinero;
    private String correoElectronico;
    private int apuestasGanadas;
  
    private Apuesta apuestaUsuario;
    
    
    
    public Usuario(String nombre, String apellido, String cedula,String contraseña, int edad, int genero, double dinero, String claveUsuario,
			String correoElectronico,int apuestasGanadas,Apuesta apuestaUsuario) {
	
	super(nombre,apellido,cedula,contraseña,edad,genero);
		this.dinero = dinero;
		this.correoElectronico = correoElectronico;
		this.apuestasGanadas=apuestasGanadas;
		this.apuestaUsuario=apuestaUsuario;
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
		// TODO Auto-generated method stub
		return 0;
	}




	
	

	
	

}
