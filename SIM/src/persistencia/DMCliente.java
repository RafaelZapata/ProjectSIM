package persistencia;

import java.sql.*;

import javax.swing.JOptionPane;

import model.*;

public class DMCliente extends DMGeral{
	Connection conCliente;

	@Override
	public void incluir(Object obj) {
		Cliente objCliente = (Cliente) obj;
		try {
//			Statement statement = getConnection().createStatement();
			String incluirSqlCliente = "INSERT INTO Cliente (nome, cpf, telefone, dataNascimento) VALUES (?, ?, ?, ?)";
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlCliente, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, objCliente.getNome());
			pStmt.setString(2, objCliente.getCpf());
			pStmt.setString(3, objCliente.getTelefone());
			pStmt.setDate(4, (Date) objCliente.getDataNascimento());
			pStmt.executeUpdate();
			
			ResultSet resultSet = pStmt.getGeneratedKeys();
			resultSet.next();
			int idGerado = resultSet.getInt(1);
			objCliente.setIdCliente(idGerado);
			pStmt.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public Object consultar(Object obj) {
		Cliente objCliente = (Cliente) obj;		
		
		try {
			String consultarSqlCliente = "SELECT * FROM Cliente WHERE (cpf = (?))";
			PreparedStatement pStmt  = getConnection().prepareStatement(consultarSqlCliente);
			pStmt.setString(1, objCliente.getCpf());
			ResultSet result = pStmt.executeQuery();
			if(result.next()) {
				JOptionPane.showMessageDialog(null, "Nome: "+result.getString("nome") + "\nCpf: "+result.getString("cpf")+ "\nData Nascimento:" + result.getString("dataNascimento")+ "\nTelefone: " + result.getString("telefone"));
				result.close();
			} else {
				objCliente = null;
			}
			pStmt.close();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return objCliente;
	}
	
	public void excluir(int id) {
		try {
			Statement stmt = getConnection().createStatement();
			String sqlExcluir = "DELETE FROM Cliente WHERE idCliente = "+id+";";
			stmt.execute(sqlExcluir);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar");
			e.printStackTrace();
		}
	}
}
