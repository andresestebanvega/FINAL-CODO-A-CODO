package infrastructure.persistence.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	public static Connection getConnection() {

		String host = "localhost";
		String port = "3306";
		String username = "root";
		String password = "root";
		String nombredb = "cosmetolover";

		// Driver de conexion a la base de datos (MySql)

		String driverClassName = "com.mysql.cj.jdbc.Driver";
		
		Connection connection = null;
		
		try {
			
			
			Class.forName(driverClassName);
			String url = "jdbc:mysql://"+ host + ":" + port + "/" + nombredb;
			
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("CONEXION ESTABLECIDA ...");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		

	}
}
