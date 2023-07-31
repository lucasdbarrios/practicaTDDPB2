package ar.unlam.edu.ar;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Empresa {

	private String nombre;
	private Map<Integer, Viaje> viajes;
	private Integer numeroViaje;
	private Integer numeroTicket;

	// Se registran todas las ventas de pasajes de los pasajeros
	private Set<Ticket> tickets;

	public Empresa(String nombre) {
		this.nombre = nombre;
		this.viajes=new HashMap<>();
		this.tickets=new HashSet<>();
		this.numeroViaje=0;
		this.numeroTicket=0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<Integer, Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(Map<Integer, Viaje> viajes) {
		this.viajes = viajes;
	}

	/*
	 * Registra Un Nuevo viaje se debe guardar en un mapa donde la Key es un entero
	 * y es autoincremental arrancando de 0
	 */
	public void registrarViaje(Viaje viaje) throws ViajeExistenteException,TransporteException {
		if(viajes.containsKey(numeroViaje)) {
			throw new ViajeExistenteException();
		}
		numeroViaje ++;
		viajes.put(numeroViaje, viaje);
		
	}

	/*
	 * Registra Un ticket para carga TicketCarga.class 
	 * Si el viaje no admite Carga lanza TipoTicketInvalidoExcption
	 *  si supera El peso maximo que soporta el   medioTransprte Lanza Una exception CapacidadExcedidaException
	 */

	public Boolean registrarTicketcarga(Integer numeroViaje, Carga carga) throws ViajeInexistenteException, TransporteException, CapacidadExcedidaException, TipoTicketInvalidoExcption {
		Viaje viajeBuscado = buscarViaje(numeroViaje);
		mediodeTransporteCargaCorrecto(viajeBuscado);
		hayEspacioParaMeterMasPeso(viajeBuscado,carga);
		numeroTicket ++;
		Ticket nuevoTiket = new TicketCarga(numeroTicket,obtenerPesoDeCarga(carga));
		viajeBuscado.ingresarTicketDelViaje(nuevoTiket);
		return tickets.add(nuevoTiket);
	}
	

	private Double obtenerPesoDeCarga(Carga carga) {
		// TODO Auto-generated method stub
		return carga.getPeso();
	}

	private void hayEspacioParaMeterMasPeso(Viaje viajeBuscado, Carga carga) throws CapacidadExcedidaException {
		
		if( obtenerCargaMaximaDelViaje(viajeBuscado) <  obtenerPesoDeCarga(carga)) {
			throw new CapacidadExcedidaException();
		}
		
	}

	private Double obtenerCargaMaximaDelViaje(Viaje viajeBuscado) {
		if(viajeBuscado.getMedioTransporte() instanceof TransporteMixto) {
			return ((TransporteMixto)viajeBuscado.getMedioTransporte()).obtenerCantidadMaximaPeso();
		}
		return ((TransporteCarga)viajeBuscado.getMedioTransporte()).obtenerCantidadMaximaPeso();
	}

	private void mediodeTransporteCargaCorrecto(Viaje viajeBuscado) throws TransporteException {
		if(!(viajeBuscado.getMedioTransporte() instanceof iCargable)){
			throw new TransporteException();
		}
		
	}

	/*
	 * Se registra un TicketPasajero TicketPasajero 
	 * Si el viaje no admite pasajeros lanza TipoTicketInvalidoExcption 
	 * si supera la cantidad de pasajero que soporta el medioTransprte Lanza Una exception CantidadPasajeroSobrepasadaException
	 */

	public Boolean registrarTicketPasajero(Integer numeroViaje, Pasajero pasajero) throws TransporteException,ViajeInexistenteException, PasajeroExistenteException, TipoTicketInvalidoExcption, CantidadPasajeroSobrepasadaException {
			
		Viaje viajeBuscado = buscarViaje(numeroViaje);
		mediodeTransporteViajeCorrecto(viajeBuscado);
		hayEspacioParaRegistrarUnNuevoTicketPasajero(viajeBuscado);
		numeroTicket ++;
		Ticket nuevoTiket = new TicketPasajero(numeroTicket,pasajero);
		viajeBuscado.ingresarTicketDelViaje(nuevoTiket);	
		return tickets.add(nuevoTiket);
		
	}
	

	

	private void hayEspacioParaRegistrarUnNuevoTicketPasajero(Viaje viajeBuscado) throws CantidadPasajeroSobrepasadaException {
		 if( cantidadDePasajerosPermitidosEnElViaje(viajeBuscado) < cantidadDeVoletosVendidos(viajeBuscado)) {
			throw new CantidadPasajeroSobrepasadaException();
		}
		
	}

	private Integer cantidadDePasajerosPermitidosEnElViaje(Viaje viajeBuscado) {
		if(viajeBuscado.getMedioTransporte() instanceof TransporteMixto) {
			return((TransporteMixto)viajeBuscado.getMedioTransporte()).obtenerCantidadMaximaPasajero();
		}
		return ((TransportePasajero)viajeBuscado.getMedioTransporte()).obtenerCantidadMaximaPasajero();
	}

	private void mediodeTransporteViajeCorrecto(Viaje viajeBuscado) throws TransporteException {
		if(!(viajeBuscado.getMedioTransporte() instanceof ITransportable)){
			throw new TransporteException();
		}
		
	}

	private Integer cantidadDeVoletosVendidos(Viaje viajeBuscado) {
		// TODO Auto-generated method stub
		return viajeBuscado.cantidadDePasajerosEnElViaje();
	}

	private Viaje buscarViaje(Integer numeroViaje) throws ViajeInexistenteException {
			if(!(viajes.containsKey(numeroViaje))) {
				throw new ViajeInexistenteException();
			}
			
			
		return viajes.get(numeroViaje);
	}

	/*
	 * Se registra un TicketMixto TicketMixto.class  
	 * si supera la cantidad de pasajero que soporta el medioTransprte Lanza Una exception CantidadPasajeroSobrepasadaException
	 * si supera El peso maximo que soporta el   medioTransprte Lanza Una exception CapacidadExcedidaException
	 */

	public boolean registrarTicketMixto(Integer numeroViaje, Pasajero pasajero,Carga carga) throws ViajeInexistenteException, TransporteException, CantidadPasajeroSobrepasadaException, CapacidadExcedidaException, PasajeroExistenteException, TipoTicketInvalidoExcption {
		Viaje viajeBuscado = buscarViaje(numeroViaje);
		mediodeTransporteCargaCorrecto(viajeBuscado);
		mediodeTransporteViajeCorrecto(viajeBuscado);
		hayEspacioParaRegistrarUnNuevoTicketPasajero(viajeBuscado);
		hayEspacioParaMeterMasPeso(viajeBuscado, carga);
		numeroTicket ++;
		Ticket nuevoTiket = new TicketMixto(numeroTicket,pasajero,carga);
		viajeBuscado.ingresarTicketDelViaje(nuevoTiket);
		
		return tickets.add(nuevoTiket);

	}


	
	
	
	
	
	
	private void mediodeTransporteMixtoCorrecto(Viaje viajeBuscado) throws TransporteException {
		if(!(viajeBuscado.getMedioTransporte() instanceof ITransportable 
				&& viajeBuscado.getMedioTransporte() instanceof iCargable)){
			throw new TransporteException();
		}
		
	}

	/*
	 * retorna la lista de pasajero enforma Descendiente Lanza una exception si el
	 * viaje no existe o si el tipo de viaje No es compatible para trnssporte de
	 * pasajero lanza una exception si el viaje no existe
	 */

	public TreeSet<Pasajero> obtenerListaPasajeroOrdenadosPorDNIDescendiente(Integer numeroViaje) throws ViajeInexistenteException, TipoTicketInvalidoExcption, CantidadPasajeroSobrepasadaException, TransporteException {
		HashSet<Pasajero> pasajerosAsignados = new HashSet<>();
		TreeSet<Pasajero> pasajerosOrdenados = new TreeSet<>(new OrdenPasajerosPorDNI());
		Viaje viajeBuscado =buscarViaje(numeroViaje);
		pasajerosAsignados.addAll(viajeBuscado.obtenerPasajeros());
		pasajerosOrdenados.addAll(pasajerosAsignados);
		return pasajerosOrdenados;
	}




	public Double obtenerELTotalDeCargaTransportadaEnTodosLosViajes() throws ViajeInexistenteException {
		Double totalCarga = 0.0;
		Integer numeroViajeCarga=0;
		for(Integer key :viajes.keySet()) {
			Viaje viajeActual = buscarViaje(key);
			if(viajeActual.getMedioTransporte() instanceof iCargable) {
				totalCarga += viajeActual.cantidadDePesoEnElViaje();
			}
		}
			
	
		return totalCarga;
	}

}
