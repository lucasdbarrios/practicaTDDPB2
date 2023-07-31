package ar.unlam.edu.ar;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.TreeSet;

import org.junit.Test;

public class TestComaniaTransporte {

	@Test
	public void queSePuedaRegistrarUnViaje() throws ViajeExistenteException, TransporteException {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Integer cantidadPasajerosMaximos = 50;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Boolean valorObtenido = empresa.getViajes().containsValue(viaje);
		assertTrue(valorObtenido);

	}

	@Test
	public void queSePuedaRegistrarUnTicketDePasajeroAUnViaje() throws ViajeExistenteException, TransporteException, ViajeInexistenteException, PasajeroExistenteException, TipoTicketInvalidoExcption, CantidadPasajeroSobrepasadaException {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Integer cantidadPasajerosMaximos = 50;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		Pasajero pasajero2 = new Pasajero(2, apellido);
		
		
		// Completar Test
		assertTrue(empresa.registrarTicketPasajero(numeroViaje, pasajero));
		assertTrue(empresa.registrarTicketPasajero(numeroViaje, pasajero));
		
	}

	@Test (expected = TransporteException.class)
	public void queAlRegistrarUnTicketDePasajeroAUnViajeConMedioDeTransporteDeCargaLanceUnaException() throws ViajeExistenteException, TransporteException, ViajeInexistenteException, PasajeroExistenteException, TipoTicketInvalidoExcption, CantidadPasajeroSobrepasadaException {

		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;
		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;

		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		empresa.registrarTicketPasajero(numeroViaje, pasajero);

		// Completar test

	}

	@Test
	public void queSePuedaRegistrarUnTicketDeCargaAUnViaje() throws ViajeInexistenteException, TransporteException, ViajeExistenteException, CapacidadExcedidaException, TipoTicketInvalidoExcption {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;
		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);
		empresa.registrarViaje(viaje);
		Integer numeroViaje = 1;
 
		// Completar Test
		assertTrue(empresa.registrarTicketcarga(numeroViaje, new Carga(1, 10.0)));
		
	}

	@Test
	public void queSePuedaRegistrarUnTicketMixtoAUnViaje() throws ViajeExistenteException, TransporteException, ViajeInexistenteException, CantidadPasajeroSobrepasadaException, CapacidadExcedidaException, PasajeroExistenteException, TipoTicketInvalidoExcption {

		// No modificar este test.
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";



		Double cargaMaxima = 50.0;

		Integer cantidadPasajerosMaximos = 50;

		MedioTransporte medioTransporte = new TransporteMixto(Patente, cantidadPasajerosMaximos,cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		Integer dni = 2222;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		Carga carga=new Carga(1, 10.0);
		assertTrue(empresa.registrarTicketMixto(numeroViaje, pasajero,carga));
		
		

		// Completar Test

	}

	@Test(expected = CapacidadExcedidaException.class)
	public void queAlRegistrarUnticketYExcedalaCargaMaximaDelTransporteLanceUnaExceptionCapacidadExcedidaException() throws ViajeInexistenteException, TransporteException, CapacidadExcedidaException, ViajeExistenteException, TipoTicketInvalidoExcption {
		// Desarrollar test
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Double cargaMaxima = 50.0;
		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);
		empresa.registrarViaje(viaje);
		Integer numeroViaje = 1;
 
		// Completar Test
		empresa.registrarTicketcarga(numeroViaje, new Carga(1, 60.0));
	}

	@Test
	public void queSePuedaObtenerUnaListaPasajeroDeUnViajeOrdenadoPorDNIDescendiente() throws ViajeExistenteException, TransporteException, ViajeInexistenteException, PasajeroExistenteException, TipoTicketInvalidoExcption, CantidadPasajeroSobrepasadaException {
		// Desarrollar test
		// Debe invcar el Metodo obtenerListaPasajeroOrdenadosPorDNIDescendiente(Integer
		// numeroViaje) y este retorna un Treeset <Pasajero>

		Empresa empresa = new Empresa("UnlamTravel");
		
		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";

		String Patente = "ac111jr";

		Integer cantidadPasajerosMaximos = 50;
		MedioTransporte medioTransporte = new TransportePasajero(Patente, cantidadPasajerosMaximos);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);

		empresa.registrarViaje(viaje);

		Integer numeroViaje = 1;
		Integer dni = 3333;
		String apellido = "perez";
		Pasajero pasajero = new Pasajero(dni, apellido);
		
		Integer dni2 = 2222;
		String apellido2 = "andariel";
		Pasajero pasajero2 = new Pasajero(dni2, apellido2);
		
		Integer dni3 = 4444;
		String apellido3 = "berez";
		Pasajero pasajero3 = new Pasajero(dni3, apellido3);
		
		// Completar Test
		empresa.registrarTicketPasajero(numeroViaje, pasajero);
		empresa.registrarTicketPasajero(numeroViaje, pasajero2);
		empresa.registrarTicketPasajero(numeroViaje, pasajero3);
		
		assertEquals(dni2, empresa.obtenerListaPasajeroOrdenadosPorDNIDescendiente(numeroViaje).first().getDni());
		assertEquals(dni3, empresa.obtenerListaPasajeroOrdenadosPorDNIDescendiente(numeroViaje).last().getDni());
	}
	
	@Test
	public void queSePuedaObtenerElTotalDeCargasTransportada() throws ViajeExistenteException, TransporteException, ViajeInexistenteException, CapacidadExcedidaException, TipoTicketInvalidoExcption {
		Empresa empresa = new Empresa("UnlamTravel");

		LocalDateTime salida = LocalDateTime.of(2023, 07, 20, 19, 00);
		LocalDateTime llegada = LocalDateTime.of(2023, 07, 21, 0, 30);
		String origen = "Buenos Aires";
		String destino = "Mardel Plata";
		
		LocalDateTime salida2 = LocalDateTime.of(2023, 07, 21, 19, 00);
		LocalDateTime llegada2 = LocalDateTime.of(2023, 07, 21, 1, 30);
		String origen2 = "Buenos Aires";
		String destino2 = "Mardel Plata";

		String Patente = "ac111jr";
		String Patente2 = "ac111je";
		String Patente3 = "ac111jt";

		Double cargaMaxima = 50.0;
		MedioTransporte medioTransporte = new TransporteCarga(Patente, cargaMaxima);
		MedioTransporte medioTransporte2 = new TransporteCarga(Patente2, cargaMaxima);
		MedioTransporte medioTransporte3 = new TransporteCarga(Patente3, cargaMaxima);

		Viaje viaje = new Viaje(salida, llegada, origen, destino, medioTransporte);
		Viaje viaje2 = new Viaje(salida2, llegada2, origen2, destino2, medioTransporte2);
		Viaje viaje3 = new Viaje(salida, llegada, origen, destino, medioTransporte3);
		empresa.registrarViaje(viaje);
		empresa.registrarViaje(viaje2);
		empresa.registrarViaje(viaje3);
		
		Integer numeroViaje = 1;
		Integer numeroViaje2 = 2;
		Integer numeroViaje3 = 3;
 
		// Completar Test
		empresa.registrarTicketcarga(numeroViaje, new Carga(1, 10.0));
		empresa.registrarTicketcarga(numeroViaje2, new Carga(2, 20.0));
		empresa.registrarTicketcarga(numeroViaje3, new Carga(3, 30.0));
		
		assertEquals((Double)60.0, empresa.obtenerELTotalDeCargaTransportadaEnTodosLosViajes());

	}
	
}
