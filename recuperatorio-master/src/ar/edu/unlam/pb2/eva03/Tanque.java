package ar.edu.unlam.pb2.eva03;

public class Tanque extends Vehiculo implements Terrestre {

	private Integer codigo;
	private String nombre;
	private Double velocidad;
	
	public Tanque(Integer codigo, String nombre) {

		super(codigo,nombre);
		this.velocidad=0.0;
	}

	@Override
	public Double getVelocidad() {
		return this.velocidad ;
	}

}
