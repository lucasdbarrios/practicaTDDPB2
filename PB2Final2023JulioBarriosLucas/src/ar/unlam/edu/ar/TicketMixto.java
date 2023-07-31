package ar.unlam.edu.ar;



public class TicketMixto extends Ticket {
	
	private TicketPasajero ticketParaPasajero;
	private TicketCarga ticketParaCarga;
	
	
	
	public TicketMixto(Integer numeroTicket, Pasajero pasajero, Carga carga) {
		super(numeroTicket);
		this.ticketParaPasajero= new TicketPasajero(numeroTicket, pasajero);
		this.ticketParaCarga= new TicketCarga(numeroTicket, carga.getPeso());
		
	}

	

	public Pasajero obtenerPasajeroConTicket() {
			return this.ticketParaPasajero.obtenerPasajeroConTicket();
		
	}

	public Double mostrarCarga() {
		return this.ticketParaCarga.mostrarCarga();
		
	}



}
