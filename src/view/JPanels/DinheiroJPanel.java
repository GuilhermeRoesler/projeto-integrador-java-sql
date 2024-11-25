package view.JPanels;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import view.Main;

public class DinheiroJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	// JComponents
	private JButton btnMoney;

	private Dimension separadorY = new Dimension(0, 100);

	// font and color
	private ImageIcon imgMoney = new ImageIcon("img/money.png");

	public DinheiroJPanel() {
		setOpaque(false);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		initComponents();
		configLayout();
	}

	private void initComponents() {
		btnMoney = new JButton();
//		btnMoney.setText("MONEY");
		btnMoney.setPreferredSize(new Dimension(357, 185));
		btnMoney.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnMoney.setIcon(imgMoney);
		btnMoney.setBorder(null);
		btnMoney.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMoney.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(Main.mainClient.getDinheiro());
				int novoValor = (Main.mainClient.getDinheiro() + 100);
				System.out.println(novoValor);
				Main.conn.updateDinheiro(novoValor, Main.mainClient.getId_pessoa());
			}
		});
	}
	
	private void configLayout() {
		add(Box.createRigidArea(separadorY));
		add(btnMoney);
		add(Box.createRigidArea(separadorY));
	}

}
