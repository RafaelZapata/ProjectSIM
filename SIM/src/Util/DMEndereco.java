package Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import SimpleInventoryManagement.Endereco;
import SimpleInventoryManagement.Produto;

public class DMEndereco extends DMGeral{

	@Override
	public void incluir(Object obj) {
		Endereco objEndereco= (Endereco) obj;
		try {
			String incluirSqlEndereco= "INSERT INTO Endereco(rua, numero, bairro, cidade, estado) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlEndereco, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, objEndereco.getRua());
			pStmt.setInt(2, objEndereco.getNumeroResidencia());
			pStmt.setString(3, objEndereco.getBairro());
			pStmt.setString(4, objEndereco.getCidade());
			pStmt.setString(5, objEndereco.getEstado());
			pStmt.executeUpdate();
			
			ResultSet resultSet = pStmt.getGeneratedKeys();
			resultSet.next();
			int idGerado = resultSet.getInt(1);
			objEndereco.setIdEndereco(idGerado);
			
			pStmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public Object consultar(Object obj) {
		Endereco objEndereco = (Endereco) obj;
		
		try {
			String consultarSqlProduto = "SELECT * FROM Endereco where (nome = (?)) AND (numeroResidencia = (?))";
			PreparedStatement pStmt = getConnection().prepareStatement(consultarSqlProduto);
			pStmt.setString(1, objEndereco.getRua());
			pStmt.setInt(2, objEndereco.getNumeroResidencia());
			ResultSet result = pStmt.executeQuery();
			if(result.next()) {
				//Pegar o id do endereço e relacionar com o id do cliente
				//Não codificado ainda 
				result.close();
			} else {
				objEndereco = null;
			}
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objEndereco;
	}
	
}
