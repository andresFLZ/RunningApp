package logica;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ruta {

	private String nombre;
	private String lugarInicio;
	private String lugarFinal;
	private Double distancia;
	private String duracion;
	private String fecha;
	private Double velocidadProm;
	private String tiempoKm;
	
	public Ruta(String nombre, String lugarInicio, String lugarFinal, Double distancia, String duracion, String fecha) {
		this.nombre = nombre;
		this.distancia = distancia;
		this.duracion = duracion;
		this.lugarInicio = lugarInicio;
		this.lugarFinal = lugarFinal;
		this.fecha = fecha;
		this.velocidadProm = calcularVelocidadProm(distancia, obtenerMinutos(duracion));
		this.tiempoKm = calcularTiempoKm(distancia, obtenerSegundos(duracion));
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugarInicio() {
		return lugarInicio;
	}

	public void setLugarInicio(String lugarInicio) {
		this.lugarInicio = lugarInicio;
	}

	public String getLugarFinal() {
		return lugarFinal;
	}

	public void setLugarFinal(String lugarFinal) {
		this.lugarFinal = lugarFinal;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Double getVelocidadProm() {
		return velocidadProm;
	}

	public void setVelocidadProm(Double velocidadProm) {
		this.velocidadProm = velocidadProm;
	}
	
	public String getTiempoKm() {
		return tiempoKm;
	}

	public void setTiempoKm(String tiempoKm) {
		this.tiempoKm = tiempoKm;
	}

	private Double calcularVelocidadProm(Double distancia, Integer tiempo) {
		double prom = (distancia / tiempo) * 60;
		return Math.round(prom * 100.0) / 100.0;
	}
	
	private String calcularTiempoKm(Double distancia, Integer tiempo) {
		double segundosKm = tiempo/distancia;
		int minutos = (int) (segundosKm / 60);
	    int segundos = (int) (segundosKm % 60);
	    return String.format("%d:%02d", minutos, segundos);
	}
	
	public static int obtenerSegundos(String tiempo) {
	    String[] partes = tiempo.split(":");
	    Integer segundos = 0;
	    if (partes.length == 2) {
	    	segundos = (Integer.parseInt(partes[0]) * 60) + Integer.parseInt(partes[1]);
	    } else if (partes.length == 3) {
	    	segundos = (Integer.parseInt(partes[0]) * 3600) + (Integer.parseInt(partes[1]) * 60) + Integer.parseInt(partes[2]);
	    }
		return segundos;  
	}

	
	private Integer obtenerMinutos(String tiempo) {
	    String[] partes = tiempo.split(":");
	  
	    if (partes.length == 2) {
	        return Integer.parseInt(partes[0]);
	    } else if (partes.length == 3) {
	        return Integer.parseInt(partes[1]) + (Integer.parseInt(partes[0]) * 60);
	    } else {
	        throw new IllegalArgumentException("El tiempo no está en un formato válido");
	    }
	}

	public static String distanciaTotalRecorrida(ArrayList<Double> lista) {
		double sumatoria = 0;
		
	    for (double d : lista) {
	        sumatoria += d;
	    }
	    
		return (Math.floor(sumatoria * 10.0) / 10.0) + " km";
	}
	
	public static String velocidadPromedioTotal(ArrayList<Double> lista) {
	    double suma = 0;

	    for (Double num : lista) {
	        suma += num;
	    }
	    double promedio = suma / lista.size();
	    
	    return (Math.floor(promedio * 10.0) / 10.0) + " Km/h";
	}
	
	public static String tiempoKmTotal(ArrayList<String> lista) {
		Integer suma = 0;
		
		for (String tiempo : lista) {
			suma += obtenerSegundos(tiempo);
		}
		
		LocalTime tiempo = LocalTime.ofSecondOfDay(suma / lista.size());
	    return tiempo.format(DateTimeFormatter.ofPattern("mm:ss"));
	}

	
}
