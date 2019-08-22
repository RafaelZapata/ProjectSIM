package persistencia;

import java.sql.*;

public abstract class DMGeral {
	protected static Connection connection;
	private String database = "bd_sim";
	private String username = "admin"; 
	private String password = "admin";

	public static Connection getConnection() {
		return connection;
	}

	public void conectaDatabase() {
		String url = "jdbc:mysql://localhost/"+database+"?serverTimezone=UTC";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException cnfex) {
			System.err.println("Falha ao abrir o driver JDBC/ODBC");
			cnfex.printStackTrace();
			System.exit(1);
		} catch (SQLException sqlex) {
			System.err.println("Impossivel conectar");
			sqlex.printStackTrace();
		}
		
	}
	
	public void shutDown()
	{	try
		{	connection.close();	}
		catch (SQLException sqlex)
		{	System.err.println("Impossível desconectar");
		  	sqlex.printStackTrace();
		}
	}
	
	public abstract void incluir(Object obj);
	public abstract Object consultar(Object obj);
}
