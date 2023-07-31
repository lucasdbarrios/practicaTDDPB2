package ar.edu.unlam.pb2;

public class Banco {
	
	private String nombre;
	private Integer idBanco;

	public Banco(Integer idBanco, String nombre) {

		this.idBanco=idBanco;
		this.nombre=nombre;
	}

	public int getIdBanco() {
		// TODO Auto-generated method stub
		return idBanco;
	}

}
