package logica;

public class Ruta {

	private String nombre;
	private String lugarInicio;
	private String lugarFinal;
	private Double distancia;
	private String duracion;
	private String fecha;
	private Double velocidadProm;
	
	public Ruta(String nombre, String lugarInicio, String lugarFinal, Double distancia, String duracion, String fecha) {
		this.nombre = nombre;
		this.distancia = distancia;
		this.duracion = duracion;
		this.lugarInicio = lugarInicio;
		this.lugarFinal = lugarFinal;
		this.fecha = fecha;
		this.velocidadProm = calcularVelocidadProm(distancia, obtenerMinutos(duracion));
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
	
	private Double calcularVelocidadProm(Double distancia, Integer tiempo) {
		double prom = (distancia / tiempo) * 60;
		return Math.round(prom * 100.0) / 100.0;
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

	
}
