package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Cliente;
import view.Main;

public class ClienteDAO {
	protected String URL = "jdbc:mysql://localhost:3306/music_company";
	protected String USER = "root";
	protected String PASS = "91512955";
	protected Connection db;

	public ClienteDAO() {
		try {
			db = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean create(Cliente p) {
		String query = "INSERT INTO Cliente VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, ?)";

		try {
			PreparedStatement st = db.prepareStatement(query);
			st.setString(1, p.getNome());
			st.setString(2, p.getSobrenome());
			st.setString(3, p.getEmail());
			st.setString(4, p.getSenha());
			st.setString(5, sexoToMysql(p.getSexo()));
			st.setString(6, p.getCpf());
			st.setString(7, p.getTelefone());
			st.setString(8, nascimentoToMysql(p.getNascimento()));
			st.setString(9, p.getCep());
			st.setString(10, p.getCidade());
			st.setString(11, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

			int numRegistros = st.executeUpdate();
			System.out.printf("%d record(s) registered\n", numRegistros);

			Main.frameCadastro.tfdLimparTodos();
			return true;
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("\nEste usuário já existe no cadastro! Tente novamento com outras credenciais!\n");
			JOptionPane.showMessageDialog(null,
					"Este usuário já existe no cadastro! Tente novamento com outras credenciais!");
			Main.frameCadastro.tfdLimparTodos();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			Main.frameCadastro.tfdLimparTodos();
			return false;
		}
	}

	public boolean read() {
		return true;
	}

	public boolean update(Cliente c) {
		String query = "UPDATE Cliente SET nome = ?, sobrenome = ?, email = ?, senha = ?, sexo = ?, cpf = ?, telefone = ?, data_nascimento = ?, cep = ?, cidade = ?, dinheiro = ?, data_entrada = ? WHERE id_cliente = ?";

		try {
			PreparedStatement st = db.prepareStatement(query);
			st.setString(1, c.getNome());
			st.setString(2, c.getSobrenome());
			st.setString(3, c.getEmail());
			st.setString(4, c.getSenha());
			st.setString(5, c.getSexo());
			st.setString(6, c.getCpf());
			st.setString(7, c.getTelefone());
			st.setString(8, c.getNascimento());
			st.setString(9, c.getCep());
			st.setString(10, c.getCidade());
			st.setInt(11, c.getDinheiro());
			st.setString(12, c.getDataEntrada());
			st.setInt(13, c.getId_pessoa());

			int numRegistros = st.executeUpdate();
			System.out.printf("%d record(s) registered\n", numRegistros);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(Cliente c) {
		String query = "DELETE FROM Cliente WHERE id_cliente = ?";
		
		try {
			PreparedStatement st = db.prepareStatement(query);
			st.setInt(1, c.getId_pessoa());
			
			int numRegistros = st.executeUpdate();
			System.out.printf("%d record(s) registered\n", numRegistros);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean canLogin(Cliente p) {
		String query = "SELECT * FROM Cliente WHERE email = ? AND senha = ?";

		try {
			PreparedStatement st = db.prepareStatement(query);
			st.setString(1, p.getEmail());
			st.setString(2, p.getSenha());
			ResultSet res = st.executeQuery();

//			System.out.println(PasswordUtil.hashPassword(p.getSenha()));
//			return PasswordUtil.checkPassword("1234", PasswordUtil.hashPassword(p.getSenha()));

			return res.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String recuperarSenha(String email) {
		String query = "SELECT * FROM Cliente WHERE email = ?";

		try {
			PreparedStatement st = db.prepareStatement(query);
			st.setString(1, email);

			ResultSet res = st.executeQuery();

			if (res.next()) {
				return res.getString("senha");
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Cliente getBySenha(String senha) {
		String query = "SELECT * FROM Cliente WHERE senha = ?";

		try {
			PreparedStatement st = db.prepareStatement(query);
			st.setString(1, senha);

			ResultSet res = st.executeQuery();
			return criarCliente(res);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Cliente getByEmail(String email) {
		String query = "SELECT * FROM Cliente WHERE email = ?";

		try {
			PreparedStatement st = db.prepareStatement(query);
			st.setString(1, email);

			ResultSet res = st.executeQuery();
			return criarCliente(res);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	private Cliente criarCliente(ResultSet res) {
		try {
			if (res.next()) {
				int id_pessoa = res.getInt("id_cliente");
				String nome = res.getString("nome");
				String sobrenome = res.getString("sobrenome");
				String email = res.getString("email");
				String senha = res.getString("senha");
				String sexo = res.getString("sexo");
				String cpf = res.getString("cpf");
				String telefone = res.getString("telefone");
				String data_nascimento = res.getString("data_nascimento");
				String cep = res.getString("cep");
				String cidade = res.getString("cidade");
				int dinheiro = res.getInt("dinheiro");
				String dataEntrada = res.getString("data_entrada");

				Cliente cliente = new Cliente(id_pessoa, nome, sobrenome, email, senha, sexo, cpf, telefone,
						data_nascimento, cep, cidade, dinheiro, dataEntrada);
				return cliente;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Cliente criarCliente(ArrayList<String> credentials) {
		int id_pessoa = Integer.parseInt(credentials.get(0));
		String nome = credentials.get(1);
		String sobrenome = credentials.get(2);
		String email = credentials.get(3);
		String senha = credentials.get(4);
		String sexo = credentials.get(5);
		String cpf = credentials.get(6);
		String telefone = credentials.get(7);
		String data_nascimento = credentials.get(8);
		String cep = credentials.get(9);
		String cidade = credentials.get(10);
		int dinheiro = Integer.parseInt(credentials.get(11));
		String dataEntrada = credentials.get(12);

		Cliente cliente = new Cliente(id_pessoa, nome, sobrenome, email, senha, sexo, cpf, telefone, data_nascimento,
				cep, cidade, dinheiro, dataEntrada);
		return cliente;
	}

	private String nascimentoToMysql(String nascimento) {
//		if (nascimento.contains("/")) {
//			return String.format("%s-%s-%s", nascimento.split("/")[2], nascimento.split("/")[1], nascimento.split("/")[0]);			
//		} else {
//			return nascimento;
//		}
		String s = LocalDate.parse(nascimento, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")).toString();
		System.out.println(s);
		return s;
	}

	private String sexoToMysql(String sexo) {
		if (sexo.equals("Masculino")) {
			return "M";
		} else if (sexo.equals("Feminino")) {
			return "F";
		} else {
			return null;
		}
	}

	// save credentials last client
	public boolean storeCredentials(Cliente c, boolean rememberMe) {
		try {
			FileWriter writer = new FileWriter("src/resources/lastClient.txt");
			writer.write("");
			if (rememberMe) {
				writer.append("1\n");
			} else {
				writer.append("0\n");
			}
			writer.append(String.valueOf(c.getId_pessoa()) + "\n"); // admin@gmail.com
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

	public boolean isRememberMeOn() {
		boolean rememberMe;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/resources/lastClient.txt"));

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

	public ArrayList<String> credentialsToArrayList() {
		ArrayList<String> credentials = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/resources/lastClient.txt"));
			String line = reader.readLine(); // excluindo byte de verificação
			line = reader.readLine(); // excluindo id
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

	public Cliente getMainClient() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("src/resources/lastClient.txt"));
			reader.readLine(); // excluindo byte de verificação

			// set mainClient
			Cliente c = new Cliente(Integer.parseInt(reader.readLine()), reader.readLine(), reader.readLine(),
					reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine(), reader.readLine(),
					reader.readLine(), reader.readLine(), reader.readLine(), Integer.parseInt(reader.readLine()),
					reader.readLine());

			reader.close();
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
