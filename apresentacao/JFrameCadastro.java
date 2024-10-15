package apresentacao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class JFrameCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private final int lblX1 = 50;
	private final int lblX2 = 400;
	private final int txtX1 = 140;
	private final int txtX2 = 510;
	private final int lblWidth = 90;
	private final int lblHeight = 15;
	private final int txtWidth = 115;
	private final int txtHeight = 20;
	private final int btnWidth = 100;
	private final int btnHeight = 25;

	private JPanel contentPane;
	private JLabel lblCadastro, lblEmail, lblRepetirEmail, lblSenha, lblRepetirSenha, lblDadosCadastrais, lblNome,
			lblSobrenome, lblSexo, lblCPF, lblTelefone, lblCelular, lblNascimento, lblEndereco, lblCEP, lblRua,
			lblNumero, lblComplemento, lblReferencia, lblBairro, lblCidade, lblEstado;
	private JTextField txtEmail, txtRepetirEmail, txtSenha, txtRepetirSenha, txtNome, txtSobrenome, txtSexo, txtCPF,
			txtTelefone, txtCelular, txtNascimento, txtCEP, txtRua, txtNumero, txtComplemento, txtReferencia, txtBairro,
			txtCidade, txtEstado;
	private JRadioButton rdbtnPessoaFisica, rdbtnPessoaJurdica;
	private JCheckBox chboxOfertas, chboxNumero;
	private JButton btnEnviar, btnRandom, btnExit;

	public JFrameCadastro() {
		initComponents();
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
		lblCadastro.setBounds(295, 0, 203, 54);
		contentPane.add(lblCadastro);

		// lblEmail
		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(lblX1, 67, lblWidth, lblHeight);
		contentPane.add(lblEmail);

		// lblRepetirEmail
		lblRepetirEmail = new JLabel("Repetir e-mail:");
		lblRepetirEmail.setBounds(lblX1, 100, lblWidth + 20, lblHeight);
		contentPane.add(lblRepetirEmail);

		// lblSenha
		lblSenha = new JLabel("Crie uma senha:");
		lblSenha.setBounds(lblX2, 69, lblWidth + 30, lblHeight);
		contentPane.add(lblSenha);

		// lblRepetirSenha
		lblRepetirSenha = new JLabel("Repetir senha:");
		lblRepetirSenha.setBounds(lblX2, 98, lblWidth + 30, lblHeight);
		contentPane.add(lblRepetirSenha);

		// txtEmail
		txtEmail = new JTextField();
		txtEmail.setBounds(txtX1 + 20, 67, txtWidth, txtHeight);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		// txtRepetirEmail
		txtRepetirEmail = new JTextField();
		txtRepetirEmail.setColumns(10);
		txtRepetirEmail.setBounds(txtX1 + 20, 98, txtWidth, txtHeight);
		contentPane.add(txtRepetirEmail);

		// txtSenha
		txtSenha = new JTextField();
		txtSenha.setBounds(txtX2 + 20, 67, txtWidth, txtHeight);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		// txtRepetirSenha
		txtRepetirSenha = new JTextField();
		txtRepetirSenha.setColumns(10);
		txtRepetirSenha.setBounds(txtX2 + 20, 98, txtWidth, txtHeight);
		contentPane.add(txtRepetirSenha);

		// lblDadosCadastrais
		lblDadosCadastrais = new JLabel("Dados cadastrais");
		lblDadosCadastrais.setFont(new Font("Gidugu", Font.BOLD, 26));
		lblDadosCadastrais.setBounds(lblX1, 130, 170, 30);
		contentPane.add(lblDadosCadastrais);

		// lblEndereco
		lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Gidugu", Font.BOLD, 26));
		lblEndereco.setBounds(lblX2, 130, 170, 30);
		contentPane.add(lblEndereco);

		// rdbtnPessoaFisica
		rdbtnPessoaFisica = new JRadioButton("Pessoa física");
		rdbtnPessoaFisica.setSelected(true);
		rdbtnPessoaFisica.setBounds(lblX1, 173, 130, 23);
		contentPane.add(rdbtnPessoaFisica);

		// rdbtnPessoaJurdica
		rdbtnPessoaJurdica = new JRadioButton("Pessoa jurídica");
		rdbtnPessoaJurdica.setBounds(lblX1 + 130, 173, 149, 23);
		contentPane.add(rdbtnPessoaJurdica);

		// lblNome
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(lblX1, 217, lblWidth, lblHeight);
		contentPane.add(lblNome);

		// lblSobrenome
		lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(lblX1, 244, lblWidth, lblHeight);
		contentPane.add(lblSobrenome);

		// lblSexo
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(lblX1, 273, lblWidth, lblHeight);
		contentPane.add(lblSexo);

		// lblCPF
		lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(lblX1, 300, lblWidth, lblHeight);
		contentPane.add(lblCPF);

		// lblTelefone
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(lblX1, 327, lblWidth, lblHeight);
		contentPane.add(lblTelefone);

		// lblCelular
		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(lblX1, 359, lblWidth, lblHeight);
		contentPane.add(lblCelular);

		// lblNascimento
		lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(lblX1, 386, lblWidth, lblHeight);
		contentPane.add(lblNascimento);

		// lblCEP
		lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(lblX2, 208, lblWidth, lblHeight);
		contentPane.add(lblCEP);

		// lblRua
		lblRua = new JLabel("Rua:");
		lblRua.setBounds(lblX2, 235, lblWidth, lblHeight);
		contentPane.add(lblRua);

		// lblNumero
		lblNumero = new JLabel("Número:");
		lblNumero.setBounds(lblX2, 264, lblWidth, lblHeight);
		contentPane.add(lblNumero);

		// chboxNumero
		chboxNumero = new JCheckBox("Sem número");
		chboxNumero.setBounds(lblX2, 300, 203, 15);
		contentPane.add(chboxNumero);

		// lblComplemento
		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(lblX2, 318, lblWidth + 20, lblHeight);
		contentPane.add(lblComplemento);

		// lblReferencia
		lblReferencia = new JLabel("Referência:");
		lblReferencia.setBounds(lblX2, 345, lblWidth, lblHeight);
		contentPane.add(lblReferencia);

		// lblBairro
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(lblX2, 377, lblWidth, lblHeight);
		contentPane.add(lblBairro);

		// lblCidade
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(lblX2, 401, lblWidth, lblHeight);
		contentPane.add(lblCidade);

		// lblEstado
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(lblX2, 428, lblWidth, lblHeight);
		contentPane.add(lblEstado);

		// chboxOfertas
		chboxOfertas = new JCheckBox("Receber ofertas e novidades por e-mail");
		chboxOfertas.setBounds(lblX1, 410, 311, 15);
		contentPane.add(chboxOfertas);

		// txtNome
		txtNome = new JTextField();
		txtNome.setBounds(txtX1, 215, txtWidth, txtHeight);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		// txtSobrenome
		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(txtX1, 244, txtWidth, txtHeight);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);

		// txtSexo
		txtSexo = new JTextField();
		txtSexo.setBounds(txtX1, 271, txtWidth, txtHeight);
		contentPane.add(txtSexo);
		txtSexo.setColumns(10);

		// txtCPF
		txtCPF = new JTextField();
		txtCPF.setBounds(txtX1, 300, txtWidth, txtHeight);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);

		// txtTelefone
		txtTelefone = new JTextField();
		txtTelefone.setBounds(txtX1, 327, txtWidth, txtHeight);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);

		// txtCelular
		txtCelular = new JTextField();
		txtCelular.setBounds(txtX1, 354, txtWidth, txtHeight);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);

		// txtNascimento
		txtNascimento = new JTextField();
		txtNascimento.setBounds(txtX1, 382, txtWidth, txtHeight);
		contentPane.add(txtNascimento);
		txtNascimento.setColumns(10);

		// txtRua
		txtRua = new JTextField();
		txtRua.setBounds(txtX2, 242, txtWidth, txtHeight);
		contentPane.add(txtRua);
		txtRua.setColumns(10);

		// txtCEP
		txtCEP = new JTextField();
		txtCEP.setBounds(txtX2, 215, txtWidth, txtHeight);
		contentPane.add(txtCEP);
		txtCEP.setColumns(10);

		// txtNumero
		txtNumero = new JTextField();
		txtNumero.setBounds(txtX2, 271, txtWidth, txtHeight);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		// txtComplemento
		txtComplemento = new JTextField();
		txtComplemento.setBounds(txtX2, 323, txtWidth, txtHeight);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);

		// txtReferencia
		txtReferencia = new JTextField();
		txtReferencia.setBounds(txtX2, 352, txtWidth, txtHeight);
		contentPane.add(txtReferencia);
		txtReferencia.setColumns(10);

		// txtBairro
		txtBairro = new JTextField();
		txtBairro.setBounds(txtX2, 382, txtWidth, txtHeight);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);

		// txtCidade
		txtCidade = new JTextField();
		txtCidade.setBounds(txtX2, 410, txtWidth, txtHeight);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		// txtEstado
		txtEstado = new JTextField();
		txtEstado.setBounds(txtX2, 442, txtWidth, txtHeight);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);

		// btnEnviar
		btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(704, 520, btnWidth, btnHeight);
		contentPane.add(btnEnviar);

		// btnRandom
		btnRandom = new JButton("Random");
		btnRandom.setBounds(12, 520, btnWidth, btnHeight);
		btnRandom.setContentAreaFilled(false);
		btnRandom.setBorderPainted(false);
		contentPane.add(btnRandom);

		// btnExit
		btnExit = new JButton("Saida");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnExit.setBounds(592, 520, btnWidth, btnHeight);
		contentPane.add(btnExit);
	}
}
