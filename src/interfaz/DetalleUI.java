package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.Ruta;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class DetalleUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnVolver;
	private JLabel lblNombreR;
	private JLabel lblLugarInicioR;
	private JLabel lblLugarFinalR;
	private JLabel lblDistanciaR;
	private JLabel lblTiempoR;
	private JLabel lblFechaR;
	private JLabel lblVelocidadPR;
	private JLabel lblTiempoKmR;
	private JButton btnEditar;


	/**
	 * Create the frame.
	 */
	public DetalleUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponentes();
		
		setTitle("DETALLE");
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	private void iniciarComponentes() {
		setBounds(100, 100, 336, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Detalle ruta");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(10, 10, 300, 21);
		lblTitulo.setFont(new Font("Georgia", Font.BOLD, 18));
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblNombre.setBounds(97, 59, 53, 14);
		contentPane.add(lblNombre);
		
		JLabel lblLugarDeInicio = new JLabel("Lugar de inicio:");
		lblLugarDeInicio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLugarDeInicio.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblLugarDeInicio.setBounds(54, 86, 96, 14);
		contentPane.add(lblLugarDeInicio);
		
		JLabel lblLugarDeFinalizacin = new JLabel("Lugar de finalización:");
		lblLugarDeFinalizacin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLugarDeFinalizacin.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblLugarDeFinalizacin.setBounds(20, 111, 130, 14);
		contentPane.add(lblLugarDeFinalizacin);
		
		JLabel lblDistancia = new JLabel("Distancia:");
		lblDistancia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDistancia.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblDistancia.setBounds(86, 135, 64, 14);
		contentPane.add(lblDistancia);
		
		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTiempo.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblTiempo.setBounds(97, 160, 53, 14);
		contentPane.add(lblTiempo);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFecha.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblFecha.setBounds(97, 185, 53, 14);
		contentPane.add(lblFecha);
		
		JLabel lblVelocidadP = new JLabel("Velocidad promedio:");
		lblVelocidadP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVelocidadP.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblVelocidadP.setBounds(28, 210, 122, 14);
		contentPane.add(lblVelocidadP);
		
		JLabel lblTiempoKm = new JLabel("Tiempo por kilometro:");
		lblTiempoKm.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTiempoKm.setFont(new Font("Georgia", Font.PLAIN, 11));
		lblTiempoKm.setBounds(20, 235, 130, 14);
		contentPane.add(lblTiempoKm);
		
		lblNombreR = new JLabel("New label");
		lblNombreR.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreR.setFont(new Font("Georgia", Font.BOLD, 11));
		lblNombreR.setBounds(160, 59, 150, 14);
		contentPane.add(lblNombreR);
		
		lblLugarInicioR = new JLabel("New label");
		lblLugarInicioR.setHorizontalAlignment(SwingConstants.LEFT);
		lblLugarInicioR.setFont(new Font("Georgia", Font.BOLD, 11));
		lblLugarInicioR.setBounds(160, 86, 150, 14);
		contentPane.add(lblLugarInicioR);
		
		lblLugarFinalR = new JLabel("New label");
		lblLugarFinalR.setHorizontalAlignment(SwingConstants.LEFT);
		lblLugarFinalR.setFont(new Font("Georgia", Font.BOLD, 11));
		lblLugarFinalR.setBounds(160, 111, 150, 14);
		contentPane.add(lblLugarFinalR);
		
		lblDistanciaR = new JLabel("New label");
		lblDistanciaR.setHorizontalAlignment(SwingConstants.LEFT);
		lblDistanciaR.setFont(new Font("Georgia", Font.BOLD, 11));
		lblDistanciaR.setBounds(160, 135, 150, 14);
		contentPane.add(lblDistanciaR);
		
		lblTiempoR = new JLabel("New label");
		lblTiempoR.setHorizontalAlignment(SwingConstants.LEFT);
		lblTiempoR.setFont(new Font("Georgia", Font.BOLD, 11));
		lblTiempoR.setBounds(160, 160, 150, 14);
		contentPane.add(lblTiempoR);
		
		lblFechaR = new JLabel("New label");
		lblFechaR.setHorizontalAlignment(SwingConstants.LEFT);
		lblFechaR.setFont(new Font("Georgia", Font.BOLD, 11));
		lblFechaR.setBounds(160, 185, 150, 14);
		contentPane.add(lblFechaR);
		
		lblVelocidadPR = new JLabel("New label");
		lblVelocidadPR.setHorizontalAlignment(SwingConstants.LEFT);
		lblVelocidadPR.setFont(new Font("Georgia", Font.BOLD, 11));
		lblVelocidadPR.setBounds(160, 210, 150, 14);
		contentPane.add(lblVelocidadPR);
		
		lblTiempoKmR = new JLabel("New label");
		lblTiempoKmR.setHorizontalAlignment(SwingConstants.LEFT);
		lblTiempoKmR.setFont(new Font("Georgia", Font.BOLD, 11));
		lblTiempoKmR.setBounds(160, 235, 150, 14);
		contentPane.add(lblTiempoKmR);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		btnEditar.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnEditar.setBounds(60, 276, 89, 23);
		contentPane.add(btnEditar);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Georgia", Font.PLAIN, 11));
		btnVolver.setBounds(159, 276, 89, 23);
		contentPane.add(btnVolver);
	}

	public void llenarDatos(Ruta ruta) {
		lblNombreR.setText(ruta.getNombre());
		lblLugarInicioR.setText(ruta.getLugarInicio());
		lblLugarFinalR.setText(ruta.getLugarFinal());
		lblDistanciaR.setText(Double.toString(ruta.getDistancia()));
		lblTiempoR.setText(ruta.getDuracion());
		lblFechaR.setText(ruta.getFecha());
		lblVelocidadPR.setText(Double.toString(ruta.getVelocidadProm()));
		lblTiempoKmR.setText(ruta.getTiempoKm());
	}
	
	private Ruta capturarDatos() {
		
		return new Ruta(lblNombreR.getText(), lblLugarInicioR.getText(), 
				lblLugarFinalR.getText(), Double.parseDouble(lblDistanciaR.getText()), 
				lblTiempoR.getText(), lblFechaR.getText());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnVolver == e.getSource()) {
			VerUI ventanaV = new VerUI();
			ventanaV.llenarTabla();
			ventanaV.setVisible(true);
			dispose();
		}
		
		if (btnEditar == e.getSource()) {
			AnadirUI ventanaA = new AnadirUI();
			ventanaA.actualizarDatos(this.capturarDatos());
			ventanaA.setVisible(true);
			dispose();
		}
	}
}
