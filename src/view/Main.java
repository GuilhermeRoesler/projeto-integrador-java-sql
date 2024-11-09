package view;

import controller.ClienteDAO;

public class Main {
	
	static final ClienteDAO conn = new ClienteDAO(); // initialize the connection
	static final ApresentacaoJFrame frameApresentacao = new ApresentacaoJFrame();
	static final LoginJFrame frameLogin = new LoginJFrame(conn);
	public static final CadastroJFrame frameCadastro = new CadastroJFrame(conn);
	static final UsuarioJFrame frameUsuario = new UsuarioJFrame(conn);
	
	public static void main(String[] args) {
		// initialize Principal
		try {
			frameApresentacao.setLocationRelativeTo(null);
			frameApresentacao.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
