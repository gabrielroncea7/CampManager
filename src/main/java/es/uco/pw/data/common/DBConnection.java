package es.uco.pw.data.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnection {

	protected Connection connection = null;

	// Important: This configuration is hard-coded here for illustrative purposes only
	

	String usuarioQuery = Config.getQuery("config.usuario");
	
	String passwordQuery = Config.getQuery("config.password");
	
	String urlQuery = Config.getQuery("config.url");
	
	public Connection getConnection(){

		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = (Connection) DriverManager.getConnection(urlQuery, usuarioQuery, passwordQuery);
				//System.out.println("Database connection successfully opened!");

		} 
		catch (SQLException e) {
			System.err.println("Connection to MySQL has failed!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("JDBC Driver not found.");
			e.printStackTrace();
		}
		return this.connection;
	}

	// We can include here other methods to encapsulate CRUD commands...

	public void closeConnection() {
		try {
			if(this.connection != null && !this.connection.isClosed()) {
				this.connection.close();
				//System.out.println("Database connection successfully closed!");
			}
		} catch (SQLException e) {
			System.err.println("Error while trying to close the connection.");
			e.printStackTrace();
		}
	}
}
