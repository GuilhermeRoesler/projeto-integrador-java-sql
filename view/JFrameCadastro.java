package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.Normalizer;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ClienteDAO;
import model.Cliente;

public class JFrameCadastro extends JFrame {

	// main settings
	private static final long serialVersionUID = 1L;
	private final int lblX1 = 50;
	private final int lblX2 = 400;
	private final int txtX1 = 140;
	private final int txtX2 = 490;
	private final int lblWidth = 80;
	private final int lblHeight = 25;
	private final int txtWidth = 150;
	private final int txtHeight = 25;
	private final int btnWidth = 100;
	private final int btnHeight = 25;
	private final int Y1 = 85;
	private final int Y2 = 235;
	private final int separadorY = 35;

	// JComponents
	protected JPanel contentPane;
	protected JLabel lblCadastro, lblEmail, lblRepetirEmail, lblSenha, lblRepetirSenha, lblDadosCadastrais, lblNome,
			lblSobrenome, lblSexo, lblCPF, lblTelefone, lblNascimento, lblEndereco, lblCEP, lblCidade, lblNumero;
	protected JTextField txtEmail, txtRepetirEmail, txtNome, txtSobrenome, txtCidade, txtNumero;
	protected JFormattedTextField txtCPF, txtTelefone, txtNascimento, txtCEP;
	protected JPasswordField txtSenha, txtRepetirSenha;
	protected JCheckBox chboxSenha, chboxOfertas, chboxNumero;
	protected JButton btnEnviar, btnRandom, btnSair;
	protected JComboBox<String> cmbboxSexo;

	private ClienteDAO conn;

	public JFrameCadastro(ClienteDAO conn) {
		this.conn = conn;
		initComponents();
		formatarCampos();
	}

	private void initComponents() {
		// contentPane
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 594);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// lblCadastro
		lblCadastro = new JLabel("Cadastro");
		lblCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadastro.setFont(new Font("Nimbus Sans", Font.BOLD, 42));
		lblCadastro.setBounds(getWidth() / 2 - 100, 0, 200, 50);
		contentPane.add(lblCadastro);

		// lblEmail
		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(lblX1, Y1 + separadorY * 0, lblWidth + 20, lblHeight);
		contentPane.add(lblEmail);

		// lblRepetirEmail
		lblRepetirEmail = new JLabel("Repetir e-mail:");
		lblRepetirEmail.setBounds(lblX1, Y1 + separadorY * 1, lblWidth + 20, lblHeight);
		contentPane.add(lblRepetirEmail);

		// lblSenha
		lblSenha = new JLabel("Crie uma senha:");
		lblSenha.setBounds(lblX2, Y1 + separadorY * 0, lblWidth + 30, lblHeight);
		contentPane.add(lblSenha);

		// lblRepetirSenha
		lblRepetirSenha = new JLabel("Repetir senha:");
		lblRepetirSenha.setBounds(lblX2, Y1 + separadorY * 1, lblWidth + 30, lblHeight);
		contentPane.add(lblRepetirSenha);

		// txtEmail
		txtEmail = new JTextField();
		txtEmail.setBounds(txtX1 + 20, Y1 + separadorY * 0, txtWidth + 50, txtHeight);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		// txtRepetirEmail
		txtRepetirEmail = new JTextField();
		txtRepetirEmail.setColumns(10);
		txtRepetirEmail.setBounds(txtX1 + 20, Y1 + separadorY * 1, txtWidth + 50, txtHeight);
		contentPane.add(txtRepetirEmail);

		// txtSenha
		txtSenha = new JPasswordField();
		txtSenha.setBounds(txtX2 + 30, Y1 + separadorY * 0, txtWidth, txtHeight);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		// txtRepetirSenha
		txtRepetirSenha = new JPasswordField();
		txtRepetirSenha.setColumns(10);
		txtRepetirSenha.setBounds(txtX2 + 30, Y1 + separadorY * 1, txtWidth, txtHeight);
		contentPane.add(txtRepetirSenha);

		// chboxSenha
		chboxSenha = new JCheckBox("Show password");
		chboxSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chboxSenha.isSelected()) {
					txtSenha.setEchoChar((char) 0);
					txtRepetirSenha.setEchoChar((char) 0);
				} else {
					txtSenha.setEchoChar('*');
					txtRepetirSenha.setEchoChar('*');
				}
			}
		});
		chboxSenha.setBounds(txtSenha.getBounds().x - 4, Y1 + separadorY * 2 - 5, 150, 15);
		contentPane.add(chboxSenha);

		// lblDadosCadastrais
		lblDadosCadastrais = new JLabel("Dados cadastrais");
		lblDadosCadastrais.setFont(new Font("Gidugu", Font.BOLD, 26));
		lblDadosCadastrais.setBounds(lblX1, Y2 - 55, 220, 30);
		contentPane.add(lblDadosCadastrais);

		// lblEndereco
		lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Gidugu", Font.BOLD, 26));
		lblEndereco.setBounds(lblX2, Y2 - 55, 170, 30);
		contentPane.add(lblEndereco);

		// lblNome
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(lblX1, Y2 + separadorY * 0, lblWidth, lblHeight);
		contentPane.add(lblNome);

		// lblSobrenome
		lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(lblX1, Y2 + separadorY * 1, lblWidth, lblHeight);
		contentPane.add(lblSobrenome);

		// lblSexo
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(lblX1, Y2 + separadorY * 2, lblWidth, lblHeight);
		contentPane.add(lblSexo);

		// lblCPF
		lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(lblX1, Y2 + separadorY * 3, lblWidth, lblHeight);
		contentPane.add(lblCPF);

		// lblTelefone
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(lblX1, Y2 + separadorY * 4, lblWidth, lblHeight);
		contentPane.add(lblTelefone);

		// lblNascimento
		lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(lblX1, Y2 + separadorY * 5, lblWidth, lblHeight);
		contentPane.add(lblNascimento);

		// chboxOfertas
		chboxOfertas = new JCheckBox("Receber ofertas e novidades por e-mail");
		chboxOfertas.setSelected(true);
		chboxOfertas.setBounds(txtX1 - 4, Y2 + separadorY * 6, 250, 15);
		contentPane.add(chboxOfertas);

		// lblCEP
		lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(lblX2, Y2 + separadorY * 0, lblWidth, lblHeight);
		contentPane.add(lblCEP);

		// lblRua
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(lblX2, Y2 + separadorY * 1, lblWidth, lblHeight);
		contentPane.add(lblCidade);

		// lblNumero
		lblNumero = new JLabel("Número:");
		lblNumero.setBounds(lblX2, Y2 + separadorY * 2, lblWidth, lblHeight);
		contentPane.add(lblNumero);

		// chboxNumero
		chboxNumero = new JCheckBox("Sem número");
		chboxNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chboxNumero.isSelected()) {
					lblNumero.setEnabled(false);
					txtNumero.setEnabled(false);
					txtNumero.setText(null);
				} else {
					lblNumero.setEnabled(true);
					txtNumero.setEnabled(true);
				}
			}
		});
		chboxNumero.setBounds(txtX2 - 4, Y2 + separadorY * 3, 110, 15);
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

		cmbboxSexo = new JComboBox<String>();
		cmbboxSexo.setModel(new DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
		cmbboxSexo.setBounds(txtX1, Y2 + 2 * separadorY, txtWidth, txtHeight);
		contentPane.add(cmbboxSexo);

		// txtCPF
		txtCPF = new JFormattedTextField();
		txtCPF.setBounds(txtX1, Y2 + 3 * separadorY, txtWidth, txtHeight);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);

		// txtTelefone
		txtTelefone = new JFormattedTextField();
		txtTelefone.setBounds(txtX1, Y2 + 4 * separadorY, txtWidth, txtHeight);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);

		// txtNascimento
		txtNascimento = new JFormattedTextField();
		txtNascimento.setBounds(txtX1, Y2 + 5 * separadorY, txtWidth, txtHeight);
		contentPane.add(txtNascimento);
		txtNascimento.setColumns(10);

		// txtCEP
		txtCEP = new JFormattedTextField();
		txtCEP.setBounds(txtX2, Y2 + separadorY * 0, txtWidth, txtHeight);
		contentPane.add(txtCEP);
		txtCEP.setColumns(10);

		// txtRua
		txtCidade = new JTextField();
		txtCidade.setBounds(txtX2, Y2 + separadorY * 1, txtWidth, txtHeight);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		// txtNumero
		txtNumero = new JTextField();
		txtNumero.setBounds(txtX2, Y2 + separadorY * 2, txtWidth, txtHeight);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		// btnEnviar
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				Cliente cliente = new Cliente(txtNome.getText(), txtNascimento.getText(), txtSobrenome.getText(),
						txtEmail.getText(), txtSenha.getText().toString(), cmbboxSexo.getSelectedItem().toString(),
						txtCPF.getText(), txtTelefone.getText(), txtCEP.getText(), txtCidade.getText());
				if (conn.create(cliente)) {
					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
					JTextField alltxt[] = { txtEmail, txtRepetirEmail, txtNome, txtSobrenome, txtCidade, txtNumero,
							txtCPF, txtTelefone, txtNascimento, txtCEP, txtSenha, txtRepetirSenha };
					for (JTextField txt : alltxt) {
						txt.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Houve um erro durante o procedimento, tente novamente inserindo outros dados!");
				}
			}
		});
		btnEnviar.setBounds(690, 520, btnWidth, btnHeight);
		contentPane.add(btnEnviar);

		// btnRandom
		btnRandom = new JButton("Random");
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				randomizar();
			}
		});
		btnRandom.setBounds(12, 520, btnWidth, btnHeight);
		contentPane.add(btnRandom);

		// btnExit
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setBounds(574, 520, btnWidth, btnHeight);
		contentPane.add(btnSair);

		JLabel[] lbls = { lblCadastro, lblEmail, lblRepetirEmail, lblSenha, lblRepetirSenha, lblDadosCadastrais,
				lblNome, lblSobrenome, lblSexo, lblCPF, lblTelefone, lblNascimento, lblEndereco, lblCEP, lblCidade,
				lblNumero };

		for (JLabel jLabel : lbls) {
			jLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		}
	}

	// formatarCampos
	private void formatarCampos() {
		try {
			new MaskFormatter("###.###.###-##").install(txtCPF);
			new MaskFormatter("(##) #####-####").install(txtTelefone);
			new MaskFormatter("##/##/####").install(txtNascimento);
			new MaskFormatter("#####-###").install(txtCEP);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
			cmbboxSexo.setSelectedIndex(1);
		} else {
			cmbboxSexo.setSelectedIndex(0);
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

}
