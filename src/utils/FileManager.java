package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Cliente;
import view.Main;

//BufferedReader reader = new BufferedReader(new InputStreamReader(Main.loadTextFile("lastClient.txt")));

public class FileManager {
	public static String readLastClient() {
		String path = "clientes.txt";
		String lastClient = "";

		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lastClient = line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lastClient;
	}

	/*
	 * reads the content of the lastClient.txt file and returns the first value. If
	 * the first value is 0, the file can be edited.
	 */
	public static boolean isRememberMeOn() {
		boolean rememberMe;
		try (BufferedReader reader = new BufferedReader(new FileReader(Constants.LAST_CLIENT_PATH))) {
			if (reader.readLine().equals("1")) {
				rememberMe = true;
			} else {
				rememberMe = false;
			}

			// set mainClient
			Cliente mainClient = new Cliente(Integer.parseInt(reader.readLine()), reader.readLine(), reader.readLine(),
					reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine(),
					reader.readLine(), reader.readLine(), reader.readLine(), Integer.parseInt(reader.readLine()),
					reader.readLine());
			Main.setMainClient(mainClient);

			reader.close();
			return rememberMe;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<String> credentialsToArrayList() {
		ArrayList<String> credentials = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(Constants.LAST_CLIENT_PATH))) {
			String line = reader.readLine(); // deleting check byte
			line = reader.readLine(); // deleting id
			while ((line = reader.readLine()) != null) {
				credentials.add(line);
			}
			reader.close();
			return credentials;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * reads the content of the lastClient.txt file and returns a Cliente object
	 * with all the credentials
	 */
	public static Cliente getMainClient() {
		try (BufferedReader reader = new BufferedReader(new FileReader(Constants.LAST_CLIENT_PATH))) {
			reader.readLine(); // deleting check byte

			// set mainClient
			Cliente client = new Cliente(Integer.parseInt(reader.readLine()), reader.readLine(), reader.readLine(),
					reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine(),
					reader.readLine(), reader.readLine(), reader.readLine(), Integer.parseInt(reader.readLine()),
					reader.readLine());

			reader.close();
			return client;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * writes the lastClient.txt file 
	 */
	public static boolean storeCredentials(Cliente c, boolean rememberMe) {
		try (FileWriter writer = new FileWriter(Constants.LAST_CLIENT_PATH)) {
			writer.write("");
			
			// creates de check byte
			if (rememberMe) {
				writer.append("1\n");
			} else {
				writer.append("0\n");
			}
			
			// writes the rest of the information
			writer.append(String.valueOf(c.getId_pessoa()) + "\n");
			writer.append(c.getNome() + "\n");
			writer.append(c.getSobrenome() + "\n");
			writer.append(c.getEmail() + "\n");
			writer.append(c.getSenha() + "\n");
			writer.append(c.getSexo() + "\n");
			writer.append(c.getCpf() + "\n");
			writer.append(c.getTelefone() + "\n");
			writer.append(c.getNascimento() + "\n");
			writer.append(c.getCep() + "\n");
			writer.append(c.getCidade() + "\n");
			writer.append(String.valueOf(c.getDinheiro()) + "\n");
			writer.append(c.getDataEntrada() + "\n");
			writer.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
