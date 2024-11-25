package utils;

import java.text.Normalizer;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class RandomCredentialsUtil {
	private int numRandomNomeSexo;

	// generates a random name
	public String randomNome() {
		Random random = new Random();

		int size = Constants.FIRST_NAMES.size();
		int randomIndex = random.nextInt(size);

		numRandomNomeSexo = randomIndex; // set the sex

		return Constants.FIRST_NAMES.get(randomIndex);
	}

	// generates a random surname
	public String randomSobrenome() {
		Random random = new Random();
		int size = Constants.LAST_NAMES.size();
		return Constants.LAST_NAMES.get(random.nextInt(size));
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

	// generates a random city
	public String randomCidade() {
		Random r = new Random();
		int size = Constants.CITIES.size();
		return Constants.CITIES.get(r.nextInt(size));
	}

	// randomNumero
	public String randomNumero() {
		Random r = new Random();

		return String.valueOf(r.nextInt(500));
	}
}
