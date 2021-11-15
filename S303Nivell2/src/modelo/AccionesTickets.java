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
public class AccionesTickets {
	private Conexion miConexion;
	private Connection connection;
	private boolean estadoOperacion;
	private PreparedStatement statement;

	public AccionesTickets() {
		miConexion = new Conexion();

	}

	public void addTicket(Ticket ticket) throws SQLException {
		String sql = null;

		connection = miConexion.dameConexion();
		try {
			PreparedStatement miSentencia = connection.prepareStatement(
					"INSERT INTO tickets(id_ticket ,preuTotal) VALUES(?,?)");

			miSentencia.setString(1, null);
			miSentencia.setDouble(2, ticket.getValorTotal());

			miSentencia.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	public void updateTicket(int id_ticket,double valorTicket) throws SQLException {
		String sql = null;

		connection = miConexion.dameConexion();
		try {
			PreparedStatement miSentencia = connection.prepareStatement(
					"UPDATE tickets SET preuTotal=? WHERE id_ticket=? ");

			miSentencia.setDouble(1, valorTicket);
			miSentencia.setInt(2, id_ticket);

			miSentencia.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	public ArrayList<Ticket> listarTickets() throws SQLException {

		ResultSet resulset = null;
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();

		String sql = null;
		connection = miConexion.dameConexion();
		java.sql.Statement sta = connection.createStatement();
		try {
			sql = "SELECT * FROM tickets";

			resulset = sta.executeQuery(sql);

			while (resulset.next()) {
				Ticket t= new Ticket();
				t.setID(resulset.getInt("id_ticket"));
				t.setValorTotal(resulset.getDouble("preuTotal"));
				

				tickets.add(t);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return tickets;
	}

	public void eliminarTicket(int id_ticket) throws SQLException {
		String sql = null;

		connection = miConexion.dameConexion();
		try {
			PreparedStatement miSentencia = connection.prepareStatement("DELETE FROM tickets  WHERE id_ticket=? ");

			miSentencia.setInt(1, id_ticket);

			miSentencia.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
	public Ticket mostrarTicket(int id) throws SQLException {
		ResultSet resulset = null;
		String sql = null;
		Ticket t = new Ticket();
		connection = miConexion.dameConexion();
		try {

			sql = "SELECT * FROM tickets WHERE id_ticket =?";
			statement = connection.prepareStatement(sql);

			statement.setInt(1, id);

			//t = new Ticket();

			resulset = statement.executeQuery();

			if (resulset.next()) {

				t.setID(resulset.getInt("id_ticket"));
				t.setValorTotal(resulset.getDouble("preuTotal"));
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return t;
	}
	public int valorTotalTickets() throws SQLException {

		ResultSet resulset = null;
		int contador=0;

		String sql = null;
		connection = miConexion.dameConexion();
		java.sql.Statement sta = connection.createStatement();
		try {
			sql = "SELECT SUM(preuTotal) AS contador FROM tickets";

			resulset = sta.executeQuery(sql);

			if (resulset.next()) {
			
				contador= resulset.getInt("contador");

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return contador;
	}

}
