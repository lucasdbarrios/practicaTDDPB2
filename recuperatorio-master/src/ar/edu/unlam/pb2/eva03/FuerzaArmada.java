package ar.edu.unlam.pb2.eva03;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



public class FuerzaArmada {

	
	private Set<Vehiculo> convoy;
	private Map<String, Batalla> batallas;
	


	
	public FuerzaArmada() {
		this.convoy= new HashSet<Vehiculo>();
		this.batallas= new TreeMap<String, Batalla>();
	}


	public void agregarVehiculo(Vehiculo vehiculoDeBatalla) {
		convoy.add(vehiculoDeBatalla);
		
	}


	public Integer getCapacidadDeDefensa() {
		return convoy.size();
	}


	public void crearBatalla(String nombreDeBatalla,TipoDeBatalla tipo, Double latitud, Double longitud) {
		batallas.put(nombreDeBatalla, new Batalla(latitud,longitud,tipo));
		
	}


	public Batalla getBatalla(String nombre) {
		
		return batallas.get(nombre);
	}



	public boolean enviarALaBatalla(String nombreDeLaBatalla, Integer codigoVehiculo) throws VehiculoInexistente, VehiculoIncompatible {
		
		Batalla buscada = batallas.get(nombreDeLaBatalla);
		Vehiculo buscado = buscarVehiculo(codigoVehiculo); 
		
		
		return buscada.ingresarVehiculoABatalla(buscado);
	}


	private void agregarVehiculoALaBatalla(Vehiculo buscado) {
		// TODO Auto-generated method stub
		
	}


	private Vehiculo buscarVehiculo(Integer codigoVehiculo) throws VehiculoInexistente {
		for (Vehiculo actual : convoy) {
			if(actual.getCodigo().equals(codigoVehiculo))
				return actual;
		}
		throw new VehiculoInexistente();
	} 

}
