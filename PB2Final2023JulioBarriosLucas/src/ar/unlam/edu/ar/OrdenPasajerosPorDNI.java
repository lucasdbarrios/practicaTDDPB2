package ar.unlam.edu.ar;

import java.util.Comparator;

public class OrdenPasajerosPorDNI implements Comparator<Pasajero>{

	@Override
	public int compare(Pasajero primerPasajero, Pasajero segundoPasajerp) {
		// TODO Auto-generated method stub
		return primerPasajero.getDni().compareTo(segundoPasajerp.getDni());
	}

}
