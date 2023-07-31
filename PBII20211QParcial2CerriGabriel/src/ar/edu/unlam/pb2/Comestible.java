package ar.edu.unlam.pb2;

public abstract class Comestible extends Producto {

	private String fechaVencimiento;
	private String fechaElaboracion;

	public Comestible(Integer codigo, String descripcion, String marca, Double precio, String fechaElaboracion,
			String fechaVencimiento) {
		super(codigo, descripcion, marca, precio);
		this.fechaVencimiento = fechaVencimiento;
		this.fechaElaboracion = fechaElaboracion;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getFechaElaboracion() {
		return fechaElaboracion;
	}

	public void setFechaElaboracion(String fechaElaboracion) {
		this.fechaElaboracion = fechaElaboracion;
	}

}
