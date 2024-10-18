package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;

import model.Cliente;

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
		String query = "INSERT INTO Cliente VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement st = db.prepareStatement(query);
			st.setString(1, p.getNome());
			st.setString(2, p.getSobrenome());
			st.setString(3, p.getEmail());
			st.setString(4, p.getSenha());
			st.setString(5, p.getSexo());
			st.setString(6, p.getCpf());
			st.setString(7, p.getTelefone());
			st.setString(8, p.getNascimento());
			st.setString(9, p.getCep());
			st.setString(10, p.getCidade());
			
			int numRegistros = st.executeUpdate();
			System.out.printf("%d record(s) registered", numRegistros);
			
			return true;
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("\nEste usuário já existe no cadastro! Tente novamento com outras credenciais!\n");
			JOptionPane.showMessageDialog(null, "Este usuário já existe no cadastro! Tente novamento com outras credenciais!");
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
