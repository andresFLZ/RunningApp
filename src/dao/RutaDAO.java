package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import logica.Ruta;

public class RutaDAO {

	private BaseDeDatos db;
	
	public RutaDAO() {
		db = new BaseDeDatos();
	}
	
	public boolean insertarRuta(Ruta ruta) {
		PreparedStatement ps = null;
		try {
			ps = db.conectar().prepareStatement("INSERT INTO ruta VALUES(null,?,?,?,?,?,?,?)");
			ps.setString(1, ruta.getNombre());
			ps.setString(2, ruta.getLugarInicio());
			ps.setString(3, ruta.getLugarFinal());
			ps.setDouble(4, ruta.getDistancia());
			ps.setString(5, ruta.getDuracion());
			ps.setString(6, ruta.getFecha());
			ps.setDouble(7, ruta.getVelocidadProm());
			ps.executeUpdate();
			db.desconectar();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
