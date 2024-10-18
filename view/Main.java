package view;

import controller.ClienteDAO;

public class Main {
	public static void main(String[] args) {
		ClienteDAO conn = new ClienteDAO(); // initialize the connection

		// initialize Principal
		try {
			JFramePrincipal frame = new JFramePrincipal(conn);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			JFrameCadastro frame = new JFrameCadastro(conn);
//			frame.setTitle("Cadastro");
//			frame.setLocationRelativeTo(null);
//			frame.setResizable(false);
//			frame.setVisible(true);
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}
		
//		try {
//			BufferedReader reader = new BufferedReader(new FileReader("sobrenomes.txt"));
//			
//			String line;
//			while ((line = reader.readLine()) != null) {
//				System.out.println(line);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

}
