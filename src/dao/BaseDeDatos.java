package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatos {
	Connection cx = null;
	
	public Connection conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			cx = DriverManager.getConnection("jdbc:sqlite:rutas.db");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return cx;
	}
	
	public void desconectar() {
		try {
			cx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
