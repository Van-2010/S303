package S303Nivell1;

public class Arbre implements IProducte{
	private static int count=1;
	private int ID;
	private String clase;
	private String tipo;
	private double precio;
	private String altura;
	
	
	public Arbre(String tipo,double precio,String altura) {
		this.clase="arbre";
		this.tipo=tipo;
		this.precio=precio;
		this.altura=altura;
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



	public String getAltura() {
		return altura;
	}



	public void setAltura(String altura) {
		this.altura = altura;
	}



	@Override
	public void crear() {
		System.out.println("se creo un  "+tipo);
		
	}


	@Override
	public String toString() {
		return "Arbre [ID=" + ID + ", clase=" + clase + ", tipo=" + tipo + ", precio=" + precio + ", altura=" + altura
				+ "]";
	}



	@Override
	public <T> Class queClase(T producto) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Class queClase(Arbre arbre) {
		// TODO Auto-generated method stub
		return arbre.getClass();
	}
	
}
