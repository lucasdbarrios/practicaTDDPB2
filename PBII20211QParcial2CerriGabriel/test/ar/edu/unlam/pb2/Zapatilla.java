package ar.edu.unlam.pb2;

public class Zapatilla extends Indumentaria {

	private Integer talle;

	public Zapatilla(Integer codigo, String descripcion, Integer talle, String marca, String color, Double precio) {
		super(codigo, descripcion, marca, precio, color);
		this.setTalle(talle);
		// TODO Auto-generated constructor stub
	}

	public Integer getTalle() {
		return talle;
	}

	public void setTalle(Integer talle) {
		this.talle = talle;
	}

}
