package ar.edu.unlam.pb2.eva03;

import java.awt.Event;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeEvento;

public class Club {

	
	private String nombre;
	private Set<Deportista> socios;
	private Map<String, Evento> competencias;
	
	public Club(String nombre) {
		this.nombre=nombre;
		this.socios= new HashSet<>();
		this.competencias=new HashMap<>();
		
	}

	public void agregarDeportista(Deportista nuevoDeportista) throws SocioExistenteException {
		
		if(socios.contains(nuevoDeportista)){
			throw new SocioExistenteException();
		}
		socios.add(nuevoDeportista);
	}

	public Integer getCantidadSocios() {
		// TODO Auto-generated method stub
		return this.socios.size();
	}

	public void crearEvento(TipoDeEvento tipoEvento, String nombreDelEvento) {
		Evento nuevoEvento = new Evento(tipoEvento);
		competencias.put(nombreDelEvento, nuevoEvento);
		
		
	}

	public Integer inscribirEnEvento(String nombreDelEvento, Deportista deportistaInscripto) throws NoEstaPreparado {
		Evento eventoBuscado = BuscarCompetenciaPorNombre(nombreDelEvento);
		return eventoBuscado.agregarParticipanteAlEvento(deportistaInscripto);
		
		
		
	}

	private Evento BuscarCompetenciaPorNombre(String nombreDelEvento) {
//		if(competencias.get(nombreDelEvento) == null){
//			throw new EventoInexistenteException();
//		}
		
		return competencias.get(nombreDelEvento);
	}
}
