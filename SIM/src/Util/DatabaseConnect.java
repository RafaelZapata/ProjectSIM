package Util;

import java.sql.*;

import javax.swing.JOptionPane;

public class DatabaseConnect {
	
	public Statement statement;
	public ResultSet resultSet;
	private String driver = "com.mysql.jdbc.Driver";
	private String path = "jdbc:mysql://localhost:3306/Database_Name";
	private String user = "rafael";
	private String password = "root";
	public Connection connect;
	
	public void connection() {
		System.setProperty("jdbc.Drivers", driver);
		try {
			connect = DriverManager.getConnection(path, user, password);
			JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de conexão!");
			e.printStackTrace();
		}
	}
}
