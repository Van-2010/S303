package S303Nivell1;

import java.util.ArrayList;
import java.util.List;

public class Stock {

//	List <Arbre> arbres=new ArrayList<Arbre>();
//	List <Flor> flors=new ArrayList<Flor>();
//	List <Decoracio> decoracions=new ArrayList<Decoracio>();
	List<IProducte> productes = new ArrayList<IProducte>();

	public void addArbre(Arbre nouProducte) {
		productes.add(nouProducte);
		// arbres.add(nouProducte);
	}

	public void eliminaProducte(int id, String tipo) {
		int posicion = budscarPosicionproducte(id, tipo);
		if (posicion >= 0) {
			productes.remove(productes.get(posicion));
			System.out.println("producto eliminado");
		} else {
			System.out.println("este  producto no existe");
		}
	}

	public void addFlor(Flor nouProducte) {
		productes.add(nouProducte);
		// flors.add(nouProducte);
	}

//	public void eliminaFlor(Flor nouProducte){
//		productes.remove(nouProducte);
//		//flors.remove(nouProducte);
//	}

	public void addDecoracio(Decoracio nouProducte) {
		productes.add(nouProducte);
		// decoracions.add(nouProducte);
	}

//	public void eliminaDecoracio(Decoracio nouProducte){
//		productes.remove(nouProducte);
//		decoracions.remove(nouProducte);
//	}
	public void pintaTodoStock() {
		productes.forEach(x -> System.out.println(x.toString()));
	}

	public void PintaCantidades() {
		int arbres = 0;
		int flors = 0;
		int deco = 0;

		for (int i = 0; i < productes.size(); i++) {
			if (productes.get(i).getClase().equalsIgnoreCase("arbre")) {
				arbres += 1;
			} else if (productes.get(i).getClase().equalsIgnoreCase("flor")) {
				flors += 1;
			} else if (productes.get(i).getClase().equalsIgnoreCase("decoracio")) {
				deco += 1;
			}
		}
		System.out.println("El stock es:");
		System.out.println("Arbres: " + arbres);
		System.out.println("Flors: " + flors);
		System.out.println("Decoracions: " + deco);
	}

	public double valorTotalFloristeria() {
		double valorTotal = 0;
		for (int i = 0; i < productes.size(); i++) {
			valorTotal += productes.get(i).getPrecio();
		}

		return valorTotal;
	}

//	public int  budscarPosicionArbres(int id) {
//		int posicion =-1;
//		for (int i=0;i<arbres.size();i++) {
//			if (arbres.get(i).getID()==id) {
//				posicion=id;
//			}
//		}
//		return posicion;
//	}
	public  int budscarPosicionproducte(int id, String tipo) {
		int posicion = -1;
		for (int i = 0; i < productes.size(); i++) {
			if (productes.get(i).getID() == id && productes.get(i).getClase().equalsIgnoreCase(tipo)) {
				posicion = i;
			}
		}
		return posicion;
	}
	
	public IProducte devolverProducte(int id, String tipo) {
		IProducte producte = null;
		for (int i = 0; i < productes.size(); i++) {
			if (productes.get(i).getID() == id && productes.get(i).getClase().equalsIgnoreCase(tipo)) {
				producte=productes.get(i);
			}
		}
		return producte;
	}
}
