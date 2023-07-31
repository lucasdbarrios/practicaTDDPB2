package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Supermercado {

	String nombre; // Nombre del supermercado
	private Set<Producto> productosExistentes; // Listado de productos que se comercializan
	private List<Producto> productosDisponibles; // Detalle de cada producto ingresado
	private Map<Integer, Venta> ventasRealizadas; // Listado de ventas realizadas (identificadas por el n�mero de venta)
	Integer contadorDeVentas; // Identificador del n�mero de venta

	public Supermercado(String nombre) {
		productosDisponibles = new ArrayList<Producto>();
		productosExistentes = new HashSet<Producto>();
		ventasRealizadas = new HashMap<Integer, Venta>();
		contadorDeVentas = 0;
	}

	public void ingresarProducto(Producto nuevo) {
		productosDisponibles.add(nuevo);
		productosExistentes.add(nuevo);
	}

	public Integer getCantidadProductosComestibles() {
		Set<Producto> productosComestibles = new HashSet<Producto>();
		for (Producto producto : productosExistentes) {
			if (producto instanceof Comestible) {
				productosComestibles.add(producto);
			}
		}
		return productosComestibles.size();

	}

	public Set<Producto> getOfertaDeProductos() {
		// Devuelve el conjunto de productos que se comercializan
		return this.productosExistentes;
	}

	public Integer getStock(Integer codigo) {
		// Devuelve la cantidad de unidades de un producto determinado
		Integer stock = 0;
		for (Producto producto : productosDisponibles) {
			if (producto.getCodigo().equals(codigo)) {
				stock++;
			}
		}
		return stock;
	}

	private Boolean productoExiste(Integer codigoDeProducto) throws ProductoInexistente {
		// Verifica si un producto existe
		for (Producto producto : productosExistentes) {
			if (producto.getCodigo().equals(codigoDeProducto)) {
				return true;
			}
		}

		throw new ProductoInexistente();
	}

	private Producto getProductoPorCodigo(Integer codigoDeProducto) throws ProductoSinStock {
		// Busca la disponibilidad de un producto
		for (Producto producto : productosDisponibles) {
			if (producto.getCodigo().equals(codigoDeProducto)) {
				return producto;
			}
		}
		throw new ProductoSinStock();
	}

	public Integer registrarNuevaVenta(Integer dniDelComprador, String nombreDelComprador) {
		// Registra una nueva venta
		ventasRealizadas.put(++contadorDeVentas, new Venta(dniDelComprador, nombreDelComprador));
		return contadorDeVentas;
	}

	public Venta getVenta(Integer nueroDeVenta) {
		// Devuelve una venta en funci�n de su n�mero identificatorio

		if (this.ventasRealizadas.containsKey(nueroDeVenta)) {
			return this.ventasRealizadas.get(nueroDeVenta);

		}

		return null;

	}

	public void agregarAlCarrito(Integer numeroDeVenta, Integer codigoDeProducto)
			throws ProductoSinStock, ProductoInexistente {
		// Incorpora al carrito de compras de la venta identificada por el
		// "numeroDeVenta", el producto identificado por el "codigoDeProducto"

		Venta ventaActual = ventasRealizadas.get(numeroDeVenta);
		if (this.productoExiste(codigoDeProducto)) {
			if (this.getProductoPorCodigo(codigoDeProducto) != null) {
				ventaActual.ponerProductoEnLaCanasta(this.getProductoPorCodigo(codigoDeProducto));
				productosDisponibles.remove(this.getProductoPorCodigo(codigoDeProducto));
			} else {
				throw new ProductoSinStock();
			}
		} else {
			throw new ProductoInexistente();
		}

	}

}
