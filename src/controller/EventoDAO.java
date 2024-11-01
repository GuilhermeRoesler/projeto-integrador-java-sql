package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Evento;

public class EventoDAO {
	protected String URL = "jdbc:mysql://localhost:3306/music_company";
	protected String USER = "root";
	protected String PASS = "91512955";
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
	
	public ArrayList<Evento> read() {
		ArrayList<Evento> eventos = new ArrayList<>();
		
		String query = "SELECT * FROM Evento";
		
		try {
			PreparedStatement st = db.prepareStatement(query);
			ResultSet res = st.executeQuery();
			
			while (res.next()) {
				int id_evento = res.getInt("id_evento");
				String nome = res.getString("nome");
				String data = res.getString("data");
				String local = res.getString("local");
				int id_artista = res.getInt("id_artista");
				double preco = res.getDouble("preco_ingresso");
				int capacidade = res.getInt("capacidade");
				String descricao = res.getString("descricao");
				String tipo = res.getString("tipo_evento");
				String status = res.getString("status");
				
				Evento e = new Evento(id_evento, nome, data, local, id_artista, preco, capacidade, descricao, tipo, status);
				eventos.add(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return eventos;
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