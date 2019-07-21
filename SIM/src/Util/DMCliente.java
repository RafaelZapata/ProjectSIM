package Util;

import java.sql.*;

import javax.swing.JOptionPane;

import SimpleInventoryManagement.*;

public class DMCliente extends DMGeral{
	Connection conCliente;

	@Override
	public void incluir(Object obj) {
		Cliente objCliente = (Cliente) obj;
		try {
//			Statement statement = getConnection().createStatement();
			String incluirSqlCliente = "INSERT INTO Cliente (nome, cpf, dataNascimento, telefone, id_endereco) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlCliente, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, objCliente.getNome());
			pStmt.setString(2, objCliente.getCpf());
			pStmt.setString(3, objCliente.getDataNascimento());
			pStmt.setString(4, objCliente.getTelefone());
			pStmt.setObject(5, objCliente.getAtRefEndereco().getIdEndereco());
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
				JOptionPane.showMessageDialog(null, "Nome: "+result.getString("nome") + "Cpf: "+result.getString("cpf")+ "Data Nascimento:" + result.getString("dataNascimento")+ "Telefone: " + result.getString("telefone"));
				result.close();
			} else {
				objCliente = null;
			}
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objCliente;
	}
	
}
