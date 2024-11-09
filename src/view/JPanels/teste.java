package view.JPanels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ClienteDAO;
import model.Cliente;
import view.Main;

public class teste extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pnlConfig, pnlHeader, pnlHome;
	private JScrollPane pnlDadosPessoais;
	private JLabel lblImagemPerfil, lblNome, lblDinheiro, lblBackground;
	private JButton[] btnsConfig;
	public JComponent[] panels = { pnlHome, pnlDadosPessoais, null, null, null, null, null, null };

	// images and fonts
	private Font font1 = new Font("Open Sans", Font.BOLD, 20);
	private Color fontColor = Color.decode("#cad0d6");
	private ImageIcon imgProfilePic = new ImageIcon("img/default_profile_pic1.png");

	private ClienteDAO conn;
	public Cliente mainClient;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teste frame = new teste();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public teste() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Art Music");
		setResizable(false);

		this.conn = Main.conn;
		mainClient = conn.getMainClient();
		initComponents();
		addingActionListeners();
		addingBackground();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#010409"));

		// lblDinheiro
		lblDinheiro = new JLabel();
		lblDinheiro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDinheiro.setBounds(1688, 20, 182, 31);
		lblDinheiro.setText("R$" + mainClient.getDinheiro() + ",00");
		lblDinheiro.setFont(font1);
		lblDinheiro.setForeground(fontColor);
		contentPane.add(lblDinheiro);

		// pnlHeader
		pnlHeader = new JPanel();
		pnlHeader.setLayout(new BoxLayout(pnlHeader, BoxLayout.X_AXIS));
		pnlHeader.setBounds(0, 0, 1920, 80);
		pnlHeader.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.decode("#3d444d")));
		pnlHeader.setOpaque(false);
		contentPane.add(pnlHeader);

		// lblImagemPerfil
		lblImagemPerfil = new JLabel("");
		lblImagemPerfil.setIcon(imgProfilePic);
		lblImagemPerfil.setPreferredSize(new Dimension(50, 50));
		lblImagemPerfil.setBackground(Color.blue);

		// lblNome
		lblNome = new JLabel(mainClient.getNome() + " " + mainClient.getSobrenome());
		lblNome.setFont(font1);
		lblNome.setForeground(fontColor);

		// pnlHeader boxLayout
		pnlHeader.add(Box.createRigidArea(new Dimension(20, 0)));
		pnlHeader.add(lblImagemPerfil);
		pnlHeader.add(Box.createRigidArea(new Dimension(10, 0)));
		pnlHeader.add(lblNome);

		// pnlConfig
		pnlConfig = new OptionJPanel();
		pnlConfig.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.decode("#3d444d")));
		pnlConfig.setBounds(1620, 80, 300, 1000);
		pnlConfig.setBackground(Color.decode("#0d1117"));
		contentPane.add(pnlConfig);

		// pnlHome
		pnlHome = new HomeJPanel();
		pnlHome.setBounds(0, 100, 1920, 200);
		contentPane.add(pnlHome);
		pnlHome.setLayout(new BoxLayout(pnlHome, BoxLayout.Y_AXIS));
//		pnlHome.setVisible(false);

		// pnlDadosPessoais
		pnlDadosPessoais = new JScrollPane(new DadosPessoaisJPanel());
		pnlDadosPessoais.setBounds(300, 100, 1320, 950);
		DadosPessoaisJPanel.configScrollPane(pnlDadosPessoais);
		contentPane.add(pnlDadosPessoais);
		pnlDadosPessoais.setVisible(false);

		JComponent[] panels2 = { pnlHome, pnlDadosPessoais };
		panels = panels2;

		// btn functions
		btnsConfig = ((OptionJPanel) pnlConfig).getButtons();
		int i = 0;
		for (JButton jButton : btnsConfig) {

			final int index = i;
			jButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (JComponent jComponent : panels) {
						jComponent.setVisible(false);
					}
					panels[index].setVisible(true);
				}
			});
			i++;
		}
	}

	private void addingActionListeners() {
	}

	private void addingBackground() {
		lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 1920, 1080);
		lblBackground.setIcon(new ImageIcon());
		contentPane.add(lblBackground);
	}
	
	public void updateDinheiro(int i) {
		lblDinheiro.setText("R$" + i + ",00");
	}
}