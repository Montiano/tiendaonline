package tiendaonline.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	Connection conexion;
	String url="jdbc:mysql://localhost:3306/curso";
	String user="root";
	String pass="";
	String host = "127.0.0.1";
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion=DriverManager.getConnection(url,user,pass);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en conexión...");
		}
		return conexion;
	}
}
