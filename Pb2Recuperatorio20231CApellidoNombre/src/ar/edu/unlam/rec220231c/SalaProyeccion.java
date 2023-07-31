package ar.edu.unlam.rec220231c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SalaProyeccion extends Sala implements IProyectable{
	
	private Set<Pelicula>peliculasEnSala;
	private Pelicula peliculaProyectada;

	public SalaProyeccion(String nombre) {
		super(nombre);
		this.peliculasEnSala=new HashSet<>();
		
	}

	@Override
	public void asiganarPelicula(Pelicula pelicula) {
		peliculaProyectada=pelicula;
		this.peliculasEnSala.add(pelicula);
		
	}

	@Override
	public Pelicula obtenerPeliculaQueSeProyecta() {
		
		return this.peliculaProyectada;
	}

	
	
}
