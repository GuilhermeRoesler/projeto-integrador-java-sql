package apresentacao;

public class Main {
	public static void main(String[] args) {

		try {
			JFrameCadastro frame = new JFrameCadastro();
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
