package ar.unlam.edu.ar;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMediosTransportes {

	@Test
	public void queSepuedaCrearMedioTransportePasajero() {
 
		Integer cantidadPasajerosMaximos=50;
		String patente = "AB123CD";
		MedioTransporte pasajero = new TransportePasajero (patente,cantidadPasajerosMaximos); 
		assertEquals("AB123CD", ((TransportePasajero)pasajero).getPatente());
		assertEquals(cantidadPasajerosMaximos, ((TransportePasajero)pasajero).obtenerCantidadMaximaPasajero());
	}
	
	@Test
	public void queSepuedaCrearMedioTransporteCarga() {

		Double cargaMaxima = 1000.0;
		String patente = "987RT";
		MedioTransporte transporteCarga = new TransporteCarga (patente,cargaMaxima); 
		assertEquals("987RT", ((TransporteCarga)transporteCarga).getPatente());
		assertEquals(cargaMaxima, ((TransporteCarga)transporteCarga).obtenerCantidadMaximaPeso());
	}


	@Test
	public void queSepuedaCrearMedioTransportMixto() {


		Integer cantidadPasajerosMaximos=50;
		Double cargaMaxima = 1000.0;
		String patente = "987RT";
		Double nuevaCargaMaxima = 1010.0;
		MedioTransporte transporteCarga = new TransporteMixto (patente,cantidadPasajerosMaximos,cargaMaxima);
		
		assertEquals("987RT", ((TransporteMixto)transporteCarga).getPatente());
		assertEquals(cargaMaxima, ((TransporteMixto)transporteCarga).obtenerCantidadMaximaPeso());
		assertEquals(cantidadPasajerosMaximos, ((TransporteMixto)transporteCarga).obtenerCantidadMaximaPasajero());
	
		
	}


}
