package ar.edu.unlam.pb2;

public class Cliente {
	private Integer dni;
	private String nombreApellido;

	public Cliente(Integer dni, String nombreApellido) {
		super();
		this.dni = dni;
		this.nombreApellido = nombreApellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

}
