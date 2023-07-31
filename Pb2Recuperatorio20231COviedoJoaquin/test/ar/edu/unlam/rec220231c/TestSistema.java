package ar.edu.unlam.rec220231c;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSistema {

	
	 
	@Test
	public void queSePuedaRegistrarUnaPelicula() throws PeliculaDuplicadaException {
		
		Cine cine = new Cine ("hoyts");
		Integer codigoPelicula = 1;
		String descripcion = "Duro De matar" ;  
		Integer duracion = 105; // minutos
		Integer id=1;
		
		Pelicula pelicula= new Pelicula (descripcion, duracion );
		cine.registrarPelicula(codigoPelicula, pelicula);
		
		assertEquals((Integer)1, cine.cantidaddepeliculasregistradas()   );
	}
	
	
	@Test (expected = PeliculaDuplicadaException.class)
	public void queAlRegistrarUnaPeliculaDuplicadaLanceUnaExpcionPeliculaDuplicadaException() throws PeliculaDuplicadaException {
		
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
	public void queSePuedaAsignarUnaPeliculaEnUnaSalaProyecciones() throws SalayaregistradaException, PeliculaDuplicadaException, SalanoencontradaException, PeliculaInExistenteException {
	

		Pelicula pelicula= new Pelicula ("Instinto", 95 );
	
		Cine cine = new Cine ("hoyts");
		
		String nombreSala= "sala 1";
		Sala salaProyeccion = new SalaProyeccion(nombreSala);
	
		
		
		cine.registrarSala(salaProyeccion);
		
		Integer codigoPelicula = 1;
		
		cine.registrarPelicula(codigoPelicula, pelicula);
		
		cine.registrarPeliculaAUnaSala(codigoPelicula,nombreSala);
		
		
		
		
		assertEquals(pelicula, ((IProyectable) salaProyeccion).obtenerPeliculaQueSeProyecta());
		
		
	}
	

	@Test
	public void queSePuedaAsignarUnaPeliculaEnUnaSalaProyecionTienda() throws PeliculaDuplicadaException, SalayaregistradaException, SalanoencontradaException, PeliculaInExistenteException {
	

		Pelicula pelicula= new Pelicula ("Instinto", 95 );
 	
		Cine cine = new Cine ("hoyts");
		
		String nombre= "sala 1";
		
		SalaTienda tienda=new SalaTienda("Tienda");
		SalaProyeccion salaproyeccion = new SalaProyeccion("proyeccion");
		Sala salaProyecionTienda = new ProyeccionTienda(nombre,tienda,salaproyeccion);
	
		cine.registrarSala(salaProyecionTienda);
		
		Integer codigoPelicula = 1;
		
		cine.registrarPelicula(codigoPelicula, pelicula);
		
		cine.registrarPeliculaAUnaSala(codigoPelicula,nombre);
		
		
		assertEquals(pelicula, ((IProyectable) salaProyecionTienda).obtenerPeliculaQueSeProyecta());
		
		
	}
	

	@Test
	public void queSePuedaAlRegistrarUnaVentaEnSalaTienda() throws SalanoencontradaException, SalayaregistradaException, VentalaException {
		
		Cine cine = new Cine ("hoyts");
		
		String nombre= "sala 1";
		Sala salaTienda = new SalaTienda(nombre);
	
		cine.registrarSala(salaTienda);
		
		
		
		Integer numeroVenta =1;
		Double monto= 100d;
		Venta  venta = new Venta(numeroVenta, monto);
		cine.registrarVentaAUnaSala(nombre,venta);

		
		assertEquals((Double)100d, ((iTienda) salaTienda).obtenerTotalDeVenta());
		
		
		
	}


	@Test
	public void queSePuedaAlRegistrarUnaVentaEnSalaProyeccionTienda() throws SalayaregistradaException, SalanoencontradaException, VentalaException {
		
		Cine cine = new Cine ("hoyts");
		
		String nombresala= "sala 1";
		

		SalaTienda tienda=new SalaTienda("Tienda");
		SalaProyeccion salaproyeccion = new SalaProyeccion("proyeccion");
		Sala salaProyeccionTienda = new  ProyeccionTienda(nombresala,tienda,salaproyeccion);
	
		cine.registrarSala(salaProyeccionTienda);
		
		
		
		Integer numeroVenta =1;
		Double monto= 100d;
		Venta  venta = new Venta(numeroVenta, monto);
		cine.registrarVentaAUnaSala(nombresala,venta);

		
		assertEquals((Double)100d, ((iTienda) salaProyeccionTienda).obtenerTotalDeVenta());

		
		
		
	}

	


	@Test
	public void queSePuedaAlRegistrarUnaPeliculasalaPoyeccionTienda() throws SalanoencontradaException, PeliculaInExistenteException, SalayaregistradaException, PeliculaDuplicadaException {
		
		
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
		assertEquals(pelicula, ((IProyectable) salaProyeccionTienda).obtenerPeliculaQueSeProyecta());

		
		
	}
	
	
	@Test
	public void queSeCalculeCorrectamenteElTotalDeVentasDeTodasLasSalasDetipoTiendas() throws SalayaregistradaException, SalanoencontradaException, VentalaException {
	


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
	public void queSePuedaObtenerLasPeliculasQueSeProyectaEnTodasLasSalasOrdenasPorNombre() throws PeliculaDuplicadaException, SalayaregistradaException, SalanoencontradaException, PeliculaInExistenteException {
		
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
		cine.registrarPeliculaAUnaSala(codigoPelicula,nombreSala);
		
		codigoPelicula = 2;
		descripcion = "Duro De matar 2" ;  
		duracion = 105; // minutos
		id=2;
		Pelicula pelicula2= new Pelicula (descripcion, duracion );
		cine.registrarPelicula(codigoPelicula, pelicula2);

		cine.registrarPeliculaAUnaSala(codigoPelicula,nombreSala);

		

		assertEquals(pelicula, cine.obtenerpeliculasproyectadasordenadas().first());
		assertEquals(pelicula2, cine.obtenerpeliculasproyectadasordenadas().last());

		
	}
	



}
