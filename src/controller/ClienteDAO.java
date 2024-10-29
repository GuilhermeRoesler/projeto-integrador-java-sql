package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import model.Cliente;
import view.Main;

public class ClienteDAO {
	protected String URL = "jdbc:mysql://localhost:3306/music_company";
	protected String USER = "root";
	protected String PASS = "root";
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
			System.out.printf("%d record(s) registered", numRegistros);

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

	public boolean login(Cliente p) {
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
				
				Cliente c = new Cliente(id_pessoa, nome, data_nascimento, sobrenome, email, senha, sexo, cpf, telefone, cep, cidade, dinheiro, dataEntrada);
				return c;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
}
