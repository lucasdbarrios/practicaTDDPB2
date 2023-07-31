package ar.edu.unlam.pb2;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Vigilancia {

	private String nombre;

	// Colocar el tipo de coleccion que corresponda
	private Set<Persona> personas;
	// Colocar el tipo de coleccion que corresponda
	private Set<Banco> bancos;

	public Vigilancia(String nombre) {
		this.nombre = nombre;
		this.bancos = new HashSet<>();
		this.personas = new HashSet<>();
		this.atracos = new HashMap<>();
	}

	// No se puede cambiar
	private Map<Integer, Atraco> atracos;

	/*
	 * Registra tanto como Vigiladores como atracadores no permite registrar 2
	 * personas con el mismo DNI. Si esto sucede lanza una exception
	 * PersonaDuplicadaException
	 * 
	 */

	public void registrarPersona(Persona persona) throws PersonaDuplicadaException {
		if (!this.personas.add(persona)) {
			throw new PersonaDuplicadaException();
		}
	}

	public void agregarBanco(Banco banco) {
		this.bancos.add(banco);
	}

	/*
	 * Este Metodo lanza las siguientes Excepciones NoSeEncuentraAtracadorException
	 * BancoNoEncontradoExcecption
	 * 
	 */

	public void registrarAtraco(Integer dniAtracador, Integer idBanco) throws NoSeEncuentraAtracadorException,BancoNoEncontradoExcecption{
	Atracador atracador = buscarAtracador(dniAtracador);
	Banco banco = buscarBanco(idBanco);
	Atraco atraco = new Atraco (atracador,banco);		
	//Se debe agregar un atraco al Mapa
	Integer idAtraco = this.atracos.size()+1;
	this.atracos.put(idAtraco, atraco);
	}

	private Banco buscarBanco(Integer idBanco) throws BancoNoEncontradoExcecption {
		for (Banco banco : bancos) {
			if (banco.getIdBanco().equals(idBanco)) {
				return banco;
			}
		}
		throw new BancoNoEncontradoExcecption();
	}

	private Atracador buscarAtracador(Integer dniAtracador) throws NoSeEncuentraAtracadorException {
		for (Persona persona : personas) {
			if (persona.getDni().equals(dniAtracador) && persona instanceof Atracador) {
				return (Atracador) persona;
			}
		}
		throw new NoSeEncuentraAtracadorException();
	}

	// Si la clave no existe lanza ClaveInexistenteException
	public Atraco buscarAtracoPorClave(Integer claveAtraco) throws ClaveInexistenteException{
		if (this.atracos.get(claveAtraco) == null) {
			throw new ClaveInexistenteException();
		}
		return this.atracos.get(claveAtraco);
	}

	public Vigilante obtenerElVigiladorDeUnAtraco(Integer claveAtraco) throws ClaveInexistenteException, VigilanteNoEncontradoException {
		Atraco atraco = buscarAtracoPorClave(claveAtraco);
		Banco banco = atraco.getBanco();
		Vigilante vigilante = buscarVigilantePorBanco(banco);

		return vigilante;

	}

	private Vigilante buscarVigilantePorBanco(Banco banco) throws VigilanteNoEncontradoException {
		for (Persona vigilante : personas) {
			if (vigilante instanceof Vigilante && ((Vigilante) vigilante).getBanco().equals(banco)) {
				return (Vigilante) vigilante;
			}
		}
		throw new VigilanteNoEncontradoException();
	}

	public TreeSet<Atracador> obtenerAtracadoresOrdenados(OrdenPorApodos ordenPorApodo) {

		TreeSet<Atracador> atracadoresOrdenadados = new TreeSet<Atracador>(ordenPorApodo);
		Set<Atracador> atracadores = filtrarAtracadores();
		atracadoresOrdenadados.addAll(atracadores);
		return atracadoresOrdenadados;
	}

	private Set<Atracador> filtrarAtracadores() {
		Set<Atracador> atracadores = new HashSet<>();
		for (Persona atracador : personas) {
			if (atracador instanceof Atracador) {
				atracadores.add((Atracador) atracador);
			}
		}
		return atracadores;
	}

	public Integer cantidadDeBancos() {
		return this.bancos.size();
	}

	public Integer obtenerCantidadAtracadores() {
		Integer cantidadDeAtracadores = 0;
		for (Persona persona : personas) {
			if (persona instanceof Atracador) {
				cantidadDeAtracadores++;
			}
		}
		return cantidadDeAtracadores;
	}

}
