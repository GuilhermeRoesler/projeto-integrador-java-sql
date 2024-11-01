package view.JPanels;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import model.Cliente;
import view.Main;

public class dadosPessoaisJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private String[] nomes = { "Nome", "Sobrenome", "Email", "Senha", "Sexo", "Cpf", "Telefone", "Nascimento", "Cep",
			"Cidade", "Dinheiro", "Data de entrada" };
	private JLabel[] labels = new JLabel[12];
	private JTextField[] fields = new JTextField[12];
	private JButton[] buttons = new JButton[12];
	private ArrayList<String> credentials = Main.conn.credentialsToArrayList();

	private final int x = 500;
	private final int y = 0;
	private final int separadorY = 120;
	private final int width = 150;
	private final int height = 30;

	private final Font font1 = new Font("Open Sans", Font.BOLD, 20);
	private final Font font2 = new Font("Open Sans", Font.BOLD, 14);

	public dadosPessoaisJPanel() {
		setLayout(null);
		setPreferredSize(new Dimension(1320, 1500));

		for (int i = 0; i < 12; i++) {
			labels[i] = new JLabel();
			fields[i] = new JTextField();
			buttons[i] = new JButton();

			// setText
			labels[i].setText(nomes[i]);
			fields[i].setText(credentials.get(i));
			buttons[i].setText("Alterar campo");

			// setBounds
			labels[i].setBounds(x, y + separadorY * i, width + 20, height);
			fields[i].setBounds(x, y + 50 + separadorY * i, width + 200, height);
			buttons[i].setBounds(x + 200, y + separadorY * i, width, height);

			// setFont
			labels[i].setFont(font1);
			fields[i].setFont(font2);
			buttons[i].setFont(font2);

			// other
			fields[i].setEnabled(false);
			buttons[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			final int index = i;
			buttons[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (JTextField field : fields) {
						field.setEnabled(false);
					}
					fields[index].setEnabled(true);
				}
			});

			// add
			add(labels[i]);
			add(fields[i]);
			add(buttons[i]);
		}

		// enviar
		JButton enviar = new JButton("Enviar");
		enviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		enviar.setBounds(x, y + separadorY * 12, width, height);
		add(enviar);
		enviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente(Main.frameUsuario.mainClient.getId_pessoa(), fields[0].getText(), fields[1].getText(),
						fields[2].getText(), fields[3].getText(), fields[4].getText(), fields[5].getText(),
						fields[6].getText(), fields[7].getText(), fields[8].getText(), fields[9].getText(),
						Integer.parseInt(fields[10].getText()), Main.frameUsuario.mainClient.getDataEntrada());
				Main.conn.update(c);
			}
		});
	}

	// Ajustando a sensibilidade de rolagem
	public static void configScrollPane(JScrollPane scrollPane) {
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);

		scrollPane.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// Multiplicando o valor de rolagem por um fator
				int notches = e.getWheelRotation();
				scrollPane.getVerticalScrollBar()
						.setValue(scrollPane.getVerticalScrollBar().getValue() + (notches * 40)); // Ajuste o fator
																									// conforme
																									// necessário
			}
		});
	}

}
