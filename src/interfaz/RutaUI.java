package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RutaUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnVerRutas, btnAadirRutas;

	/**
	 * Create the frame.
	 */
	public RutaUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponentes();
		
		setTitle("RUNNING APP");
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void iniciarComponentes() {
		setBounds(100, 100, 243, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("RUNNING APP");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Georgia", Font.BOLD, 18));
		lblTitulo.setBounds(10, 11, 207, 33);
		contentPane.add(lblTitulo);
		
		btnVerRutas = new JButton("Ver Rutas");
		btnVerRutas.addActionListener(this);
		btnVerRutas.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnVerRutas.setBounds(49, 55, 123, 23);
		contentPane.add(btnVerRutas);
		
		btnAadirRutas = new JButton("Añadir Rutas");
		btnAadirRutas.addActionListener(this);
		btnAadirRutas.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnAadirRutas.setBounds(49, 89, 123, 23);
		contentPane.add(btnAadirRutas);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnAadirRutas == e.getSource()) {
			AnadirUI ventanaAnadir = new AnadirUI();
			ventanaAnadir.setVisible(true);
			dispose();
		}
		if (btnVerRutas == e.getSource()) {
			VerUI ventanaVer = new VerUI();
			ventanaVer.llenarTabla();
			ventanaVer.setVisible(true);
			dispose();
		}
	}
}
