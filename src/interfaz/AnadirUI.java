package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AnadirUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtPuntoP;
	private JTextField txtPuntoL;
	private JTextField txtDistancia;
	private JTextField txtDuracion;
	private JButton btnAñadir;
	private JButton btnCancelar;

	/**
	 * Create the frame.
	 */
	public AnadirUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponentes();
		
		setTitle("AÑADIR");
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void iniciarComponentes() {
		setBounds(100, 100, 289, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("AÑADIR UNA RUTA");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Georgia", Font.BOLD, 18));
		lblTitulo.setBounds(10, 26, 253, 29);
		contentPane.add(lblTitulo);
		
		txtPuntoP = new JTextField();
		txtPuntoP.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtPuntoP.setBounds(10, 95, 118, 20);
		contentPane.add(txtPuntoP);
		txtPuntoP.setColumns(10);
		
		JLabel lblPuntoP = new JLabel("Punto de partida");
		lblPuntoP.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntoP.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblPuntoP.setBounds(10, 70, 118, 20);
		contentPane.add(lblPuntoP);
		
		txtPuntoL = new JTextField();
		txtPuntoL.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtPuntoL.setColumns(10);
		txtPuntoL.setBounds(145, 95, 118, 20);
		contentPane.add(txtPuntoL);
		
		JLabel lblPuntoL = new JLabel("Punto de llegada");
		lblPuntoL.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntoL.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblPuntoL.setBounds(151, 70, 118, 20);
		contentPane.add(lblPuntoL);
		
		txtDistancia = new JTextField();
		txtDistancia.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtDistancia.setColumns(10);
		txtDistancia.setBounds(10, 151, 118, 20);
		contentPane.add(txtDistancia);
		
		JLabel lblDistancia = new JLabel("Distancia");
		lblDistancia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistancia.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblDistancia.setBounds(10, 126, 118, 20);
		contentPane.add(lblDistancia);
		
		txtDuracion = new JTextField();
		txtDuracion.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(145, 151, 118, 20);
		contentPane.add(txtDuracion);
		
		JLabel lblDuracion = new JLabel("Duración");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuracion.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblDuracion.setBounds(145, 126, 118, 20);
		contentPane.add(lblDuracion);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.addActionListener(this);
		btnAñadir.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnAñadir.setBounds(10, 196, 118, 23);
		contentPane.add(btnAñadir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnCancelar.setBounds(145, 196, 118, 23);
		contentPane.add(btnCancelar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnAñadir == e.getSource()) {
			JOptionPane.showMessageDialog(null, "Añadir");
		}
	}
}
