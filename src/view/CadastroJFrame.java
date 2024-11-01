package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ClienteDAO;
import model.Cliente;
import utils.MaskUtil;

public class CadastroJFrame extends JFrame {

	// main settings
	private static final long serialVersionUID = 1L;
	private final int txtX1 = 202;
	private final int txtX2 = 611;
	private final int txtWidth = 182;
	private final int txtWidth2 = 162;
	private final int txtHeight = 25;
	private final int Y1 = 187;
	private final int Y2 = 317;
	private final int Y3 = Y2 + 8;
	private final int separadorY = 31;

	// JComponents
	protected JPanel contentPane;
	protected JLabel lblSexo2, lblBackground;
	protected JTextField txtEmail, txtRepetirEmail, txtNome, txtSobrenome, txtCidade, txtNumero;
	protected JFormattedTextField txtCPF, txtTelefone, txtNascimento, txtCEP;
	protected JPasswordField txtSenha, txtRepetirSenha;
	protected JCheckBox chboxSenha, chboxOfertas, chboxNumero;
	protected JButton btnCadastrar, btnRandom, btnBack;
	protected JComboBox<String> cmbboxSexo;

	private ClienteDAO conn;

	public CadastroJFrame(ClienteDAO conn) {
		setTitle("Cadastro");
		setResizable(false);

		this.conn = conn;
		initComponents();
		reloadComponents();
	}

	private void initComponents() {
		// contentPane
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// btnBack
		btnBack = new JButton();
		btnBack.setIcon(new ImageIcon(
				"C:\\Users\\Gui\\Documents\\Guilherme\\GitHub\\projeto-integrador-java-sql\\img\\back1.png"));
		btnBack.setBounds(10, 11, 30, 30);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.frameLogin.setVisible(true);
				tfdLimparTodos();
			}
		});

		// txtEmail
		txtEmail = new JTextField();
		txtEmail.setBounds(txtX1, Y1 + separadorY * 0, txtWidth, 25);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		// txtRepetirEmail
		txtRepetirEmail = new JTextField();
		txtRepetirEmail.setBounds(txtX1, Y1 + separadorY * 1, txtWidth, 25);
		contentPane.add(txtRepetirEmail);

		// txtSenha
		txtSenha = new JPasswordField();
		txtSenha.setBounds(txtX2, Y1 + separadorY * 0, txtWidth2, 25);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		// txtRepetirSenha
		txtRepetirSenha = new JPasswordField();
		txtRepetirSenha.setColumns(10);
		txtRepetirSenha.setBounds(txtX2, Y1 + separadorY * 1, txtWidth2, txtHeight);
		contentPane.add(txtRepetirSenha);

		// chboxSenha
		chboxSenha = new JCheckBox("Show password");
		chboxSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chboxSenha.isSelected()) {
					txtSenha.setEchoChar((char) 0);
					txtRepetirSenha.setEchoChar((char) 0);
				} else {
					txtSenha.setEchoChar('•');
					txtRepetirSenha.setEchoChar('•');
				}
			}
		});
		chboxSenha.setBounds(txtSenha.getBounds().x - 4, Y1 + separadorY * 2, 150, 15);
		contentPane.add(chboxSenha);

		// chboxOfertas
		chboxOfertas = new JCheckBox("Receber ofertas e novidades por e-mail");
		chboxOfertas.setSelected(true);
		chboxOfertas.setBounds(txtX1 - 4, Y2 + separadorY * 6, 250, 15);
		contentPane.add(chboxOfertas);

		// chboxNumero
		chboxNumero = new JCheckBox("Sem número");
		chboxNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chboxNumero.isSelected()) {
					txtNumero.setEnabled(false);
					txtNumero.setText(null);
				} else {
					txtNumero.setEnabled(true);
				}
			}
		});
		chboxNumero.setBounds(txtX2 - 4, Y2 + separadorY * 3 + 5, 110, 15);
		contentPane.add(chboxNumero);

		// txtNome
		txtNome = new JTextField();
		txtNome.setBounds(txtX1, Y2 + 0 * separadorY, txtWidth, txtHeight);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		// txtSobrenome
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(txtX1, Y2 + 1 * separadorY, txtWidth, txtHeight);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);

		// lblSexo2
		lblSexo2 = new JLabel("Selecione");
		lblSexo2.setBounds(txtX1, Y2 + 2 * separadorY, txtWidth, txtHeight);
		lblSexo2.setFont(new Font("Open Sans", Font.PLAIN, 12));
		contentPane.add(lblSexo2);

		// cmbboxSexo
		cmbboxSexo = new JComboBox<String>();
		cmbboxSexo.setModel(new DefaultComboBoxModel<>(new String[] { "Selecione", "Masculino", "Feminino" }));
		cmbboxSexo.setSelectedIndex(0);
		cmbboxSexo.setBounds(txtX1 - 5, Y2 + 2 * separadorY, txtWidth, txtHeight);
		cmbboxSexo.setVisible(false);
		contentPane.add(cmbboxSexo);
		cmbboxSexo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cmbboxSexo.getSelectedItem().equals("Selecione")) {
					cmbboxSexo.setSelectedIndex(0);
				} else {
					cmbboxSexo.removeItem("Selecione");
				}
			}
		});
		lblSexo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblSexo2.setVisible(false);
				cmbboxSexo.setVisible(true);
//				cmbboxSexo.showPopup();
				cmbboxSexo.setPopupVisible(true);

				cmbboxSexo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						lblSexo2.setText(cmbboxSexo.getSelectedItem().toString());
						lblSexo2.setVisible(true);
						cmbboxSexo.setVisible(false);
					}
				});
			}
		});

		// txtCPF
		txtCPF = new JFormattedTextField(MaskUtil.createMaskFormatter("###.###.###-##"));
		txtCPF.setBounds(txtX1, Y2 + 3 * separadorY, txtWidth, txtHeight);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);

		// txtTelefone
		txtTelefone = new JFormattedTextField(MaskUtil.createMaskFormatter("(##) #####-####"));
		txtTelefone.setBounds(txtX1, Y2 + 4 * separadorY, txtWidth, txtHeight);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);

		// txtNascimento
		txtNascimento = new JFormattedTextField(MaskUtil.createMaskFormatter("##/##/####"));
		txtNascimento.setBounds(txtX1, Y2 + 5 * separadorY + 1, txtWidth, txtHeight);
		contentPane.add(txtNascimento);
		txtNascimento.setColumns(10);

		// txtCEP
		txtCEP = new JFormattedTextField(MaskUtil.createMaskFormatter("#####-###"));
		txtCEP.setBounds(txtX2, Y3 + separadorY * 0, txtWidth2, txtHeight);
		contentPane.add(txtCEP);
		txtCEP.setColumns(10);

		// txtRua
		txtCidade = new JTextField();
		txtCidade.setBounds(txtX2, Y3 + separadorY * 1, txtWidth2, txtHeight);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		// txtNumero
		txtNumero = new JTextField();
		txtNumero.setBounds(txtX2, Y3 + separadorY * 2, txtWidth2, txtHeight);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		// btnCadastrar
		btnCadastrar = new JButton();
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (verificarTfds()) {
					@SuppressWarnings("deprecation")
					Cliente cliente = new Cliente(txtNome.getText(), txtSobrenome.getText(), txtEmail.getText(),
							txtSenha.getText(), cmbboxSexo.getSelectedItem().toString(), txtCPF.toString(),
							txtTelefone.getText(), txtNascimento.getText(), txtCEP.getText(), txtCidade.getText());
					if (conn.create(cliente)) {
						JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
						dispose();
						Main.frameLogin.setVisible(true);
						tfdLimparTodos();
					} else {
						JOptionPane.showMessageDialog(null,
								"Houve um erro durante o procedimento, tente novamente inserindo outros dados!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!!!");
				}
			}
		});
		btnCadastrar.setBounds(336, 538, 162, 42);
		btnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnCadastrar);

		// btnRandom
		btnRandom = new JButton("");
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomizar();
			}
		});
		btnRandom.setBounds(10, 591, 20, 20);
		btnRandom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnRandom);

		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(
				"C:\\Users\\Gui\\Documents\\Guilherme\\GitHub\\projeto-integrador-java-sql\\img\\tela cadastro.png"));
		lblBackground.setBounds(0, 0, 834, 611);
		contentPane.add(lblBackground);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
				Main.frameLogin.setVisible(true);
			}
		});
	}

	// randomizar
	@SuppressWarnings("deprecation")
	private void randomizar() {
		txtNome.setText(randomNome());
		txtSobrenome.setText(randomSobrenome());
		txtEmail.setText(randomEmail(txtNome.getText(), txtSobrenome.getText()));
		txtRepetirEmail.setText(txtEmail.getText());
		txtSenha.setText(randomSenha());
		txtRepetirSenha.setText(txtSenha.getText());
		txtCPF.setText(randomCPF());
		txtTelefone.setText(randomTelefone());
		txtNascimento.setText(randomNascimento());
		txtCEP.setText(randomCEP());
		txtCidade.setText(randomCidade());
		txtNumero.setText(randomNumero());
	}

	private String randomNome() {
		Random random = new Random();
		ArrayList<String> nomes = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("nomes.txt"));

			String line;
			while ((line = reader.readLine()) != null) {
				nomes.add(line);
			}

			reader.close();

			int numRandom = random.nextInt(199);
			randomSexo(numRandom);
			return nomes.get(numRandom);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String randomSobrenome() {
		Random random = new Random();
		ArrayList<String> sobrenomes = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("sobrenomes.txt"));

			String line;
			while ((line = reader.readLine()) != null) {
				sobrenomes.add(line);
			}

			reader.close();

			return sobrenomes.get(random.nextInt(99));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String randomEmail(String nome, String sobrenome) {
		if (nome.contains(" ")) {
			nome = nome.split(" ")[0];
		}

		nome = Normalizer.normalize(nome, Normalizer.Form.NFD);
		nome = nome.replaceAll("[^\\p{ASCII}]", "");

		nome = nome.toLowerCase();
		sobrenome = sobrenome.toLowerCase();
		return nome + sobrenome + "@gmail.com";
	}

	private String randomSenha() {
		Random r = new Random();
		String senha = "";

		for (int i = 0; i < 8; i++) {
			int rNumber = r.nextInt(10);
			senha += rNumber;
		}

		return senha;
	}

	private void randomSexo(int numRandom) {
		if (numRandom < 100) {
			cmbboxSexo.setSelectedIndex(cmbboxSexo.getItemCount() - 1);
			lblSexo2.setText("Feminino");
		} else {
			cmbboxSexo.setSelectedIndex(cmbboxSexo.getItemCount() - 2);
			lblSexo2.setText("Masculino");
		}
	}

	private String randomCPF() {
		Random r = new Random();
		String s = String.format("%d%d%d.%d%d%d.%d%d%d-%d%d", r.nextInt(10), r.nextInt(10), r.nextInt(10),
				r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10),
				r.nextInt(10));

		return s;
	}

	private String randomTelefone() {
		Random r = new Random();
		String s = String.format("(%d%d) %d%d%d%d%d-%d%d%d%d", r.nextInt(10), r.nextInt(10), r.nextInt(10),
				r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10),
				r.nextInt(10));

		return s;
	}

	private String randomNascimento() {
		Random r = new Random();
		String s = String.format("%02d/%02d/%04d", r.nextInt(30) + 1, r.nextInt(12) + 1, r.nextInt(1000) + 1000);

		return s;
	}

	private String randomCEP() {
		Random r = new Random();
		String s = String.format("%d%d%d%d%d-%d%d%d", r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10),
				r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10));
		return s;
	}

	private String randomCidade() {
		Random r = new Random();
		ArrayList<String> cidades = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader("cidades.txt"));

			String line;
			while ((line = reader.readLine()) != null) {
				cidades.add(line);
			}

			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return cidades.get(r.nextInt(200));
	}

	private String randomNumero() {
		Random r = new Random();

		return String.valueOf(r.nextInt(500));
	}

	private void reloadComponents() {
		JTextField[] allTextFilds = { txtEmail, txtRepetirEmail, txtNome, txtSobrenome, txtCidade, txtNumero, txtCPF,
				txtTelefone, txtNascimento, txtCEP, txtSenha, txtRepetirSenha };

		JCheckBox[] allCheckBox = { chboxSenha, chboxOfertas, chboxNumero };

		JButton[] allButtons = { btnCadastrar, btnRandom };

		for (JTextField jTextField : allTextFilds) {
			jTextField.setOpaque(false);
			jTextField.setBorder(null);
			jTextField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						btnCadastrar.doClick();
					}
				}
			});
		}

		for (JCheckBox jCheckBox : allCheckBox) {
			jCheckBox.setContentAreaFilled(false);
			jCheckBox.setBorderPainted(false);
			jCheckBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}

		for (JButton jButton : allButtons) {
			jButton.setContentAreaFilled(false);
			jButton.setBorderPainted(false);
			jButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
	}

	public void tfdLimparTodos() {
		JTextField[] allTextFields = { txtEmail, txtRepetirEmail, txtNome, txtSobrenome, txtCidade, txtNumero, txtCPF,
				txtTelefone, txtNascimento, txtCEP, txtSenha, txtRepetirSenha };

		for (JTextField jTextField : allTextFields) {
			jTextField.setText("");
		}
	}

	private boolean verificarTfds() {
		JTextField[] allTextFields = { txtEmail, txtRepetirEmail, txtNome, txtSobrenome, txtCidade, txtNumero, txtCPF,
				txtTelefone, txtNascimento, txtCEP, txtSenha, txtRepetirSenha };
		boolean isAllFilled = true;

		for (JTextField jTextField : allTextFields) {
			if (jTextField.getText().equals("")) {
				isAllFilled = false;
			}
		}

		String cpf = txtCPF.getText().replaceAll("[^0-9]", ""); // Remove a máscara
		String telefone = txtTelefone.getText().replaceAll("[^0-9]", "");
		String nascimento = txtNascimento.getText().replaceAll("[^0-9]", "");
		String cep = txtCEP.getText().replaceAll("[^0-9]", "");
		if (cpf.length() != 11 || telefone.length() != 11 || nascimento.length() != 8 || cep.length() != 8)
			isAllFilled = false;
		if (nascimento.length() == 8) {
			if (Integer.parseInt(nascimento.substring(0, 2)) > 30 || Integer.parseInt(nascimento.substring(2, 4)) > 12
					|| Integer.parseInt(nascimento.substring(4, 8)) < 1000
					|| Integer.parseInt(nascimento.substring(4, 8)) > 2050)
				isAllFilled = false;
		}

		return isAllFilled;
	}
}
