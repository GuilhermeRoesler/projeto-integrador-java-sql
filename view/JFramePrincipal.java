package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.ClienteDAO;

public class JFramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblBackground;
	private JButton btnArtistas, btnCadastrar, btnEventos;
	
	private ClienteDAO conn;

	public JFramePrincipal(ClienteDAO conn) {
		this.conn = conn;
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// scrollPane
		scrollPane = new JScrollPane();
		scrollPane.setBounds(169, 317, 294, 278);
		contentPane.add(scrollPane);

		// table
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { "oi", null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
				new String[] { "Artista", "Nome", "Data", "Local" }));

		// transparency
		// table.setShowGrid(false);
		// table.setGridColor(Color.RED);
		table.setBackground(new Color(0, 0, 0, 0));
		((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setBackground(new Color(0, 0, 0, 0));
		scrollPane.setBackground(new Color(0, 0, 0, 0));
		scrollPane.setOpaque(false);
		table.setOpaque(false);
		((DefaultTableCellRenderer) table.getDefaultRenderer(Object.class)).setOpaque(false);
		scrollPane.getViewport().setOpaque(false);

		// btnCadastrar
		btnCadastrar = new JButton();
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFrameCadastro frame = new JFrameCadastro(conn);
					frame.setTitle("Cadastrar");
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(80, 128, 150, 31);
		btnCadastrar.setContentAreaFilled(false);
		btnCadastrar.setBorderPainted(false);
		contentPane.add(btnCadastrar);

		// btnArtistas
		btnArtistas = new JButton();
		btnArtistas.setBounds(80, 186, 150, 31);
		btnArtistas.setContentAreaFilled(false);
		btnArtistas.setBorderPainted(false);
		contentPane.add(btnArtistas);

		// btnEventos
		btnEventos = new JButton();
		btnEventos.setBounds(80, 246, 150, 31);
		btnEventos.setContentAreaFilled(false);
		btnEventos.setBorderPainted(false);
		contentPane.add(btnEventos);

		// lblBackground
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(
				"C:\\Users\\Gui\\Documents\\Guilherme\\GitHub\\projeto-integrador-java-sql\\ART Music.png"));
		lblBackground.setBounds(0, 0, 484, 661);
		contentPane.add(lblBackground);
	}
}
