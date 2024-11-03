package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;
import model.Evento;

public class ParticipacaoDAO {
	protected String URL = "jdbc:mysql://localhost:3306/music_company";
	protected String USER = "root";
	protected String PASS = "91512955";
	protected Connection db;

	public ParticipacaoDAO() {
		try {
			db = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean create(Cliente c, Evento e) {
		String query = "INSERT INTO Participacao VALUES(null, ?, ?)";
		
		try {
			PreparedStatement st = db.prepareStatement(query);
			st.setInt(1, c.getId_pessoa());
			st.setInt(2, e.getId_evento());
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}
	
	public void read() {
		String query = "SELECT * FROM Participacao";
		
		try {
			PreparedStatement st = db.prepareStatement(query);
			ResultSet res = st.executeQuery();
			
			while (res.next()) {
				System.out.println(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean update() {
		return true;
	}
	
	public boolean delete() {
		return true;
	}

}
