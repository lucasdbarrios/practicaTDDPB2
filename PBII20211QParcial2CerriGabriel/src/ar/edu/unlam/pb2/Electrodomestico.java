package ar.edu.unlam.pb2;

public abstract class Electrodomestico extends Producto {

	private Integer garantia;

	public Electrodomestico(Integer codigo, String descripcion, String marca, Double precio, Integer garantia) {
		super(codigo, descripcion, marca, precio);
		this.garantia = garantia;
	}

	public Integer getGarantia() {
		// TODO Auto-generated method stub
		return this.garantia;
	}

}
