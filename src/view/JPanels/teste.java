package view.JPanels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class teste extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelConfig, pnlHeader, pnlHome;
	private JButton btnHome, btnOpcoes, btnConfig, btnDadosPessoais, btnAtividade, btnNotificacoes, btnAjuda,
			btnDinheiro, btnSair;
	private JLabel lblDinheiro, lblBackground;

//	private int opcoesX = 1740;
//	private int opcoesY = 130;
//	private int opcoesSeparadorY = 70;
//	private int opcoesWidth = 150;
//	private int opcoesHeigth = 50;

	private JLabel lblImagemPerfil;
	private JLabel lblNome;

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

		initComponents();
		addingBackground();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// pnlHeader
		pnlHeader = new JPanel();
		pnlHeader.setLayout(new BoxLayout(pnlHeader, BoxLayout.X_AXIS));
		pnlHeader.setBounds(0, 0, 1920, 80);
		pnlHeader.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
		contentPane.add(pnlHeader);

		// lblImagemPerfil
		lblImagemPerfil = new JLabel("");
		lblImagemPerfil.setIcon(new ImageIcon(
				"C:\\Users\\Gui\\Documents\\Guilherme\\GitHub\\projeto-integrador-java-sql\\img\\default_profile_pic1.png"));
		lblImagemPerfil.setPreferredSize(new Dimension(50, 50));
		lblImagemPerfil.setBackground(Color.blue);

		// lblNome
		lblNome = new JLabel("Guilherme Roesler");
		lblNome.setFont(new Font("Open Sans", Font.BOLD, 20));

		// pnlHeader boxLayout
		pnlHeader.add(Box.createRigidArea(new Dimension(20, 0)));
		pnlHeader.add(lblImagemPerfil);
		pnlHeader.add(Box.createRigidArea(new Dimension(10, 0)));
		pnlHeader.add(lblNome);

		// lblDinheiro
		lblDinheiro = new JLabel();
		lblDinheiro.setText("R$0,00");
		contentPane.add(lblDinheiro);

		// panelConfig
		panelConfig = new JPanel();
		panelConfig.setBounds(1620, 80, 300, 1000);
		panelConfig.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.BLACK));
		panelConfig.setOpaque(false);
		contentPane.add(panelConfig);
		panelConfig.setLayout(new BoxLayout(panelConfig, BoxLayout.Y_AXIS));

		// btnHome
		btnHome = new JButton("Home");
		btnHome.setAlignmentX(CENTER_ALIGNMENT);

		// btnOpcoes
		btnOpcoes = new JButton();
		btnOpcoes.setText("Opções");
		btnOpcoes.setAlignmentX(CENTER_ALIGNMENT);

		// btnConfig
		btnConfig = new JButton();
		btnConfig.setText("Configurações");
		btnConfig.setAlignmentX(CENTER_ALIGNMENT);

		// btnDadosPessoais
		btnDadosPessoais = new JButton();
		btnDadosPessoais.setText("Dados Pessoais");
		btnDadosPessoais.setAlignmentX(CENTER_ALIGNMENT);

		// btnAtividade
		btnAtividade = new JButton();
		btnAtividade.setText("Atividade");
		btnAtividade.setAlignmentX(CENTER_ALIGNMENT);

		// btnNotificacoes
		btnNotificacoes = new JButton();
		btnNotificacoes.setText("Notificações");
		btnNotificacoes.setAlignmentX(CENTER_ALIGNMENT);

		// btnAjuda
		btnAjuda = new JButton();
		btnAjuda.setText("Ajuda");
		btnAjuda.setAlignmentX(CENTER_ALIGNMENT);

		// btnDinheiro
		btnDinheiro = new JButton();
		btnDinheiro.setText("Dinheiro");
		btnDinheiro.setAlignmentX(CENTER_ALIGNMENT);

		// btnSair
		btnSair = new JButton();
		btnSair.setText("Sair");
		btnSair.setAlignmentX(CENTER_ALIGNMENT);

		JButton[] pnlConfigButtons = { btnHome, btnOpcoes, btnConfig, btnDadosPessoais, btnAtividade, btnNotificacoes,
				btnAjuda, btnDinheiro, btnSair };
		for (JButton jButton : pnlConfigButtons) {
			jButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jButton.setAlignmentX(CENTER_ALIGNMENT);
			jButton.setPreferredSize(new Dimension(200, 50));
		}

		// pnlConfig boxLayout
		Dimension pnlConfigDimension = new Dimension(20, 20);
		panelConfig.add(btnHome);
		panelConfig.add(Box.createRigidArea(pnlConfigDimension));
		panelConfig.add(btnOpcoes);
		panelConfig.add(Box.createRigidArea(pnlConfigDimension));
		panelConfig.add(btnConfig);
		panelConfig.add(Box.createRigidArea(pnlConfigDimension));
		panelConfig.add(btnDadosPessoais);
		panelConfig.add(Box.createRigidArea(pnlConfigDimension));
		panelConfig.add(btnAtividade);
		panelConfig.add(Box.createRigidArea(pnlConfigDimension));
		panelConfig.add(btnNotificacoes);
		panelConfig.add(Box.createRigidArea(pnlConfigDimension));
		panelConfig.add(btnAjuda);
		panelConfig.add(Box.createRigidArea(pnlConfigDimension));
		panelConfig.add(btnDinheiro);
		panelConfig.add(Box.createRigidArea(pnlConfigDimension));
		panelConfig.add(btnSair);

		// pnlHome
		pnlHome = new homeJPanel();
		pnlHome.setBounds(0, 100, 1920, 200);
		contentPane.add(pnlHome);
		pnlHome.setLayout(new BoxLayout(pnlHome, BoxLayout.Y_AXIS));
		pnlHome.setVisible(false);
		
		// pnlDadosPessoais
		JScrollPane pnlDadosPessoais = new JScrollPane(new dadosPessoaisJPanel());
		pnlDadosPessoais.setBounds(300, 100, 1320, 950);
		dadosPessoaisJPanel.configScrollPane(pnlDadosPessoais);
		contentPane.add(pnlDadosPessoais);
//		scrollPane.setVisible(false);
	}

	private void addingBackground() {
		lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 1920, 1080);
		lblBackground.setIcon(new ImageIcon());
		contentPane.add(lblBackground);
	}
}