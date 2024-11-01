package view.JPanels;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import view.UsuarioJFrame;

public class homeJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblSeusShows, lblSeusShows2;
	private JButton btnComprarIngresso;

	private Font font1 = new Font("Nimbus Sans", Font.BOLD, 40);
	private Font font2 = new Font("Nimbus Sans", Font.BOLD, 28);

	public homeJPanel() {

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
		add(Box.createGlue());
		add(lblSeusShows);
		add(Box.createGlue());
		add(lblSeusShows2);
		add(Box.createGlue());
		add(btnComprarIngresso);
		add(Box.createGlue());

		// btnComprarIngresso
		btnComprarIngresso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UsuarioJFrame.frameIngresso.setVisible(true);
					UsuarioJFrame.frameIngresso.setLocationRelativeTo(null);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

}
