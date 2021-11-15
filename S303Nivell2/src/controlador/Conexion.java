package controlador;

import java.sql.*;
public class Conexion {

	private static Connection miConexion=null; ;
	public Conexion() {
		
	}
	
	public static Connection dameConexion() {
		
		try {
			//Crear Conexion
				
			  	String conex="jdbc:mysql://localhost:3306/margarita";
		        
		        //INCIALIZAMOS LA CONEXIÓN A LA BASE DE DATOS
				 miConexion = DriverManager.getConnection (conex,"root","");
		}catch(Exception e) {
			System.out.println("no conecta");
			e.printStackTrace();
		}	
		return miConexion;
	}
	
}
