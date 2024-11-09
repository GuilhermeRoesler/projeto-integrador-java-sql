package view;

import java.awt.Image;
import java.awt.Toolkit;

import controller.ArtistaDAO;
import controller.ClienteDAO;
import controller.EventoDAO;
import model.Cliente;

public class Main {

	public static final ClienteDAO conn = new ClienteDAO(); // initialize the connection
	public static final EventoDAO eventoDAO = new EventoDAO(); // initialize the connection
	public static final ArtistaDAO artistaDAO = new ArtistaDAO(); // initialize the connection
	public static Cliente mainClient = conn.getMainClient(); // set mainClient
	public static final Image logo = Toolkit.getDefaultToolkit().getImage("img/ART Music logo.png"); // set logo.png

	// initialize frames
	public static final ApresentacaoJFrame frameApresentacao = new ApresentacaoJFrame();
	public static final LoginJFrame frameLogin = new LoginJFrame(conn);
	public static final CadastroJFrame frameCadastro = new CadastroJFrame(conn);
	public static UsuarioJFrame frameUsuario;

	public static void main(String[] args) {
		// initialize frameApresentacao
		try {
			frameApresentacao.setLocationRelativeTo(null);
			frameApresentacao.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setMainClient(Cliente cliente) {
		mainClient = cliente;
	}
}
