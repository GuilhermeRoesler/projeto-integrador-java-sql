package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventoDAO {
	protected String URL = "jdbc:mysql://localhost:3306/music_company";
	protected String USER = "root";
	protected String PASS = "root";
	protected Connection db;
	
	public EventoDAO() {
		try {
			db = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean create() {
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
	
	public boolean read() {
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
