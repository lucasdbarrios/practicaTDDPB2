package ar.edu.unlam.pb2.eva02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Compradores implements Comprar {

	private Integer dni;
	private String nombre;
	private Double presupuesto;
	private TipoArticulo tipoPreferido;
	private Set<Articulo> articulosComprados;
	private Set<Combo> combosComprados;
	
	
	public Compradores(Integer dni, String nombre, Double presupuesto, TipoArticulo tipoPreferido) {
		this.dni=dni;
		this.nombre=nombre;
		this.presupuesto=presupuesto;
		this.tipoPreferido=tipoPreferido;
		this.articulosComprados=new HashSet<>();
		this.combosComprados= new HashSet<>();
		}


	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compradores other = (Compradores) obj;
		return Objects.equals(dni, other.dni);
	}


	public Integer getDni() {
		return dni;
	}


	public void setDni(Integer dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Double getPresupuesto() {
		return presupuesto;
	}


	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}


	public TipoArticulo getTipoPreferido() {
		return tipoPreferido;
	}


	public void setTipoPreferido(TipoArticulo tipoPreferido) {
		this.tipoPreferido = tipoPreferido;
	}


	@Override
	public void comprarArticulos() {
		// TODO Auto-generated method stub
		
	}

}
