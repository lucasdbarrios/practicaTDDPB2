package ar.edu.unlam.rec220231c;

public class Pelicula {

	private String descripcion;
	private Integer duracion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Pelicula( String descripcion, Integer duracion) {
		// TODO Auto-generated constructor stub
		
		this.descripcion=descripcion;
		this.duracion=duracion;
	}


}
