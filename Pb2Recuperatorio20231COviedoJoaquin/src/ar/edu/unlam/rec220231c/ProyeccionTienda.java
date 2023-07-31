package ar.edu.unlam.rec220231c;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Las peliculas se asignan dentro de las salas deProyeccion
//Las ventas se asiganas en las salas de tienda

public class ProyeccionTienda extends Sala implements IProyectable,iTienda{
	
	private HashSet<Pelicula> peliculasasignadasproyectables;
	private Pelicula peliculaproyectada;
	private List<Venta> ventas;
	private SalaTienda salaTienda;
	private SalaProyeccion salaProyeccion;
	
	
	public ProyeccionTienda(String nombreSala, SalaTienda salaTienda, SalaProyeccion salaProyeccion) {
		super(nombreSala);
		peliculasasignadasproyectables=new HashSet<>();			
		ventas=new ArrayList<>();
		this.salaTienda=salaTienda;
		this.salaProyeccion=salaProyeccion;
		
		
		
	}

	@Override
	public void registrarVenta(Venta venta) {
		// TODO Auto-generated method stub
		salaTienda.registrarVenta(venta);
		
		
	}

	@Override
	public Double obtenerTotalDeVenta() {
		// TODO Auto-generated method stub
		
		return salaTienda.obtenerTotalDeVenta();
	}

	@Override
	public void asiganarPelicula(Pelicula pelicula) {
		// TODO Auto-generated method stub
		salaProyeccion.asiganarPelicula(pelicula);
		
	}

	@Override
	public Pelicula obtenerPeliculaQueSeProyecta() {
		// TODO Auto-generated method stub
		return salaProyeccion.obtenerPeliculaQueSeProyecta();
	}

	@Override
	public HashSet<Pelicula> obtenerpeliculasasignadasproyectables() {
		// TODO Auto-generated method stub
		return salaProyeccion.obtenerpeliculasasignadasproyectables();
	}

	
	
	
	
	
	
	

}
