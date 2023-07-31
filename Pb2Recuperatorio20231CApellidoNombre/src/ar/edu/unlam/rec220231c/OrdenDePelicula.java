package ar.edu.unlam.rec220231c;

import java.util.Comparator;

public class OrdenDePelicula implements Comparator<Pelicula>{

	@Override
	public int compare(Pelicula peliculaIngresada, Pelicula peliculaSiguiente) {
		
		return peliculaIngresada.getDescripcion().compareTo(peliculaSiguiente.getDescripcion());
	}

}
