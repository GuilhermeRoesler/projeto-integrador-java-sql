package apresentacao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Font;

public class JFrameCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private final int lblX1 = 50;
	private final int lblX2 = 400;
	private final int lblWidth = 90;
	private final int lblHeight = 15;
	private final int txtWidth = 115;
	private final int txtHeight = 20;

	private JPanel contentPane;
	private JLabel lblEmail, lblRepetirEmail, lblSenha, lblRepetirSenha, lblDadosCadastrais, lblNome, lblSobrenome,
	lblSexo, lblCPF, lblTelefone, lblCelular, lblNascimento, lblEnderecoEntrega, lblCEP, lblRua, lblNumero,
	lblComplemento, lblReferencia, lblBairro, lblCidade, lblEstado;
	private JTextField txtEmail, txtRepetirEmail, txtSenha, txtRepetirSenha, txtNome, txtSobrenome, txtSexo, txtCPF,
	txtTelefone, txtCelular, txtNascimento, txtCEP, txtRua, txtNumero, txtComplemento, txtReferencia, txtBairro,
	txtCidade, txtEstado;
	private JRadioButton rdbtnPessoaFisica, rdbtnPessoaJurdica;
	private JCheckBox chboxOfertas, chboxNumero;

	public JFrameCadastro() {
		initComponents();
	}

	private void initComponents() {
		// contentPane
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// lblEmail
		lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(50, 67, 92, 18);
		contentPane.add(lblEmail);

		// txtEmail
		txtEmail = new JTextField();
		txtEmail.setBounds(132, 67, 114, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		// lblRepetirEmail
		lblRepetirEmail = new JLabel("Repetir e-mail:");
		lblRepetirEmail.setBounds(26, 100, 160, 15);
		contentPane.add(lblRepetirEmail);

		// txtRepetirEmail
		txtRepetirEmail = new JTextField();
		txtRepetirEmail.setColumns(10);
		txtRepetirEmail.setBounds(132, 98, 114, 19);
		contentPane.add(txtRepetirEmail);

		// lblSenha
		lblSenha = new JLabel("Crie uma senha:");
		lblSenha.setBounds(263, 69, 188, 15);
		contentPane.add(lblSenha);

		// txtSenha
		txtSenha = new JTextField();
		txtSenha.setBounds(388, 67, 114, 19);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		// lblRepetirSenha
		lblRepetirSenha = new JLabel("Repetir senha:");
		lblRepetirSenha.setBounds(263, 98, 188, 15);
		contentPane.add(lblRepetirSenha);

		// txtRepetirSenha
		txtRepetirSenha = new JTextField();
		txtRepetirSenha.setColumns(10);
		txtRepetirSenha.setBounds(388, 98, 114, 19);
		contentPane.add(txtRepetirSenha);

		// lblDadosCadastrais
		lblDadosCadastrais = new JLabel("Dados cadastrais");
		lblDadosCadastrais.setFont(new Font("Gentium Book Basic", Font.BOLD, 14));
		lblDadosCadastrais.setBounds(36, 118, 136, 54);
		contentPane.add(lblDadosCadastrais);

		// lblNome
		lblNome = new JLabel("Nome:");
		lblNome.setBounds(50, 217, lblWidth, 15);
		contentPane.add(lblNome);

		// lblSobrenome
		lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(50, 244, lblWidth, 15);
		contentPane.add(lblSobrenome);

		// lblSexo
		lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(50, 273, lblWidth, 15);
		contentPane.add(lblSexo);

		// lblCPF
		lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(50, 300, lblWidth, 15);
		contentPane.add(lblCPF);

		// lblTelefone
		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(42, 327, lblWidth, 15);
		contentPane.add(lblTelefone);

		// lblCelular
		lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(50, 359, lblWidth, 15);
		contentPane.add(lblCelular);

		// lblNascimento
		lblNascimento = new JLabel("Nascimento:");
		lblNascimento.setBounds(50, 386, lblWidth, 15);
		contentPane.add(lblNascimento);

		// rdbtnPessoaFisica
		rdbtnPessoaFisica = new JRadioButton("Pessoa física");
		rdbtnPessoaFisica.setSelected(true);
		rdbtnPessoaFisica.setBounds(37, 173, 136, 23);
		contentPane.add(rdbtnPessoaFisica);

		// rdbtnPessoaJurdica
		rdbtnPessoaJurdica = new JRadioButton("Pessoa jurídica");
		rdbtnPessoaJurdica.setBounds(171, 173, 149, 23);
		contentPane.add(rdbtnPessoaJurdica);

		lblEnderecoEntrega = new JLabel("Endereço de entrega");
		lblEnderecoEntrega.setFont(new Font("Gentium Book Basic", Font.BOLD, 14));
		lblEnderecoEntrega.setBounds(366, 112, 198, 67);
		contentPane.add(lblEnderecoEntrega);

		lblCEP = new JLabel("CEP:");
		lblCEP.setBounds(400, 208, lblWidth, 32);
		contentPane.add(lblCEP);

		lblRua = new JLabel("Rua:");
		lblRua.setBounds(388, 235, lblWidth, 32);
		contentPane.add(lblRua);

		lblNumero = new JLabel("Número:");
		lblNumero.setBounds(388, 264, lblWidth, 32);
		contentPane.add(lblNumero);

		chboxNumero = new JCheckBox("Sem número");
		chboxNumero.setBounds(462, 300, 203, 15);
		contentPane.add(chboxNumero);

		lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(388, 318, lblWidth, 32);
		contentPane.add(lblComplemento);

		// lblReferencia
		lblReferencia = new JLabel("Referência:");
		lblReferencia.setBounds(388, 345, lblWidth, 32);
		contentPane.add(lblReferencia);

		// lblBairro
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(388, 377, lblWidth, 32);
		contentPane.add(lblBairro);

		// lblCidade
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(388, 401, lblWidth, 32);
		contentPane.add(lblCidade);

		// lblEstado
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(388, 428, lblWidth, 33);
		contentPane.add(lblEstado);

		chboxOfertas = new JCheckBox("Receber ofertas e novidades por e-mail");
		chboxOfertas.setBounds(75, 410, 311, 15);
		contentPane.add(chboxOfertas);

		txtNome = new JTextField();
		txtNome.setBounds(143, 215, 114, 19);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtSobrenome = new JTextField();
		txtSobrenome.setBounds(143, 244, 114, 19);
		contentPane.add(txtSobrenome);
		txtSobrenome.setColumns(10);

		txtSexo = new JTextField();
		txtSexo.setBounds(143, 271, 114, 19);
		contentPane.add(txtSexo);
		txtSexo.setColumns(10);

		txtCPF = new JTextField();
		txtCPF.setBounds(143, 300, 114, 19);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(143, 327, 114, 19);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);

		txtCelular = new JTextField();
		txtCelular.setBounds(143, 354, 114, 19);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);

		txtNascimento = new JTextField();
		txtNascimento.setBounds(143, 382, 114, 19);
		contentPane.add(txtNascimento);
		txtNascimento.setColumns(10);

		txtRua = new JTextField();
		txtRua.setBounds(462, 242, 114, 19);
		contentPane.add(txtRua);
		txtRua.setColumns(10);

		txtCEP = new JTextField();
		txtCEP.setBounds(462, 215, 114, 19);
		contentPane.add(txtCEP);
		txtCEP.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setBounds(462, 271, 114, 19);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(491, 323, 114, 19);
		contentPane.add(txtComplemento);
		txtComplemento.setColumns(10);

		txtReferencia = new JTextField();
		txtReferencia.setBounds(491, 352, 114, 19);
		contentPane.add(txtReferencia);
		txtReferencia.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setBounds(491, 382, 114, 19);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setBounds(491, 410, 114, 19);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		txtEstado = new JTextField();
		txtEstado.setBounds(491, 442, 114, 19);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
	}
}
