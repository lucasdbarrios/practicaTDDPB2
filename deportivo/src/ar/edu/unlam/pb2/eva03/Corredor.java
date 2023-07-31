package ar.edu.unlam.pb2.eva03;

import ar.edu.unlam.pb2.eva03.interfaces.ICorredor;

public class Corredor extends Deportista implements ICorredor {

	private Integer numeroDeSocio;
	private String nombre;
	private Integer cantidadDeKilometrosEntrenados;
	private Integer distanciaPreferida;
	
	public Corredor(Integer numeroDeSocio,  String nombre, Integer distanciaPreferida) {
		super(numeroDeSocio,nombre);
		this.distanciaPreferida=distanciaPreferida;
		this.cantidadDeKilometrosEntrenados=0;
		}

	public Integer getDistanciaPreferida() {
		return distanciaPreferida;
	}

	public void setDistanciaPreferida(Integer distanciaPreferida) {
		this.distanciaPreferida = distanciaPreferida;
	}

	@Override
	public void setCantidadDeKilometrosEntrenados(Integer km) {
		this.cantidadDeKilometrosEntrenados=km;
		
	}

	@Override
	public Integer getCantidadDeKilometrosEntrenados() {
		// TODO Auto-generated method stub
		return this.cantidadDeKilometrosEntrenados;
	}

	

}
