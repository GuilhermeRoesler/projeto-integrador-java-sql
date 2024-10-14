package apresentacao;

public class Main {
	public static void main(String[] args) {

		try {
			JFramePrincipal frame = new JFramePrincipal();
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
