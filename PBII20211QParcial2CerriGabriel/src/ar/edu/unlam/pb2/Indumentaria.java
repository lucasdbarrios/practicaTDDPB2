package ar.edu.unlam.pb2;

public abstract class Indumentaria extends Producto {

	private String color;

	public Indumentaria(Integer codigo, String descripcion, String marca, Double precio, String color) {
		super(codigo, descripcion, marca, precio);

		this.setColor(color);
		// TODO Auto-generated constructor stub
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
