package ar.edu.unlam.pb2.eva03;

import java.net.InterfaceAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;



public class Batalla {
	
	private Double latitud;
	private Double longitud;
	private TipoDeBatalla tipo;
	Set<Vehiculo> vehiculosEnLaBatalla;
	

	public Batalla(Double latitud, Double longitud, TipoDeBatalla tipo) {
		this.tipo=tipo;
		this.latitud=latitud;
		this.longitud=longitud;
		vehiculosEnLaBatalla =new TreeSet<Vehiculo>();
	}
	public Double getLatitud() {
		return this.latitud;
	}
	public Double getLongitud() {
		return this.longitud;
	}
	public Boolean ingresarVehiculoABatalla(Vehiculo nuevo) throws VehiculoIncompatible {
		
	
		if((this.tipo == TipoDeBatalla.TERRESTRE && !(nuevo instanceof Terrestre)) || 
				(this.tipo == TipoDeBatalla.NAVAL && !(nuevo instanceof Acuatico)) ||
				(this.tipo == TipoDeBatalla.AEREA && !(nuevo instanceof Volador))){
					throw new VehiculoIncompatible();

				}
		
		
		return vehiculosEnLaBatalla.add(nuevo);
	
	}
}
