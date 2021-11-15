package S303Nivell1;

import java.util.List;

public class Floristeria {
	
	String nom;
	Stock stock;
	Tickets tickets;
	
	public Floristeria(String nom,Stock stock,Tickets tickets) {
		this.nom=nom;
		this.stock=stock;
		this.tickets=tickets;
				
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Tickets getTickets() {
		return tickets;
	}

	public void setTickets(Tickets tickets) {
		this.tickets = tickets;
	}
	
	

}
