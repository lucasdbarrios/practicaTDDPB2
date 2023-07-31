package ar.edu.unlam.pb2.eva03;

public class Submarino extends Vehiculo implements Acuatico {

	
	private Double profundidad;
	
	public Submarino(Integer codigo, String nombre) {
		super(codigo,nombre);
		this.profundidad=0.0;
	}

	@Override
	public Double getProfundidad() {
		// TODO Auto-generated method stub
		return this.profundidad;
	}

}
