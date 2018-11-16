package modelo;

public class Administrador {
	
	public final static int MASCULINO=1;
	public final static int FEMENINO=2;
	private String nombre;
	private String apellido;
	private String cedula;
	private String contraseña;
	private int edad;
	private int genero;

	
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
