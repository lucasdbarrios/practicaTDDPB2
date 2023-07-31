package ar.edu.unlam.pb2.eva03;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeBicicleta;
import ar.edu.unlam.pb2.eva03.interfaces.ICiclista;
import ar.edu.unlam.pb2.eva03.interfaces.ICorredor;
import ar.edu.unlam.pb2.eva03.interfaces.INadador;

public class Triatleta extends Deportista implements ICorredor,INadador,ICiclista{

	private Integer numeroDeSocio;
	private String nombre;
	private Integer cantidadDeKilometrosEntrenados;
	private String distanciaPreferida;
	private TipoDeBicicleta tipoDeBicicleta;
	private String estiloPreferido;
	
	public Triatleta(Integer numeroDeSocio,  String nombre, String distanciaPreferida, TipoDeBicicleta tipoDeBicicleta) {
		super(numeroDeSocio,nombre);
		this.distanciaPreferida=distanciaPreferida;
		this.tipoDeBicicleta=tipoDeBicicleta;
		this.cantidadDeKilometrosEntrenados=0;
	}

	
	

	public String getDistanciaPreferida() {
		return distanciaPreferida;
	}

	public void setDistanciaPreferida(String distanciaPreferida) {
		this.distanciaPreferida = distanciaPreferida;
	}

	public TipoDeBicicleta getTipoDeBicicleta() {
		return tipoDeBicicleta;
	}

	public void setTipoDeBicicleta(TipoDeBicicleta tipoDeBicicleta) {
		this.tipoDeBicicleta = tipoDeBicicleta;
	}

	public String getEstiloPreferido() {
		return estiloPreferido;
	}

	public void setEstiloPreferido(String estiloPreferido) {
		this.estiloPreferido = estiloPreferido;
	}

	@Override
	public void setCantidadDeKilometrosEntrenados(Integer km) {
		
		
	}

	@Override
	public Integer getCantidadDeKilometrosEntrenados() {
		// TODO Auto-generated method stub
		return null;
	}

}
