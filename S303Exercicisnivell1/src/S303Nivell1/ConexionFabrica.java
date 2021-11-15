package S303Nivell1;

public class ConexionFabrica{

	public IProducte CrearProducte(String tipoProducte,String tipo,double preu,String otro) {
		
		if (tipo==null) {
			return new ProducteEquivocat();
		}else if (tipoProducte.equalsIgnoreCase("arbre")) {
			return new Arbre(tipo,preu, otro);
		}else if (tipoProducte.equalsIgnoreCase("flor")) {
			return new Flor(tipo,preu, otro);
		}else if (tipoProducte.equalsIgnoreCase("decoracio")) {
			return new Decoracio(tipo,preu, otro);
		}
		
		
		return new ProducteEquivocat();
	}
}
