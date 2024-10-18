package view;

import java.awt.Color;
import java.awt.EventQueue;

//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;

import controller.ClienteDAO;

public class JFrameCadastroNew extends JFrameCadastro {

	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameCadastroNew frame = new JFrameCadastroNew(new ClienteDAO());
					frame.setTitle("Cadastro");
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameCadastroNew(ClienteDAO conn) {
		super(conn);
		btnEnviar.setBackground(new Color(0,255,255));
	}

}
