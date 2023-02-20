package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VerUI extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
	}

}
