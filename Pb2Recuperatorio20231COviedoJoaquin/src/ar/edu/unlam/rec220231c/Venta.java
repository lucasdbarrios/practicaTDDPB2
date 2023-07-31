package ar.edu.unlam.rec220231c;

public class Venta {

	private Integer numeroVenta;
	private Double monto;

	public Venta(Integer numeroVenta, Double monto) {
	this.numeroVenta=numeroVenta;
	this.monto=monto;
	}

	public Integer getNumeroVenta() {
		return numeroVenta;
	}

	public void setNumeroVenta(Integer numeroVenta) {
		this.numeroVenta = numeroVenta;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	
	
}
