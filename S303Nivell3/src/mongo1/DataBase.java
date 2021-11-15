package mongo1;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import mongo1.Arbol;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class DataBase {

	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection coleccion;
	private MongoCollection coleccionTickets;

	public DataBase() {

		this.mongoClient = MongoClients.create("mongodb://localhost:27017");
		this.database = mongoClient.getDatabase("MiFloristeria");
		this.coleccion = database.getCollection("Productes");
		this.coleccionTickets = database.getCollection("Tickets");

	}

	public void listar_databases() {

		MongoCursor<String> dbsCursor = mongoClient.listDatabaseNames().iterator();
		while (dbsCursor.hasNext()) {
			System.out.println(dbsCursor.next());
		}
	}

	public void listar_colecciones_db(String db) {
		MongoDatabase mdb = mongoClient.getDatabase(db);
		for (String name : mdb.listCollectionNames()) {
			System.out.println(name);
		}
	}

	public void verTickets() {

		MongoCursor<Document> cursor = coleccionTickets.find().iterator();
		System.out.println();
		while (cursor.hasNext()) {
			Document doc = cursor.next();
			System.out.println(doc.toJson());
		}
		System.out.println();
		cursor.close();

	}

	public void verStock() {

		MongoCursor<Document> cursor = coleccion.find().iterator();
		System.out.println();
		while (cursor.hasNext()) {
			Document doc = cursor.next();
			System.out.println(doc.toJson());
		}
		System.out.println();
		cursor.close();

	}

	public void insertarArbol(Arbol arbol) {

		Document amigo = new Document();
		amigo.put("_id", arbol.get_id());
		amigo.put("tipo", arbol.getTipo());
		amigo.put("altura", arbol.getAltura());
		amigo.put("precio", arbol.getPrecio());
		coleccion.insertOne(amigo);

	}

	public void insertarFlor(Flor flor) {

		Document amigo = new Document();
		amigo.put("_id", flor.get_id());
		amigo.put("tipo", flor.getTipo());
		amigo.put("color", flor.getColor());
		amigo.put("precio", flor.getPrecio());

		coleccion.insertOne(amigo);

	}

	public void insertarDecoracion(Decoracion decoracion) {

		Document amigo = new Document();
		amigo.put("_id", decoracion.get_id());
		amigo.put("tipo", decoracion.getTipo());
		amigo.put("material", decoracion.getMaterial());
		amigo.put("precio", decoracion.getPrecio());

		coleccion.insertOne(amigo);

	}

	public void actualizarArbol(Arbol arbol) {

		BasicDBObject query = new BasicDBObject();
		query.put("_id", arbol.get_id());

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("tipo", arbol.getTipo());
		newDocument.put("altura", arbol.getAltura());
		newDocument.put("precio", arbol.getPrecio());
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newDocument);

		coleccion.updateOne(query, updateObject);

	}

	public void actualizarFlor(Flor flor) {

		BasicDBObject query = new BasicDBObject();
		query.put("_id", flor.get_id());

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("tipo", flor.getTipo());
		newDocument.put("color", flor.getColor());
		newDocument.put("precio", flor.getPrecio());

		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newDocument);

		coleccion.updateOne(query, updateObject);

	}

	public void actualizarDecoracion(Decoracion decoracion) {

		BasicDBObject query = new BasicDBObject();
		query.put("_id", decoracion.get_id());

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("tipo", decoracion.getTipo());
		newDocument.put("material", decoracion.getMaterial());
		newDocument.put("precio", decoracion.getPrecio());
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newDocument);

		coleccion.updateOne(query, updateObject);

	}

	public void vender(Tickets ticket) {

		BasicDBObject query = new BasicDBObject();
		query.put("_id", ticket.get_id());

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.put("creado", ticket.getCreado());
		BasicDBObject updateObject = new BasicDBObject();
		updateObject.put("$set", newDocument);

		coleccionTickets.updateOne(query, updateObject);

		retirarProducto(ticket.get_id());

	}

	public void crearTicket(Tickets ticket) {

		Document amigo = new Document();
		amigo.put("_id", ticket.get_id());
		amigo.put("tipo", ticket.getTipo());
		amigo.put("precio", ticket.getPrecio());
		amigo.put("creado", ticket.getCreado());
		coleccionTickets.insertOne(amigo);

	}

	public void retirarProducto(int _id) {

		coleccion.deleteOne(new Document("_id", _id));

	}

	public void retirarTicket(int _id) {

		coleccionTickets.deleteOne(new Document("_id", _id));

	}

}
