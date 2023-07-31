package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeEvento;
import ar.edu.unlam.pb2.eva03.interfaces.ICiclista;
import ar.edu.unlam.pb2.eva03.interfaces.ICorredor;
import ar.edu.unlam.pb2.eva03.interfaces.INadador;

public class Evento {

	private TipoDeEvento tipo;
	private Integer numeroDeInscripcion;
	private Map<Integer, Deportista> participantes;
	
	public Evento(TipoDeEvento tipo) {
		this.tipo=tipo;
		this.participantes=new HashMap<>();
		this.numeroDeInscripcion=1;
		
	}

	public TipoDeEvento getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeEvento tipo) {
		this.tipo = tipo;
	}

	public Integer getNumeroDeInscripcion() {
		return numeroDeInscripcion;
	}

	public void setNumeroDeInscripcion(Integer numeroDeInscripcion) {
		this.numeroDeInscripcion = numeroDeInscripcion;
	}

	public Map<Integer, Deportista> getParticipantes() {
		return participantes;
	}

	public Integer agregarParticipanteAlEvento(Deportista nuevoParticipante) throws NoEstaPreparado {
		switch (tipo) {
		case 	CARRERA_5K:
		case 	CARRERA_10K:
		case	CARRERA_21K:
		case	CARRERA_42K:
						if(!(nuevoParticipante instanceof ICorredor)) {
							throw new NoEstaPreparado();
						}
							
			break;
		case 	DUATLON:
			if((!(nuevoParticipante instanceof ICorredor))
					|| !(nuevoParticipante instanceof ICiclista))  {
				throw new NoEstaPreparado();
			}
			break;
		case 	CARRERA_NATACION_EN_PICINA:
		case 	CARRERA_NATACION_EN_AGUAS_ABIERTAS:
					if(!(nuevoParticipante instanceof INadador))  {
						throw new NoEstaPreparado();
			}
			break;
		case 	TRIATLON_SHORT:
		case 	TRIATLON_OLIMPICO:
		case 	TRIATLON_MEDIO:
		case 	TRIATLON_IRONMAN:
					if((!(nuevoParticipante instanceof ICorredor))
							||!(nuevoParticipante instanceof ICiclista)
							||!(nuevoParticipante instanceof INadador))  {
							throw new NoEstaPreparado();
					}
			break;

		
		}
		participantes.put(numeroDeInscripcion, nuevoParticipante);
		numeroDeInscripcion ++ ;
		return participantes.size();
	}
	
	
}
