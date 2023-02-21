package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import dao.RutaDAO;
import logica.Ruta;

import javax.swing.JButton;

public class VerUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVolver;
	private RutaDAO dao = new RutaDAO();
	private DefaultTableModel model;
	
	/**
	 * Create the frame.
	 */
	public VerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponentes();
		
		setTitle("RUTAS");
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void iniciarComponentes() {
		setBounds(100, 100, 693, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("RUTAS REALIZADAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Georgia", Font.BOLD, 18));
		lblTitulo.setBounds(10, 11, 603, 27);
		contentPane.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 657, 136);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		table.setModel(model);
		
		model.addColumn("Nombre");
		model.addColumn("Lugar de inicio");
		model.addColumn("Lugar de finalización");
		model.addColumn("Distancia (Km)");
		model.addColumn("Tiempo");
		model.addColumn("Fecha");
		model.addColumn("Velocidad promedio (Km)");
		
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(97);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(66);
		table.getColumnModel().getColumn(5).setPreferredWidth(63);
		table.getColumnModel().getColumn(6).setPreferredWidth(110);
		scrollPane.setViewportView(table);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(268, 196, 89, 23);
		contentPane.add(btnVolver);
	}

	public void llenarTabla() {
		ArrayList<Ruta> lista = dao.consultarRutas();
		
		for (Ruta ruta : lista) {
			Object[] fila = new Object[7];
			fila[0] = ruta.getNombre();
			fila[1] = ruta.getLugarInicio();
			fila[2] = ruta.getLugarFinal();
			fila[3] = ruta.getDistancia();
			fila[4] = ruta.getDuracion();
			fila[5] = ruta.getFecha();
			fila[6] = ruta.getVelocidadProm();
			
			model.addRow(fila);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnVolver == e.getSource()) {
			RutaUI ventanaP = new RutaUI();
			ventanaP.setVisible(true);
			dispose();
		}
		
	}
}
