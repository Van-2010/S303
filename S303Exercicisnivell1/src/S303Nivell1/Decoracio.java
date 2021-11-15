package S303Nivell1;

public class Decoracio implements IProducte{
	private static int count=1;
	private int ID;
	private String clase;
	private String tipo;
	private double precio;
	private String fustaPlastic;
	
	public Decoracio(String tipo,double precio,String otro) {
		this.clase="decoracio";
		this.tipo=tipo;
		this.precio=precio;
		this.fustaPlastic= otro;
		this.ID=count ++;
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


	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public String getfustaPlastic() {
		return fustaPlastic;
	}



	public void setfustaPlastic(String fustaPlastic) {
		this.fustaPlastic = fustaPlastic;
	}



	@Override
	public void crear() {
		System.out.println("se creo un  "+tipo);
		
	}


	@Override
	public String toString() {
		return "Decoracio [ID=" + ID + ", clase=" + clase + ", tipo=" + tipo + ", precio=" + precio + ", fustaPlastic="
				+ fustaPlastic + "]";
	}


	@Override
	public <T> Class queClase(T producto) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Class queClase(Arbre arbre) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
