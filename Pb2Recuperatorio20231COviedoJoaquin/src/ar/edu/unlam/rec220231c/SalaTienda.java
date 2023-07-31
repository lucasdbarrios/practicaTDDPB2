package ar.edu.unlam.rec220231c;

import java.util.ArrayList;
import java.util.List;

public class SalaTienda extends Sala implements iTienda {

	
	List<Venta> ventas;
	
	
	public SalaTienda(String nombre) {
		super(nombre);
		ventas=new ArrayList<>();
	}
	@Override
	public void registrarVenta(Venta venta) {
		// TODO Auto-generated method stub
		ventas.add(venta);
		
	}
	@Override
	public Double obtenerTotalDeVenta() {
		// TODO Auto-generated method stub
		Double totaldeventas=0.0;
		
		for(Venta actual:ventas) {
			totaldeventas=totaldeventas+actual.getMonto();
		}
		
		
		return totaldeventas;
	}

}
