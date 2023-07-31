package ar.edu.unlam.pb2;

public class Heladera extends Electrodomestico {

	private Boolean isNoFrost;

	public Heladera(Integer codigo, String descripcion, Boolean isNoFrost, Integer garantia, String marca,
			Double precio) {
		super(codigo, descripcion, marca, precio, garantia);
		this.setIsNoFrost(isNoFrost);
	}

	public Boolean isNoFrost() {
		return isNoFrost;
	}

	public void setIsNoFrost(Boolean isNoFrost) {
		this.isNoFrost = isNoFrost;
	}

}
