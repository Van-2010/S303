package S303Nivell1;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
	private static int count=1;
	private int ID;
	private List<IProducte> ticket=new ArrayList<IProducte>();
	private double valorTotal = valorTicket();
	
	public Ticket () {
		this.ID=count ++;
	}
	
	public List<IProducte> getTicket() {
		return ticket;
		
	}

	public void setTicket(List<IProducte> ticket) {
		this.ticket = ticket;
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

	public void addProducte(IProducte nouProducte){
		ticket.add(nouProducte);	
	}
	
	public void eliminaProducte(IProducte nouProducte){
		ticket.remove(nouProducte);
	}
	
	
	public double valorTicket() {
		 double valorTotal=0.0;
		for (int i=0;i<ticket.size();i++) {
			valorTotal+=ticket.get(i).getPrecio();
		}
		  //return ticket.stream().mapToInt(Integer::intValue).sum();
		
		return valorTotal;
	}
	
	public void MostrarTicket() {
		ticket.forEach(x->System.out.println("ticket "+x.getID()));
		ticket.forEach(x->System.out.println(x.getTipo()));
		System.out.println("total a pagar: "+valorTicket());
	}
	
	
}
