package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ClienteDAO;
import model.Cliente;

public class UsuarioJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, panelConfig, pnlHeader, pnlBody;
	private JButton btnHome, btnOpcoes, btnConfig, btnDadosPessoais, btnAtividade, btnNotificacoes, btnAjuda, btnDinheiro, btnSair, btnComprarIngresso;
	private JLabel lblSeusShows, lblSeusShows2, lblDinheiro, lblBackground;
	
	protected static final IngressoComprarJFrame frameIngresso = new IngressoComprarJFrame();
	
	private int opcoesX = 1740;
	private int opcoesY = 130;
	private int opcoesSeparadorY = 70;
	private int opcoesWidth = 150;
	private int opcoesHeigth = 50;
	
	private Font font1 = new Font("Nimbus Sans", Font.BOLD, 40);
	private Font font2 = new Font("Nimbus Sans", Font.BOLD, 28);
	private ClienteDAO conn;
	private JLabel lblImagemPerfil;
	private JLabel lblNome;

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UsuarioJFrame frame = new UsuarioJFrame();
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

	public UsuarioJFrame(ClienteDAO conn) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Art Music");
		setResizable(false);

		this.conn = conn;
		initComponents();
	}
	
	public UsuarioJFrame() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Art Music");
		setResizable(false);
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
		
		// panelConfig
		panelConfig = new JPanel();
		panelConfig.setBounds(1650, 100, 270, 1080);
		panelConfig.setOpaque(false);
		contentPane.add(panelConfig);
		
		// btnHome
		btnHome = new JButton("Home");
		btnHome.setBounds(opcoesX, opcoesY + opcoesSeparadorY * 0, opcoesWidth, opcoesHeigth);
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnHome);
		
		// btnOpcoes
		btnOpcoes = new JButton();
		btnOpcoes.setText("Opções");
		btnOpcoes.setBounds(opcoesX, opcoesY + opcoesSeparadorY * 1, opcoesWidth, opcoesHeigth);
		btnOpcoes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnOpcoes);
		
		// btnConfig
		btnConfig = new JButton();
		btnConfig.setText("Configurações");
		btnConfig.setBounds(opcoesX, opcoesY + opcoesSeparadorY * 2, opcoesWidth, opcoesHeigth);
		btnConfig.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnConfig);
		
		// btnDadosPessoais
		btnDadosPessoais = new JButton();
		btnDadosPessoais.setText("Dados Pessoais");
		btnDadosPessoais.setBounds(opcoesX, opcoesY + opcoesSeparadorY * 3, opcoesWidth, opcoesHeigth);
		contentPane.add(btnDadosPessoais);
		btnDadosPessoais.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		// btnAtividade
		btnAtividade = new JButton();
		btnAtividade.setText("Atividade");
		btnAtividade.setBounds(opcoesX, opcoesY + opcoesSeparadorY * 4, opcoesWidth, opcoesHeigth);
		contentPane.add(btnAtividade);
		btnAtividade.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		// btnNotificacoes
		btnNotificacoes = new JButton();
		btnNotificacoes.setText("Notificações");
		btnNotificacoes.setBounds(opcoesX, opcoesY + opcoesSeparadorY * 5, opcoesWidth, opcoesHeigth);
		contentPane.add(btnNotificacoes);
		btnNotificacoes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		// btnAjuda
		btnAjuda = new JButton();
		btnAjuda.setText("Ajuda");
		btnAjuda.setBounds(opcoesX, opcoesY + opcoesSeparadorY * 6, opcoesWidth, opcoesHeigth);
		contentPane.add(btnAjuda);
		btnAjuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		// btnDinheiro
		btnDinheiro = new JButton();
		btnDinheiro.setText("Dinheiro");
		btnDinheiro.setBounds(opcoesX, opcoesY + opcoesSeparadorY * 7, opcoesWidth, opcoesHeigth);
		contentPane.add(btnDinheiro);
		btnDinheiro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		// btnSair
		btnSair = new JButton();
		btnSair.setText("Sair");
		btnSair.setBounds(opcoesX, opcoesY + opcoesSeparadorY * 8, opcoesWidth, opcoesHeigth);
		contentPane.add(btnSair);
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//panel2
		pnlBody = new JPanel();
		pnlBody.setBounds(0, 100, 1920, 200);
		contentPane.add(pnlBody);
		pnlBody.setLayout(new BoxLayout(pnlBody, BoxLayout.Y_AXIS));

		// lblSeusShows
		lblSeusShows = new JLabel("Seus Shows");
		lblSeusShows.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSeusShows.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeusShows.setPreferredSize(new Dimension(100, 50));
		lblSeusShows.setFont(font1);
		
		// lblSeusShows2
		lblSeusShows2 = new JLabel("Sua agenda está vazia...");
		lblSeusShows2.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSeusShows2.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeusShows2.setPreferredSize(new Dimension(100, 50));
		lblSeusShows2.setFont(font2);
		
		// btnComprarIngresso
		btnComprarIngresso = new JButton("Comprar ingresso");
		btnComprarIngresso.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnComprarIngresso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		// boxLayout organization
		pnlBody.add(Box.createGlue());
		pnlBody.add(lblSeusShows);
		pnlBody.add(Box.createGlue());
		pnlBody.add(lblSeusShows2);
		pnlBody.add(Box.createGlue());
		pnlBody.add(btnComprarIngresso);
		pnlBody.add(Box.createGlue());
		
		// pnlHeader
		pnlHeader = new JPanel();
		pnlHeader.setBounds(0, 0, 1920, 100);
		pnlHeader.setBackground(Color.red);
		contentPane.add(pnlHeader);
		
		// lblDinheiro
		lblDinheiro = new JLabel();
		lblDinheiro.setText("R$0,00");
		pnlHeader.add(lblDinheiro);
		
		// lblImagemPerfil
		lblImagemPerfil = new JLabel("imagem perfil");
		lblImagemPerfil.setPreferredSize(new Dimension(50, 50));
		lblImagemPerfil.setBackground(Color.blue);
		pnlHeader.add(lblImagemPerfil);
		
		// lblNome
		lblNome = new JLabel("nome");
		pnlHeader.add(lblNome);
	}
	
	private void addingActionListeners() {
		// btnOpcoes
		btnOpcoes.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				if (false) conn.create(new Cliente());
			}
		});

		// btnComprarIngresso
		btnComprarIngresso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frameIngresso.setVisible(true);
					frameIngresso.setLocationRelativeTo(null);					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	private void addingBackground() {
		lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, 1920, 1080);
		lblBackground.setIcon(new ImageIcon());
		contentPane.add(lblBackground);
	}
}
