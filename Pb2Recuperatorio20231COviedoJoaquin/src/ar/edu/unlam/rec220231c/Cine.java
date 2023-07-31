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
		salas= new HashSet<>();
		peliculas= new HashMap<>();
		
	}




	/*
	 * busca la sala por nombre y registra La Venta
	 * 	en caso que se registre una venta en una sala de proyeccion lanza una exception SalaException

	 */
	public void registrarVentaAUnaSala(String nombreSala, Venta venta) throws SalanoencontradaException, VentalaException {
 		
		Sala salabuscada = BuscarSalapornombre(nombreSala);

		if(salabuscada instanceof iTienda) {
			
			((iTienda) salabuscada).registrarVenta(venta);
		}
		
		if(salabuscada instanceof SalaProyeccion) {
			throw new VentalaException("No se puede asignar una venta a una sala de proyeccion");
		}
		
	}
	
	
	
	
	//Registrar Una pelicula en una sala donde se preyectan una Pelicula
	//Si el codigo Pelicula esta duplicado Lanza una Exception PeliculaExistenteExeption
	public void registrarPelicula(Integer codigo, Pelicula pelicula) throws PeliculaDuplicadaException {
		
		if(peliculas.containsKey(codigo)) {
			throw new PeliculaDuplicadaException("La pelicula ya se encuentra registrada");
		}
		
		
		peliculas.put(codigo, pelicula);
		
		
		
	}


	
	

	/*
	 * registra Una sala
	 * No se pueden registrar 2 salas con el mismo nombre, en caso que este se repita lanza Una Exception 
	 * SalaDuplicadaException
	 * 
	 */
	public void registrarSala(Sala sala) throws SalayaregistradaException {
		
		if(salas.contains(sala)) {
			throw new SalayaregistradaException("Sala ya registrada");
		}
		salas.add(sala);
		
	}

	/*
	 * Registra una pelicula en las salas de proyecciones
	 * en caso que la pelicula no existe lanza exception
	 * en caso que la  sala no exista launa excpetion salaInixistennte xception
	 * 	//en caso que se registre una pelicula en una sala de tienda lanza una exception SalaException

	 */


	public void registrarPeliculaAUnaSala(Integer codigoPelicula, String nombreSala) throws SalanoencontradaException, PeliculaInExistenteException {
		// TODO Auto-generated method stub
		
		Sala salabuscada = BuscarSalapornombre(nombreSala);
		
		if(!(peliculas.containsKey(codigoPelicula))) {
			throw new PeliculaInExistenteException("La pelicula no exite");
		}
		
		if(salabuscada instanceof IProyectable) {
			
			((IProyectable) salabuscada).asiganarPelicula(peliculas.get(codigoPelicula));
		}
		
		
	}




	private Sala BuscarSalapornombre(String nombreSala) throws SalanoencontradaException {
		// TODO Auto-generated method stub
		
		for(Sala actual:salas) {
			if(actual.getNombre().equals(nombreSala)) {
				return actual;
			}
		}
		
		throw new SalanoencontradaException("Sala no encontrada");
		
	}




	public Double obtenerEltotalDeVetasDeTodasLasConTiendas() {
		// TODO Auto-generated method stub
		
		Double totaldeventasentodaslassala=0.0;
		
		for(Sala actual:salas) {
			if(actual instanceof iTienda) {
				totaldeventasentodaslassala=totaldeventasentodaslassala+((iTienda)actual).obtenerTotalDeVenta();
			}
		}
		
		
		return totaldeventasentodaslassala;
	}




	public Integer cantidaddepeliculasregistradas() {
		// TODO Auto-generated method stub
		return peliculas.size();
	}




	public TreeSet<Pelicula> obtenerpeliculasproyectadasordenadas() {
		// TODO Auto-generated method stub
		HashSet<Pelicula> peliculasasignadas = new HashSet<>();
		
		TreeSet<Pelicula> peliculasordenadaspornombre = new TreeSet<Pelicula>(new Orden_de_Peliculas());
		
		for(Sala actual:salas) {
			if(actual instanceof IProyectable) {
				
				
				peliculasasignadas.addAll(((IProyectable)actual).obtenerpeliculasasignadasproyectables());
				
				
			}
		}
		
		peliculasordenadaspornombre.addAll(peliculasasignadas);
		
		
		
		return peliculasordenadaspornombre;
	}



 
	

}
