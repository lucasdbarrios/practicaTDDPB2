package ar.edu.unlam.rec220231c;

import java.util.HashSet;

public interface IProyectable {
	
	void asiganarPelicula(Pelicula pelicula);
	
	
	Pelicula obtenerPeliculaQueSeProyecta();


	HashSet<Pelicula>  obtenerpeliculasasignadasproyectables();

}
