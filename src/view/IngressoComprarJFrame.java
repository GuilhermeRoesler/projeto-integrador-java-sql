package view;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import controller.EventoDAO;
import model.Evento;
import utils.MaskUtil;

public class IngressoComprarJFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	// JComponents
	private JPanel contentPane, pnlHeader;
	private JLabel lblIngressos, lblPreco, lblShowsProximos, lblDinheiro;
	private JButton btnSair, btnComprar;
	private JComboBox<String> cmbboxShow;
	private JScrollPane scrollPane;
	private JTable table;

	// fonts
	private Font font1 = new Font("Nimbus Sans", Font.BOLD, 30);
	private Font font2 = new Font("Open Sans", Font.BOLD, 14);
	private JFormattedTextField tfdCpf;
	private JPasswordField tfdSenha;

	private EventoDAO eventoDAO = new EventoDAO();
	private ArrayList<Evento> eventos;

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
		eventos = eventoDAO.read();
		setResizable(false);
		setTitle("Ingressos");
		setIconImage(Main.logo);

		initComponents();
		initListeners();
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

		// cmbboxShow
		cmbboxShow = new JComboBox<String>();
		cmbboxShow.setModel(comboBoxModel());
		cmbboxShow.setBounds(47, 138, 260, 30);
		contentPane.add(cmbboxShow);
		cmbboxShow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String preco = String.valueOf(eventos.get(cmbboxShow.getSelectedIndex()).getPreco());
				preco = String.format("R$%s0", preco);
				lblPreco.setText(preco);
			}
		});

		// lblPreco
		lblPreco = new JLabel("R$0,00");
		lblPreco.setBounds(345, 146, 66, 14);
		contentPane.add(lblPreco);

		// tfdCpf
		tfdCpf = new JFormattedTextField(MaskUtil.createMaskFormatter("###.###.###-##"));
		tfdCpf.setText("cpf");
		tfdCpf.setBounds(47, 195, 196, 30);
		tfdCpf.setFont(font2);
		contentPane.add(tfdCpf);

		// tfdSenha
		tfdSenha = new JPasswordField("Senha");
		tfdSenha.setEchoChar((char) 0);
		tfdSenha.setBounds(302, 195, 133, 30);
		tfdSenha.setFont(font2);
		contentPane.add(tfdSenha);

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
		btnComprar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnComprar);

		// btnSair
		btnSair = new JButton("Sair");
		btnSair.setBounds(416, 627, 58, 23);
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnSair);
		tfdSenha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		// lblDinheiro
		lblDinheiro = new JLabel("R$" + Main.mainClient.getDinheiro() + ",00");
		lblDinheiro.setHorizontalAlignment(SwingConstants.LEFT);
		lblDinheiro.setBounds(10, 631, 111, 14);
		contentPane.add(lblDinheiro);
	}

	private void initListeners() {
		KeyAdapter enterKeyAdapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnComprar.doClick();
				}
			}
		};
		tfdCpf.addKeyListener(enterKeyAdapter);
		tfdSenha.addKeyListener(enterKeyAdapter);

		tfdCpf.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (tfdCpf.getText().equals("Cpf")) {
					tfdCpf.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tfdCpf.getText().isEmpty()) {
					tfdCpf.setText("Cpf");
				}
			}
		});
		
		tfdSenha.addFocusListener(new FocusListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if (tfdSenha.getText().equals("Senha")) {
					tfdSenha.setText("");
					tfdSenha.setEchoChar('•');
				}
			}
			
			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if (tfdSenha.getText().isEmpty()) {
					tfdSenha.setText("Senha");
					tfdSenha.setEchoChar((char) 0);
				}
			}
		});
		
		((AbstractDocument) tfdCpf.getDocument()).setDocumentFilter(new CpfDocumentFilter());

        tfdCpf.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tfdCpf.getText().trim().isEmpty()) {
                    tfdCpf.setText(""); // Limpa o campo ao ganhar foco apenas se estiver vazio
                }
            }
        });
    }

    private class CpfDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string == null) return;

            // Obtém o texto atual antes da inserção
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = currentText.substring(0, offset) + string + currentText.substring(offset);

            // Remove caracteres não numéricos
            newText = newText.replaceAll("\\D", "");

            // Aplica a máscara
            if (newText.length() > 11) newText = newText.substring(0, 11); // Limite de 11 dígitos
            if (newText.length() > 9) newText = newText.replaceAll("(\\d{3})(\\d{1,2})$", "$1.$2"); // Adiciona o primeiro ponto
            if (newText.length() > 6) newText = newText.replaceAll("(\\d{3})(\\d{1,3})$", "$1.$2"); // Adiciona o segundo ponto
            if (newText.length() > 3) newText = newText.replaceAll("(\\d{3})(\\d{1,2})$", "$1-$2"); // Adiciona o hífen

            // Atualiza o campo com o texto formatado
            super.insertString(fb, offset, newText.substring(offset), attr); // Adiciona o texto formatado
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text == null) return;

            // Obtém o texto atual antes da substituição
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);

            // Remove caracteres não numéricos
            newText = newText.replaceAll("\\D", "");

            // Aplica a máscara
            if (newText.length() > 11) newText = newText.substring(0, 11); // Limite de 11 dígitos
            if (newText.length() > 9) newText = newText.replaceAll("(\\d{3})(\\d{1,2})$", "$1.$2"); // Adiciona o primeiro ponto
            if (newText.length() > 6) newText = newText.replaceAll("(\\d{3})(\\d{1,3})$", "$1.$2"); // Adiciona o segundo ponto
            if (newText.length() > 3) newText = newText.replaceAll("(\\d{3})(\\d{1,2})$", "$1-$2"); // Adiciona o hífen

            // Atualiza o campo com o texto formatado
            super.replace(fb, offset, length, newText.substring(offset, newText.length()), attrs);
        }
    }

	private ComboBoxModel<String> comboBoxModel() {
		ArrayList<String> nomes = new ArrayList<>();
		nomes.add("Seleione");

		for (Evento evento : eventos) {
			nomes.add(evento.getNome());
		}

		return new DefaultComboBoxModel<String>(nomes.toArray(new String[0]));
	}
}
