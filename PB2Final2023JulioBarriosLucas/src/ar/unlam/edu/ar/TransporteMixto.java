package ar.unlam.edu.ar;

public class TransporteMixto extends MedioTransporte implements ITransportable, iCargable {
	/*
	 * No se pueden agregar mas Atributos
	 */
	
	
	
	private Integer cantidadPasajerosMaximos;
	private Double cargaMaxima;
 

	public TransporteMixto(String patente, Integer cantidadPasajerosMaximos, Double cargaMaxima) {
		super(patente);
		this.cantidadPasajerosMaximos=cantidadPasajerosMaximos;
		this.cargaMaxima=cargaMaxima;
	}


 

	@Override
	public Double obtenerCantidadMaximaPeso() {
		// TODO Auto-generated method stub
		return this.cargaMaxima;
	}




	@Override
	public Integer obtenerCantidadMaximaPasajero() {
		// TODO Auto-generated method stub
		return this.cantidadPasajerosMaximos;
	}
	
	

}
