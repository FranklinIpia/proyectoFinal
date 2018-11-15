package modelo;

public class Usuario implements Comparable<Usuario>{
	
	
	
	private String nombre;
	private String apellido;
	private String cedula;
	private int edad;
	private int genero;
	private double dinero;
	private String claveUsuario;
    private String correoElectronico;
    private int apuestasGanadas;
    private Usuario derecho;
    private Usuario izquierdo;
    
    public Usuario(String nombre, String apellido, String cedula, int edad, int genero, double dinero, String claveUsuario,
			String correoElectronico) {
	
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.edad = edad;
		this.genero = genero;
		this.dinero = dinero;
		this.claveUsuario = claveUsuario;
		this.correoElectronico = correoElectronico;
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





	public double getDinero() {
		return dinero;
	}





	public void setDinero(double dinero) {
		this.dinero = dinero;
	}





	public String getClaveUsuario() {
		return claveUsuario;
	}





	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}





	public String getCorreoElectronico() {
		return correoElectronico;
	}





	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}





	public Usuario getDerecho() {
		return derecho;
	}





	public void setDerecho(Usuario derecho) {
		this.derecho = derecho;
	}





	public Usuario getIzquierdo() {
		return izquierdo;
	}





	public void setIzquierdo(Usuario izquierdo) {
		this.izquierdo = izquierdo;
	}





	





	@Override
	public int compareTo(Usuario u1) {
		if(this.cedula.compareTo(u1.getCedula())>0) {
			return 1;
		}else if(this.cedula.compareTo(u1.getCedula())<0) {
			return -1;
		}else {
			return 0;
		}
	
	}
	
	

	
	

}
