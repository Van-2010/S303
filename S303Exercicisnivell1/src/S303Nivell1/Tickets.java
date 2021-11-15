package S303Nivell1;

import java.util.ArrayList;
import java.util.List;

public class Tickets {
	private List<Ticket> tickets= new ArrayList<Ticket>();
	
	
	
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}
	
	public void eliminarTicket(int  id) {
		int posicion=budscarPosicionticket( id);
		tickets.remove(posicion);
	}
	
	public void MostrarAllTickets() {

		tickets.forEach(x->x.MostrarTicket());

	}
	public  int budscarPosicionticket(int id) {
		int posicion = -1;
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getID() == id ) {
				posicion = i;
			}
		}
		return posicion;
	}
}
