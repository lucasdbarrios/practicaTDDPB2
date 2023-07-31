package ar.edu.unlam.pb2;

import java.util.Comparator;

public class OrdenPorApodos implements Comparator<Atracador>{
	@Override
	public int compare(Atracador atracador1, Atracador atracador2) {
		return atracador1.getApodo().compareTo(atracador2.getApodo());
	}
}
