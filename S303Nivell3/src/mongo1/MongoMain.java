package mongo1;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;

public class MongoMain {

	public static void main(String[] args) throws Exception {

		Scanner reader = new Scanner(System.in);
		DataBase db = new DataBase();
		double precio;
		//hola
		boolean fin = false;
		while (!fin) {

			System.out.println("1. Lista las bases de datos de Mongodb ");
			System.out.println("2. Lista las colecciones de una base datos");
			System.out.println("3. Ver Stock de MiFloristeria");
			System.out.println("4. Ver tickets");
			System.out.println("5. Crea un Producto");
			System.out.println("6. Vender un producto");
			System.out.println("7. Modificar un Producto");
			System.out.println("8. Retirar un Producto");
			System.out.println("9. Salir");

			System.out.print("Introduce que opción quieres?");

			int opcion = reader.nextInt();
			switch (opcion) {
			case 1:
				db.listar_databases();
				break;
			case 2:
				System.out.print("Introduce database para ver colecciones: ");
				String mbd = reader.next();
				db.listar_colecciones_db(mbd);
				break;
			case 3:
				db.verStock();
				break;
			case 4:
				db.verTickets();
				break;
			case 5:

				System.out.println("Que tipo de producto quieres crear? \n 1-Arbol \n 2-Flor \n 3-Decoración");
				int op = reader.nextInt();

				if (op == 1) {

					System.out.print("Introduce _id Arbol: ");
					int _id = reader.nextInt();

					System.out.print("Introduce tipo Arbol: ");
					String tipo = reader.next();
					System.out.print("Introduce altura: ");
					int altura = reader.nextInt();

					if (altura < 30) {
						precio = 15.99;
					} else if (altura > 30 && altura < 90) {

						precio = 32.00;
					} else {
						precio = 59.98;
					}
					db.insertarArbol(new Arbol(_id, tipo, altura, precio));
					db.crearTicket(new Tickets(_id, tipo, altura, precio, "En Stock"));
					db.verStock();
					db.verTickets();

				} else if (op == 2) {

					System.out.print("Introduce _id Flor: ");
					int _id = reader.nextInt();
					System.out.print("Introduce tipo Flor: ");
					String tipo = reader.next();
					System.out.print("Introduce color: ");
					String color = reader.next();
					precio = 1.50;

					db.insertarFlor(new Flor(_id, tipo, color, precio));
					db.crearTicket(new Tickets(_id, tipo, color, precio, "En Stock"));
					db.verStock();
					db.verTickets();

				} else if (op == 3) {

					System.out.print("Introduce _id decoración: ");
					int _id = reader.nextInt();
					System.out.print("Introduce tipo decoración: ");
					String tipo = reader.next();
					System.out.print("Introduce material: ceramica, madera, plástico ");
					String material = reader.next();

					if (material.equalsIgnoreCase("ceramica")) {

						precio = 28.99;
					} else if (material.equalsIgnoreCase("madera")) {

						precio = 17.65;
					} else {

						precio = 9.99;
					}
					db.insertarDecoracion(new Decoracion(_id, tipo, material, precio));
					db.crearTicket(new Tickets(_id, tipo, material, precio, "En Stock"));
					db.verStock();
					db.verTickets();

				}

				break;

			case 6:

				db.verStock();
				System.out.println("Que quieres vender?\\n 1-Arbol \\n 2-Flor \\n 3-Decoración");
				op = reader.nextInt();

				if (op == 1) {

					System.out.print("Introduce _id Arbol: ");
					int _id = reader.nextInt();

					db.vender(new Tickets(_id, "", "", 0, "vendido"));

					db.verStock();
					db.verTickets();

				} else if (op == 2) {

					System.out.print("Introduce _id Flor: ");
					int _id = reader.nextInt();
					db.vender(new Tickets(_id, "", "", 0, "vendido"));

					db.verStock();
				} else if (op == 3) {

					System.out.print("Introduce _id Deco: ");
					int _id = reader.nextInt();

					db.vender(new Tickets(_id, "", "", 0, "vendido"));

					db.verStock();

				}

				break;
			case 7:

				System.out.println("Que tipo de producto quieres modificar? \n 1-Arbol \n 2-Flor \n 3-Decoración");
				op = reader.nextInt();

				if (op == 1) {

					db.verStock();

					System.out.print("Introduce _id Arbol: ");
					int _id = reader.nextInt();
					System.out.print("Introduce tipo Arbol: ");
					String tipo = reader.next();
					System.out.print("Introduce altura Arbol: ");
					int altura = reader.nextInt();
					System.out.print("Introduce precio Arbol: ");
					precio = reader.nextDouble();

					db.actualizarArbol(new Arbol(_id, tipo, altura, precio));
					db.verStock();
				} else if (op == 2) {

					db.verStock();

					System.out.print("Introduce _id Flor: ");
					int _id = reader.nextInt();
					System.out.print("Introduce tipo Flor: ");
					String tipo = reader.next();
					System.out.print("Introduce color Flor: ");
					String color = reader.next();
					System.out.print("Introduce precio Flor: ");
					precio = reader.nextDouble();
					db.actualizarFlor(new Flor(_id, tipo, color, precio));
					db.verStock();

				} else if (op == 3) {

					System.out.print("Introduce _id Decoracion: ");
					int _id = reader.nextInt();
					System.out.print("Introduce tipo Decoracion: ");
					String tipo = reader.next();
					System.out.print("Introduce material Decoracion: ");
					String material = reader.next();
					System.out.print("Introduce precio Decoración: ");
					precio = reader.nextDouble();
					db.actualizarDecoracion(new Decoracion(_id, tipo, material, precio));
					db.verStock();
				}
				break;
			case 8:

				System.out.println("Que quieres retirar?\\n 1-Arbol \\n 2-Flor \\n 3-Decoración");
				op = reader.nextInt();

				if (op == 1) {

					db.verStock();

					System.out.print("Introduce _id Arbol: ");

					int _id = reader.nextInt();

					db.retirarProducto(_id);
					db.retirarTicket(_id);
					db.verStock();
					db.verTickets();

				} else if (op == 2) {

					System.out.print("Introduce _id Flor: ");
					int _id = reader.nextInt();
					db.retirarProducto(_id);
					db.retirarTicket(_id);

					db.verStock();
					db.verTickets();
				} else if (op == 3) {

					System.out.print("Introduce _id Decoración: ");
					int _id = reader.nextInt();
					db.retirarProducto(_id);
					db.retirarTicket(_id);
					db.verStock();
					db.verTickets();

				}
				break;
			case 9:
				fin = true;
				break;

			}
		}
	}

}
