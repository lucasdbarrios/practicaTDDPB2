package ar.edu.unlam.rec220231c;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Cine {
	
	//EN Los cines hay 3 tipos de salas Proyectables , Tiendas, ProyectablesTiendas
	
	//No cambisar
	private Map<Integer,Pelicula> peliculas;
	
	
	
	//No pueden existir 2 Salas con el mismo nombre
	private Set<Sala> salas;



	private String nombre;
	
	
	/*
	 * Busca la sala Por nombre. y registra la venta en en dicha sala\
	 * en caso de no encontrar la tienda lanza una excpetion. 
	 * Las ventas solamente se registran en las salas Tienda y en las TiendasPreyectables. 
	 * Las salas Proyectables no registranventas. En caso que se quiera Asiganar una venta en estos tipos 
	 * de salas lanza una exception VentaSalaException  
	 */

	public Cine(String nombre) {
		this.nombre=nombre;
		this.peliculas=new HashMap<>();
		this.salas=new HashSet<>();
		
	}




	/*
	 * busca la sala por nombre y registra La Venta
	 * 
	 * 	en caso que se registre una venta en una sala de proyeccion lanza una exception SalaException

	 */
	public void registrarVentaAUnaSala(String nombre, Venta venta) throws SalaException {
		Sala salaBuscada = buscarSalaPorCodigo(nombre);
		if(!(salaBuscada instanceof iTienda)) {
			throw new SalaException ();
		
		}
		((iTienda)salaBuscada).registrarVenta(venta);
	}
	
	
	
	
	//Registrar Una pelicula en una sala donde se preyectan una Pelicula

	//Si el codigo Pelicula esta duplicado Lanza una Exception PeliculaExistenteExeption
	public void registrarPelicula(Integer codigo, Pelicula pelicula) throws PeliculaExistenteExeption {
		
		if(peliculas.containsKey(codigo)) {
			throw new PeliculaExistenteExeption();
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
		if(salas.contains(sala)) {
			throw new SalaDuplicadaException();
		}
		salas.add(sala);
		
	}


	/*
	 * Registra una pelicula en las salas de proyecciones
	 * en caso que la pelicula no existe lanza exception
	 * 	//en caso que se registre una pelicula en una sala de tienda lanza una exception SalaException
	 * en caso que la  sala no exista launa excpetion salaInixistennte xception
	 */


	public void registrarPeliculaAUnaSala(Integer codigoPelicula, String nombreSala) throws PeliculaInexistenteExeption, SalaException {
		Pelicula peliculaBuscada = buscarPeliculaPorCodigo(codigoPelicula);
		Sala salaBuscada = buscarSalaPorCodigo(nombreSala);
		if(!(salaBuscada instanceof IProyectable)) {
			throw new SalaException();
		}
			
		((IProyectable)salaBuscada).asiganarPelicula(peliculaBuscada);
			
	}




	private Sala buscarSalaPorCodigo(String nombreSala) throws SalaException {
		for (Sala estaSala : salas) {
			if(estaSala.getNombre().equals(nombreSala)){
			return estaSala;
		}
		
	}
		throw new SalaException();
	}




	private Pelicula buscarPeliculaPorCodigo(Integer codigoPelicula) throws PeliculaInexistenteExeption {
		if(peliculas.get(codigoPelicula) == null) {
			throw new PeliculaInexistenteExeption();
		}
		return peliculas.get(codigoPelicula);
				
		
	}




	public Double obtenerEltotalDeVetasDeTodasLasConTiendas() {
	 Double totaDeTotales=0.0;
	 for(Sala salaConTienda : salas) {
		 if(salaConTienda instanceof iTienda)
			totaDeTotales += ((iTienda)salaConTienda).obtenerTotalDeVenta();
	 }
		return totaDeTotales;
	}




	public Integer cantidadDePeliculas() {
		
		return this.peliculas.size();
	}




	public TreeSet<Pelicula> obtenerOrdenadasPeliculasQueSeProyectanEnTodasLasSalas(OrdenDePelicula peliculasEnSalas) {
		TreeSet<Pelicula> peliculasOrdenadas = new TreeSet<Pelicula>(peliculasEnSalas);
		HashSet<Pelicula> buscarPeliculasYaEnSala = buscarPeliculasEnSalaFiltrado();
		peliculasOrdenadas.addAll(buscarPeliculasYaEnSala);
		
		return peliculasOrdenadas;
	}




	private HashSet<Pelicula> buscarPeliculasEnSalaFiltrado() {
		HashSet<Pelicula> peliculaDeSala = new HashSet<>();
		for(Sala salas :salas)
			if(salas instanceof IProyectable) {
				peliculaDeSala.add(((IProyectable)salas).obtenerPeliculaQueSeProyecta());
			}
		return peliculaDeSala;
	}



 
	

}
