package ar.edu.unlam.rec220231c;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//import ar.edu.unlam.pb2.ClaveInexistenteException;

public class Cine {
	
	//EN Los cines hay 3 tipos de salas Proyectables , Tiendas, ProyectablesTiendas
	
	//No cambisar
	private Map<Integer,Pelicula> peliculas;
	
	
	
	//No pueden existir 2 Salas con el mismo nombre
	private Set<Sala> salas;



	private String nombre;
	
	public Cine(String nombre) {
		this.nombre=nombre;
		this.salas= new HashSet<>();
		this.peliculas= new HashMap<>();
	}
	/*
	 * Busca la sala Por nombre. y registra la venta en en dicha sala\
	 * en caso de no encontrar la tienda lanza una excpetion. 
	 * Las ventas solamente se registran en las salas Tienda y en las TiendasPreyectables. 
	 * Las salas Proyectables no registranventas. En caso que se quiera Asiganar una venta en estos tipos 
	 * de salas lanza una exception VentaSalaException  
	 */

	public Map<Integer, Pelicula> getPeliculas() {
		return peliculas;
	}




	public void setPeliculas(Map<Integer, Pelicula> peliculas) {
		this.peliculas = peliculas;
	}




	public Set<Sala> getSalas() {
		return salas;
	}




	public void setSalas(Set<Sala> salas) {
		this.salas = salas;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	




	/*
	 * busca la sala por nombre y registra La Venta
	 * 	en caso que se registre una venta en una sala de proyeccion lanza una exception SalaException

	 */
	public void registrarVentaAUnaSala(String nombre, Venta venta) throws salaInixistennteException, SalaException {
		Sala salaBuscada = buscarSala(nombre);
		if(!(salaBuscada instanceof iTienda)) {
			throw new SalaException();
		}
		
 		((iTienda)salaBuscada).registrarVenta(venta);
	}
	
	
	
	
	//Registrar Una pelicula en una sala donde se preyectan una Pelicula
	
	//Si el codigo Pelicula esta duplicado Lanza una Exception PeliculaExistenteExeption
	public void registrarPelicula(Integer codigo, Pelicula pelicula) throws PeliculaDuplicadaException {
		 if (peliculas.containsKey(codigo)) {
	            throw new PeliculaDuplicadaException();
	        }
	          peliculas.put(codigo, pelicula);
	    }
		
		
		
		
	


	
	

	/*
	 * registra Una sala
	 * No se pueden registrar 2 salas con el mismo nombre, en caso que este se repita lanza Una Exception 
	 * SalaDuplicadaException
	 * 
	 */
	public void registrarSala(Sala sala) throws SalaDuplicadaException {
		if(!salas.add(sala)) {
			throw new SalaDuplicadaException();
		}
	}


	/*
	 * Registra una pelicula en las salas de proyecciones
	 * en caso que la pelicula no existe lanza exception
	 * //en caso que se registre una pelicula en una sala de tienda lanza una exception SalaException
	 * en caso que la  sala no exista launa excpetion salaInixistennte xception
	 */


	public void registrarPeliculaAUnaSala(Integer codigoPelicula, String nombreSala) throws PeliculaInexistenteException, salaInixistennteException, NoEsUnaSalaDeProyeccionException  {
		Pelicula peliculaBuscada = buscarPelicula(codigoPelicula);
		Sala salaBuscada = buscarSala(nombreSala);
		if(esUnaSalaDeProyeccionDePeliculas(nombreSala) ) {
			((IProyectable)salaBuscada).asiganarPelicula(peliculaBuscada);
			
		}
		
		
		
	}




	private boolean esUnaSalaDeProyeccionDePeliculas(String nombreSala) throws NoEsUnaSalaDeProyeccionException {
		for(Sala salaBuscada : salas) {
			if(salaBuscada instanceof SalaProyeccion || salaBuscada instanceof ProyeccionTienda ) {
				return true;
			}
		}
		throw new NoEsUnaSalaDeProyeccionException();
		
	}




	private Sala buscarSala(String nombreSala)throws salaInixistennteException {
		for(Sala salasBuscada :salas) {
			if(salasBuscada.getNombre().equals(nombreSala)) {
				return salasBuscada;
			}
			
		}
			
		throw new salaInixistennteException();
	}




	private Pelicula buscarPelicula(Integer codigoPelicula) throws PeliculaInexistenteException {
		if(this.peliculas.get(codigoPelicula)== null) {
			throw new PeliculaInexistenteException();
		}
		return this.peliculas.get(codigoPelicula);
	}




	public Double obtenerEltotalDeVetasDeTodasLasConTiendas()  {
		Double totalDeVentas = 0.0;
		for(Sala salasConTienda : salas) {
			if(salasConTienda instanceof iTienda) {
				totalDeVentas += ((iTienda) salasConTienda).obtenerTotalDeVenta();
			}
		}
			
			return totalDeVentas;
		
	}




	public Integer cantidadDePeliculas() {
		
		return peliculas.size();
	}




	public Pelicula cantiadadDePeliculasEnSala(SalaProyeccion salaProyeccion) {
		
		return salaProyeccion.obtenerPeliculaQueSeProyecta();
	}



 
	

}
