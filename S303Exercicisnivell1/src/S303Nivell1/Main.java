package S303Nivell1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


	public static  void main(String[] args) {
		
		Floristeria margarita = null;
		
		boolean sortir = false;

		do {
			switch (menu()) {
			case 1:
				String nom = Teclado.leerString("cual es el nombre de la floristeria");
				margarita = CrearFloristeria(nom);
				break;
			case 2:
				String tipoProducte = Teclado.leerString("que tipo de producto quieres aÒadir(arbre,flor,decoracio)");
				String tipo = Teclado.leerString("que nombre  de producto quieres aÒadir");
				double preu = Teclado.leerDouble("que precio tiene");
				String otro=Teclado.leerString("si es un arbol introduce altura,si es una flor color y si es una decoracion true para madera false para plastico");
				crearProducto(tipoProducte, tipo, preu, otro, margarita.stock);
				break;
			case 3:
				margarita.stock.pintaTodoStock();
				break;
			case 4:
				System.out.println(margarita.stock.valorTotalFloristeria());
				break;
			case 5:
				margarita.stock.PintaCantidades();
				break;
			case 6:
				int id=Teclado.leerInt("que id has comprado?");
				String tipo1=Teclado.leerString("que tipo de articulo es?");
				IProducte[] productos= {margarita.stock.devolverProducte(id, tipo1)};
				crearTicket(productos,margarita.stock,margarita.tickets);
				break;
			case 7:
				margarita.tickets.MostrarAllTickets();
				break;
			case 8:
				int id1=Teclado.leerInt("Cual es el id del ticket que quieres eliminar?");
				eliminarTicket( id1,margarita.stock, margarita.tickets);
				break;
			case 0:
				System.out.println("Gr√†cies per utilitzar l'aplicaci√≥");
				sortir = true;
				break;

			}
		} while (!sortir);
	}

	public static byte menu() {
		Scanner entrada = new Scanner(System.in);
		byte opcio;
		final byte MINIMO = 0;
		final byte MAXIMO = 8;

		do {
			System.out.println("\nMEN√∫ PRINCIPAL");
			System.out.println("1. crear floristeria 1.");
			System.out.println("2. crear producto y aÒadirlo al stock 2.");
			System.out.println("3. imprimir stock 3.");
			System.out.println("4. Ventas totales4.");
			System.out.println("5. imprimir cantidades stock 5.");
			System.out.println("6. crear ticket y mostrarlo 6.");
			System.out.println("7. mostrar todos los tickets 7.");
			System.out.println("8. eliminar ticket 8.");

			System.out.println("0. Sortir de l'aplicaci√≥.\n");
			opcio = entrada.nextByte();
			if (opcio < MINIMO || opcio > MAXIMO) {
				System.out.println("Escull una opci√≥ v√†lida");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;
	}

	public static Floristeria CrearFloristeria(String nomFloristeria) {
		Stock stockFloristeria = new Stock();
		Tickets ticketsFloristeria=new Tickets();

		Floristeria floristeria = new Floristeria(nomFloristeria, stockFloristeria,ticketsFloristeria);
		return floristeria;
	}

	public static <T> void crearProducto(String tipoProducte, String tipo, double preu, String otro, Stock stock) {
		ConexionFabrica cf = new ConexionFabrica();
		if (tipoProducte.equalsIgnoreCase("arbre")) {
			Arbre arbre = (Arbre) cf.CrearProducte(tipoProducte, tipo, preu, otro);
			addStock(arbre, stock);
		} else if (tipoProducte.equalsIgnoreCase("flor")) {
			Flor flor = (Flor) cf.CrearProducte(tipoProducte, tipo, preu, otro);
			addStock(flor, stock);
		} else if (tipoProducte.equalsIgnoreCase("decoracio")) {
			Decoracio decoracio = (Decoracio) cf.CrearProducte(tipoProducte, tipo, preu, otro);
			addStock(decoracio, stock);
		}

	}

	public static <T> void addStock(T producte, Stock stock) {
		try {
			Arbre arbre = (Arbre) producte;
			stock.addArbre((Arbre) producte);

		} catch (Exception e) {
			try {
				Flor flor = (Flor) producte;
				stock.addFlor((Flor) producte);

			} catch (Exception ex) {
				try {
					Decoracio decoracio = (Decoracio) producte;
					stock.addDecoracio((Decoracio) producte);

				} catch (Exception exc) {
					System.out.println("no se ha podido aÒadir producto");
				}
			}
		}

	}

	public static void crearTicket(IProducte[] productos,Stock stock, Tickets tickets) {
		Ticket ticket=new Ticket();

		for (int i=0;i<productos.length;i++) {
			ticket.addProducte(productos[i]);
			stock.eliminaProducte(productos[i].getID(), productos[i].getClase());
		}
		tickets.addTicket(ticket);
		ticket.MostrarTicket();
		
	}
	
	public static void eliminarTicket(int id,Stock stock, Tickets tickets) {
		int posicionTicket=tickets.budscarPosicionticket(id);
		List<IProducte> listaProductos=tickets.getTickets().get(posicionTicket).getTicket();
		for (int i=0;i<listaProductos.size();i++) {
			if(listaProductos.get(i).getClase().equalsIgnoreCase("arbre")) {
				stock.addArbre((Arbre) listaProductos.get(i));
			}else if(listaProductos.get(i).getClase().equalsIgnoreCase("flor")) {
				stock.addFlor((Flor) listaProductos.get(i));
			}else if(listaProductos.get(i).getClase().equalsIgnoreCase("decoracio")) {
				stock.addDecoracio((Decoracio) listaProductos.get(i));
			}
		}
		tickets.eliminarTicket(id);
		
	}
}
