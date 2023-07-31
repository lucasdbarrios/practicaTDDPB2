package ar.edu.unlam.pb2.eva03;

public class Destructor extends Vehiculo implements Acuatico {

	private Integer codigo;
	private String nombre;
	private Double profundidad;
	
	public Destructor(Integer codigo, String nombre) {
		super(codigo, nombre);
		this.profundidad=0.0;
	}

	@Override
	public Double getProfundidad() {
		
		return this.profundidad;
	}

}
