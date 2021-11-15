package modelo;

import controlador.Conexion;
import java.sql.PreparedStatement;
import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

import vista.Teclado;

public class AccionesProductos {

	private Conexion miConexion;
	private Connection connection;
	private boolean estadoOperacion;
	private PreparedStatement statement;

	public AccionesProductos() {
		miConexion = new Conexion();

	}

	public void addProducto(Producte producte) throws SQLException {
		String sql = null;

		connection = miConexion.dameConexion();
		try {
			PreparedStatement miSentencia = connection.prepareStatement(
					"INSERT INTO productes(id_producte,clase, nom, preu, otro, ticket_id) VALUES(?,?,?,?,?,?)");
			
			miSentencia.setString(1, null);
			miSentencia.setString(2, producte.getClase());
			miSentencia.setString(3, producte.getNom());
			miSentencia.setDouble(4, producte.getPreu());
			miSentencia.setString(5, producte.getOtro());
			miSentencia.setInt(6, producte.getTicket_id());
			

			miSentencia.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void updateProducto(Producte producte) throws SQLException {
		String sql = null;

		connection = miConexion.dameConexion();
		try {
			PreparedStatement miSentencia = connection.prepareStatement(
					"UPDATE productes SET clase=?,nom=?, preu=?, otro=?, ticket_id=? WHERE id_producte=? ");

			miSentencia.setString(1, producte.getClase());
			miSentencia.setString(2, producte.getNom());
			miSentencia.setDouble(3, producte.getPreu());
			miSentencia.setString(4, producte.getOtro());
			miSentencia.setInt(5, producte.getTicket_id());

			miSentencia.setInt(6, producte.getID());
			System.out.println(miSentencia.toString());

			miSentencia.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public ArrayList<Producte> listarProductos() throws SQLException {

		ResultSet resulset = null;
		ArrayList<Producte> productes = new ArrayList<Producte>();

		String sql = null;
		connection = miConexion.dameConexion();
		java.sql.Statement sta = connection.createStatement();
		try {
			sql = "SELECT * FROM productes";

			resulset = sta.executeQuery(sql);

			while (resulset.next()) {
				Producte p = new Producte();
				p.setID(resulset.getInt("id_producte"));
				p.setClase(resulset.getString("clase"));
				p.setNom(resulset.getString("nom"));
				p.setPreu(resulset.getDouble("preu"));
				p.setOtro(resulset.getString("otro"));
				p.setTicket_id(resulset.getInt("ticket_id"));

				productes.add(p);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return productes;
	}

	public void eliminarProducto(int id_producte) throws SQLException {
		String sql = null;

		connection = miConexion.dameConexion();
		try {
			PreparedStatement miSentencia = connection.prepareStatement("DELETE FROM productes  WHERE id_producte=? ");

			miSentencia.setInt(1, id_producte);

			miSentencia.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public Producte mostrarProducto(int id) throws SQLException {
		ResultSet resulset = null;
		String sql = null;
		Producte p = new Producte();
		connection = miConexion.dameConexion();
		try {

			sql = "SELECT * FROM productes WHERE id_producte=?";
			statement = connection.prepareStatement(sql);

			statement.setInt(1, id);

			p = new Producte();

			resulset = statement.executeQuery();

			if (resulset.next()) {

				p.setID(resulset.getInt("id_producte"));
				p.setClase(resulset.getString("clase"));
				p.setNom(resulset.getString("nom"));
				p.setPreu(resulset.getDouble("preu"));
				p.setOtro(resulset.getString("otro"));
				p.setTicket_id(resulset.getInt("ticket_id"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return p;
	}

	public Map<String, Integer> stockCantidades() throws SQLException {

		ResultSet resulset = null;
		Map<String, Integer> map = new HashMap<String, Integer>();

		String sql = null;
		connection = miConexion.dameConexion();
		java.sql.Statement sta = connection.createStatement();
		try {
			sql = "SELECT clase, count(*) AS contador FROM productes group by clase";

			resulset = sta.executeQuery(sql);

			while (resulset.next()) {
				Producte p = new Producte();

				map.put(resulset.getString("clase"), resulset.getInt("contador"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return map;
	}

	public int valorTotalFloristeria() throws SQLException {

		ResultSet resulset = null;
		int contador=0;

		String sql = null;
		connection = miConexion.dameConexion();
		java.sql.Statement sta = connection.createStatement();
		try {
			sql = "SELECT SUM(preu) AS contador FROM productes";

			resulset = sta.executeQuery(sql);

			if (resulset.next()) {
			
				contador= resulset.getInt("contador");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return contador;
	}
	
	public void updateProductoComprado(int id_producte,int ticket_id) throws SQLException {
		String sql = null;

		connection = miConexion.dameConexion();
		try {
			PreparedStatement miSentencia = connection.prepareStatement(
					"UPDATE productes SET ticket_id=? WHERE id_producte=? ");

			miSentencia.setInt(1, ticket_id);
			miSentencia.setInt(2, id_producte);
			
			miSentencia.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public int mostrarPrecioProducto(int id) throws SQLException {
		ResultSet resulset = null;
		String sql = null;
		int preu =0;
		connection = miConexion.dameConexion();
		try {

			sql = "SELECT preu FROM productes WHERE id_producte=?";
			statement = connection.prepareStatement(sql);

			statement.setInt(1, id);

			

			resulset = statement.executeQuery();

			if (resulset.next()) {

				preu=resulset.getInt("preu");
				

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return preu;
	}
	
	public ArrayList<Producte> listarProductosTicket(int id_ticket) throws SQLException {

		ResultSet resulset = null;
		ArrayList<Producte> productes = new ArrayList<Producte>();

		String sql = null;
		connection = miConexion.dameConexion();
		
		try {
			sql = "SELECT * FROM productes WHERE ticket_id=?";
			statement = connection.prepareStatement(sql);

			statement.setInt(1, id_ticket);


			resulset = statement.executeQuery();

			while (resulset.next()) {
				Producte p = new Producte();
				p.setID(resulset.getInt("id_producte"));
				p.setClase(resulset.getString("clase"));
				p.setNom(resulset.getString("nom"));
				p.setPreu(resulset.getDouble("preu"));
				p.setOtro(resulset.getString("otro"));
				p.setTicket_id(resulset.getInt("ticket_id"));

				productes.add(p);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return productes;
	}
	public void updateProductoDevuelto(int ticket_id) throws SQLException {
		String sql = null;

		connection = miConexion.dameConexion();
		try {
			PreparedStatement miSentencia = connection.prepareStatement(
					"UPDATE productes SET ticket_id=? WHERE ticket_id=? ");

			miSentencia.setInt(1, 0);
			miSentencia.setInt(2, ticket_id);
			
			miSentencia.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
