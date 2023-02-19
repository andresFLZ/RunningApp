package logica;

public class Ruta {

	private String nombre;
	private String lugarInicio;
	private String lugarFinal;
	private String distancia;
	private String duracion;
	
	public Ruta(String lugarInicio, String lugarFinal, String distancia, String duracion) {
		this.distancia = distancia;
		this.duracion = duracion;
		this.lugarInicio = lugarInicio;
		this.lugarFinal = lugarFinal;
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

	public String getDistancia() {
		return distancia;
	}

	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
		
}
