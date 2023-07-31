package ar.edu.unlam.pb2.eva03;

public class Avion extends Vehiculo implements Volador {

	private Integer codigo;
	private String nombre;
	private Double altura;
	
	//constructor 
	
	public Avion(Integer codigo, String nombre) {
		super(codigo,nombre);
		this.altura = 0.0;
	}

	@Override
	public Double getAltura() {
		return this.altura ;
	}


}
