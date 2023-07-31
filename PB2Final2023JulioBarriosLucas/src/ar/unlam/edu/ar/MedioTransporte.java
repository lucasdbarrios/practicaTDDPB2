package ar.unlam.edu.ar;

import java.util.Objects;

public class MedioTransporte {

	
	@Override
	public int hashCode() {
		return Objects.hash(patente);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		MedioTransporte other = (MedioTransporte) obj;
		return Objects.equals(patente, other.patente);
	}

	private String patente;

	public MedioTransporte (String patente) {
		this.patente=patente;
	}
	
	
	

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	
	
}
