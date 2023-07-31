package ar.edu.unlam.pb2;

import java.util.*;

public class Venta {

	private Integer dniDelComprador;
	private String nombreDelComprador;
	private List<Producto> carrito;
	private Double importe;

	public Venta(Integer dniDelComprador, String nombreDelComprador) {
		// TODO Auto-generated constructor stub
		this.dniDelComprador = dniDelComprador;
		this.nombreDelComprador = nombreDelComprador;
		this.carrito = new LinkedList<>();
		this.importe = 0.0;
	}

	public Integer getDniDelComprador() {
		return dniDelComprador;
	}

	public void setDniDelComprador(Integer dniDelComprador) {
		this.dniDelComprador = dniDelComprador;
	}

	public String getNombreDelComprador() {
		return nombreDelComprador;
	}

	public void setNombreDelComprador(String nombreDelComprador) {
		this.nombreDelComprador = nombreDelComprador;
	}

	public void ponerProductoEnLaCanasta(Producto producto) {
		this.carrito.add(producto);
		importe += producto.getPrecio();
	}

	public List<Producto> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Producto> carrito) {
		this.carrito = carrito;
	}

	public Double getImporte() {
		return importe;
	}

}
