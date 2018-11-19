package modelo;

import java.io.Serializable;

public class Administrador implements Serializable{
	
	public final static int MASCULINO=1;
	public final static int FEMENINO=2;
	protected String nombre;
	protected String apellido;
	protected String cedula;
	protected String contraseña;
	protected int edad;
	protected int genero;

	
	public Administrador(String nombre,String apellido,String cedula,String contraseña,int edad,int genero) {
		this.nombre=nombre;
		this.apellido=apellido;
		this.cedula=cedula;
		this.contraseña=contraseña;
		this.genero=genero;
		this.edad=edad;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getContraseña() {
		return contraseña;
	}


	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public int getGenero() {
		return genero;
	}


	public void setGenero(int genero) {
		this.genero = genero;
	}



	
	

}
