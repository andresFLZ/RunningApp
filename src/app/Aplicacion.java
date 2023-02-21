package app;

//import dao.BaseDeDatos;
import interfaz.RutaUI;

public class Aplicacion {

	//private BaseDeDatos db = new BaseDeDatos(); 
	
	public Aplicacion() {
		ventanaPrincipal();
		//conectarDB();
	}

	private void ventanaPrincipal() {
		RutaUI ventanaP = new RutaUI();
		ventanaP.setVisible(true);
	}
	
	/*private void conectarDB() {
		db.conectar();
	}*/
}
