package ar.edu.unlam.pb2;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.hamcrest.core.IsInstanceOf;

public class Vigilancia {

	private String nombreCompania;

	// Colocar el tipo de coleccion que corresponda
	private Set<Persona> personas;
	// Colocar el tipo de coleccion que corresponda
	private Set<Banco> bancos;
	//No se puede cambiar 
	private Map <Integer, Atraco> atracos;
	
	
	public Vigilancia(String nombreCompania) {
		 this.nombreCompania = nombreCompania;
	     this.bancos = new HashSet<>();
	     this.personas = new HashSet<>();
	     this.atracos = new HashMap<>();
		
	}
	

	

	/*
	 * Registra tanto como Vigiladores como atracadores no permite registrar 2
	 * personas con el mismo DNI. Si esto sucede lanza una exception
	 * PersonaDuplicadaException
	 * 
	 */

	  public Boolean registrarPersona(Persona persona) throws PersonaDuplicadaException {
//	        for (Persona personaEnViigilancia : personas) {
//	            if (personaEnViigilancia.getDni().equals(persona.getDni())) {
//	                throw new PersonaDuplicadaException();
//	            }
//	        }
		  if (personas.contains(persona)) {
	            throw new PersonaDuplicadaException();
	        }
	        
	        return personas.add(persona);
	    }
	
	
	public Integer cantidadDePersonasRegistradas()  {
		return personas.size();

		
		
	}
	
	public Boolean agregarBanco(Banco banco) {
		return bancos.add(banco);
	}

	/*
	 * Este Metodo lanza las siguientes Excepciones NoSeEncuentraAtracadorException
	 * BancoNoEncontradoExcecption
	 * 
	 */
	
	  public void registrarAtraco(int dni, int idBanco) {
		  Atracador atracador = buscarPersonaPorDni(dni);
	        Banco banco = buscarBancoPorId(idBanco);
	        Atraco atraco = new Atraco(atracador, banco);
	        atracos.put(atraco.getClaveAtraco(), atraco);
	    }

	    public Atraco buscarAtracoPorClave(int claveAtraco) {
	        return atracos.get(claveAtraco);
	    }

	    private Persona buscarPersonaPorDni(int dni) {
	        
	    	for (Persona persona : personas) {
	            if (persona.getDni() == dni ) {
	                return persona;
	            }
	        }
	        return null;
	    }

	    	
	    private Banco buscarBancoPorId(int idBanco) {
	        for (Banco banco : bancos) {
	            if (banco.getIdBanco() == idBanco) {
	                return banco;
	            }
	        }
	        return null;
	    }



	//Si la clave no existe lanza ClaveInexistenteException
	public Atraco buscarAtracoPorClave(Integer claveAtraco) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public Vigilante obtenerElVigiladorDeUnAtraco(Integer claveAtraco) {

		
		Vigilante vigilante;
		
		
		
		return vigilante;
		
		
		
	}

	
	public Set<Atracador> obtenerAtracadoresOrdenados(OrdenPorApodos ordenPorApodo ){
		
		Set<Atracador> atracadoresOrdenadados;
		
		
		return atracadoresOrdenadados;
	}
	
	

}
