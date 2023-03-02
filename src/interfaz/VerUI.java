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
import interfaz.recursos.RenderTable;
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
		setBounds(100, 100, 731, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("RUTAS REALIZADAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Georgia", Font.BOLD, 18));
		lblTitulo.setBounds(10, 11, 695, 27);
		contentPane.add(lblTitulo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 695, 136);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		table.setModel(model);
		
		model.addColumn("Nombre");
		model.addColumn("Lugar de inicio");
		model.addColumn("Lugar de finalización");
		model.addColumn("Fecha");
		model.addColumn("Detalle");
		
		scrollPane.setViewportView(table);
		
		btnVolver = new JButton("Volver");
		btnVolver.addActionListener(this);
		btnVolver.setBounds(321, 196, 89, 23);
		contentPane.add(btnVolver);
	}

	public void llenarTabla() {
		ArrayList<Ruta> lista = dao.consultarRutas();
		
		for (Ruta ruta : lista) {
		    Object[] fila = new Object[5];
		    fila[0] = ruta.getNombre();
		    fila[1] = ruta.getLugarInicio();
		    fila[2] = ruta.getLugarFinal();
		    fila[3] = ruta.getFecha();
		    fila[4] = new JButton("Ver detalles");
		    model.addRow(fila);
		}
		
		this.table.setDefaultRenderer(Object.class, new RenderTable());
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


