package app;

import interfaz.RutaUI;

public class Aplicacion {

	public Aplicacion() {
		ventanaPrincipal();
	}

	private void ventanaPrincipal() {
		RutaUI ventanaP = new RutaUI();
		ventanaP.setVisible(true);
	}
	
}
