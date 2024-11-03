package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Artista;

public class ArtistaDAO {
	protected String URL = "jdbc:mysql://localhost:3306/music_company";
	protected String USER = "root";
	protected String PASS = "91512955";
	protected Connection db;
	
	public ArtistaDAO() {
		try {
			db = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean create(Artista p) {
		String query = "";
		
		try {
			PreparedStatement st = db.prepareStatement(query);
			int numRegistros = st.executeUpdate();
			System.out.printf("%d record(s) registered", numRegistros);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	@SuppressWarnings(value = { })
	public boolean read() {
		String query = "SELECT * FROM Artista";
		
		try {
			PreparedStatement st = db.prepareStatement(query);
			ResultSet res = st.executeQuery();
			
			while (res.next()) {
				System.out.println(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean update() {
		String query = "";
		
		try {
			PreparedStatement st = db.prepareStatement(query);
			int numRegistros = st.executeUpdate();
			System.out.printf("%d record(s) registered", numRegistros);
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete() {
		String query = "";
		
		try {
			PreparedStatement st = db.prepareStatement(query);
			int numRegistros = st.executeUpdate();
			System.out.printf("%d record(s) registered", numRegistros);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}