package modelo;

public class UsuarioVip  extends Usuario{

	private int tarjetaVip;
	private UsuarioVip derecho;
	private UsuarioVip izquierdo;
	
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



	
	
	
}
