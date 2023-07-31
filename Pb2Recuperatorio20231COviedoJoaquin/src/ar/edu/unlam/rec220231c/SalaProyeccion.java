package ar.edu.unlam.rec220231c;

import java.util.HashSet;

public class SalaProyeccion extends Sala implements IProyectable{
	private HashSet<Pelicula> peliculasasignadasproyectables;

	private Pelicula peliculaproyectada;

	
	
	public SalaProyeccion(String nombre) {
		super(nombre);
		// TODO Auto-generated constructor stub
		peliculasasignadasproyectables=new HashSet<>();
	}

	@Override
	public void asiganarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		peliculaproyectada=pelicula;
		
		peliculasasignadasproyectables.add(pelicula);
		
	}

	@Override
	public Pelicula obtenerPeliculaQueSeProyecta() {
		// TODO Auto-generated method stub
		return peliculaproyectada;
	}

	@Override
	public HashSet<Pelicula> obtenerpeliculasasignadasproyectables() {
		// TODO Auto-generated method stub
		return peliculasasignadasproyectables;
	}
	
	

	
	
}
