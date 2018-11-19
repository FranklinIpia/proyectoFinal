package Comparador;

import java.util.Comparator;

import modelo.Usuario;

public class ComparadorNombre implements Comparator<Usuario>{

	@Override
	public int compare(Usuario o1, Usuario o2) {
		// TODO Auto-generated method stub
		return (int)o1.getNombre().compareTo(o2.getNombre());
	}

	
	
	
}
