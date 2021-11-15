package vista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import modelo.*;
//import modelo.Producte;
//import modelo.Ticket;

public class Main {

	public static void main(String[] args) {

		boolean sortir = false;

		do {
			switch (menu()) {
			case 1:
				String clase = Teclado.leerString("Cual es la clase del producto?");
				String tipo = Teclado.leerString("Cual es el tipo del producto?");
				Double preu = Teclado.leerDouble("Cual es el precio del producto?");
				String otro = Teclado.leerString(
						"para arbol insertar altura, para flor insertar color , para decoracion insertar madera o plastico?");
				Producte producte = new Producte(clase, tipo, preu, otro, 0);
				addProducte(producte);
				break;
			case 2:
				llistarProducte();
				int id = Teclado.leerInt("que id quieres cambiar");
				String clase1 = Teclado.leerString("Cual es la nueva clase del producto?");
				String tipo1 = Teclado.leerString("Cual es el nuevo tipo del producto?");
				Double preu1 = Teclado.leerDouble("Cual es el nuevo precio del producto?");
				String otro1 = Teclado.leerString(
						"para arbol insertar altura, para flor insertar color , para decoracion insertar madera o plastico?");
				int id_ticket = Teclado.leerInt("cual es el nuevo id_ticket");
				Producte producte1 = new Producte(id, clase1, tipo1, preu1, otro1, id_ticket);
				updateProducte(producte1);
				llistarProducte();
				break;
			case 3:
				llistarProducte();
				break;
			case 4:
				llistarProducte();
				int id_producte = Teclado.leerInt("cual es el id del producto a borrar?");
				eliminarProducte(id_producte);
				llistarProducte();
				break;
			case 5:
				int id1 = Teclado.leerInt("cual es el id del producto a mostrar?");
				mostrarProducte(id1);
				break;
			case 6:
				mostrarStockCantidades();
				break;
			case 7:
				mostrarValorTotalFloristeria();
				break;
			case 8:
				Ticket ticket = new Ticket(0);
				addTicket(ticket);
				llistarTickets();
				int productes = Teclado.leerInt("cuantos productos has comprado");
				double valorTicket=0;
				int ticket_id = Teclado.leerInt("cual es el id del ticket");
				llistarProducte();
				for (int i = 0; i < productes; i++) {
					int id_producte1 = Teclado.leerInt("cual es el id del producto comprado");
					updateProductoComprado(id_producte1, ticket_id);
					valorTicket += darPrecioProducto(id_producte1);
				}
				updateTicket(ticket_id,valorTicket);
				llistarProducte();
				mostrarTicket(ticket_id);
				break;
			case 9:
				llistarTickets();
				int id2 = Teclado.leerInt("que id quieres modificar?");
				double valorTotal2 = Teclado.leerDouble("Cual es el valor total del ticket");
				
				updateTicket(id2, valorTotal2 );
				llistarTickets();
				break;
			case 10:
				llistarTickets();
				break;
			case 11:
				llistarTickets();
				int id3 = Teclado.leerInt("que id quieres eliminar?");
				updateProductoDevuelto(id3);
				llistarProducte();
				eliminarTicket(id3);
				llistarTickets();
				break;
			case 12:
				int id4 = Teclado.leerInt("Que id tiene el ticket que quieres mostrar?");
				mostrarTicket(id4);
				break;
			case 13:
				mostrarValorTotalTickets();
				break;
			case 0:
				System.out.println("Gràcies per utilitzar l'aplicació");
				sortir = true;
				break;

			}
		} while (!sortir);
	}

	public static byte menu() {
		Scanner entrada = new Scanner(System.in);
		byte opcio;
		final byte MINIMO = 0;
		final byte MAXIMO = 13;

		do {
			System.out.println("\nMENú PRINCIPAL");
			System.out.println("1. crear producto 1.");
			System.out.println("2. modificar producto 2.");
			System.out.println("3. listar productos 3.");
			System.out.println("4. Borrar producto 4.");
			System.out.println("5. mostrar un producto 5.");
			System.out.println("6. imprimir las cantidades del stock6.");
			System.out.println("7. mostrar valor total floristeria7.");
			System.out.println("8. a�adir ticket 8.");
			System.out.println("9. modificar ticket 9.");
			System.out.println("10. listar tickets 10.");
			System.out.println("11. eliminar ticket 11.");
			System.out.println("12. mostrar un ticket 12.");
			System.out.println("13. total ventas 13.");

			System.out.println("0. Sortir de l'aplicació.\n");
			opcio = entrada.nextByte();
			if (opcio < MINIMO || opcio > MAXIMO) {
				System.out.println("Escull una opció vàlida");
			}
		} while (opcio < MINIMO || opcio > MAXIMO);
		return opcio;
	}

	public static void addProducte(Producte producte) {
		AccionesProductos add = new AccionesProductos();
		try {
			add.addProducto(producte);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void updateProducte(Producte producte) {
		AccionesProductos add = new AccionesProductos();
		try {
			add.updateProducto(producte);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void llistarProducte() {

		AccionesProductos add = new AccionesProductos();
		try {
			add.listarProductos();
			ArrayList<Producte> productes = add.listarProductos();

			productes.forEach(x -> System.out.println(x.toString()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void eliminarProducte(int id_producte) {
		AccionesProductos add = new AccionesProductos();
		try {
			add.eliminarProducto(id_producte);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void mostrarProducte(int id) {

		AccionesProductos add = new AccionesProductos();
		try {
			add.mostrarProducto(id);
			Producte producte = add.mostrarProducto(id);
			System.out.println(producte.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void mostrarStockCantidades() {

		AccionesProductos add = new AccionesProductos();
		try {
			add.stockCantidades();
			Map<String, Integer> map = add.stockCantidades();

			System.out.println(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void mostrarValorTotalFloristeria() {

		AccionesProductos add = new AccionesProductos();
		try {
			add.valorTotalFloristeria();
			int contador = add.valorTotalFloristeria();

			System.out.println("el valor total de la floristeria es " + contador);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addTicket(Ticket ticket) {
		AccionesTickets llista = new AccionesTickets();
		try {
			llista.addTicket(ticket);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void updateTicket(int id_ticket,double valorTicket) {
		AccionesTickets add = new AccionesTickets();
		try {
			add.updateTicket( id_ticket, valorTicket);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void llistarTickets() {

		AccionesTickets llista = new AccionesTickets();
		try {
			llista.listarTickets();
			ArrayList<Ticket> tickets = llista.listarTickets();

			tickets.forEach(x -> System.out.println(x.toString()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void eliminarTicket(int id_ticket) {
		AccionesTickets llista = new AccionesTickets();
		try {
			llista.eliminarTicket(id_ticket);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void mostrarTicket(int id) {

		AccionesTickets llista = new AccionesTickets();
		try {

			Ticket ticket = llista.mostrarTicket(id);
			System.out.println("ticket: "+ ticket.getID());
			llistarProductesTicket(id);
			System.out.println("ticket: "+ ticket.getValorTotal());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void mostrarValorTotalTickets() {

		AccionesTickets llista = new AccionesTickets();
		try {

			int contador = llista.valorTotalTickets();

			System.out.println("el total cde diners guanyats amb totes les ventes es " + contador);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void updateProductoComprado(int id_producte, int ticket_id) {
		AccionesProductos add = new AccionesProductos();
		try {
			add.updateProductoComprado(id_producte, ticket_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int darPrecioProducto(int id) {

		int preu = 0;
		AccionesProductos add = new AccionesProductos();
		try {

			preu = add.mostrarPrecioProducto(id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preu;
	}
	public static void llistarProductesTicket(int id_ticket) {

		AccionesProductos add = new AccionesProductos();
		try {
			
			ArrayList<Producte> productes = add.listarProductosTicket(id_ticket);

			productes.forEach(x -> System.out.println(x.getNom()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void updateProductoDevuelto(int ticket_id) {
		AccionesProductos add = new AccionesProductos();
		try {
			add.updateProductoDevuelto(ticket_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
