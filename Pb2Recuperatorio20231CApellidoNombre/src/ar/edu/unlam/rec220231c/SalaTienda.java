package ar.edu.unlam.rec220231c;

import java.util.ArrayList;
import java.util.List;

public class SalaTienda extends Sala implements iTienda {

	
	List<Venta> ventas;
	public SalaTienda(String nombre) {
		super(nombre);
		this.ventas=new ArrayList<>();

	}
	@Override
	public void registrarVenta(Venta venta) {
		this.ventas.add(venta);
		
	}
	@Override
	public Double obtenerTotalDeVenta() {
		Double totalDeVentas=0.0;
		for(Venta estaVenta : ventas) {
			totalDeVentas+= estaVenta.getMonto();
		}
			
		return totalDeVentas;
	}

}
