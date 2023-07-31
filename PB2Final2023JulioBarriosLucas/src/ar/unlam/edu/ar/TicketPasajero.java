package ar.unlam.edu.ar;

import java.util.HashSet;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class TicketPasajero extends Ticket {
	
	private Pasajero pasajeroConTicket;
	
	
	public TicketPasajero(Integer id, Pasajero pasajeroConTicket) {
		super(id);
		this.pasajeroConTicket =pasajeroConTicket;
	}
	
			

	public Pasajero obtenerPasajeroConTicket(){
		return this.pasajeroConTicket;
	}

}
