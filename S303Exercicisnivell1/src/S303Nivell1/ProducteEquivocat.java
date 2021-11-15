package S303Nivell1;

public class ProducteEquivocat implements IProducte{

	@Override
	public void crear() {
		// TODO Auto-generated method stub
		System.out.println("tipoAquest producte no existeix");
	}

	@Override
	public double getPrecio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getClase() {
		// TODO Auto-generated method stub
		return null;
	}
}
