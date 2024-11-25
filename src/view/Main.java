package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import controller.ArtistaDAO;
import controller.ClienteDAO;
import controller.EventoDAO;
import controller.ParticipacaoDAO;
import model.Cliente;
import utils.Constants;
import utils.FileManager;
import utils.ImageLoader;

public class Main {

	public static final ClienteDAO conn = new ClienteDAO(); // initialize the connection
	public static final EventoDAO eventoDAO = new EventoDAO(); // initialize the connection
	public static final ArtistaDAO artistaDAO = new ArtistaDAO(); // initialize the connection
	public static final ParticipacaoDAO participacaoDAO = new ParticipacaoDAO(); // initialize the connection

	public static Cliente mainClient; // set mainClient
	public static final Image logo = ImageLoader.loadImage("ART Music logo.png").getImage(); // set logo.png

	// initialize frames
	public static final ApresentacaoJFrame frameApresentacao = new ApresentacaoJFrame();
	public static final LoginJFrame frameLogin = new LoginJFrame(conn);
	public static final CadastroJFrame frameCadastro = new CadastroJFrame(conn);
	public static UsuarioJFrame frameUsuario;

	public static void main(String[] args) {
		initializeFile();
		mainClient = FileManager.getMainClient();

		// initialize frameApresentacao
		try {
			frameApresentacao.setLocationRelativeTo(null);
			frameApresentacao.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		File directory = new File();

//		System.getProperties().forEach((k, v) -> System.out.println(k + ": " + v));
	}

	public static void setMainClient(Cliente cliente) {
		mainClient = cliente;
	}

	/*
	 * initializes all the files the program needs to run checks if the main folder
	 * already exists in the AppData directory, and if it doesn't, creates it checks
	 * if the lastClient.txt file already exists, and if not, creates it
	 */
	public static void initializeFile() {
		try {
			File directory = new File(Constants.APP_FOLDER);

			if (!directory.exists()) {
				directory.mkdirs();
			}

			File lastClient = new File(Constants.LAST_CLIENT_PATH);
			if (!lastClient.exists()) {
				lastClient.createNewFile();
//	            FileWriter writer = new FileWriter(lastClient);
//	            writer.close();
			}
		} catch (IOException e) {
			System.out.println("Erro ao criar arquivo: " + e.getMessage());
		}
	}

//	public static InputStream loadTextFile(String fileName) {
//	    try {
//	        InputStream input = Main.class.getResourceAsStream("/resources/" + fileName);
//	        if (input != null) {
//	            return input;
//	        } else {
//	            System.err.println("Couldn't find file: " + fileName);
//	            return null;
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        return null;
//	    }
//	}

}
