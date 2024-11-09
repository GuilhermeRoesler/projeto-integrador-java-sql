package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Evento;
import utils.ConversorUtils;

public class DetalhesJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblBackground;
	private JLabel[] labels = new JLabel[9];

	private int x1 = 160;
	private int x2 = 525;
	private int y1 = 60;
	private int width = 200;
	private int height = 20;
	private int separadorY = 67;

	// image
	private ImageIcon imgBackground = new ImageIcon("img/detalhes show.png");
	private Font font = new Font("Montserrat Bold", Font.PLAIN, 15);
	private Color fontColor = Color.decode("#202020");

	private Evento mainEvent;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DetalhesJFrame frame = new DetalhesJFrame();
//					frame.setResizable(false);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DetalhesJFrame(Evento evento) {
		setTitle("Detalhes");
		setResizable(false);
		mainEvent = evento;

		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 834, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] texts = { mainEvent.getNome(), ConversorUtils.DateTimeToUser(mainEvent.getData()), mainEvent.getLocal(),
				Main.artistaDAO.getById(mainEvent.getId_artista()).getNome(), "R$" + mainEvent.getPreco() + "0",
				String.valueOf(mainEvent.getCapacidade()), mainEvent.getTipo(), mainEvent.getStatus(),
				mainEvent.getDescricao() };

		for (int i = 0; i < 9; i++) {
			int x;
			int y = 0;

			if (i >= 6) {
				x = x2;
				y = y1 + separadorY * (i - 6);
			} else {
				x = x1;
				y = y1 + separadorY * i;
			}

			labels[i] = new JLabel();
			labels[i].setText(texts[i]);
			labels[i].setBounds(x, y, width, height);
			labels[i].setFont(font);
			labels[i].setForeground(fontColor);
			contentPane.add(labels[i]);
		}

		addingBackground();
	}

	private void addingBackground() {
		lblBackground = new JLabel();
		lblBackground.setBounds(0, 0, imgBackground.getIconWidth() + 8, imgBackground.getIconHeight());
		lblBackground.setIcon(imgBackground);
		contentPane.add(lblBackground);
	}

}
