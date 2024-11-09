package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLController {
	protected String URL = "jdbc:mysql://localhost:3306/art_music";
	protected String USER = "root";
	protected String PASS = "91512955";
	protected Connection db;
	
	public SQLController() {
		try {
			db = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
