package Comparador;

import java.util.Comparator;

import modelo.Usuario;

public class ComparadorApuesta implements Comparator<Usuario>{

	@Override
	public int compare(Usuario u1, Usuario u2) {
		// TODO Auto-generated method stub
		if(u1.getApuestasGanadas()>u2.getApuestasGanadas()) {
			return 1;
		}else if(u1.getApuestasGanadas()<u2.getApuestasGanadas()) {
			return -1;
		}else {
			return 0;

		}
	}



}
