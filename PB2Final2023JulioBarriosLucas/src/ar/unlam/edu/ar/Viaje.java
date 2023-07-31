package ar.unlam.edu.ar;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Viaje {
	
	private LocalDateTime salida; 
	private LocalDateTime llegada;  
	private String origen;  
	private String destino;
	private MedioTransporte medioTransporte;
	private Set<Ticket> ticketsDelViaje;
	private Set<Pasajero> pasajerosEnViaje;
	private Double pesoEnViaje;
	
	
	public Viaje(LocalDateTime salida, LocalDateTime llegada, String origen, String destino,
			MedioTransporte medioTransporte) {
		this.salida=salida;
		this.llegada=llegada;
		this.origen=origen;
		this.destino=destino;
		this.medioTransporte=medioTransporte;
		this.ticketsDelViaje=new HashSet<>();
		this.pasajerosEnViaje= new HashSet<>();
		this.pesoEnViaje=0.0;
			
	}
	public LocalDateTime getSalida() {
		return salida;
	}
	public void setSalida(LocalDateTime salida) {
		this.salida = salida;
	}
	public LocalDateTime getLlegada() {
		return llegada;
	}
	public void setLlegada(LocalDateTime llegada) {
		this.llegada = llegada;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public MedioTransporte getMedioTransporte() {
		return medioTransporte;
	}
	public void setMedioTransporte(MedioTransporte medioTransporte) {
		this.medioTransporte = medioTransporte;
	}
	
	public void ingresarTicketDelViaje(Ticket nuevoTicket) throws TipoTicketInvalidoExcption {
	if((medioTransporte instanceof iCargable && !(nuevoTicket instanceof TicketCarga || nuevoTicket instanceof TicketMixto) )
		|| (medioTransporte instanceof ITransportable && !(nuevoTicket instanceof TicketPasajero || nuevoTicket instanceof TicketMixto))) {
		 throw new TipoTicketInvalidoExcption();
								}
			
		this.ticketsDelViaje.add(nuevoTicket);
	}
	
	public Integer cantidadDePasajerosEnElViaje() {
		
		return pasajerosEnViaje.size();
	}

	public Double cantidadDePesoEnElViaje() {
		return this.pesoEnViaje;
	}
	
	public Set<Pasajero> obtenerPasajeros(){
		Set<Pasajero> pasajerosEnElViaje = new HashSet<>();
		for(Ticket ticketpasaje: ticketsDelViaje) {
			if(ticketpasaje instanceof TicketPasajero) {
				pasajerosEnElViaje.add(((TicketPasajero)ticketpasaje).obtenerPasajeroConTicket());
				
		
			}
			
		}
		return pasajerosEnElViaje;
				
	}

}

