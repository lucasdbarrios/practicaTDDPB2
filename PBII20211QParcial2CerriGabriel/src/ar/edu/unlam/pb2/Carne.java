package ar.edu.unlam.pb2;

public class Carne extends Comestible {
	private Double kilos;

	public Carne(Integer codigo, String descripcion, String fechaElaboracion, String fechaVencimiento, Double kilos,
			String marca, Double precio) {
		super(codigo, descripcion, marca, precio, fechaElaboracion, fechaVencimiento);
		this.setKilos(kilos);
	}

	public Double getKilos() {
		return kilos;
	}

	public void setKilos(Double kilos) {
		this.kilos = kilos;
	}

}
