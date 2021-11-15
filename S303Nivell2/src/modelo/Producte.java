package modelo;

public class Producte {
	
	private Integer ID;
	private String clase;
	private String nom;
	private double preu;
	private String otro;
	private int ticket_id;
	
	public Producte( String clase, String nom, double preu, String otro,int ticket_id) {
		
		this.ID=null;
		this.clase = clase;
		this.nom = nom;
		this.preu = preu;
		this.otro = otro;
		this.ticket_id=ticket_id;
	}

public Producte(int ID, String clase, String nom, double preu, String otro,int ticket_id) {
		
		this.ID=ID;
		this.clase = clase;
		this.nom = nom;
		this.preu = preu;
		this.otro = otro;
		this.ticket_id=ticket_id;
	}

	public Producte() {
		
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPreu() {
		return preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}

	public String getOtro() {
		return otro;
	}

	public void setOtro(String otro) {
		this.otro = otro;
	}

	
	public Integer getTicket_id() {
		return ticket_id;
	}


	public void setTicket_id(Integer ticket_id) {
		this.ticket_id = ticket_id;
	}

	@Override
	public String toString() {
		return "Producte [ID=" + ID + ", clase=" + clase + ", nom=" + nom + ", preu=" + preu + ", otro=" + otro
				+ ", ticket_id=" + ticket_id + "]";
	}





	
	
	
	
}
