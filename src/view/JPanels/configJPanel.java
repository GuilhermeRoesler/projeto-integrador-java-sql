package view.JPanels;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import view.Main;

public class configJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnHome, btnOpcoes, btnConfig, btnDadosPessoais, btnAtividade, btnNotificacoes, btnAjuda,
			btnDinheiro, btnSair;
	JButton[] pnlConfigButtons = { btnHome, btnOpcoes, btnConfig, btnDadosPessoais, btnAtividade, btnNotificacoes,
			btnAjuda, btnDinheiro };

	public configJPanel() {
		setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.BLACK));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

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
		JButton[] pnlConfigButtons2 = { btnHome, btnOpcoes, btnConfig, btnDadosPessoais, btnAtividade, btnNotificacoes,
				btnAjuda, btnDinheiro };
		for (JButton jButton : pnlConfigButtons2) {
			jButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			jButton.setAlignmentX(CENTER_ALIGNMENT);
			jButton.setPreferredSize(new Dimension(200, 50));
		}
		pnlConfigButtons = pnlConfigButtons2;

		// pnlConfig boxLayout
		Dimension pnlConfigDimension = new Dimension(20, 20);
		add(btnHome);
		add(Box.createRigidArea(pnlConfigDimension));
		add(btnOpcoes);
		add(Box.createRigidArea(pnlConfigDimension));
		add(btnConfig);
		add(Box.createRigidArea(pnlConfigDimension));
		add(btnDadosPessoais);
		add(Box.createRigidArea(pnlConfigDimension));
		add(btnAtividade);
		add(Box.createRigidArea(pnlConfigDimension));
		add(btnNotificacoes);
		add(Box.createRigidArea(pnlConfigDimension));
		add(btnAjuda);
		add(Box.createRigidArea(pnlConfigDimension));
		add(btnDinheiro);
		add(Box.createRigidArea(pnlConfigDimension));
		add(btnSair);

		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.frameUsuario.dispose();
				Main.frameLogin.setVisible(true);
			}
		});
	}

	public JButton[] getButtons() {
		return pnlConfigButtons;
	}
}
