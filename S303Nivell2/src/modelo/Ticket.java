package modelo;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
	
	private int ID;
	private double valorTotal ;
	
	

	public Ticket() {
	
	}

	public Ticket(double valorTotal) {
		
		this.valorTotal = valorTotal;
	}
	
	

	public Ticket(int iD, double valorTotal) {
		
		ID = iD;
		this.valorTotal = valorTotal;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "Ticket [ID=" + ID + ", valorTotal=" + valorTotal + "]";
	}

	
	
	
}
