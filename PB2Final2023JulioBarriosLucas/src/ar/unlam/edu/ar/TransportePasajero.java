package ar.unlam.edu.ar;

public class TransportePasajero extends MedioTransporte implements ITransportable{

	private Integer cantidadPasajerosMaximos;
	
	public TransportePasajero(String patente,Integer cantidadPasajerosMaximos) {
		super(patente);
		this.cantidadPasajerosMaximos=cantidadPasajerosMaximos;
	}

	

	@Override
	public Integer obtenerCantidadMaximaPasajero() {
		// TODO Auto-generated method stub
		 return cantidadPasajerosMaximos;
	}

	

}
