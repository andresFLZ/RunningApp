package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.RutaDAO;
import logica.Ruta;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class EstadisticaUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblDistanciaR;
	private JLabel lblVelocidadPR;
	private JLabel lblTiempoKmR;
	private RutaDAO dao = new RutaDAO();
	private JButton btnVolver;

	public EstadisticaUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponentes();
		
		setTitle("ESTADISTICAS");
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void iniciarComponentes() {
		setBounds(100, 100, 367, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(132, 124, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblTitulo = new JLabel("Estadisticas");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Georgia", Font.BOLD, 18));
		lblTitulo.setBounds(58, 11, 235, 23);
		contentPane.add(lblTitulo);
		
		JLabel lblDistancia = new JLabel("Distancia total recorrida:");
		lblDistancia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDistancia.setBounds(10, 45, 203, 14);
		contentPane.add(lblDistancia);
		
		JLabel lblVelocidadP = new JLabel("Velocidad promedio:");
		lblVelocidadP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVelocidadP.setBounds(10, 70, 203, 14);
		contentPane.add(lblVelocidadP);
		
		JLabel lblTiempoKm = new JLabel("Tiempo por kilometro promedio:");
		lblTiempoKm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTiempoKm.setBounds(10, 95, 203, 14);
		contentPane.add(lblTiempoKm);
		
		lblDistanciaR = new JLabel("New label");
		lblDistanciaR.setHorizontalAlignment(SwingConstants.LEFT);
		lblDistanciaR.setBounds(223, 45, 118, 14);
		contentPane.add(lblDistanciaR);
		
		lblVelocidadPR = new JLabel("New label");
		lblVelocidadPR.setHorizontalAlignment(SwingConstants.LEFT);
		lblVelocidadPR.setBounds(223, 70, 118, 14);
		contentPane.add(lblVelocidadPR);
		
		lblTiempoKmR = new JLabel("New label");
		lblTiempoKmR.setHorizontalAlignment(SwingConstants.LEFT);
		lblTiempoKmR.setBounds(223, 95, 118, 14);
		contentPane.add(lblTiempoKmR);
	}
	
	public void llenarDatos() {
		lblDistanciaR.setText(Ruta.distanciaTotalRecorrida(dao.obtenerDistancias()));
		lblVelocidadPR.setText(Ruta.velocidadPromedioTotal(dao.obtenerVelocidadesP()));
		lblTiempoKmR.setText(Ruta.tiempoKmTotal(dao.obtenerTiemposKm()));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnVolver == e.getSource()) {
			VerUI ventanaV = new VerUI();
			ventanaV.llenarTabla();
			ventanaV.setVisible(true);
			dispose();
		}
	}
	
}
