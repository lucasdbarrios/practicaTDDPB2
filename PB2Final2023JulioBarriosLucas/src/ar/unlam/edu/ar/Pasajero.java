package ar.unlam.edu.ar;

import java.util.Objects;

public class Pasajero {

	
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
		
		Pasajero other = (Pasajero) obj;
		return Objects.equals(dni, other.dni);
	}
	private Integer dni; 
	private String apellido;
	
	
	public Pasajero(Integer dni, String apellido) {
//		super();
		this.dni = dni;
		this.apellido = apellido;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	

}
