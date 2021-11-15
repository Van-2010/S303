package S303Nivell1;

public interface IProducte {

	
	void crear();

	double getPrecio();
	String getTipo();
	String toString();
	 <T> Class queClase(T producto);

	Class queClase(Arbre arbre);

	int getID();
	String getClase();
}
