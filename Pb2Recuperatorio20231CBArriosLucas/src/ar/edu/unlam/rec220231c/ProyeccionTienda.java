package ar.edu.unlam.rec220231c;

import java.util.HashSet;
import java.util.Set;

// Las peliculas se asignan dentro de las salas deProyeccion
//Las ventas se asiganas en las salas de tienda

public class ProyeccionTienda extends Sala implements IProyectable,iTienda{
	
	
private SalaTienda salaTienda;
private SalaProyeccion salaProyeccion;
private Set<Venta> ventaSalaTienda;
	
	
	
	public ProyeccionTienda(String nombreSala, SalaTienda salaTienda, SalaProyeccion salaProyeccion) {
		super(nombreSala);
		this.salaProyeccion=salaProyeccion;
		this.salaTienda=salaTienda;
		this.ventaSalaTienda =new HashSet<>();
	}

	@Override
	public void registrarVenta(Venta venta) {
		this.ventaSalaTienda.add(venta);
		
	}

	@Override
	public Double obtenerTotalDeVenta() {
		Double ventasTotales = 0.0;
		for(Venta ventastotales: ventaSalaTienda) {
			 ventasTotales += ventastotales.getMonto();
		}
		return ventasTotales;
	}

	@Override
	public void asiganarPelicula(Pelicula pelicula) {
		this.salaProyeccion.asiganarPelicula(pelicula);
		
	}

	@Override
	public Pelicula obtenerPeliculaQueSeProyecta() {
		return this.salaProyeccion.obtenerPeliculaQueSeProyecta();
		 
	}

	
	
	
	
	
	
	

}
