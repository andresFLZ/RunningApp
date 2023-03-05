package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import logica.Ruta;

public class RutaDAO {

	private BaseDeDatos db;
	
	public RutaDAO() {
		db = new BaseDeDatos();
	}
	
	public boolean insertarRuta(Ruta ruta) {
		PreparedStatement ps = null;
		try {
			ps = db.conectar().prepareStatement("INSERT INTO ruta VALUES(null,?,?,?,?,?,?,?,?)");
			ps.setString(1, ruta.getNombre());
			ps.setString(2, ruta.getLugarInicio());
			ps.setString(3, ruta.getLugarFinal());
			ps.setDouble(4, ruta.getDistancia());
			ps.setString(5, ruta.getDuracion());
			ps.setString(6, ruta.getFecha());
			ps.setDouble(7, ruta.getVelocidadProm());
			ps.setString(8, ruta.getTiempoKm());
			ps.executeUpdate();
			db.desconectar();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Ruta> consultarRutas() {
		ArrayList<Ruta> lista = new ArrayList<Ruta>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = db.conectar().prepareStatement("SELECT * FROM ruta");
			rs = ps.executeQuery();
			while (rs.next()) {
				Ruta ruta = new Ruta(rs.getString("nombre"), rs.getString("lugarInicio"), rs.getString("lugarFinal"),
						rs.getDouble("distancia"), rs.getString("duracion"), rs.getString("fecha"));
				ruta.setVelocidadProm(rs.getDouble("velocidadPromedio"));
				ruta.setTiempoKm(rs.getString("tiempoKilometro"));
				lista.add(ruta);
			}
			db.desconectar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public Ruta obtenerRutaPorNombre(String nombreRuta) {
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    Ruta ruta = null;
	    
	    try {
	        ps = db.conectar().prepareStatement("SELECT * FROM ruta WHERE nombre = ?");
	        ps.setString(1, nombreRuta);
	        rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            ruta = new Ruta(rs.getString("nombre"), rs.getString("lugarInicio"), rs.getString("lugarFinal"),
	                            rs.getDouble("distancia"), rs.getString("duracion"), rs.getString("fecha"));
	            ruta.setVelocidadProm(rs.getDouble("velocidadPromedio"));
	            ruta.setTiempoKm(rs.getString("tiempoKilometro"));
	        }
	        db.desconectar();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return ruta;
	}

	public boolean validarRutaExistente(String nombre) {
	    boolean existe = false;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        ps = db.conectar().prepareStatement("SELECT COUNT(*) FROM ruta WHERE nombre = ?");
	        ps.setString(1, nombre);
	        rs = ps.executeQuery();
	        rs.next();
	        int count = rs.getInt(1);
	        if (count > 0) {
	            existe = true;
	        }
	        db.desconectar();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return existe;
	}

	public boolean actualizarRuta(Ruta ruta) {
	    boolean actualizacion = false;
	    PreparedStatement ps = null;
	    
	    try {
	        ps = db.conectar().prepareStatement("UPDATE ruta SET lugarInicio = ?, lugarFinal = ?, distancia = ?, duracion = ?, fecha = ?, velocidadPromedio = ?, tiempoKilometro = ? WHERE nombre = ?");
	        ps.setString(1, ruta.getLugarInicio());
	        ps.setString(2, ruta.getLugarFinal());
	        ps.setDouble(3, ruta.getDistancia());
	        ps.setString(4, ruta.getDuracion());
	        ps.setString(5, ruta.getFecha());
	        ps.setDouble(6, ruta.getVelocidadProm());
	        ps.setString(7, ruta.getTiempoKm());
	        ps.setString(8, ruta.getNombre());
	        
	        int filasActualizadas = ps.executeUpdate();
	        
	        if (filasActualizadas > 0) {
	        	actualizacion = true;
	        }
	        db.desconectar();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return actualizacion;
	}

	public ArrayList<Double> obtenerDistancias() {
	    ArrayList<Double> distancias = new ArrayList<>();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    try {
	    	ps = db.conectar().prepareStatement("SELECT distancia FROM ruta");
	    	rs = ps.executeQuery();
	    			
	        while (rs.next()) {
	            distancias.add(rs.getDouble("distancia"));
	        }
	        rs.close();
	        db.desconectar();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return distancias;
	}
	
	public ArrayList<Double> obtenerVelocidadesP() {
	    ArrayList<Double> velocidades = new ArrayList<>();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    try {
	    	ps = db.conectar().prepareStatement("SELECT velocidadPromedio FROM ruta");
	    	rs = ps.executeQuery();
	    			
	        while (rs.next()) {
	        	velocidades.add(rs.getDouble("velocidadPromedio"));
	        }
	        rs.close();
	        db.desconectar();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return velocidades;
	}

	public ArrayList<String> obtenerTiemposKm() {
	    ArrayList<String> tiempos = new ArrayList<>();
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    try {
	    	ps = db.conectar().prepareStatement("SELECT tiempoKilometro FROM ruta");
	    	rs = ps.executeQuery();
	    			
	        while (rs.next()) {
	        	tiempos.add(rs.getString("tiempoKilometro"));
	        }
	        rs.close();
	        db.desconectar();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return tiempos;
	}
	
}
