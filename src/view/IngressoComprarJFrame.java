package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class IngressoComprarJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane, pnlHeader;
	private JLabel lblIngressos, lblShowsProximos, lblDinheiro;
	private JButton btnSair, btnComprar;
	private JTextField tfdShow;
	private JScrollPane scrollPane;
	private JTable table;

	private Font font1 = new Font("Nimbus Sans", Font.BOLD, 30);
	private Font font2 = new Font("Open Sans", Font.BOLD, 15);

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IngressoComprarJFrame frame = new IngressoComprarJFrame();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IngressoComprarJFrame() {
		setResizable(false);
		setTitle("Ingressos");

		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// pnlHeader
		pnlHeader = new JPanel();
		pnlHeader.setBounds(5, 5, 474, 50);
		contentPane.add(pnlHeader);

		// lblIngressos
		lblIngressos = new JLabel("Ingressos");
//		lblIngressos.setBounds(171, 5, 142, 39);
		lblIngressos.setFont(font1);
		lblIngressos.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnlHeader.add(lblIngressos);

		// tfdShow
		tfdShow = new JTextField();
		tfdShow.setBounds(108, 130, 260, 30);
		tfdShow.setFont(font2);
		contentPane.add(tfdShow);

		// lblShowsProximos
		lblShowsProximos = new JLabel("Shows próximos");
		lblShowsProximos.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowsProximos.setFont(font1);
		lblShowsProximos.setBounds(119, 290, 249, 39);
		contentPane.add(lblShowsProximos);

		// scrollPane
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 340, 437, 276);
		contentPane.add(scrollPane);
		
		// table
		table = new JTable();
		scrollPane.setViewportView(table);

		// btnComprar
		btnComprar = new JButton("Comprar");
		btnComprar.setBounds(195, 256, 86, 23);
		contentPane.add(btnComprar);

		// btnSair
		btnSair = new JButton("Sair");
		btnSair.setBounds(416, 627, 58, 23);
		contentPane.add(btnSair);

		// lblDinheiro
		lblDinheiro = new JLabel("R$0,00");
		lblDinheiro.setBounds(10, 631, 46, 14);
		contentPane.add(lblDinheiro);
	}
}
