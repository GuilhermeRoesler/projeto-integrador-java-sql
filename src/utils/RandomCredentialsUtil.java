package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class RandomCredentialsUtil {
	// fileReaders
	private String strNomes;
	private String strSobrenomes;
	private String strCidades;
	
	private int numRandomNomeSexo;
	
	// constructor
	public RandomCredentialsUtil() {
		try {
			strNomes = "resources/nomes.txt";
			strSobrenomes = "resources/sobrenomes.txt";
			strCidades = "resources/cidades.txt";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// randomNome
	public String randomNome() {
		Random random = new Random();
		ArrayList<String> nomes = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(strNomes));

			String line;
			while ((line = reader.readLine()) != null) {
				nomes.add(line);
			}

			reader.close();

			int numRandom = random.nextInt(199);
			numRandomNomeSexo = numRandom;
			return nomes.get(numRandom);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// randomSobrenome
	public String randomSobrenome() {
		Random random = new Random();
		ArrayList<String> sobrenomes = new ArrayList<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(strSobrenomes));

			String line;
			while ((line = reader.readLine()) != null) {
				sobrenomes.add(line);
			}

			reader.close();

			return sobrenomes.get(random.nextInt(99));

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// randomEmail
	public String randomEmail(String nome, String sobrenome) {
		if (nome.contains(" ")) {
			nome = nome.split(" ")[0];
		}

		nome = Normalizer.normalize(nome, Normalizer.Form.NFD);
		nome = nome.replaceAll("[^\\p{ASCII}]", "");

		nome = nome.toLowerCase();
		sobrenome = sobrenome.toLowerCase();
		return nome + sobrenome + "@gmail.com";
	}

	// randomSenha
	public String randomSenha() {
		Random r = new Random();
		String senha = "";

		for (int i = 0; i < 8; i++) {
			int rNumber = r.nextInt(10);
			senha += rNumber;
		}

		return senha;
	}

	// randomSexo
	public void randomSexo(JComboBox<String> cmbboxSexo, JLabel lblSexo2) {
		if (numRandomNomeSexo < 100) {
			cmbboxSexo.setSelectedIndex(cmbboxSexo.getItemCount() - 1);
			lblSexo2.setText("Feminino");
		} else {
			cmbboxSexo.setSelectedIndex(cmbboxSexo.getItemCount() - 2);
			lblSexo2.setText("Masculino");
		}
	}

	// randomCPF
	public String randomCPF() {
		Random r = new Random();
		String s = String.format("%d%d%d.%d%d%d.%d%d%d-%d%d", r.nextInt(10), r.nextInt(10), r.nextInt(10),
				r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10),
				r.nextInt(10));

		return s;
	}

	// randomTelefone
	public String randomTelefone() {
		Random r = new Random();
		String s = String.format("(%d%d) %d%d%d%d%d-%d%d%d%d", r.nextInt(10), r.nextInt(10), r.nextInt(10),
				r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10),
				r.nextInt(10));

		return s;
	}

	// randomNascimento
	public String randomNascimento() {
		Random r = new Random();
		String s = String.format("%02d/%02d/%04d", r.nextInt(30) + 1, r.nextInt(12) + 1, r.nextInt(1000) + 1000);

		return s;
	}

	// randomCEP
	public String randomCEP() {
		Random r = new Random();
		String s = String.format("%d%d%d%d%d-%d%d%d", r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10),
				r.nextInt(10), r.nextInt(10), r.nextInt(10), r.nextInt(10));
		return s;
	}

	// randomCidade
	public String randomCidade() {
		Random r = new Random();
		ArrayList<String> cidades = new ArrayList<String>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(strCidades));

			String line;
			while ((line = reader.readLine()) != null) {
				cidades.add(line);
			}

			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return cidades.get(r.nextInt(200));
	}

	// randomNumero
	public String randomNumero() {
		Random r = new Random();

		return String.valueOf(r.nextInt(500));
	}
}
