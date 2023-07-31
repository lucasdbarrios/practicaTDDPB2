package ar.edu.unlam.rec220231c;

import java.util.Comparator;

public class Orden_de_Peliculas implements Comparator<Pelicula> {

	@Override
	public int compare(Pelicula o1, Pelicula o2) {
		// TODO Auto-generated method stub
		return o1.getDescripcion().compareTo(o2.getDescripcion());
	}

}
