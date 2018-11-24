package Comparador;

import java.util.Comparator;

import modelo.Caballo;

public class ComparadorVelocidad implements Comparator<Caballo>{

	@Override
	public int compare(Caballo o1, Caballo o2) {
		// TODO Auto-generated method stub
		return (int) (o1.getVelocidadMaxima()-o2.getVelocidadMaxima());
	}

}
