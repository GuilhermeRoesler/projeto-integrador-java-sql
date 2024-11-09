package view.JPanels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Evento;
import view.DetalhesJFrame;
import view.IngressoComprarJFrame;
import view.Main;

public class HomeJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblSeusShows;
	private JButton btnComprarIngresso;
	private JLabel[] showslbl;

	private Dimension separadorY = new Dimension(0, 20);

	// fonts and colors
	private Font font1 = new Font("Nimbus Sans", Font.BOLD, 42);
	private Font font2 = new Font("Nimbus Sans", Font.BOLD, 25);
	private Font fontButton = new Font("Montserrat", Font.BOLD, 14);
	private Color fontColor = Color.decode("#cad0d6");
	private Color fontColor2 = Color.decode("#eff6f0");
	private Color colorButton = Color.decode("#238636");

	private DetalhesJFrame frameDetalhes;

	public HomeJPanel() {
		setOpaque(false);

		initComponents();
	}

	private void initComponents() {
		// lblSeusShows
		lblSeusShows = new JLabel("Seus Shows");
		lblSeusShows.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSeusShows.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeusShows.setPreferredSize(new Dimension(100, 50));
		lblSeusShows.setForeground(fontColor);
		lblSeusShows.setFont(font1);

		// btnComprarIngresso
		btnComprarIngresso = new JButton("Comprar ingresso");
		btnComprarIngresso.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnComprarIngresso.setBackground(colorButton);
		btnComprarIngresso.setForeground(fontColor2);
		btnComprarIngresso.setFont(fontButton);
		btnComprarIngresso.setBorder(BorderFactory.createLineBorder(colorButton, 10));
		btnComprarIngresso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// box layout config
		add(Box.createRigidArea(separadorY));
		add(lblSeusShows);
		add(Box.createRigidArea(separadorY));
		add(Box.createRigidArea(separadorY));

		verificarShows();

		add(Box.createRigidArea(separadorY));
		add(btnComprarIngresso);
		add(Box.createRigidArea(separadorY));

		// btnComprarIngresso
		btnComprarIngresso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					IngressoComprarJFrame frameIngresso = new IngressoComprarJFrame();
					frameIngresso.setVisible(true);
					frameIngresso.setLocationRelativeTo(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	private void verificarShows() {
		ArrayList<Evento> shows;
		if ((shows = Main.eventoDAO.getShows(Main.mainClient)) == null) {
			// lblSeusShows2
			JLabel lblSeusShows2 = new JLabel("Sua agenda está vazia...");
			lblSeusShows2.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblSeusShows2.setHorizontalAlignment(SwingConstants.CENTER);
			lblSeusShows2.setPreferredSize(new Dimension(100, 50));
			lblSeusShows2.setForeground(fontColor);
			lblSeusShows2.setFont(font2);
			add(lblSeusShows2);
			add(Box.createRigidArea(separadorY));
		} else {
			int numShows = shows.size();
			showslbl = new JLabel[numShows];
			for (int i = 0; i < numShows; i++) {
				showslbl[i] = new JLabel();
				showslbl[i].setText("• " + shows.get(i).getNome());
				showslbl[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				showslbl[i].setAlignmentX(Component.CENTER_ALIGNMENT);
				showslbl[i].setHorizontalAlignment(SwingConstants.CENTER);
				showslbl[i].setForeground(Color.decode("#867223"));
				showslbl[i].setFont(font2);
				final int index = i;
				showslbl[i].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						showslbl[index].setForeground(Color.decode("#d6af17")); // Altera a cor do texto para amarelo ao
																				// passar o mouse
					}

					@Override
					public void mouseExited(MouseEvent e) {
						showslbl[index].setForeground(Color.decode("#867223")); // Retorna a cor original ao sair
					}

					@Override
					public void mouseClicked(MouseEvent e) {
						frameDetalhes = new DetalhesJFrame(
								Main.eventoDAO.getByName(showslbl[index].getText().replace("• ", "")));
						frameDetalhes.setLocationRelativeTo(null);
						frameDetalhes.setVisible(true);
					}
				});
				add(showslbl[i]);
				add(Box.createRigidArea(separadorY));
			}
		}
	}
	
	public void reloadComponents() {
		removeAll();
		initComponents();
	}

}
