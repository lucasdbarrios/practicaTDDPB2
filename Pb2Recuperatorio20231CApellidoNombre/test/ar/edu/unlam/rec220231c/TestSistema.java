package ar.edu.unlam.rec220231c;

import static org.junit.Assert.*;

import javax.swing.event.TreeSelectionEvent;

import org.junit.Test;

public class TestSistema {

	
	 
	@Test
	public void queSePuedaRegistrarUnaPelicula() throws PeliculaExistenteExeption {
		
		Cine cine = new Cine ("hoyts");
		Integer codigoPelicula = 1;
		String descripcion = "Duro De matar" ;  
		Integer duracion = 105; // minutos
		Integer id=1;
		
		Pelicula pelicula= new Pelicula (descripcion, duracion );
		cine.registrarPelicula(codigoPelicula, pelicula);
		
		assertEquals((Integer)1, cine.cantidadDePeliculas());
	}
	
	
	@Test(expected = PeliculaExistenteExeption.class )
	public void queAlRegistrarUnaPeliculaDuplicadaLanceUnaExpcionPeliculaDuplicadaException() throws PeliculaExistenteExeption {
		
		Cine cine = new Cine ("hoyts");
		Integer codigoPelicula = 1;
		String descripcion = "Duro De matar" ;  
		Integer duracion = 105; // minutos
		
		
		Pelicula pelicula= new Pelicula (descripcion, duracion);
		cine.registrarPelicula(codigoPelicula, pelicula);
	
		Pelicula pelicula2= new Pelicula ("Instinto", 95 );
	
		
		cine.registrarPelicula(codigoPelicula, pelicula2);
		
		 
	
	}
	
	@Test
	public void queSePuedaAsignarUnaPeliculaEnUnaSalaProyecciones() throws PeliculaExistenteExeption, SalaDuplicadaException, PeliculaInexistenteExeption, SalaException {
	

		Pelicula pelicula= new Pelicula ("Instinto", 95 );
		
		Cine cine = new Cine ("hoyts");
		
		String nombreSala= "sala 1";
		Integer idPelicula = 1;
		Sala salaProyeccion = new SalaProyeccion(nombreSala);
		cine.registrarPelicula(idPelicula, pelicula);
		cine.registrarSala(salaProyeccion);
		cine.registrarPeliculaAUnaSala(idPelicula, nombreSala);
		
		assertEquals(pelicula.getDescripcion(),((IProyectable)salaProyeccion).obtenerPeliculaQueSeProyecta().getDescripcion());
		
		
	}
	
	
	@Test
	public void queSePuedaAsignarUnaPeliculaEnUnaSalaProyecionTienda() throws PeliculaExistenteExeption, SalaDuplicadaException, PeliculaInexistenteExeption, SalaException {
	

		Pelicula pelicula= new Pelicula ("Instinto", 95 );
		Integer codigoPelicula =2;
		Cine cine = new Cine ("hoyts");
		
		String nombre= "sala 1";
		
		SalaTienda tienda=new SalaTienda("Tienda");
		Sala salaproyeccion = new SalaProyeccion("proyeccion");
		Sala salaProyecionTienda = new ProyeccionTienda(nombre,tienda,salaproyeccion);
		
		cine.registrarPelicula(codigoPelicula, pelicula);
			
		cine.registrarSala(salaProyecionTienda);
		
		cine.registrarPeliculaAUnaSala(codigoPelicula, nombre);
		
		assertEquals(pelicula,((IProyectable)salaProyecionTienda).obtenerPeliculaQueSeProyecta());;
		
		
	}
	
	
	@Test
	public void queSePuedaAlRegistrarUnaVentaEnSalaTienda() throws SalaException, SalaDuplicadaException {
		
		Cine cine = new Cine ("hoyts");
		
		String nombre= "sala 1";
		Sala salaTienda = new SalaTienda(nombre);
		
		cine.registrarSala(salaTienda);
		
		
		
		Integer numeroVenta =1;
		Double monto= 100d;
		Venta  venta = new Venta(numeroVenta, monto);
		cine.registrarVentaAUnaSala(nombre,venta);

		
		assertEquals(venta.getMonto(),((iTienda)salaTienda).obtenerTotalDeVenta());
		
		
		
	}

	
	@Test
	public void queSePuedaAlRegistrarUnaVentaEnSalaProyeccionTienda() throws SalaException, SalaDuplicadaException {
		
		Cine cine = new Cine ("hoyts");
		
		String nombresala= "sala 1";
		

		Sala tienda=new SalaTienda("Tienda");
		Sala salaproyeccion = new SalaProyeccion("proyeccion");
		Sala salaProyeccionTienda = new  ProyeccionTienda(nombresala,tienda,salaproyeccion);
	
		cine.registrarSala(salaProyeccionTienda);
		
		
		
		
		Integer numeroVenta =1;
		Double monto= 100d;
		Venta  venta = new Venta(numeroVenta, monto);
		cine.registrarVentaAUnaSala(nombresala,venta);
		

		
		assertEquals(venta.getMonto(), ((iTienda)salaProyeccionTienda).obtenerTotalDeVenta());
		
		
		
	}

	

	
	@Test
	public void queSePuedaAlRegistrarUnaPeliculasalaPoyeccionTienda() throws PeliculaExistenteExeption, SalaDuplicadaException, PeliculaInexistenteExeption, SalaException {
		
		
		Cine cine = new Cine ("hoyts");
		
		Integer codigoPelicula = 1;
		String descripcion = "Duro De matar" ;  
		Integer duracion = 105; // minutos
		Integer id=1;
		
		Pelicula pelicula= new Pelicula (descripcion, duracion );
		cine.registrarPelicula(codigoPelicula, pelicula);
				

		SalaTienda tienda=new SalaTienda("Tienda");
		SalaProyeccion salaproyeccion = new SalaProyeccion("proyeccion");
		
		String nombreSala ="sala Mixta";
		Sala salaProyeccionTienda = new  ProyeccionTienda(nombreSala ,tienda,salaproyeccion);
	
		cine.registrarSala(salaProyeccionTienda);
		
		cine.registrarPeliculaAUnaSala(codigoPelicula,nombreSala );
		assertEquals(pelicula,((IProyectable)salaProyeccionTienda).obtenerPeliculaQueSeProyecta());
		
		
	}
	
	
	@Test
	public void queSeCalculeCorrectamenteElTotalDeVentasDeTodasLasSalasDetipoTiendas() throws SalaDuplicadaException, SalaException {
	


		Cine cine = new Cine ("hoyts");
		
		String nombre= "sala Tienda";
		Sala salaTienda = new SalaTienda(nombre);
	
		cine.registrarSala(salaTienda);
		
	
		Integer numeroVenta =1;
		Double monto= 100d;
		Venta  venta = new Venta(numeroVenta, monto);
		cine.registrarVentaAUnaSala(nombre,venta);



		SalaTienda tienda=new SalaTienda("Tienda");
		SalaProyeccion salaproyeccion = new SalaProyeccion("proyeccion");
		
		String nombreProyeccionTienda ="salaMixta";
		Sala salaProyeccionTienda = new  ProyeccionTienda(nombreProyeccionTienda ,tienda,salaproyeccion);
	
		cine.registrarSala(salaProyeccionTienda);
	
	
		Integer numeroVenta2 =2;
		Double monto2= 300d;
		Venta  venta2 = new Venta(numeroVenta2, monto2);
		cine.registrarVentaAUnaSala(nombreProyeccionTienda,venta2);

		
  	
		Double valorEsperado = 400d;
		Double valorObtenido = cine.obtenerEltotalDeVetasDeTodasLasConTiendas();
		assertEquals(valorEsperado,valorObtenido);
		

	
	}
	
	@Test
	public void queSePuedaObtenerLasPeliculasQueSeProyectaEnTodasLasSalasOrdenasPorNombre() throws PeliculaExistenteExeption, SalaDuplicadaException, PeliculaInexistenteExeption, SalaException {
		
		Cine cine = new Cine ("hoyts");
		
		Integer codigoPelicula = 1;
		String descripcion = "b" ;  
		Integer duracion = 105; // minutos
		
		Integer codigoPelicula2 = 2;
		String descripcion2 = "a" ;  
		Integer duracion2 = 105; // minutos
		
		Integer codigoPelicula3 = 3;
		String descripcion3 = "d" ;  
		Integer duracion3 = 105; // minutos
		Integer id=1;
		
		Pelicula pelicula= new Pelicula (descripcion, duracion );
		cine.registrarPelicula(codigoPelicula, pelicula);
		
		Pelicula pelicula2= new Pelicula (descripcion2, duracion2 );
		cine.registrarPelicula(codigoPelicula2, pelicula2);
		
		Pelicula pelicula3= new Pelicula (descripcion3, duracion3 );
		cine.registrarPelicula(codigoPelicula3, pelicula3);
				
		
		String nombreDelaSala ="proyecta1";
		
		Sala salaproyeccion = new SalaProyeccion(nombreDelaSala); 
				
		cine.registrarSala(salaproyeccion);
		
		cine.registrarPeliculaAUnaSala(codigoPelicula, nombreDelaSala);
		
		
		String nombreDelaSala2 ="proyecta2";
		
		Sala salaproyeccion2 = new SalaProyeccion(nombreDelaSala2); 
				
		cine.registrarSala(salaproyeccion2);
		
		cine.registrarPeliculaAUnaSala(codigoPelicula2, nombreDelaSala2);
		
		
		String nombreDelaSala3 ="proyecta3";
		
		Sala salaproyeccion3 = new SalaProyeccion(nombreDelaSala3); 
				
		cine.registrarSala(salaproyeccion3);
		
		cine.registrarPeliculaAUnaSala(codigoPelicula3, nombreDelaSala3);
		
		
		  
		  
		assertEquals(pelicula2.getDescripcion(),cine.obtenerOrdenadasPeliculasQueSeProyectanEnTodasLasSalas(new OrdenDePelicula()).first().getDescripcion());
		
	}
	



}
