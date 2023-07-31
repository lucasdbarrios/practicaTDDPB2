package ar.edu.unlam.pb2.eva02;

import java.util.Objects;

public class Articulo {

	private Integer codigoProducto;
	private String nombre;
	private Integer valor;
	private String descripcion;
	private Integer cantidad;
	private TipoArticulo tipo;
	
	public Articulo(Integer codigoProducto, String nombre, Integer valor, String descripcion, Integer cantidad,
			TipoArticulo tipo) {
		this.codigoProducto=codigoProducto;
		this.nombre=nombre;
		this.valor=valor;
		this.descripcion=descripcion;
		this.cantidad=cantidad;
		this.tipo=tipo;
	}

	public Integer getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Integer codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public TipoArticulo getTipo() {
		return tipo;
	}

	public void setTipo(TipoArticulo tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoProducto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
	
		Articulo other = (Articulo) obj;
		return Objects.equals(codigoProducto, other.codigoProducto);
	}

}
