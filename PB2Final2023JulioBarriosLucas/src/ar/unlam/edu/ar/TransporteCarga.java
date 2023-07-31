package ar.unlam.edu.ar;

public class TransporteCarga  extends MedioTransporte implements iCargable{

	private Double cargaMaxima;
	public TransporteCarga(String patente,Double cargaMaxima) {
		super(patente);
		this.cargaMaxima=cargaMaxima;
	}
	
	
	@Override
	public Double obtenerCantidadMaximaPeso() {
		// TODO Auto-generated method stub
		 return cargaMaxima;
	}

	

}
