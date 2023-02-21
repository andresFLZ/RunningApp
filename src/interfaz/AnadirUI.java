package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.RutaDAO;
import logica.Ruta;

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
	private JTextField txtNombre;
	private JTextField txtFecha;
	private RutaDAO dao = new RutaDAO();

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
		setBounds(100, 100, 289, 325);
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
		txtPuntoP.setBounds(10, 147, 118, 20);
		contentPane.add(txtPuntoP);
		txtPuntoP.setColumns(10);
		
		JLabel lblPuntoP = new JLabel("Punto de partida");
		lblPuntoP.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntoP.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblPuntoP.setBounds(10, 122, 118, 20);
		contentPane.add(lblPuntoP);
		
		txtPuntoL = new JTextField();
		txtPuntoL.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtPuntoL.setColumns(10);
		txtPuntoL.setBounds(145, 147, 118, 20);
		contentPane.add(txtPuntoL);
		
		JLabel lblPuntoL = new JLabel("Punto de llegada");
		lblPuntoL.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuntoL.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblPuntoL.setBounds(145, 122, 118, 20);
		contentPane.add(lblPuntoL);
		
		txtDistancia = new JTextField();
		txtDistancia.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtDistancia.setColumns(10);
		txtDistancia.setBounds(10, 203, 118, 20);
		contentPane.add(txtDistancia);
		
		JLabel lblDistancia = new JLabel("Distancia (Km)");
		lblDistancia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistancia.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblDistancia.setBounds(10, 178, 118, 20);
		contentPane.add(lblDistancia);
		
		txtDuracion = new JTextField();
		txtDuracion.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtDuracion.setColumns(10);
		txtDuracion.setBounds(145, 203, 118, 20);
		contentPane.add(txtDuracion);
		
		JLabel lblDuracion = new JLabel("Duración");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuracion.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblDuracion.setBounds(145, 178, 118, 20);
		contentPane.add(lblDuracion);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.addActionListener(this);
		btnAñadir.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnAñadir.setBounds(10, 248, 118, 23);
		contentPane.add(btnAñadir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Georgia", Font.PLAIN, 14));
		btnCancelar.setBounds(145, 248, 118, 23);
		contentPane.add(btnCancelar);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBounds(10, 91, 118, 20);
		contentPane.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblNombre.setBounds(10, 66, 118, 20);
		contentPane.add(lblNombre);
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Georgia", Font.PLAIN, 14));
		txtFecha.setColumns(10);
		txtFecha.setBounds(145, 91, 118, 20);
		contentPane.add(txtFecha);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblFecha.setBounds(145, 66, 118, 20);
		contentPane.add(lblFecha);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnAñadir == e.getSource()) {
			try {
				Ruta ruta = new Ruta(txtNombre.getText(), txtPuntoP.getText(), txtPuntoL.getText(), 
						Double.parseDouble(txtDistancia.getText()), txtDuracion.getText(), txtFecha.getText());
				if (dao.insertarRuta(ruta)) {
					JOptionPane.showMessageDialog(null, "RUTA CORRECTAMENTE AGREGADA");
				} else {
					JOptionPane.showMessageDialog(null, "ERROR1");
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "ERROR2");
			}
		}
	}
}
