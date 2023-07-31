package ar.edu.unlam.pb2;

public class Remera extends Indumentaria {

	private String talle;

	public Remera(Integer codigo, String descripcion, String talle, String marca, String color, Double precio) {
		super(codigo, descripcion, marca, precio, color);
		this.setTalle(talle);
		// TODO Auto-generated constructor stub
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	// new Remera(5, "B�sica", "XL", "Lacoste", "Azul", 2000.0)
}
