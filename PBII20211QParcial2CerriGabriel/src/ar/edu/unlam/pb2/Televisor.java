package ar.edu.unlam.pb2;

public class Televisor extends Electrodomestico {

	private Integer pulgadas;

	public Televisor(Integer codigo, String descripcion, Integer pulgadas, Integer garantia, String marca,
			Double precio) {
		super(codigo, descripcion, marca, precio, garantia);
		this.setPulgadas(pulgadas);
	}

	public Integer getPulgadas() {
		return pulgadas;
	}

	public void setPulgadas(Integer pulgadas) {
		this.pulgadas = pulgadas;
	}

}
