package Comparador;

import java.util.Comparator;

import modelo.Usuario;

public class ComparadorEdad implements Comparator<Usuario>{

	@Override
	public int compare(Usuario u1, Usuario u2) {
		return(int) u1.getEdad()-u2.getEdad();
		// TODO Auto-generated method stub
		
	}

	
	
	
}
