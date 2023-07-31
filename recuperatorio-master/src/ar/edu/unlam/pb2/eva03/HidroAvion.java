package ar.edu.unlam.pb2.eva03;

public class HidroAvion extends Vehiculo implements Volador,Acuatico {

	private Integer codigo;
	private String nombre;
	private Double profundidad;
	private Double altura;
	
	public HidroAvion(Integer codigo, String nombre) {
		super(codigo,nombre);
		this.profundidad=0.0;
		this.altura=0.0;
		
	}

	@Override
	public Double getProfundidad() {
		// TODO Auto-generated method stub
		return this.profundidad;
	}

	@Override
	public Double getAltura() {
		// TODO Auto-generated method stub
		return this.altura;
	}

}
