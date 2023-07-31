package ar.edu.unlam.rec220231c;

import java.util.HashSet;
import java.util.Set;

// Las peliculas se asignan dentro de las salas deProyeccion
//Las ventas se asiganas en las salas de tienda

public class ProyeccionTienda extends Sala implements IProyectable,iTienda{
	
	

	private Set<Pelicula>peliculasEnSala;
	private Pelicula peliculaProyectada;
	private SalaProyeccion salaParaProyectar;
	private SalaTienda salaParaVender;
	
	
	
	public ProyeccionTienda(String nombreSala, Sala salaTienda, Sala salaProyeccion) {
		super(nombreSala);
		this.peliculasEnSala=new HashSet<>();
		this.salaParaProyectar=(SalaProyeccion) salaProyeccion;
		this.salaParaVender=(SalaTienda) salaTienda;
	}

	@Override
	public void registrarVenta(Venta venta) {
		this.salaParaVender.registrarVenta(venta);
		
	}

	@Override
	public Double obtenerTotalDeVenta() {
		
		return this.salaParaVender.obtenerTotalDeVenta();
	}

	@Override
	public void asiganarPelicula(Pelicula pelicula) {
		
		
		this.salaParaProyectar.asiganarPelicula(pelicula);
		
	}

	@Override
	public Pelicula obtenerPeliculaQueSeProyecta() {
		
		return this.salaParaProyectar.obtenerPeliculaQueSeProyecta();
	}

	
	
	
	
	
	
	

}
