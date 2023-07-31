package ar.edu.unlam.rec220231c;

import java.util.HashSet;
import java.util.Set;

public class SalaProyeccion extends Sala implements IProyectable{
	
	private Pelicula peliculaEnSala;
	
	public SalaProyeccion(String nombre) {
		super(nombre);
		this.peliculaEnSala=peliculaEnSala;
	
		
	}

	@Override
	public void asiganarPelicula(Pelicula pelicula) {
		this.peliculaEnSala=pelicula;
		
		
	}

	@Override
	public Pelicula obtenerPeliculaQueSeProyecta() {
		
		return this.peliculaEnSala;
	}

	
	
}
