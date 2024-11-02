package view;

import java.awt.Image;
import java.awt.Toolkit;

import controller.ClienteDAO;
import model.Cliente;

public class Main {

	public static final ClienteDAO conn = new ClienteDAO(); // initialize the connection
	public static Cliente mainClient = conn.getMainClient(); // set mainClient
	public static final Image logo = Toolkit.getDefaultToolkit().getImage("src/img/ART Music logo.png"); // set logo.png
	
	// initialize frames
	public static final ApresentacaoJFrame frameApresentacao = new ApresentacaoJFrame();
	public static final LoginJFrame frameLogin = new LoginJFrame(conn);
	public static final CadastroJFrame frameCadastro = new CadastroJFrame(conn);
	public static UsuarioJFrame frameUsuario;

	public static void main(String[] args) {
		// initialize Principal
		try {
			frameApresentacao.setLocationRelativeTo(null);
			frameApresentacao.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void setMainClient(int id_pessoa, String nome, String nascimento, String sobrenome, String email,
			String senha, String sexo, String cpf, String telefone, String cep, String cidade, int dinheiro,
			String dataEntrada) {
		Cliente cliente = new Cliente(id_pessoa, nome, nascimento, sobrenome, email, senha, sexo, cpf, telefone, cep,
				cidade, dinheiro, dataEntrada);
		mainClient = cliente;
	}
}
