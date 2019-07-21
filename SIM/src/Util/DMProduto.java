package Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import SimpleInventoryManagement.*;

public class DMProduto extends DMGeral {

	@Override
	public void incluir(Object obj) {
		Produto objProduto = (Produto) obj;
		try {
			String incluirSqlProduto = "INSERT INTO Produto (nome, descricao, quantidade, custo, preco) VALUES (?, ?, ?, ?)";
			PreparedStatement pStmt = getConnection().prepareStatement(incluirSqlProduto, Statement.RETURN_GENERATED_KEYS);
			pStmt.setString(1, objProduto.getNome());
			pStmt.setString(2, objProduto.getDescricao());
			pStmt.setInt(3, objProduto.getQuantidade());
			pStmt.setFloat(4, objProduto.getPreco_de_custo());
			pStmt.setFloat(5, objProduto.getPreco_de_venda());
			
			pStmt.executeUpdate();
			
			ResultSet resultSet = pStmt.getGeneratedKeys();
			resultSet.next();
			int idGerado = resultSet.getInt(1);
			objProduto.setIdProduto(idGerado);
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Object consultar(Object obj) {
		Produto objProduto = (Produto) obj;
		
		try {
			String consultarSqlProduto = "SELECT * FROM Produto where (nome = (?))";
			PreparedStatement pStmt = getConnection().prepareStatement(consultarSqlProduto);
			pStmt.setString(1, objProduto.getNome());
			ResultSet result = pStmt.executeQuery();
			if(result.next()) {
				result.close();
			} else {
				objProduto = null;
			}
			pStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objProduto;
	}
	
}
